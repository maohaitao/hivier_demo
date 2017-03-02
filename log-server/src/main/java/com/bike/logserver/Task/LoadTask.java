package com.bike.logserver.Task;

import com.bike.logserver.service.LogServerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by a700 on 17/2/27.
 */
@Component
public class LoadTask {

    @Autowired
    private LogServerInfoService logServerInfoService;
    public void loadData(){
        logServerInfoService.loadText();
        System.out.println("===loadData===");
    }
}
