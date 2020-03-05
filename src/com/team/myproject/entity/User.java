package com.team.myproject.entity;

public class User {
    private int userId;
    private String  userNum;
    private String  userName;
    private String  userAddr;
    private String  createDate;
    private int  cardId;
    private String cardName;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userNum='" + userNum + '\'' +
                ", userName='" + userName + '\'' +
                ", userAddr='" + userAddr + '\'' +
                ", createDate='" + createDate + '\'' +
                ", cardId=" + cardId +
                ", cardName='" + cardName + '\'' +
                '}';
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
}
