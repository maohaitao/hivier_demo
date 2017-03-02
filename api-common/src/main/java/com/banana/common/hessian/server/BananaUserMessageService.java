package com.banana.common.hessian.server;

import org.springframework.stereotype.Service;

/**
 * Created by a700 on 17/2/7.
 */
@Service
public interface BananaUserMessageService {

    public boolean addUserMessage(UserMessageHessian userMessageHessian);

    public boolean delUserMessage(UserMessageHessian userMessageHessian);
}
