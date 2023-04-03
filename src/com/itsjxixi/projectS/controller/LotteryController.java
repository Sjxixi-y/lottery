package com.itsjxixi.projectS.controller;




import com.itsjxixi.projectS.entity.Lotterys;
import com.itsjxixi.projectS.service.serviceImpl.LotteryServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * 界面
 */
public class LotteryController {
    Show show = new Show();
    Scanner sc = new Scanner(System.in);
    Check tjy = new Check();
    LotteryServiceImpl ts = new LotteryServiceImpl();

    /**
     * 首页
     */
    public void frontPage() {
        while (true) {
            // 打印主页
            show.show3();
            System.out.println("1.购买");
            System.out.println("2.查看历史信息");
            System.out.println("3.开奖");
            System.out.println("4.退出");
            show.show4();
            // 输入等待
            String str = sc.nextLine();
            try {
                // 判断是否为单个字符
                tjy.noNumber(str);
                // 输入字符串转化为字符
                char s = str.charAt(0);
                switch (s) {
                    case '1':
                        // 进入界面1 购买
                        buy();
                        break;
                    case '2':
                        // 进入界面2 查询历史
                        viewHistory();
                        break;
                    case '3':
                        // 进入界面3 开奖
                        lottery();
                        break;
                    case '4':
                        // 退出

                        return;
                    default:
                        // 其他选项
                        System.err.println("***输入错误***");
                }
            } catch (E e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * 界面 1 购买
     */
    public void buy() {
        while (true) {
            // 界面
            show.show3();
            System.out.println("1.自选");
            System.out.println("2.机选");
            System.out.println("3.退出");
            show.show4();
            // 等待输入
            String str = sc.nextLine();
            try {
                // 判断是否为单个字符
                tjy.noNumber(str);
                // 输入字符串转化为字符
                char s = str.charAt(0);
                switch (s) {
                    case '1':
                        // 自选
                        optional();
                        break;
                    case '2':
                        // 机选
                        machineSelection();
                        break;
                    case '3':
                        // 退出
                        return;
                    default:
                        System.err.println("输入错误");
                }
            } catch (E e) {
                System.err.println(e.getMessage());
            }
        }
    }

    // 自选界面
    public void optional() {
        System.out.print("请输入六位号码：");
        String s = sc.nextLine();
        try {
            // 纠错机制
            tjy.noSixNumber(s);
            // 上传数据
            int flag = 0;
            flag = ts.optional(s);
            if (flag == 1) {
                System.out.println("购票成功!!!");
            } else {
                System.out.println("自选购票失败");
            }
            // 按任意键返回
            show.show1(sc);
        } catch (E e) {
            System.err.println(e.getMessage());
        }
    }

    // 机选界面
    public void machineSelection() {
        // 获取彩票号
        String s = ts.machineSelection();
        System.out.println("获取到了：" + s);
        // 上传数据
        int flag = 0;
        flag = ts.optional(s);
        if (flag == 1) {
            System.out.println("购票成功!!!");
        } else {
            System.out.println("自选购票失败");
        }
        // 按任意键返回
        show.show1(sc);
    }

    /**
     * 界面 2 查看历史
     */
    public void viewHistory() {
        // 提示界面
        show.show3();
        // 获取数据
        List<Lotterys> l = ts.lottery();
        try {
            // 判断集合是否有数据
            tjy.isEmpty(l);
            // 输出
            for (Lotterys l1 : l) {
                System.out.println(l1);
            }
            // 按任意键返回
            show.show1(sc);
        } catch (E e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 界面 3 开奖
     */
    public void lottery() {
        // 输入界面
        show.show3();
        System.out.println("是否开奖？Y/N");
        // 等待输入
        String s = sc.nextLine();
        try {
            tjy.noYyNn(s);
            if ("Y".equalsIgnoreCase(s)) {
                // 开奖
                System.out.println(ts.select());
            }
        } catch (E e) {
            System.err.println(e.getMessage());
        }
    }
}
