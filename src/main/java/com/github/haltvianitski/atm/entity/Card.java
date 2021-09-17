package com.github.haltvianitski.atm.entity;

public class Card {
    private double balance;
    private String ownersName;
    private String number;
    private String validity;
    private String iban;
    private int password;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private boolean status;

    @Override
    public String toString() {
        return getNumber() + " " + getOwnersName() + " " + getValidity() + " " + getIban() + " " + getBalance() + " " + getPassword() + " " + isStatus();
    }

    public Card(String number, String ownersName, String validity, String iban, double balance, int password, boolean status) {
        this.balance = balance;
        this.ownersName = ownersName;
        this.number = number;
        this.validity = validity;
        this.iban = iban;
        this.password = password;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPassword() {
        return password;
    }

    public Double getBalance() {
        return balance;
    }

    public String getOwnersName() {
        return ownersName;
    }

    public String getNumber() {
        return number;
    }

    public String getValidity() {
        return validity;
    }

    public String getIban() {
        return iban;
    }

}
