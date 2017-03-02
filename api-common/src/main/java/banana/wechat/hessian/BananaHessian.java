package banana.wechat.hessian;


import banana.wechat.model.ImageInfo;

/**
 * Created by a700 on 16/11/25.
 * 内部hessian接口
 */
public interface BananaHessian {

    /**
     * 七牛鉴黄处理
     *
     * @param url
     * @return
     */
    public ImageInfo checkImage(String url);

    /**
     * 文字过滤
     *
     * @param content
     * @return
     */
    public String checkText(String content);

}
