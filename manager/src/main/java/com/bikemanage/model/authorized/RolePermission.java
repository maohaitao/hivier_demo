package com.bikemanage.model.authorized;

import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

/*  */
@pbdb_alias("role_permission")
public class RolePermission {
    @pbdb_ignore
    @pbdb_alias("id")
    private Integer id;//remark:;length:10; not null,default:null
    @pbdb_alias("role_id")
    private Integer roleId;//remark:;length:10
    @pbdb_alias("permission_id")
    private Integer permissionId;//remark:;length:10

    public RolePermission() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}