package com.bike.activity.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;

/**
 * Created by allen duan on 17/1/6.
 *
 * 用户住址信息
 */
@pbdb_alias("t_user_address_info")
public class UserAddressInfo implements Serializable {

    @Expose
    @pbdb_alias("account_id")
    private String accountId;//'用户id'

    @Expose
    @pbdb_alias("rel_name")
    private String relName;//'真实姓名'

    @Expose
    @pbdb_alias("sex")
    private Integer sex;//姓名

    @Expose
    @pbdb_alias("phone_num")
    private String phoneNum;//'联系方式'

    @Expose
    @pbdb_alias("province")
    private String province;//'省'

    @Expose
    @pbdb_alias("city")
    private String city;//'城市'

    @Expose
    @pbdb_alias("county")
    private String county;//'县级'

    @Expose
    @pbdb_alias("detail_address")
    private String detailAddress;//'详细地址'

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getRelName() {
        return relName;
    }

    public void setRelName(String relName) {
        this.relName = relName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    @Override
    public String toString() {
        return "UserAddressInfo{" +
                "accountId='" + accountId + '\'' +
                ", relName='" + relName + '\'' +
                ", sex=" + sex +
                ", phoneNum='" + phoneNum + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                '}';
    }
}
