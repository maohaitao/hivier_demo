package com.bikemanage.model.authorized;

import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

/*  */
@pbdb_alias("user_role")
public class UserRole {
    @pbdb_ignore
    private Integer id;//remark:;length:10; not null,default:null
    @pbdb_alias("user_id")
    private Integer userId;//remark:;length:10; not null,default:null
    @pbdb_alias("role_id")
    private Integer roleId;//remark:;length:10; not null,default:null

    public UserRole() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}