package org.samsara.pistachio.entity;

import java.util.Date;

/**
 * User Entity
 * @author sczyh30
 */
public class User {

    private Integer uid;

    private Integer borrowId;

    private String username;

    private Integer role;

    private String tips;

    private Integer gender;

    private Date birth;

    private String email;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User -> {" +
                "uid=" + uid +
                ", borrowId=" + borrowId +
                ", username='" + username + '\'' +
                ", role=" + role +
                ", tips='" + tips + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                ", email='" + email + '\'' +
                '}';
    }
}