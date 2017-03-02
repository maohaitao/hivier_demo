package com.banana.common.hessian.server;

import com.caucho.hessian.client.HessianProxyFactory;

import java.net.MalformedURLException;
import java.util.Date;

/**
 * Created by a700 on 17/2/7.
 */
public class UserMessageTest {

    public static void main(String[] args) {
        String url = "http://localhost:8093/bananacardmanager/banana/hessian/bananaUserMessageHessian";
        HessianProxyFactory factory = new HessianProxyFactory();
        try {
            BananaUserMessageService spaceService = (BananaUserMessageService) factory.create(
                    BananaUserMessageService.class, url);
            System.out.println("---"+spaceService);

            UserMessageHessian userMessageHessian = new UserMessageHessian();

            userMessageHessian.setTitle("111111");
            userMessageHessian.setAccount_id("ka111");
            userMessageHessian.setPush_record_id(1);
            userMessageHessian.setPush_type(5); // 活动挑战消息类型
            userMessageHessian.setComment("活动挑战");
            userMessageHessian.setPush_time(new Date());

            System.out.println(spaceService.addUserMessage(userMessageHessian));

            System.out.println(spaceService.delUserMessage(userMessageHessian));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            e.printStackTrace();
        }
    }
}
