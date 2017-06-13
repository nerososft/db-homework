package org.nero.jxc.entity;

import java.sql.Date;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:03
 */
public class InstockItem {
    private Integer id;// int PRIMARY KEY AUTO_INCREMENT,
    private Date intime;// DATETIME NOT NULL ,
    private Integer gid;// int NOT NULL ,
    private Integer num;// INT NOT NULL ,
    private Float price;// FLOAT NOT NULL ,
    private Float allprice;// FLOAT not NULL ,

    public InstockItem(Integer id, Date intime, Integer gid, Integer num, Float price, Float allprice) {
        this.id = id;
        this.intime = intime;
        this.gid = gid;
        this.num = num;
        this.price = price;
        this.allprice = allprice;
    }

    public InstockItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getAllprice() {
        return allprice;
    }

    public void setAllprice(Float allprice) {
        this.allprice = allprice;
    }

    @Override
    public String toString() {
        return "InstockItem{" +
                "id=" + id +
                ", intime=" + intime +
                ", gid=" + gid +
                ", num=" + num +
                ", price=" + price +
                ", allprice=" + allprice +
                '}';
    }
}
