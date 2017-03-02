package com.bike.dynamic.service;

import com.bike.dynamic.model.DynamicComment;
import com.bike.user.serializable.PageBean;
import java.util.List;

/**
 * Created by allen duan on 16/9/28.
 * 动态评论接口
 */
public interface DynamicCommentService  {
    /**
     * 保存评论
     * @param dynamicComment
     * @return
     */
    public DynamicComment saveDynamicComment(DynamicComment dynamicComment);


    /**
     * 删除评论
     * @param dynamicComment
     * @return
     */
    public boolean delDynamicComment(DynamicComment dynamicComment,Integer isFb);

    /**
     * 获取评论点赞总数
     * @param dynamicId
     * @return
     */
    public int getDynamicCommentCount(Integer dynamicId);

    /**
     * 页码分页获取评论列表
     * @param dynamicId
     * @param pageNum
     * @return
     */
    public PageBean listDynamicCommentById(Integer dynamicId,Integer pageNum);

    /**
     * 时间戳分页获取评论列表
     * @param dynamicId
     * @param size
     * @param dateStr
     * @return
     */
    public List<DynamicComment> listDynamicCommentByDate(Integer dynamicId,Integer size,String dateStr);

    /**
     * 获取用户动态最新评论数
     * @param accountId
     * @return
     */
    public int getNewCommentCountByUserId (String accountId);


    public List<DynamicComment> getCommentListByDate(String account_id, String start_time, String end_time, int size,int startEqual);
}
