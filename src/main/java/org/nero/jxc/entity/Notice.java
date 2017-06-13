package org.nero.jxc.entity;

import java.beans.IntrospectionException;
import java.sql.Date;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:02
 */
public class Notice {

    private Integer id;// int PRIMARY KEY AUTO_INCREMENT,
    private Integer type;// VARCHAR(32) NOT NULL ,
    private String content;// VARCHAR(64) NOT NULL ,
    private Date ctime;// DATETIME DEFAULT current_timestamp

    public Notice(Integer id, Integer type, String content, Date ctime) {
        this.id = id;
        this.type = type;
        this.content = content;
        this.ctime = ctime;
    }

    public Notice() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", ctime=" + ctime +
                '}';
    }
}
