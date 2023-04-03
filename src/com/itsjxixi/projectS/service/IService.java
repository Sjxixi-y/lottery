package com.itsjxixi.projectS.service;



import com.itsjxixi.projectS.entity.Lotterys;

import java.util.List;

public interface IService {
    /**
     * 机选
     *
     * @return 返回一个机选值
     */
    String machineSelection();

    /**
     * 机选
     *
     * @param numbers 传入一个用户选择的彩票号
     * @return 影响的行数
     */
    int optional(String numbers);

    /**
     * 查询全部
     *
     * @return 数据集合
     */
    List<Lotterys> lottery();

    /**
     * 开奖
     *
     * @return "第 " + X + " 期彩票为：" + Y
     */
    String select();
}
