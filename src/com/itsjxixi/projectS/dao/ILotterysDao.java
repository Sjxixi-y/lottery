package com.itsjxixi.projectS.dao;



import com.itsjxixi.projectS.entity.Lotterys;

import java.util.List;

public interface ILotterysDao {
    /**
     * 增加
     *
     * @param u 数据对象
     * @return 影响行数
     */
    int insert(Lotterys u);

    /**
     * 删除
     *
     * @param lotterys 根据ID删除行
     * @return 影响行数
     */
    int delete(String lotterys);

    /**
     * 修改
     *
     * @param u  数据对象
     * @param lotterys 根据 ID 修改行
     * @return 返回影响的行数
     */
    int update(Lotterys u, String lotterys);

    /**
     * 单独查询查询
     *
     * @param lotterys 根据 ID 查询
     * @return 查询到的数据
     */
    Lotterys select(String lotterys);

    /**
     * 全部查询
     *
     * @return 返回表数据
     */
    List<Lotterys> select();
}
