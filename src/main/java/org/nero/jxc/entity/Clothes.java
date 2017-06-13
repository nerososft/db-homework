package org.nero.jxc.entity;

import com.sun.org.apache.bcel.internal.generic.FLOAD;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/4/9
 * Time   下午7:02
 */
public class Clothes {
    private Integer id;
    private String name;
    private String pingpai;
    private String color;
    private String size;
    private String person;
    private Float price;
    private Integer num;

    public Clothes(Integer id, String name, String pingpai, String color, String size, String person, Float price, Integer num) {
        this.id = id;
        this.name = name;
        this.pingpai = pingpai;
        this.color = color;
        this.size = size;
        this.person = person;
        this.price = price;
        this.num = num;
    }

    public Clothes() {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
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
        return "Clothes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pingpai=" + pingpai +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", person='" + person + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }
}
