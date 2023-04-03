package com.itsjxixi.projectS.entity;

import java.util.Date;

/**
 * 彩票期
 */
public class Lottery {
    // 彩票期数
    private int period;
    // 当前期开奖号码
    private String numbers;
    // 开奖日期
    private Date date;

    public Lottery() {
    }

    public Lottery(int period, String numbers, Date date) {
        this.period = period;
        this.numbers = numbers;
        this.date = date;
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
        return "Lottery{" +
                "period=" + period +
                ", numbers='" + numbers + '\'' +
                '}';
    }
}
