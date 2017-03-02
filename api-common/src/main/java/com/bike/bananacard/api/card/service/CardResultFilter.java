package com.bike.bananacard.api.card.service;

import com.bike.bananacard.common.constant.CardType;
import com.bike.bananacard.bean.UserCard;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/14
 * time: 下午5:39
 * description: 卡片结果过滤
 */
public class CardResultFilter {
    public boolean filter(UserCard userCard) {
        return !CardType.PUBLIC_CARD.equals(userCard.getCardType());
    }
}
