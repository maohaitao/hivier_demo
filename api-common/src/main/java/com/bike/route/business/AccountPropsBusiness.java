package com.bike.route.business;

import com.bike.route.model.GameResult;
import com.bike.route.model.TAccountProps;
import com.sf.common.exception.AppException;

import java.util.List;

/**
 * Created by a700 on 16/4/1.
 * 道具业务类
 */
public interface AccountPropsBusiness {

    public List<TAccountProps> getProps(String token) throws AppException;

    public GameResult useProps(String token, String propsId) throws AppException;

    /**
     * 跑步完成获取道具进度
     *
     * @param distance 跑步距离 m 米
     * @param time     跑步时间 s 秒
     * @return
     */
    public List<TAccountProps> runGetProps(String accountId, String distance, String time);
}
