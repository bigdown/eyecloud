package com.qding.eyecloud.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.qding.eyecloud.base.BaseTreeModel;
import com.qding.eyecloud.common.data.base.TreeVO;
import com.qding.eyecloud.model.AuthMenu;

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
    
    public static void main(String[] args) {
        
        List<AuthMenu> reqList = new ArrayList<AuthMenu>();
        AuthMenu a1 = new AuthMenu();
        a1.setId("1");
        a1.setParentId("-1");
        a1.setMenuCode("123");
        a1.setMenuName("123");
        reqList.add(a1);
        
        AuthMenu a2 = new AuthMenu();
        BeanUtils.copyProperties(a1, a2);
        a2.setId("2");
        a2.setParentId("1");
        reqList.add(a2);
        
        AuthMenu a3 = new AuthMenu();
        BeanUtils.copyProperties(a1, a3);
        a3.setId("3");
        a3.setParentId("2");
        reqList.add(a3);
        
        AuthMenu a4 = new AuthMenu();
        BeanUtils.copyProperties(a1, a4);
        a4.setId("4");
        a4.setParentId("2");
        reqList.add(a4);
        
        System.out.println(JsonUtil.writeValue(startForTree(reqList)));
        
        List<TreeVO<? extends BaseTreeModel>> result = startForTree(reqList);
        for (TreeVO<? extends BaseTreeModel> treeVO : result) {
            System.out.println(treeVO);
            AuthMenu vo = (AuthMenu)treeVO.getData();
            System.out.println(vo);
        }
    }
}
