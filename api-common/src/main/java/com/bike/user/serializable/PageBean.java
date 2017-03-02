package com.bike.user.serializable;


import java.io.Serializable;
import java.util.List;

public class PageBean  implements Serializable{
    private int currentPage;
    private int pageSize;
    private int startNum;
    private int totalNum;
    private int totalPage;
    private List<?> result;

    public PageBean() {
    }

    public PageBean(int currentPage, int pageSize) {
        if(currentPage <= 0) {
            this.currentPage = 1;
        } else {
            this.currentPage = currentPage;
        }

        if(pageSize <= 0) {
            this.pageSize = 10;
        } else {
            this.pageSize = pageSize;
        }

        this.startNum = (this.currentPage - 1) * pageSize;
    }

    public int getTotalNum() {
        return this.totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
        if(totalNum <= 0) {
            this.totalNum = 0;
            this.totalPage = 1;
        } else if(totalNum % this.pageSize == 0) {
            this.totalPage = totalNum / this.pageSize;
        } else {
            this.totalPage = totalNum / this.pageSize + 1;
        }

    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getStartNum() {
        return this.startNum;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<?> getResult() {
        return this.result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }

    public String toString() {
        return "PageBean [currentPage=" + this.currentPage + ", pageSize=" + this.pageSize + ", startNum=" + this.startNum + ", totalNum=" + this.totalNum + ", totalPage=" + this.totalPage + "]";
    }

    public void doCopy(com.sf.common.database.model.PageBean pageBean){
        if(null != pageBean){
            this.currentPage=pageBean.getCurrentPage();
            this.pageSize = pageBean.getPageSize();
            this.startNum = pageBean.getStartNum();
            this.totalNum = pageBean.getTotalNum();
            this.totalPage = pageBean.getTotalPage();
            this.result = pageBean.getResult();
        }
    }
}