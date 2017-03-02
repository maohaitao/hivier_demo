package com.hi.service;

import com.bike.sns.model.BasmsAccountTask;
import com.bike.sns.service.BasmsAccountTaskService;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import com.sf.common.service.BaseService;
import com.sf.common.util.DateUtil;
import org.springframework.stereotype.Service;

/**
 * Created by a700 on 16/10/9.
 */
@Service("basmsAccountTaskServiceImpl")
public class BasmsAccountTaskServiceImpl extends BaseService implements  BasmsAccountTaskService{

    public BasmsAccountTask addAccountTask(BasmsAccountTask accountTask) {
        if (accountTask != null) {
            try {
                saveEntity(accountTask);
            } catch (AppException e) {
                LogService.error("addAccountTask,添加信息:", e);
                return null;
            }
        }
        return accountTask;
    }

    public BasmsAccountTask addAccountTask(String acc_id, String assoc_acc_id, Integer u_type) {
        BasmsAccountTask accountTask = new BasmsAccountTask();
        accountTask.setAccId(acc_id);
        accountTask.setAssocAccId(assoc_acc_id);
        accountTask.setuType(u_type);
        accountTask.settId(u_type);
        accountTask.setCreateTime(DateUtil.getCurrentDate());
        return addAccountTask(accountTask);
    }
}
