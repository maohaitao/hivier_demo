package com.bike.dynamic.common;

import com.bike.apicommon.AppContext;
import com.bike.apicommon.SnsAppContext;
import com.bike.apicommon.cache.RedisService;
import com.bike.dynamic.model.CardImageDynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by allen duan on 16/9/30.
 * 设置动态图片地址缓存
 */
public class DynamicImageUrlCache {

    public static void setUrlCache(CardImageDynamic dynamic,int type ){
        if(null==dynamic){
            return;
        }
        List<String> ids = RedisService.getJedisCache().lrange(dynamic.getAccountId() + AppContext.DYNAMIC_IMAGE_URL,
                0, SnsAppContext.Page_size);
        String imageUrl = "";
        int open_type = dynamic.getIs_open();
        String isYellow = dynamic.getIs_yellow();
        String isDefaultYellow = dynamic.getIs_default_yellow();
        if(open_type==AppContext.OPEN_NO ||(AppContext.YELLOW_YES.equals(isYellow)||AppContext.YELLOW_YES.equals(isDefaultYellow))){
            open_type = AppContext.OPEN_NO ;
        }else{
            open_type = AppContext.OPEN_YES;
        }
        if(type==AppContext.DEFAULT_IMAGE_NO){
            imageUrl = dynamic.getImage_url();
        }else{
            imageUrl = dynamic.getDefault_image_url();
        }
        boolean isExists = false;
        if(ids==null || ids.size()==0){//未放入过缓存
            RedisService.getJedisCache().rpush(dynamic.getAccountId() + AppContext.DYNAMIC_IMAGE_URL,dynamic.getId().intValue()+"##"+open_type+"##"+imageUrl);
        }else if(ids!=null&&ids.size()<AppContext.IMAGE_RUL_NUM){//最多缓存四张图片地址

            for(String urlStr:ids){
                if(urlStr.startsWith(dynamic.getId()+"##")){//已经在缓存内，则替换
                    RedisService.getJedisCache().lrem(dynamic.getAccountId() + AppContext.DYNAMIC_IMAGE_URL,0,urlStr);
                    RedisService.getJedisCache().rpush(dynamic.getAccountId() + AppContext.DYNAMIC_IMAGE_URL,dynamic.getId().intValue()+"##"+open_type+"##"+imageUrl);
                    isExists = true;
                    break;
                }
            }
            if(!isExists){//不存在緩存，则添加
                RedisService.getJedisCache().rpush(dynamic.getAccountId() + AppContext.DYNAMIC_IMAGE_URL,dynamic.getId().intValue()+"##"+open_type+"##"+imageUrl);
            }
        }else if(ids!=null&&ids.size()>=AppContext.IMAGE_RUL_NUM){//最多缓存四张图片地址
            for(String urlStr:ids){
                if(urlStr.startsWith(dynamic.getId()+"##")){//已经在缓存内，则替换
                    RedisService.getJedisCache().lrem(dynamic.getAccountId() + AppContext.DYNAMIC_IMAGE_URL,0,urlStr);
                    RedisService.getJedisCache().rpush(dynamic.getAccountId() + AppContext.DYNAMIC_IMAGE_URL,dynamic.getId().intValue()+"##"+open_type+"##"+imageUrl);
                    isExists = true;
                    break;
                }
            }
            if(!isExists) {//不存在緩存，则添加,并删除最后个
                RedisService.getJedisCache().lrem(dynamic.getAccountId() + AppContext.DYNAMIC_IMAGE_URL,0,ids.get(0));//移除最后一个
                RedisService.getJedisCache().rpush(dynamic.getAccountId() + AppContext.DYNAMIC_IMAGE_URL,dynamic.getId().intValue()+"##"+open_type+"##"+imageUrl);
            }

        }
    }

    /**
     * 刪除图片缓存
     * @param accountId
     * @param dynamicId
     */
    public static  void delImageUrlCache(String accountId,Integer dynamicId){
        List<String> ids = RedisService.getJedisCache().lrange(accountId + AppContext.DYNAMIC_IMAGE_URL,
                0, SnsAppContext.Page_size);
        if(ids!=null && ids.size()>0){
            for(String urlStr:ids){
                if(urlStr.startsWith(dynamicId.intValue()+"##")){//已经在缓存内，则替换
                    RedisService.getJedisCache().lrem(accountId + AppContext.DYNAMIC_IMAGE_URL,0,urlStr);
                    break;
                }
            }
        }
    }

    /**
     *
     * @param accountId
     * @param size
     * @param isRecommend 是否是【推荐用户】最近发布的图片
     * @return
     */
    public static List<String> getImageUrlListOnCache(String accountId,int size,int isRecommend){
        if(size<=0||size>AppContext.IMAGE_RUL_NUM){
            size = AppContext.IMAGE_RUL_NUM;
        }
        List<String> ids = RedisService.getJedisCache().lrange(accountId + AppContext.DYNAMIC_IMAGE_URL,
                0,AppContext.IMAGE_RUL_NUM);
        List<String> urlList = new ArrayList<>();
       if(ids!=null && ids.size()>0){
           Collections.reverse(ids);
           for (String urlImage:ids){
               if(isRecommend==AppContext.Recommend_YES && urlList.size()>=size){
                   break;
               }
               String []arr = urlImage.split("##");
               if(arr.length>2){
                   if(isRecommend==AppContext.Recommend_YES){//公开的动态图片
                       if(AppContext.YELLOW_NO.equals(arr[1])){
                           urlList.add(arr[2]);
                       }
                   }else{
                       urlList.add(arr[2]);
                   }
               }
           }
       }
        return urlList;
    }


}
