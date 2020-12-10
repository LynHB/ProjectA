package algorithms.leecode;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @description:
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 *
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lemonade-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date: 10:05 2020/12/10
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order860LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer,Integer> profit = new HashMap<>();
        for(int i=0;i<bills.length;i++){
            Integer val = profit.putIfAbsent(bills[i],1);
            if(val!=null){
                profit.put(bills[i],val+1);
            }
            if(bills[i]==10){
                Integer change = profit.get(5);
                if(change==null || change <= 0){
                    return false;
                }
                profit.put(5,change-1);
            }
            if(bills[i]==20){
                // 先找10块再找5块
                int mustChange = 15;
                Integer tenChange = profit.get(10);
                if(tenChange!= null && tenChange>0){
                    profit.put(10,tenChange-1);
                    mustChange-=10;
                }
                Integer fiveChange = profit.get(5);
                if(fiveChange!=null && fiveChange>=mustChange/5){
                    profit.put(5,fiveChange-(mustChange/5));
                    mustChange = 0;
                }
                if(mustChange>0){
                    return false;
                }

            }
        }

        return true;

    }

    public static void main(String[] args){
        Order860LemonadeChange order860LemonadeChange = new Order860LemonadeChange();
        order860LemonadeChange.lemonadeChange(new int[]{5, 5, 5, 10, 5, 5, 10, 20, 20, 20});
    }
}
