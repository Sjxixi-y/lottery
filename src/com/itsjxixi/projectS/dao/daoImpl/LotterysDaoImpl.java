package com.itsjxixi.projectS.dao.daoImpl;


import com.itsjxixi.projectS.dao.ILotterysDao;
import com.itsjxixi.projectS.entity.Lotterys;
import com.itsjxixi.projectS.util.DaoUtilDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class LotterysDaoImpl implements ILotterysDao {
    private final QueryRunner queryRunner = new QueryRunner(DaoUtilDruid.getDataSource());
    // 增加
    @Override
    public int insert(Lotterys u) {
        String sql = "insert into lotterys(period, numbers, date) values(?, ?, ?)";
        try {
            return queryRunner.update(sql, u.getPeriod(), u.getNumbers(), u.getDate().toLocaleString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 删除
    @Override
    public int delete(String id) {
        String sql = "delete from lotterys where id = ?";
        try {
            return queryRunner.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 数据修改
    @Override
    public int update(Lotterys u, String card) {
        String sql = "update lotterys set period = ?, numbers = ?, date = ? where id = ?";
        try {
            return queryRunner.update(sql, u.getPeriod(), u.getNumbers(), u.getDate().toLocaleString(), card);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 查询数据
    @Override
    public Lotterys select(String id) {
        String sql = "select * from lotterys where id = ?";
        try {
            Lotterys query = queryRunner.query(sql, new BeanHandler<>(Lotterys.class), id);
            if (query != null)
                return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询数据
    @Override
    public List<Lotterys> select() {
        String sql = "select * from lotterys";
        try {
            return queryRunner.query(sql, new BeanListHandler<>(Lotterys.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
