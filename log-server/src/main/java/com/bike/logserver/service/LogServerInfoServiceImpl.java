package com.bike.logserver.service;

import com.bike.logserver.model.LogServerInfo;
import com.sf.common.database.dao.BaseDaoImpl;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import com.sf.common.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * Created by a700 on 17/2/27.
 */

@Service
public class LogServerInfoServiceImpl implements LogServerInfoService {
    @Autowired
    private BaseDaoImpl<LogServerInfo> signBaseDao;

    @Value("${log4jPrefix}")
    private String log4jPrefix;
    @Override
    public boolean loadText() {
        Calendar   cal   =   Calendar.getInstance();
        cal.add(Calendar.DATE,   -1);
        String date = DateUtil.formatDateToStringShort(cal.getTime());
        String path = log4jPrefix+"/log/info.countserver."+date;
        LogService.info("log4jPrefix path==="+path);

        String sql="load data local infile '"+ path+"'" +
                "into table log_server_info fields terminated by '||'";
        try {
            signBaseDao.updatesql(sql);
            // TODO 数据汇总
        } catch (AppException e) {
            LogService.error("");
        }
        return false;
    }
}
