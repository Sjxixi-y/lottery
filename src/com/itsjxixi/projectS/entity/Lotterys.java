package com.itsjxixi.projectS.entity;

import java.util.Date;

/**
 * 彩票单号
 */
public class Lotterys {
    // 订单号
    private int id;
    // 期号
    private int period;
    // 彩票号
    private String numbers;
    // 日期
    private Date date;

    public Lotterys() {
    }

    public Lotterys(int id, int period, String numbers, Date date) {
        this.id = id;
        this.period = period;
        this.numbers = numbers;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "订单{" +
                "订单id=" + id +
                ", 期号=" + period +
                ", 开奖号码='" + numbers + '\'' +
                ", 时间=" + date.toLocaleString() +
                '}';
    }
}
