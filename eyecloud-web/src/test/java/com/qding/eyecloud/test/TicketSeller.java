package com.qding.eyecloud.test;

import com.qding.eyecloud.common.utils.SnowFlake;
import com.qding.eyecloud.web.utils.LockSample;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;

/**
 * description: <简述>
 * info: <详细信息>
 *
 * @author: tanshen@qding.me
 * @Date:
 * @since [产品/模块版本]
 */
public class TicketSeller {

    private void sell() {
        System.out.println("售票开始");
        // 线程随机休眠数毫秒，模拟现实中的费时操作
        int sleepMillis = 1000;
        try {
            //代表复杂逻辑执行了一段时间
            Thread.sleep(sleepMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("售票结束");
    }

    public void sellTicketWithLock(String userId) throws KeeperException, InterruptedException, IOException {
        LockSample lock = new LockSample();
        lock.acquireLock(userId);
        sell();
        lock.releaseLock(userId);
    }

    public static void main(String[] args) throws KeeperException, InterruptedException, IOException {
        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        TicketSeller ticketSeller = new TicketSeller();
                        ticketSeller.sellTicketWithLock("user" + SnowFlake.createSnowFlake().nextIdString());
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }

}
