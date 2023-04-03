package com.itsjxixi.projectS.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DaoUtilDruid {
    private static DruidDataSource ds;

    static {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/database.properties");
            properties.load(fileInputStream);
            // 创建连接池对象
            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取连接池对象
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    // 返回一个数据源
    public static DataSource getDataSource() {
        return ds;
    }

    // 释放资源
    public static void close(Connection c, PreparedStatement p, ResultSet r) {
        try {
            if (r != null)
                r.close();
        } catch (SQLException s) {
            s.printStackTrace();
        } finally {
            try {
                if (p != null)
                    p.close();
            } catch (SQLException s) {
                s.printStackTrace();
            } finally {
                try {
                    if (c != null) {
                        c.close();
                    }
                } catch (SQLException s) {
                    s.printStackTrace();
                }
            }
        }
    }
}
