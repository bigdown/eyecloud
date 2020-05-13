package com.qding.eyecloud.web.utils;

import com.qding.eyecloud.web.controller.CallbackController;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
public class LockSample {

    private static final Logger logger = LoggerFactory.getLogger(LockSample.class);

    private ZooKeeper zkClient;

    private String lockPath;

    private static final String LOCK_ROOT_PATH = "/Locks";

    private static final String LOCK_NODE_NAME = "Lock_";

    private Watcher watcher = new Watcher() {
        @Override
        public void process(WatchedEvent event) {
            logger.info(event.getPath() + " 前锁释放");
            synchronized (this) {
                notifyAll();
            }

        }
    };

    public LockSample() throws IOException {
        zkClient = new ZooKeeper("localhost:2181", 10000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.Disconnected) {
                    logger.info("失去连接");
                }
            }
        });
    }

    public void acquireLock(String userId) throws InterruptedException, KeeperException {
        //创建锁节点
        createLock();
        //尝试获取锁
        attemptLock(userId);
    }

    private void attemptLock(String userId) throws KeeperException, InterruptedException {
        for (; ; ) {
            List<String> lockPaths = null;
            lockPaths = zkClient.getChildren(LOCK_ROOT_PATH, false);
            Collections.sort(lockPaths);
            int index = lockPaths.indexOf(lockPath.substring(LOCK_ROOT_PATH.length() + 1));
            // 如果lockPath是序号最小的节点则获取锁
            if (index == 0) {
                logger.info("user <{}> 获取锁, lockPath <{}>", userId, lockPath);
                break;
            } else {
                // lockPath不是序号最小的节点，监听前一个节点
                String preLockPath = lockPaths.get(index - 1);
                Stat stat = zkClient.exists(LOCK_ROOT_PATH + "/" + preLockPath, watcher);
                if (stat == null) {
//                    attemptLock(userId);
                } else {
                    logger.info("等待前锁释放，preLockPath <{}>", preLockPath);
                    synchronized (watcher) {
                        watcher.wait();
                    }
//                    attemptLock(userId);
                }
            }
        }
    }

    private void createLock() throws KeeperException, InterruptedException {
        // 如果根节点不存在则创建根节点
        Stat stat = zkClient.exists(LOCK_ROOT_PATH, false);
        if (stat == null) {
            zkClient.create(LOCK_ROOT_PATH, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        // 创建EPHEMERAL_SEQUENTIAL类型节点
        String lockPath = zkClient.create(LOCK_ROOT_PATH + "/" + LOCK_NODE_NAME,
                Thread.currentThread().getName().getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);
        this.lockPath = lockPath;
    }

    public void releaseLock(String userId) throws KeeperException, InterruptedException {
        zkClient.delete(lockPath, -1);
        zkClient.close();
        logger.info(" user <{}> 锁 <{}> 释放", userId, lockPath);
    }
}
