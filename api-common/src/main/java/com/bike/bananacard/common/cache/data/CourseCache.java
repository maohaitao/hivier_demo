package com.bike.bananacard.common.cache.data;

import com.bike.bananacard.bean.TCourse;
import com.bike.bananacard.common.constant.AppContext;
import com.bike.bananacard.common.jdbc.JdbcDao;
import com.sf.common.exception.AppException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/2/3
 * time: 下午4:01
 * description: 课程
 */
public class CourseCache extends CacheLoader {
    public final static String COURSE_KEY = "COURSE_LOCAL_CACHE";
    private final static Logger LOG = Logger.getLogger(UserCardCache.class);
    private JdbcDao jdbcDao;

    @Override
    protected void loadData(JdbcDao jdbcDao) {
        this.jdbcDao = jdbcDao;
        List<TCourse> data = getData();
        set(COURSE_KEY, data);
        for (TCourse course : data) {
            set(COURSE_KEY + course.getId(), course);
        }
    }

    private List<TCourse> getData() {
        List<Object> parameter = new ArrayList<Object>();
        parameter.add(AppContext.COURSE_STATUS_RUN);
        String sql = "select * from t_course where status=?";
        try {
            return jdbcDao.queryBySQL(sql, TCourse.class, parameter);
        } catch (AppException e) {
            LOG.error("加载课程失败:", e);
        }
        return new ArrayList<TCourse>();
    }
}
