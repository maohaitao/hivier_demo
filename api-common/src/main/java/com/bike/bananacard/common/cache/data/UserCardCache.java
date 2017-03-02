package com.bike.bananacard.common.cache.data;

import com.bike.bananacard.bean.UserCard;
import com.bike.bananacard.common.constant.AppContext;
import com.bike.bananacard.common.constant.CardType;
import com.bike.bananacard.common.jdbc.JdbcDao;
import com.sf.common.exception.AppException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/15
 * time: 上午11:57
 * description: 加载日历卡片数据
 */
public class UserCardCache extends CacheLoader {
    public final static String PUBLIC_KEY = "PUBLIC_CARD_LOCAL_CACHE";
    public final static String OPTION_KEY = "OPTION_CARD_LOCAL_CACHE";
    public final static String DAYLY_KEY = "DAYLY_CARD_LOCAL_CACHE";
    public final static String SYSTEM_CARD_NAME_KEY = "SYSTEM_CARD_NAME_KEY";
    private final static Logger LOG = Logger.getLogger(UserCardCache.class);
    private JdbcDao jdbcDao;

    private List<UserCard> getPublicCard() {
        try {
            List<UserCard> userCards = getData(CardType.PUBLIC_CARD);
            //公共卡默认为固定卡
            for (UserCard userCard : userCards) {
                userCard.setIsDayCard(AppContext.IS_DAY_CARD_NO); //TODO YES-->NO
                set(SYSTEM_CARD_NAME_KEY + userCard.getCardName(), userCard);
            }
            return userCards;
        } catch (AppException e) {
            LOG.error("加载公共卡失败:", e);
        }
        return null;
    }

    private List<UserCard> getOptionCard() {
        try {
            List<UserCard> userCards = getData(CardType.OPTION_CARD);
            for (UserCard userCard : userCards) {
                set(SYSTEM_CARD_NAME_KEY + userCard.getCardName(), userCard);
            }
            return userCards;
        } catch (AppException e) {
            LOG.error("加载备选卡失败:", e);
        }
        return null;
    }


    private List<UserCard> getDaylyCard() {
        try {
            List<UserCard> userCards = getData(CardType.DAYLY_CARD);
            //公共卡默认为固定卡
            for (UserCard userCard : userCards) {
                userCard.setIsDayCard(AppContext.IS_DAY_CARD_YES);
                set(SYSTEM_CARD_NAME_KEY + userCard.getCardName(), userCard);
            }
            return userCards;
        } catch (AppException e) {
            LOG.error("加载日常卡失败:", e);
        }
        return null;
    }


    @Override
    protected void loadData(JdbcDao jdbcDao) {
        this.jdbcDao = jdbcDao;
        set(PUBLIC_KEY, getPublicCard());
        set(OPTION_KEY, getOptionCard());
        set(DAYLY_KEY, getDaylyCard());
    }

    private List<UserCard> getData(Integer cardType) throws AppException {
        List<Object> parameter = new ArrayList<Object>();
        parameter.add(cardType);
        String sql = "select * from t_calendar_cards where card_type=?";
        return jdbcDao.queryBySQL(sql, UserCard.class, parameter);
    }


}
