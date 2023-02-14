package gov.iti.jets.controllers;

import java.io.Serializable;

public class CashingUser implements Serializable {
    private String phoneNumber;
    private String passWord;
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public CashingUser(String phoneNumber, String passWord) {
        this.phoneNumber = phoneNumber;
        this.passWord = passWord;
    }
    public String toString() {
        return "CashingUser{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

}
