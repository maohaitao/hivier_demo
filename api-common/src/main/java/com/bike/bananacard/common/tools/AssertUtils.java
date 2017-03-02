package com.bike.bananacard.common.tools;

import com.bike.bananacard.common.constant.ErrorCode;
import com.bike.bananacard.common.exception.CustomCodeException;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/13
 * time: 上午11:58
 * description: 验证工具
 */
public class AssertUtils {

    private final static Logger LOG = Logger.getLogger(AssertUtils.class);
    private final static String MESSAGE = "不可为空或者格式错误";

    public static void assertNull(Object obj, String fieldName) {
        if (obj == null) {
            showException(fieldName);
        }
    }

    public static void assertEmpty(String value, String fieldName) {
        if (StringUtils.isEmpty(value)) {
            showException(fieldName);
        }
    }

    public static void assertTrue(Boolean value, String fieldName) {
        if (value) {
            showException(fieldName);
        }
    }

    public static void assertEmpty(Collection<?> collection, String fieldName) {
        if (collection == null || collection.size() == 0) {
            showException(fieldName);
        }
    }


    public static void showException(String fieldName) {
        if (isDebug()) {
            throw new CustomCodeException(ErrorCode.PARAMETERS_INCORRECT, fieldName + MESSAGE);
        } else {
            throw new CustomCodeException(ErrorCode.PARAMETERS_INCORRECT);
        }
    }

    public static boolean isDebug() {
        return LOG.isDebugEnabled();
    }
}
