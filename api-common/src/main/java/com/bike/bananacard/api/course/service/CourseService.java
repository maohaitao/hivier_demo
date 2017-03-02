package com.bike.bananacard.api.course.service;

import com.sf.common.exception.AppException;

import java.util.Date;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/2/3
 * time: 下午12:15
 * description: 课程service
 */
public interface CourseService {

    public String list(Integer categoryId) throws AppException ;

/*    private List<TCourse> getCourses(Integer categoryId) throws AppException ;*/

    public String add(Integer courseId, Date startDate, Date endDate, String accountId) throws AppException ;

    public String categorys() ;
}
