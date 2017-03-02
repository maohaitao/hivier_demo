package com.bike.dynamic.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;

/**
 * Created by a700 on 17/2/16.
 */
@pbdb_alias("t_dynamic_collection_info")
public class CollectionInfo implements Serializable {
    @Expose
    @pbdb_alias("id")
    private Integer id;

    @Expose
    @pbdb_alias("collection_name")
    private String collection_name;//合集名称

    @Expose
    @pbdb_alias("collection_desc")
    private String collection_desc;//合集描述

    @Expose
    @pbdb_alias("image")
    private String image;//合集封面图

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollection_name() {
        return collection_name;
    }

    public void setCollection_name(String collection_name) {
        this.collection_name = collection_name;
    }

    public String getCollection_desc() {
        return collection_desc;
    }

    public void setCollection_desc(String collection_desc) {
        this.collection_desc = collection_desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "CollectionInfo{" +
                "id=" + id +
                ", collection_name='" + collection_name + '\'' +
                ", collection_desc='" + collection_desc + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
