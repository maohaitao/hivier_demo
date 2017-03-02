package com.bike.apicommon;

import com.bike.apicommon.utils.TokenUtils;
import com.sf.common.exception.AppException;
import com.sf.common.image.QiniuImageConfig;
import com.sf.common.image.QiniuImageInfo;
import com.sf.common.image.QiniuImageManager;
import com.sf.common.image.QiniuImageService;
import com.sf.common.log.LogService;
import com.sf.common.properties.PropertiesQiniuUtil;
import com.sf.common.util.CommonUtil;
import com.sf.common.util.RandomUtils;
import sun.misc.BASE64Decoder;

/**
 * Created by a700 on 16/9/27.
 */
public class ImageUploadUtill {
    //base64字符串转化成图片
    public static byte[] GenerateImage(String imgStr) {   //对字节数组字符串进行Base64解码并生成图片
        if (CommonUtil.isNull(imgStr)) //图像数据为空
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            return b;
        } catch (Exception e) {
            LogService.error("GenerateImage error:", e);
            return null;
        }
    }

    public  static String getUploadUrl(String image,String token,String qiNiuSpace,String domain) throws AppException{
        QiniuImageConfig imageConfig = new QiniuImageConfig();
        imageConfig.setAccessKey(PropertiesQiniuUtil.getValue("qiniu.access_key"));
        imageConfig.setSecretKey(PropertiesQiniuUtil.getValue("qiniu.secret_key"));
        imageConfig.setBucket(PropertiesQiniuUtil.getValue(qiNiuSpace));
        imageConfig.setDomain(PropertiesQiniuUtil.getValue(domain));
        imageConfig.setAppClient(PropertiesQiniuUtil.getValue("qiniu.appclient"));
        imageConfig.setfSizeLimit(Integer.valueOf(PropertiesQiniuUtil.getValue("qiniu.fsizeLimit", 0)));
        imageConfig.setMimeLimit(PropertiesQiniuUtil.getValue("qiniu.mimeLimit"));
        imageConfig.setTokenExpires(Integer.valueOf(PropertiesQiniuUtil.getValue("qiniu.token_expires", 0)));
        QiniuImageService qiniuImageService = new QiniuImageService(imageConfig);
        byte[] images = GenerateImage(image);
        if (images != null) {
            QiniuImageInfo imageInfo = qiniuImageService.uploadFile(images, TokenUtils.getIDByToken(token)+"dynamic" + RandomUtils.getRandomAlphaString(8) + ".jpg",
                    PropertiesQiniuUtil.getValue(qiNiuSpace)); // TODO 七牛的配置
            if (imageInfo != null) {
                    return  imageInfo.getUrl();
            }
        }
        return  null;
    }


    public  static String getUploadUrlUserFace(String image,String token,String qiNiuSpace,String domain) throws AppException{
        QiniuImageConfig imageConfig = new QiniuImageConfig();
        imageConfig.setAccessKey(PropertiesQiniuUtil.getValue("qiniu.access_key"));
        imageConfig.setSecretKey(PropertiesQiniuUtil.getValue("qiniu.secret_key"));
        imageConfig.setBucket(PropertiesQiniuUtil.getValue(qiNiuSpace));
        imageConfig.setDomain(PropertiesQiniuUtil.getValue(domain));
        imageConfig.setAppClient(PropertiesQiniuUtil.getValue("qiniu.appclient"));
        imageConfig.setfSizeLimit(Integer.valueOf(PropertiesQiniuUtil.getValue("qiniu.fsizeLimit", 0)));
        imageConfig.setMimeLimit(PropertiesQiniuUtil.getValue("qiniu.mimeLimit"));
        imageConfig.setTokenExpires(Integer.valueOf(PropertiesQiniuUtil.getValue("qiniu.token_expires", 0)));
        QiniuImageService qiniuImageService = new QiniuImageService(imageConfig);
        byte[] images = GenerateImage(image);
        if (images != null) {
            QiniuImageInfo imageInfo = qiniuImageService.uploadFile(images, TokenUtils.getIDByToken(token)+"userface" +
                            RandomUtils.getRandomAlphaString(8) + ".jpg",
                    PropertiesQiniuUtil.getValue(qiNiuSpace)); // TODO 七牛的配置
            if (imageInfo != null) {
                return  imageInfo.getUrl();
            }
        }
        return  null;
    }

}
