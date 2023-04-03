package com.itsjxixi.projectS.dao;



import com.itsjxixi.projectS.entity.Lottery;

import java.util.List;

public interface ILotteryDao {
    /**
     * 增加
     *
     * @param u 数据对象
     * @return 影响行数
     */
    int insert(Lottery u);

    /**
     * 删除
     *
     * @param id 根据ID删除行
     * @return 影响行数
     */
    int delete(String id);

    /**
     * 修改
     *
     * @param u  数据对象
     * @param id 根据 ID 修改行
     * @return 返回影响的行数
     */
    int update(Lottery u, String id);

    /**
     * 单独查询查询
     *
     * @param id 根据 ID 查询
     * @return 查询到的数据
     */
    Lottery select(String id);

    /**
     * 全部查询
     *
     * @return 返回表数据
     */
    List<Lottery> select();

    /**
     * 查询当前期号
     * @param b 多态查询，无意义
     * @return 期号
     */
    long select(boolean b);
}
