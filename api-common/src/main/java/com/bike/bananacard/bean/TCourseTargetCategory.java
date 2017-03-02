package com.bike.bananacard.bean;

import com.google.gson.annotations.SerializedName;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.List;

/*  */
@pbdb_alias("t_course_target_category")
public class TCourseTargetCategory implements Serializable {
    @pbdb_ignore
    private Integer id;//remark:ID;length:10; not null,default:null
    @pbdb_alias("category_name")
    @SerializedName("category_name")
    private String categoryName;//remark:种类名称;length:100
    @pbdb_alias("parent_id")
    @SerializedName("parent_id")
    private Integer parentId;//remark:父ID;length:10
    private String problem;//remark:问题;length:200
    @pbdb_alias("category_value")
    private transient String categoryValue;//remark:种类对用值;length:45
    private transient Integer sort;//remark:;length:10; not null,default:0

    private List<TCourseTargetCategory> children;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getCategoryValue() {
        return categoryValue;
    }

    public void setCategoryValue(String categoryValue) {
        this.categoryValue = categoryValue;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<TCourseTargetCategory> getChildren() {
        return children;
    }

    public void setChildren(List<TCourseTargetCategory> children) {
        this.children = children;
    }
}