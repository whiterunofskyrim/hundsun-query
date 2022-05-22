package com.example.businessearch.pojo;

import java.math.BigDecimal;

public class Bank {
    private String bankAccount;
    private String clientId;
    private BigDecimal cardBalance;
    private String bankJourId;
    private BigDecimal bankChange;

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(BigDecimal cardBalance) {
        this.cardBalance = cardBalance;
    }

    public String getBankJourId() {
        return bankJourId;
    }

    public void setBankJourId(String bankJourId) {
        this.bankJourId = bankJourId;
    }

    public BigDecimal getBankChange() {
        return bankChange;
    }

    public void setBankChange(BigDecimal bankChange) {
        this.bankChange = bankChange;
    }
}
