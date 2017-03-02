package com.bikemanage.model.authorized;

/**
 * 描述：
 * 创建时间：15/8/4
 * 作者：yanghui
 */

import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

/*  */
@pbdb_alias("role")
public class Role {
    @pbdb_ignore
    private Integer id;//remark:;length:10; not null,default:null
    private String name;//remark:;length:20; not null,default:null
    @pbdb_alias("role_code")
    private String roleCode;//remark:;length:20; not null,default:null
    private String description;//remark:;length:65535
    private Integer sort;//remark:;length:5
    @pbdb_alias("is_del")
    private Integer isDel;//remark:;length:255
    @pbdb_ignore
    private String permissionIds;

    public Role() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(String permissionIds) {
        this.permissionIds = permissionIds;
    }
}