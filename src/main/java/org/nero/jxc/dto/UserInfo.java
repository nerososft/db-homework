package org.nero.jxc.dto;

import java.sql.Date;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:40
 */
public class UserInfo {

    private Integer id;// bigint not null auto_increment,
    private String username;// varchar(64) not null,
    private String token;// varchar(64) not null,
    private Date ctime;// DATETIME DEFAULT CURRENT_TIMESTAMP,
    private Integer level;// int DEFAULT 0,

    public UserInfo(Integer id, String username, String token, Date ctime, Integer level) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.ctime = ctime;
        this.level = level;
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
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                ", ctime=" + ctime +
                ", level=" + level +
                '}';
    }
}
