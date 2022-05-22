package com.example.businessearch.pojo;

import java.math.BigDecimal;
import java.sql.Date;

public class RedemResult {
    private String redemId;
    private String clientId;
    private String bankAccount;
    private String fundCode;
    private Date redemDate;
    private BigDecimal redemShare;
    private BigDecimal redemCount;
    private BigDecimal redemCurrentShare;
    private Date redemEstimatedDate;
    private String redemStatus;
    private String clientName;
    private String fundName;

    public String getRedemId() {
        return redemId;
    }

    public void setRedemId(String redemId) {
        this.redemId = redemId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public Date getRedemDate() {
        return redemDate;
    }

    public void setRedemDate(Date redemDate) {
        this.redemDate = redemDate;
    }

    public BigDecimal getRedemShare() {
        return redemShare;
    }

    public void setRedemShare(BigDecimal redemShare) {
        this.redemShare = redemShare;
    }

    public BigDecimal getRedemCount() {
        return redemCount;
    }

    public void setRedemCount(BigDecimal redemCount) {
        this.redemCount = redemCount;
    }

    public BigDecimal getRedemCurrentShare() {
        return redemCurrentShare;
    }

    public void setRedemCurrentShare(BigDecimal redemCurrentShare) {
        this.redemCurrentShare = redemCurrentShare;
    }

    public Date getRedemEstimatedDate() {
        return redemEstimatedDate;
    }

    public void setRedemEstimatedDate(Date redemEstimatedDate) {
        this.redemEstimatedDate = redemEstimatedDate;
    }

    public String getRedemStatus() {
        return redemStatus;
    }

    public void setRedemStatus(String redemStatus) {
        this.redemStatus = redemStatus;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }
}
