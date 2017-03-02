package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by a700 on 17/2/24.
 */
public class DealServiceTest {
    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-mvc.xml"});
        context.start();
//        DemoService service = (DemoService) context.getBean("demoServiceImpl");
//        service.build("test");
        System.out.println("新浪微博：疯狂的杨中仁.");

        System.in.read(); // 按任意键退出
    }
}
