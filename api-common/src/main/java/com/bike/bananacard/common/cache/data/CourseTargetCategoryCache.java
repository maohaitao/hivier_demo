package com.bike.bananacard.common.cache.data;

import com.bike.bananacard.bean.TCourseTargetCategory;
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
public class CourseTargetCategoryCache extends CacheLoader {
    public final static String COURSE_TARGET_CATEGORY_KEY = "COURSE_TARGET_CATEGORY_LOCAL_CACHE";
    private final static Logger LOG = Logger.getLogger(CourseTargetCategoryCache.class);
    private JdbcDao jdbcDao;

    @Override
    protected void loadData(JdbcDao jdbcDao) {
        this.jdbcDao = jdbcDao;
        set(COURSE_TARGET_CATEGORY_KEY, getData());
    }

    private TCourseTargetCategory getData() {
        List<Object> parameter = new ArrayList<Object>();
        String sql = "select * from t_course_target_category order by sort desc";
        try {
            return tree(jdbcDao.queryBySQL(sql, TCourseTargetCategory.class, parameter));
        } catch (AppException e) {
            LOG.error("加载课程目标策略失败:", e);
        }
        return null;
    }

    private TCourseTargetCategory tree(List<TCourseTargetCategory> courseTargetCategories) {

        List<TCourseTargetCategory> nodeList = new ArrayList<TCourseTargetCategory>();
        for (TCourseTargetCategory category : courseTargetCategories) {
            boolean mark = false;
            for (TCourseTargetCategory childrenNode : courseTargetCategories) {
                if (category.getParentId() != null && category.getParentId().equals(childrenNode.getId())) {
                    mark = true;
                    if (childrenNode.getChildren() == null)
                        childrenNode.setChildren(new ArrayList<TCourseTargetCategory>());
                    childrenNode.getChildren().add(category);
                    break;
                }
            }
            if (!mark) {
                nodeList.add(category);
            }
        }
        return nodeList.get(0);
    }
}
