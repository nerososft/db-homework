package org.nero.jxc.entity;

import java.sql.Date;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:02
 */
public class SellItem {
    private Integer id;// int PRIMARY KEY AUTO_INCREMENT,
    private Date selltime;// DATETIME NOT NULL ,
    private Integer gid;// int NOT NULL ,
    private Integer num;// INT NOT NULL ,
    private Float price;// FLOAT NOT NULL ,
    private Float allprice;// FLOAT not NULL ,

    public SellItem(Integer id, Date selltime, Integer gid, Integer num, Float price, Float allprice) {
        this.id = id;
        this.selltime = selltime;
        this.gid = gid;
        this.num = num;
        this.price = price;
        this.allprice = allprice;
    }

    public SellItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSelltime() {
        return selltime;
    }

    public void setSelltime(Date selltime) {
        this.selltime = selltime;
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
        return "SellItem{" +
                "id=" + id +
                ", selltime=" + selltime +
                ", gid=" + gid +
                ", num=" + num +
                ", price=" + price +
                ", allprice=" + allprice +
                '}';
    }
}
