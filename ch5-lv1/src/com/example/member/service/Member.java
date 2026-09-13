package com.example.member.service;

public class Member {

    private String memberId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String rank;
    private boolean active;
    private String createdAt;

    public Member(String memberId, String name, String email, String phoneNumber,
                  String address, String rank, boolean active, String createdAt) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.rank = rank;
        this.active = active;
        this.createdAt = createdAt;
    }

    public String getMemberId()   { return memberId; }
    public String getName()       { return name; }
    public String getEmail()      { return email; }
    public String getPhoneNumber(){ return phoneNumber; }
    public String getAddress()    { return address; }
    public String getRank()       { return rank; }
    public boolean isActive()     { return active; }
    public String getCreatedAt()  { return createdAt; }
}