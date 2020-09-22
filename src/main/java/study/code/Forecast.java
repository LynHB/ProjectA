package study.code;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author LynHB
 * @Description : 预测规则
 * @Date 12:42 2020/8/11
 **/
@Getter
@Setter
public class Forecast {

    /** 默认预测需要的数据量 **/
    public static int DEFAULT_NUMBER = 10;

    /**一分钟的秒数**/
    public static int ONE_MINUTE = 60;


    /** 最小循环规律 **/
    private int[] regular;

    /**是否出现分钟内预测错误**/
    private boolean isMinuteIntervalError = false;



    /** 分钟变化 **/
    private int[] minuteVariety;



    /** 一分钟内变化 **/
    private int[] additionalVariety;

    /** 多少次循环触发一次 **/
    private int additionalInterval;







}
