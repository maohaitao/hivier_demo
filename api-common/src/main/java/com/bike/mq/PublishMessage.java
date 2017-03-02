package com.bike.mq;

/**
 * Created by 700bike on 2016/11/30.
 */
public class PublishMessage {
    private String title;
    private String alert;
    private Integer notification;
    private Extra extra;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public Integer getNotification() {
        return notification;
    }

    public void setNotification(Integer notification) {
        this.notification = notification;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public class Extra {
        private String type;
        private Integer typeId;
        private Integer subTypeId;
        private String value;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getTypeId() {
            return typeId;
        }

        public void setTypeId(Integer typeId) {
            this.typeId = typeId;
        }

        public Integer getSubTypeId() {
            return subTypeId;
        }

        public void setSubTypeId(Integer subTypeId) {
            this.subTypeId = subTypeId;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
