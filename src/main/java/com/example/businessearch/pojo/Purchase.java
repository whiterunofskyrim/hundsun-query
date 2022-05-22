package com.example.businessearch.pojo;

import java.math.BigDecimal;
import java.sql.Date;

public class Purchase {
    private String purchaseId;
    private String clientId;
    private String bankAccount;
    private String fundCode;
    private Date purchaseDate;
    private BigDecimal purchaseCount;
    private BigDecimal purchaseShare;
    private String purchaseStatus;

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
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

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(BigDecimal purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public BigDecimal getPurchaseShare() {
        return purchaseShare;
    }

    public void setPurchase_share(BigDecimal purchaseShare) {
        this.purchaseShare = purchaseShare;
    }

    public String getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchase_status(String purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }
}
