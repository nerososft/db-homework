package org.nero.jxc.entity;

import org.nero.jxc.service.INoticeService;

import java.sql.Date;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:02
 */
public class Food {
    private Integer id;
    private String name;
    private String pingpai;
    private Date baozhiqi;
    private String chandi;
    private Float price;
    private Integer num;

    public Food() {
    }

    public Food(Integer id, String name, String pingpai, Date baozhiqi, String chandi, Float price, Integer num) {
        this.id = id;
        this.name = name;
        this.pingpai = pingpai;
        this.baozhiqi = baozhiqi;
        this.chandi = chandi;
        this.price = price;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPingpai() {
        return pingpai;
    }

    public void setPingpai(String pingpai) {
        this.pingpai = pingpai;
    }

    public Date getBaozhiqi() {
        return baozhiqi;
    }

    public void setBaozhiqi(Date baozhiqi) {
        this.baozhiqi = baozhiqi;
    }

    public String getChandi() {
        return chandi;
    }

    public void setChandi(String chandi) {
        this.chandi = chandi;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pingpai='" + pingpai +'\''+
                ", baozhiqi=" + baozhiqi +
                ", chandi='" + chandi + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }
}
