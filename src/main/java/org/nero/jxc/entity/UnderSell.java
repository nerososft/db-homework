package org.nero.jxc.entity;

import java.sql.Date;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:28
 */
public class UnderSell {
    private Integer id;// int PRIMARY KEY  AUTO_INCREMENT,
    private Integer gid;//  int NOT NULL ,
    private Date undertiem;// DATETIME NOT NULL DEFAULT current_timestamp,
    private String reson;// VARCHAR(128)

    public UnderSell(Integer id, Integer gid, Date undertiem, String reson) {
        this.id = id;
        this.gid = gid;
        this.undertiem = undertiem;
        this.reson = reson;
    }

    public UnderSell() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Date getUndertiem() {
        return undertiem;
    }

    public void setUndertiem(Date undertiem) {
        this.undertiem = undertiem;
    }

    public String getReson() {
        return reson;
    }

    public void setReson(String reson) {
        this.reson = reson;
    }

    @Override
    public String toString() {
        return "UnderSell{" +
                "id=" + id +
                ", gid=" + gid +
                ", undertiem=" + undertiem +
                ", reson='" + reson + '\'' +
                '}';
    }
}
