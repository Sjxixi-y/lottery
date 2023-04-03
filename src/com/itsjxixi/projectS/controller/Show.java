package com.itsjxixi.projectS.controller;

import java.util.Scanner;

public class Show {

    // 任意键返回
    public void show1(Scanner sc) {
        System.out.println("按任意键返回主页...");
        sc.nextLine();
    }

    // 打印界面最上面的介绍
    public void show3() {
        showa(10);
        System.out.print("购票");
        showa(10);
        System.out.println();
    }

    public void show4() {
        System.out.print("请输入：");
    }

    public void showa(int a) {
        for (int i = 0; i < a; i++) {
            System.out.print("=");
        }
    }
}


