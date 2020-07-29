package study.jvm;

/**
 * @Author LynHB
 * @Description :
 *      通过 -xms:xxxMB 调整初始化堆大小
 *      通过 -xmx:xxxMB 调整最大堆大小
 *      建议：
 *          将-xms和-xmx调整至一样大，减少堆的扩容和收缩
 *      默认：
 *          -xms为物理内存/64
 *          -xmx为物理内存/4
 * @Date 20:49 2020/7/11
 **/
public class XmsParameter {
    public static void main(String[] args){
        try{
            Thread.sleep(10000000000000000L);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        return;
    }

}
