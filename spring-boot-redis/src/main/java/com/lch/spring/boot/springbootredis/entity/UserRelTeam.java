package com.lch.spring.boot.springbootredis.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Date;
@Entity(name = "user_rel_team")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRelTeam {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "team_id")
    private Long teamId;
    @Column(name = "manager")
    private Integer manager;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "create_user_email")
    private String createUserEmail;
    @Column(name = "create_user_name")
    private String createUserName;
    @Column(name = "modify_user_email")
    private String modifyUserEmail;
    @Column(name = "modify_user_name")
    private String modifyUserName;
    @Column(name = "update_time")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserEmail() {
        return createUserEmail;
    }

    public void setCreateUserEmail(String createUserEmail) {
        this.createUserEmail = createUserEmail;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getModifyUserEmail() {
        return modifyUserEmail;
    }

    public void setModifyUserEmail(String modifyUserEmail) {
        this.modifyUserEmail = modifyUserEmail;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", teamId=" + teamId +
                ", manager=" + manager +
                ", userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", createTime=" + createTime +
                ", createUserEmail='" + createUserEmail + '\'' +
                ", createUserName='" + createUserName + '\'' +
                ", modifyUserEmail='" + modifyUserEmail + '\'' +
                ", modifyUserName='" + modifyUserName + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
