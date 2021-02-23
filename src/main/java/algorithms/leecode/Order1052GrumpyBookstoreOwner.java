package algorithms.leecode;

import java.util.Arrays;

/**
 * @Author LynHB
 * @Description :
 *  今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 *
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 *
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 * @Date 14:03 2021/2/23
 **/
public class Order1052GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // 全部顾客都可以满意
        if(X>customers.length){
            return Arrays.stream(customers).sum();
        }
        int[] customerWithAngry = new int[customers.length];
        // 获取到百分百满意的客户
        int satisfied = 0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0){
                customerWithAngry[i] = 0;
                satisfied += customers[i];
            }else{
                customerWithAngry[i] = customers[i];
            }
        }
        // 滑动窗口，窗口大小X，拿到X最大值的总数
        int tempMax = 0;
        int temp = 0;
        for(int i=0;i<X;i++){
            temp+=customerWithAngry[i];
        }
        tempMax = temp;

        for(int i=X;i<customers.length;i++){
            temp += customerWithAngry[i];
            temp -= customerWithAngry[i-X];
            tempMax = Math.max(temp,tempMax);
        }
        return satisfied+tempMax;
    }
}
