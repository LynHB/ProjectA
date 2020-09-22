package study.code;

import static study.code.Forecast.DEFAULT_NUMBER;
import static study.code.Forecast.ONE_MINUTE;
import static study.code.FunctionData.*;
import static study.code.FunctionData2.*;

/**
 * @Author LynHB
 * @Description :
 * @Date 2:19 2020/8/11
 **/
public class DataForecast {

    public static void main(String[] args){
        System.out.println("function 1");
        test(functionData1);
        int num = 0;
        for(int i=0;i<functionData1.length;i++){
            num +=functionData1[i];
        }

        System.out.println(num);
        System.out.println("function 2");
        test(functionData2);
        System.out.println("function 3");
        test(functionData3);
        System.out.println("function 4");
        test(functionData4);
        System.out.println("function 5");
        test(functionData5);
        num = 0;
        for(int i=0;i<functionData5.length;i++){
            num +=functionData5[i];
        }
        System.out.println(num);
        System.out.println("function 6");
        test(functionData6);
        System.out.println("function 7");
        test(functionData7);
        System.out.println("function 8");
        test(functionData8);
        System.out.println("function 9");
        test(functionData9);
        System.out.println("function 10");
        test(functionData10);
        System.out.println("function 11");
        test(functionData11);
        System.out.println("function 12");
        test(functionData12);
        System.out.println("function 13");
        test(functionData13);
        System.out.println("function 14");
        test(functionData14);
        num = 0;
        for(int i=0;i<functionData14.length;i++){
            num +=functionData14[i];
        }
        System.out.println(num);
        System.out.println("function 15");
        test(functionData15);


    }


    public static void test(int[] functionDataArg){
        // 当前测算程序为20分钟，现在所有function小于20分钟，足够做预测推算
        int[] regular;

        int[] functionData = functionDataArg;
        Forecast forecast = new Forecast();


        for(int z=0;z<functionData.length/10;z++){
            int loopData = DEFAULT_NUMBER*(z+1);

            // regular从一位开始预测
            for(int i=0;i<loopData/2;i++){
                // 给regular赋值
                regular = new int[i+1];
                for(int j=0;j<=i;j++){
                    regular[j] = functionData[j];
                }

                boolean isMatch = true;


                // 匹配regular准确性
                for(int j=0;j<loopData;){

                    boolean breakF = false;
                    for(int r=0;r<regular.length;r++){
                        if(functionData[j]==regular[r]){
                            j++;
                        }else{
                            breakF = true;
                            break;
                        }
                    }
                    if(breakF){
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch ){
                    // 匹配到了
                    forecast.setRegular(regular);
                    break;
                }
            }
            if(forecast.getRegular()!=null){
                break;
            }
        }





        int errorNumber = 0;
        int rightNumber = 0;
        int differentNumber = 0;
        int forecastTotalNumber = 0;
        if(forecast.getRegular()!=null){
            forecast.setMinuteVariety(new int[forecast.getRegular().length]);
            // 通过预测结果补全 dp 元素
            for(int i = DEFAULT_NUMBER;i<functionData.length;i++){
                forecastTotalNumber+=functionData[i];
                if(i%ONE_MINUTE==0){
                     //System.out.println("新的一分钟");
                }
                if(i%ONE_MINUTE==0 && !forecast.isMinuteIntervalError()){
                    // 每分钟递加 分钟变化
                    for(int j=0;j<forecast.getRegular().length;j++){
                        forecast.getRegular()[j] = forecast.getRegular()[j]+forecast.getMinuteVariety()[j];
                    }

                }

                int forecastNumber = forecast.getRegular()[i%forecast.getRegular().length];
                // System.out.println("预测值为："+forecastNumber+",实际值为："+functionData[i]);
                if(forecastNumber!=functionData[i]){
                    errorNumber++;
                    differentNumber += (Math.abs(forecastNumber-functionData[i]));
                    // 分钟内预测紊乱，此时不应该进行分钟周期预测
                    if(i%ONE_MINUTE<forecast.getRegular().length && !forecast.isMinuteIntervalError()){
                        forecast.getMinuteVariety()[i%ONE_MINUTE] = functionData[i] - forecast.getRegular()[i%ONE_MINUTE];
                    }else{
                        forecast.setMinuteIntervalError(true);
                    }
                    // 设置该值
                    forecast.getRegular()[i%forecast.getRegular().length] = functionData[i];
                }else{
                    rightNumber++;
                }

            }
        }else if(functionData.length>DEFAULT_NUMBER){
            forecast.setRegular(new int[]{functionData[DEFAULT_NUMBER-1]});
            for(int i = DEFAULT_NUMBER;i<functionData.length;i++){
                forecastTotalNumber+=functionData[i];
                if(functionData[i]!=forecast.getRegular()[0]){
                    errorNumber++;
                    differentNumber+=Math.abs(functionData[i] - forecast.getRegular()[0]);
                    forecast.getRegular()[0] = functionData[i];
                }else {
                    rightNumber++;
                }
            }
        }
        System.out.println("正确预测数："+rightNumber+" 错误预测数:"+errorNumber+" "+"误差容器数："+differentNumber+",预测总容器数："+forecastTotalNumber);














    }
}
