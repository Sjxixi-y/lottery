package com.itsjxixi.projectS.controller;



import com.itsjxixi.projectS.entity.Lotterys;

import java.util.List;

/**
 * 校验
 */
public class Check {
    /**
     * 非空判断
     *
     * @param str 被校验字符
     * @throws E 编译错误
     */
    public void noNull(String str) throws E {
        if (str == null) {
            throw new E("输入错误 --- 请输入能被识别的字符");
        }
    }

    /**
     * 判断是否为单个数字
     *
     * @param str 被校验字符
     * @throws E 编译错误
     */
    public void noNumber(String str) throws E {
        noNull(str);
        // 判断输入的是否为 单个数字1
        if (!str.matches("[0-9]")) {
            throw new E("输入错误 --- 来自单独纠错机制。");
        }
    }

    /**
     * 判断输入的是否是 六位数；
     *
     * @param str 被校验字符
     * @throws E 编译错误
     */
    public void noSixNumber(String str) throws E {
        noNull(str);
        if (!str.matches("[0-9]{6}")) {
            throw new E("输入错误 --- 来自六位纠错机制");
        }
    }

    /**
     * 判断输入的是否为 （Y\N\y\n）
     *
     * @param str 被校验字符
     * @throws E 编译错误
     */
    public void noYyNn(String str) throws E {
        noNull(str);
        if (!str.matches("[YNyn]")) {
            throw new E("输入错误 --- 来自六位纠错机制");
        }
    }

    /**
     * 判断集合内是否有元素
     * @param list 被校验集合
     * @throws E 编译错误
     */
    public void isEmpty(List<Lotterys> list) throws E {
        if (list == null || list.size() == 0) {
            throw new E("还没有开启过一次奖");
        }
    }
}
