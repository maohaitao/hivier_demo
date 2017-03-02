package com.bike.bananacard.common.cache.data;

import com.bike.bananacard.bean.TCalendarCards;
import com.bike.bananacard.common.constant.CardType;
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
public class CardCache extends CacheLoader {
    public final static String CALENDAR_CARDS_KEY = "CALENDAR_CARDS_LOCAL_CACHE";
    public final static String CALENDAR_CARDS_COURSE_KEY = "CALENDAR_CARDS_COURSE_LOCAL_CACHE";
    public final static String CALENDAR_CARDS_COMMON_KEY = "CALENDAR_CARDS_COMMON_LOCAL_CACHE";
    private final static Logger LOG = Logger.getLogger(UserCardCache.class);
    private JdbcDao jdbcDao;

    @Override
    protected void loadData(JdbcDao jdbcDao) {
        this.jdbcDao = jdbcDao;
        List<TCalendarCards> data = getData();
        List<TCalendarCards> commonData = new ArrayList<TCalendarCards>();
        set(CALENDAR_CARDS_KEY, data);
        for (TCalendarCards card : data) {
            if (card != null && CardType.DAYLY_CARD == card.getCardType()) {
                card.setIsDayCard(AppContext.IS_DAY_CARD_YES);
            } else {
                card.setIsDayCard(AppContext.IS_DAY_CARD_NO);
            }
            if (card.getIsCommon() == AppContext.IS_COMMON_CARD_YES &&
                    card.getcStatus() == AppContext.IS_CARD_STATUS_UP &&
                    card.getDefaultCommon() == AppContext.IS_DEFAULT_COMMON_YES) {
                commonData.add(card);
            }
            set(CALENDAR_CARDS_KEY + card.getId(), card);
            if (card.getCourseId() != null) {
                set(CALENDAR_CARDS_COURSE_KEY + card.getCourseId(), card);
            }
        }
//        List<TCalendarCards> commonData = getCommonData();
        set(CALENDAR_CARDS_COMMON_KEY, commonData);
    }

    private List<TCalendarCards> getData() {
        List<Object> parameter = new ArrayList<Object>();
        String sql = "select * from t_calendar_cards";
        try {
            return jdbcDao.queryBySQL(sql, TCalendarCards.class, parameter);
        } catch (AppException e) {
            LOG.error("加载所有卡片失败:", e);
        }
        return new ArrayList<TCalendarCards>();
    }

    private List<TCalendarCards> getCommonData() {
        List<Object> parameter = new ArrayList<Object>();
        String sql = "select * from t_calendar_cards where is_common=? and c_status=? and defoult_common=?";
        parameter.add(AppContext.IS_COMMON_CARD_YES);
        parameter.add(AppContext.IS_CARD_STATUS_UP);
        parameter.add(AppContext.IS_DEFAULT_COMMON_YES);
        try {
            return jdbcDao.queryBySQL(sql, TCalendarCards.class, parameter);
        } catch (AppException e) {
            LOG.error("加载常用卡片失败:", e);
        }
        return new ArrayList<TCalendarCards>();
    }
}
