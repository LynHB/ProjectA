package study.dynamic.proxy.entity;

/**
 * @Author LynHB
 * @Description : 代理接口
 * @Date 23:13 2020/7/8
 **/
public interface IPerson {
    /**
     * @Description : 吃菜
     * @Date 23:14 2020/7/8
     * @param dishName : 菜名
     * @return java.lang.String
     **/
    String eat(String dishName);

    /**
     * @Description : 饥渴
     * @Date 23:15 2020/7/8
     * @return java.lang.String
     **/
    String hungry();
}
