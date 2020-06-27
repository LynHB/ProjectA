package algorithms.leecode;

/**
 * @Author LynHB
 * @Description :
 *      Questions :
 *          You are given two strings, pattern and value. The pattern string consists of just the letters a and b, describing a pattern within a string. For example, the string catcatgocatgo matches the pattern aabab (where cat is a and go is b). It also matches patterns like a, ab, and b. Write a method to determine if value matches pattern. a and b cannot be the same string.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pattern-matching-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 20:09 2020/6/22
 **/
public class Order1618PatternMatchingIcci {

    private final int B_CAN_NOT_DIVIDE = -1;

    /**
     * @Description :通过a的数量和宽度及b的数量获取b的宽度
     * @Date 20:33 2020/6/22
     * @param l :总长度
     * @param aNumber :a的数量
     * @param bNumber :b的数量
     * @param aSize :单个a的长度
     * @return int
     **/
    private int getBSizeByASize(int l,int aNumber,int bNumber,int aSize){
           int bTotal =  l-aNumber*aSize;
           return bTotal%bNumber==0&&bTotal>=0?bTotal/bNumber:B_CAN_NOT_DIVIDE;
    }

    public boolean patternMatching(String pattern, String value) {
        if(pattern.equals(value)&& pattern.equals("")){
            return true;
        }

        int l = value.length();
        int aNumber = 0;
        int bNumber = 0;
        int aSize,bSize;

        // 统计a b数量
        for(int i=0;i<pattern.length();i++){
            if(pattern.charAt(i)=='a'){
                aNumber++;
            }else{
                bNumber++;
            }
        }

        // 排除a或者b其中一方的数量为0的情况
        if(aNumber==0 || bNumber==0){
            int number;
            if(aNumber!=0){
                number = aNumber;
            }else if(bNumber!=0){
                number = bNumber;
            }else{
                return false;
            }
            // 当l == 0说明 a或者b的字符串为“”符合题意返回true
            // 获取到的size，拿到value的第一个a的实际值，进行全替换的结果为""符合题意返回true
            boolean judge = l==0 || l%number==0&&value.replaceAll(value.substring(0,l/number),"").equals("");
            if(judge){
                return true;
            }
            return false;
        }

        // 针对a的size进行枚举
        for(int i=0;i<=l;i++){
            aSize = i;

            // 当前的a的总长度已经大于l的长度，后面的判断没必要继续进行了
            if(aSize*aNumber>l){
                break;
            }

            bSize = getBSizeByASize(l,aNumber,bNumber,aSize);
            // 当b的单个长度无法被整除时，或者b的总长度已经为负数，此时跳过该判断
            if(bSize == B_CAN_NOT_DIVIDE){
                continue;
            }

            // 排除a或者b长度为0的情况
            if(aSize==0 || bSize==0){
                int size = 0,number;
                if(aSize!=0){
                    size = aSize;
                    number = aNumber;
                }else if(bSize!=0){
                    size = bSize;
                    number = bNumber;
                }else{
                    continue;
                }

                // 获取到的size，拿到value的第一个a的实际值，进行全替换的结果为""符合题意返回true
                boolean judge =  l%size==0&&l==size*number&&value.replaceAll(value.substring(0,size),"").equals("");
                if(judge){
                    return true;
                }
                continue;
            }

            // 还原String和value做对比
            String aStr=null,bStr=null,res="";
            int index =0;
            for(int j=0;j<pattern.length();j++){
                Character c = pattern.charAt(j);
                if(c=='a'){
                    if(aStr==null){
                        aStr = value.substring(index,index+aSize);
                    }
                    res += aStr;

                    index += aSize;
                }else{
                    if(bStr==null){
                        bStr = value.substring(index,index+bSize);
                    }
                    res += bStr;
                    index +=bSize;
                }

            }
            if(res.equals(value)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        Order1618PatternMatchingIcci order1618PatternMatchingIcci = new Order1618PatternMatchingIcci();
        System.out.println(order1618PatternMatchingIcci.patternMatching("abba","dogcatcatdog"));
    }
}
