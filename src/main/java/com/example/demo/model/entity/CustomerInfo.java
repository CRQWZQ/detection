package com.example.demo.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 杭州蓝诗网络科技有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created by 2018/12/04 <br>
 * @Author: <a href="wangzhiqiang@quannengzhanggui.cn">wzq</a>
 */
@Data
@Table(name = "customer_info")
@EqualsAndHashCode(callSuper = false)
public class CustomerInfo extends CommonDomain{
    @Column(name = "relation_uuid")
    private String relationUuid;//活动uuid
    @Column(name = "nick")
    private String nick;//旺旺昵称
    @Column(name = "punish_count")
    private int punishCount;//降权记录
    @Column(name = "no_sales_count")
    private int noSalesCount;//不计销量
    @Column(name = "rate_delete_count")
    private int rateDeleteCount;//删评记录
    @Column(name = "avg_number")
    private int avgNumber;//周平均单数
    @Column(name = "credit")
    private String credit;//信用
    @Column(name = "real_name_auth")
    private String realNameAuth;
    @Column(name = "sex")
    private String sex;//性别
    @Column(name = "tao_score")
    private String taoScore;
    @Column(name = "mongodb_id")
    private String mongodbId;

    public String getRelationUuid() {
        return relationUuid;
    }

    public void setRelationUuid(String relationUuid) {
        this.relationUuid = relationUuid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getPunishCount() {
        return punishCount;
    }

    public void setPunishCount(int punishCount) {
        this.punishCount = punishCount;
    }

    public int getNoSalesCount() {
        return noSalesCount;
    }

    public void setNoSalesCount(int noSalesCount) {
        this.noSalesCount = noSalesCount;
    }

    public int getRateDeleteCount() {
        return rateDeleteCount;
    }

    public void setRateDeleteCount(int rateDeleteCount) {
        this.rateDeleteCount = rateDeleteCount;
    }

    public int getAvgNumber() {
        return avgNumber;
    }

    public void setAvgNumber(int avgNumber) {
        this.avgNumber = avgNumber;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getRealNameAuth() {
        return realNameAuth;
    }

    public void setRealNameAuth(String realNameAuth) {
        this.realNameAuth = realNameAuth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTaoScore() {
        return taoScore;
    }

    public void setTaoScore(String taoScore) {
        this.taoScore = taoScore;
    }

    public String getMongodbId() {
        return mongodbId;
    }

    public void setMongodbId(String mongodbId) {
        this.mongodbId = mongodbId;
    }
}
