package com.itsjxixi.projectS.service.serviceImpl;



import com.itsjxixi.projectS.dao.daoImpl.LotteryDaoImpl;
import com.itsjxixi.projectS.dao.daoImpl.LotterysDaoImpl;
import com.itsjxixi.projectS.entity.Lottery;
import com.itsjxixi.projectS.entity.Lotterys;
import com.itsjxixi.projectS.service.IService;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class LotteryServiceImpl implements IService {
    private final Random ra = new Random();
    private final LotteryDaoImpl d = new LotteryDaoImpl();
    private final LotterysDaoImpl ds = new LotterysDaoImpl();

    /**
     * 自选
     *
     * @param numbers 传入一个用户选择的彩票号
     * @return 影响的行数
     */
    @Override
    public int optional(String numbers) {
        Lotterys l = new Lotterys(0, (int) d.select(false), numbers, new Date());
        return ds.insert(l);
    }

    /**
     * 机选
     *
     * @return 返回一个机选值
     */
    @Override
    public String machineSelection() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(ra.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * 查询全部
     *
     * @return 数据集合
     */
    @Override
    public List<Lotterys> lottery() {
        return ds.select();
    }

    /**
     * 开奖
     *
     * @return
     */
    @Override
    public String select() {
        // 获取一份中奖号
        String str = machineSelection();
        // 获取期数
        int a = (int) d.select(false);
        // 写入数据库
        d.insert(new Lottery(0, str, new Date()));
        // d.insert(new Lottery((int) d.select(false), null, null));
        return "第 " + a + " 期彩票为：" + str;
    }
}
