package com.bikemanage.model.authorized;

import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.util.List;

/*  */
@pbdb_alias("permission")
public class Permission {
    @pbdb_ignore
    private Integer id;//remark:;length:10; not null,default:null
    private Integer pid;//remark:父节点名称;length:10
    private String name;//remark:名称;length:50; not null,default:null
    private Integer sort;//remark:排序;length:10
    private String url;//remark:;length:255
    @pbdb_alias("perm_code")
    private String permCode;//remark:菜单编码;length:50
    private String icon;//remark:;length:255
    private String statu;//remark:;length:10
    private String description;//remark:;length:65535
    @pbdb_alias("menu_type")
    private Integer menuType;

    @pbdb_ignore
    private List<Permission> childrens;

    public Permission() {
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermCode() {
        return permCode;
    }

    public void setPermCode(String permCode) {
        this.permCode = permCode;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Permission> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Permission> childrens) {
        this.childrens = childrens;
    }
}