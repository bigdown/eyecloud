package com.t.s.eyecloud.common.utils;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.t.s.eyecloud.base.BaseTreeModel;
import com.t.s.eyecloud.common.data.base.TreeVO;

/**
 * Desc: 树形结构帮助类
 * Info: <功能详细描述>
 * @since  [产品/模块版本]
 * @author tanshen@qding.me
 * @version v1.0
 * @Date: 2019年11月28日
 */
public class TreeUtils {
    
    private final static String ROOT = "-1";
    
    public final static List<TreeVO<? extends BaseTreeModel>> startForTree(List<? extends BaseTreeModel> reqList) {
        List<TreeVO<? extends BaseTreeModel>> result = new ArrayList<TreeVO<? extends BaseTreeModel>>();
        if (CollectionUtils.isEmpty(reqList)) {
            return result;
        }
        reqList.stream().forEach(item -> {
            TreeVO<? extends BaseTreeModel> tree = new TreeVO<>();
            tree.setId(item.getId());
            tree.setPid(item.getParentId());
            tree.setData(item);
            result.add(tree);
        });
        return getTree(result);
    }
    
    public final static List<TreeVO<? extends BaseTreeModel>> getTree(List<TreeVO<? extends BaseTreeModel>> reqList) {
        return getTree(reqList, ROOT);
    }
    
    public final static List<TreeVO<? extends BaseTreeModel>> getTree(List<TreeVO<? extends BaseTreeModel>> reqList,
        String root) {
        if (reqList != null) {
            List<TreeVO<? extends BaseTreeModel>> list = new ArrayList<TreeVO<? extends BaseTreeModel>>();
            for (TreeVO<? extends BaseTreeModel> treeVO : reqList) {
                if (root.equals(treeVO.getPid())) {
                    treeVO.setChildren(getChildrenTree(treeVO.getId(), reqList, root));
                    list.add(treeVO);
                }
            }
            return list;
        } else {
            return new ArrayList<>(0);
        }
    }
    
    public final static List<TreeVO<? extends BaseTreeModel>> getChildrenTree(String code,
        List<TreeVO<? extends BaseTreeModel>> reqList, String root) {
        List<TreeVO<? extends BaseTreeModel>> list = new ArrayList<TreeVO<? extends BaseTreeModel>>();
        for (TreeVO<? extends BaseTreeModel> treeVO : reqList) {
            if (root.equals(treeVO.getPid())) {
                continue;
            }
            if (treeVO.getPid().equals(code)) {
                treeVO.setChildren(getChildrenTree(treeVO.getId(), reqList, root));
                list.add(treeVO);
            }
        }
        return list;
    }
}
