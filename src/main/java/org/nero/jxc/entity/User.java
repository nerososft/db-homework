package org.nero.jxc.entity;

import java.sql.Date;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:02
 */
public class User {

    private Integer id;// bigint not null auto_increment,
    private String username;// varchar(64) not null,
    private String password;// varchar(64) not null,
    private String token;// varchar(64) not null,
    private Date ctime;// DATETIME DEFAULT CURRENT_TIMESTAMP,
    private Integer level;// int DEFAULT 0,

    public User(Integer id, String username, String password, String token, Date ctime, Integer level) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.token = token;
        this.ctime = ctime;
        this.level = level;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", ctime=" + ctime +
                ", level=" + level +
                '}';
    }
}
