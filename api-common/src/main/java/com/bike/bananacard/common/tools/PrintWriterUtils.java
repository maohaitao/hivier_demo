package com.bike.bananacard.common.tools;

import com.bike.bananacard.common.constant.ErrorCode;
import com.bike.bananacard.common.tools.json.JsonResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/13
 * time: 下午5:09
 * description: 打印错误信息
 */
public class PrintWriterUtils {
    public static void print(HttpServletResponse response, ErrorCode errorCode, String message) throws IOException {
        JsonResult jsonResult = new JsonResult();
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(jsonResult.failure(errorCode, message));
        printWriter.flush();
        printWriter.close();
    }

    public static void print(HttpServletResponse response, ErrorCode errorCode) throws IOException {
        print(response, errorCode, null);
    }
}
