package com.bike.apicommon;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by a700 on 16/11/28.
 */
public class BananaMessage  implements Serializable {

    private static final long serialVersionUID = -5316122571161723307L;
    private Integer msgId; //消息Id
    private String senderId; //触发者
    private String recvId; //接收者
    private Integer type; // 消息类型
    private String imei;
    private String content;
    private Date createTime;
    private Integer status;// 0未读；1已读。
    private Integer category;
    private String item;
    private Integer itemId;

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getRecvId() {
        return recvId;
    }

    public void setRecvId(String recvId) {
        this.recvId = recvId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BananaMessage{" +
                "category=" + category +
                ", msgId=" + msgId +
                ", senderId='" + senderId + '\'' +
                ", recvId='" + recvId + '\'' +
                ", type=" + type +
                ", imei='" + imei + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                ", item='" + item + '\'' +
                ", itemId=" + itemId +
                '}';
    }
}
