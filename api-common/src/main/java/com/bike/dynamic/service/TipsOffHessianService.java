package com.bike.dynamic.service;

/**
 * Created by allen duan on 16/12/12.
 * 举报通过删除动态及评论接口
 */
public interface TipsOffHessianService {


    /**
     *
     * @param id
     * @param type 1动态举报 2评论举报
     * @return
     */
    public boolean delTipOffRecord(int id,int type,String accountId);

    /**
     * 标识涉黄
     * @param id
     * @return
     */
    public boolean dealYellowDynamic(int id,int is_yellow,int is_default_yellow);
}
