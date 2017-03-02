package com.bikemanage.service.login;

import com.bikemanage.common.tools.DateUtil;
import com.bikemanage.dto.common.TreeNode;
import com.bikemanage.model.authorized.Permission;
import com.bikemanage.model.authorized.User;
import com.bikemanage.service.BaseService;
import com.sf.common.database.dao.BaseDaoImpl;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * 创建时间：15/5/5
 */
@Service
public class LoginService extends BaseService {

    public void setBaseDao(BaseDaoImpl baseDao) {
        this.baseDao = baseDao;
    }

    public User login(String userName, String passWord) {
        User user = new User();
        user.setLoginName(userName);
        try {
            user = findByEntity(user);
            if (user != null && !(passWord).equals(user.getPassword())) {
                pwErrorOrSeccess(user, 0);
                return null;
            } else if (user != null && (passWord).equals(user.getPassword())) {
                pwErrorOrSeccess(user, 1);
                return user;
            }
        } catch (Exception e) {
            LogService.error("login error:", e);
            return null;
        }
        return user;
    }

    public boolean pwErrorOrSeccess(User user, int type) {
        if (user.getId() != null && user.getId() > 0) {
            List<Object> params = new ArrayList<Object>();
            params.add(user.getLastVisit() == null ? DateUtil.getCurrentDate() : user.getLastVisit());
            params.add(DateUtil.getCurrentDate());
            params.add(user.getId());
            try {
                String errorCount;
                if (type == 1) {
                    errorCount = "0";
                } else {
                    errorCount = "error_count+1";
                }
                String sql = "update user set error_count =" + errorCount + ", login_count=ifnull(login_count, 0)+1, previous_visit=? ,last_visit=? where id=?";
                return add(sql, params);
            } catch (AppException e) {
                LogService.error("pwErrorOrSeccess:", e);
            }
        }
        return false;
    }

    public List<TreeNode> queryMenu(Integer userId) throws AppException {
        List<Object> params = new ArrayList<>();
        params.add(userId);
        List<Permission> permissionModels = queryByEntity("select p.* from user_role u,role_permission r,permission p where u.role_id=r.role_id and p.id=r.permission_id and menu_type=1 and u.user_id=? order by p.pid, p.sort", Permission.class, params);
        List<TreeNode> menuList = new ArrayList<>();
        for (Permission permission : permissionModels) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(permission.getId());
            treeNode.setIcon(permission.getIcon());
            treeNode.setName(permission.getName());
            treeNode.setParentId(permission.getPid());
            treeNode.setUrl(permission.getUrl());
            menuList.add(treeNode);
        }
        List<TreeNode> nodeList = new ArrayList<>();
        for (TreeNode node : menuList) {
            boolean mark = false;
            for (TreeNode childrenNode : menuList) {
                if (node.getParentId() != null && node.getParentId().equals(childrenNode.getId())) {
                    mark = true;
                    if (childrenNode.getChildren() == null)
                        childrenNode.setChildren(new ArrayList<TreeNode>());
                    childrenNode.getChildren().add(node);
                    break;
                }
            }
            if (!mark) {
                nodeList.add(node);
            }
        }
        return nodeList;
    }


}
