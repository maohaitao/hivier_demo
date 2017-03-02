package com.bike.apicommon;

import com.g3.common.util.CommonUtil;

/**
 * Created by a700 on 16/11/22.
 * gzip压缩处理
 */
public class GzipUtil {

    /**
     * 解压处理
     * @param data
     * @return
     */
    public static String ungzip(String data) throws Exception {
        data = new String(CommonUtil.ungzip(data.getBytes("ISO-8859-1")), "UTF-8");
        return  data;
    }

    /**
     * 压缩处理
     * @param data
     * @return
     * @throws Exception
     */
    public static String gzip(String data) throws Exception {
        data = new String(CommonUtil.gzip(data.toString().getBytes("UTF-8")), "ISO-8859-1");
        return  data;
    }
}
