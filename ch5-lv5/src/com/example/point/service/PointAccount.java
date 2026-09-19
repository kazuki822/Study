package com.example.point.service;

public class PointAccount {

    private String accountId;
    private String memberId;
    private String memberName;
    private int currentPoints;
    private int lifetimePoints;
    private String rank;
    private String lastTransactionDate;
    private boolean active;

    public PointAccount(String accountId, String memberId, String memberName,
                        int currentPoints, int lifetimePoints, String rank,
                        String lastTransactionDate, boolean active) {
        this.accountId = accountId;
        this.memberId = memberId;
        this.memberName = memberName;
        this.currentPoints = currentPoints;
        this.lifetimePoints = lifetimePoints;
        this.rank = rank;
        this.lastTransactionDate = lastTransactionDate;
        this.active = active;
    }

    public String getAccountId()           { return accountId; }
    public String getMemberId()            { return memberId; }
    public String getMemberName()          { return memberName; }
    public int getCurrentPoints()          { return currentPoints; }
    public int getLifetimePoints()         { return lifetimePoints; }
    public String getRank()                { return rank; }
    public String getLastTransactionDate() { return lastTransactionDate; }
    public boolean isActive()              { return active; }
    public void setCurrentPoints(int p)    { this.currentPoints = p; }
    public void setLifetimePoints(int p)   { this.lifetimePoints = p; }
    public void setRank(String r)          { this.rank = r; }
}