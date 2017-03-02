package banana.wechat.model;

import java.io.Serializable;

/**
 * Created by a700 on 16/11/25.
 */
public class ImageInfo implements Serializable {
    public int label; //图片等级 0：色情； 1：性感； 2：正常；
    public boolean review; // 是否需要重审

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public boolean isReview() {
        return review;
    }

    public void setReview(boolean review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "ImageInfo{" +
                "label=" + label +
                ", review=" + review +
                '}';
    }

}
