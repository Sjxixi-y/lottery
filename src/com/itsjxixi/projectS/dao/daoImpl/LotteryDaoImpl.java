package com.itsjxixi.projectS.dao.daoImpl;


import com.itsjxixi.projectS.dao.ILotteryDao;
import com.itsjxixi.projectS.entity.Lottery;
import com.itsjxixi.projectS.util.DaoUtilDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 彩票期
 */
public class LotteryDaoImpl implements ILotteryDao {
    private final QueryRunner queryRunner = new QueryRunner(DaoUtilDruid.getDataSource());

    /**
     * 添加
     *
     * @param u 数据对象
     * @return 影响行数
     */
    @Override
    public int insert(Lottery u) {
        String sql = "insert into lottery(numbers, date) values(?, ?)";
        try {
            return queryRunner.update(sql, u.getNumbers(), u.getDate().toLocaleString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 删除
     *
     * @param period 根据ID删除行
     * @return 影响行数
     */
    @Override
    public int delete(String period) {
        String sql = "delete from lotterys where period = ?";
        try {
            return queryRunner.update(sql, period);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 修改
     *
     * @param u  数据对象
     * @param period 根据 ID 修改行
     * @return 返回影响的行数
     */
    @Override
    public int update(Lottery u, String period) {
        String sql = "update lottery set numbers = ?, date = ? where period = ?";
        try {
            return queryRunner.update(sql, u.getNumbers(), u.getDate().toLocaleString(), period);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 单独查询查询
     *
     * @param period 根据 ID 查询
     * @return 查询到的数据
     */
    @Override
    public Lottery select(String period) {
        String sql = "select * from lottery where period = ?";
        try {
            Lottery query = queryRunner.query(sql, new BeanHandler<>(Lottery.class), period);
            if (query != null)
                return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 全部查询
     *
     * @return 返回表数据
     */
    @Override
    public List<Lottery> select() {
        String sql = "select * from lottery";
        try {
            return queryRunner.query(sql, new BeanListHandler<>(Lottery.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回当前期号
     * @param b 多态查询，无意义
     * @return 当前期号
     */
    @Override
    public long select(boolean b) {
        String sql = "select COUNT(*) from lottery";
        long flag = 0;
        try {
             flag = queryRunner.query(sql, new ScalarHandler<>());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag + 1;
    }
}
