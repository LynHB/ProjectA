package study.stream;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


/**
 * @Author LynHB
 * @Description : List Stream 转Map
 * @Date 1:42 2020/7/17
 **/
public class ListToMap {

    public static void main(String[] args){
        List<Integer> nums = Lists.newArrayList(1,2,3,1,10,2,3,10,10);

        // 统计nums每个元素出现的次数
        Map<Integer,Integer> map = Maps.newHashMap();
        nums.stream().forEach(pair->{
            map.compute(
                     pair,(key, val) -> val = (val==null ? 1 : val+1)
            );
        });
        System.out.println(map);
        System.out.println("===============");

        // 简单的list转map
        Map<Integer,Integer> map2 =  nums.stream().distinct().map(num -> {
            return new ImmutablePair<Integer,Integer>(num,1);
        }).collect(Collectors.toMap(pair -> pair.left,pair -> pair.right));
        System.out.println(map2);
        System.out.println("=====================");

        // 将map中的key val转成同等val数量的key
        Map<Integer,Integer> map1 = Maps.newHashMap();
        map1.put(10,2);
        map1.put(3,1);
        map1.put(7,2);

        List list = map1.entrySet().stream().map(entry -> {
            return IntStream.range(0, entry.getValue()).mapToObj($ -> entry.getKey()).collect(Collectors.toList());
        }).flatMap(Collection::stream).collect(toList());

        System.out.println(list);
        System.out.println("=====================");
    }
}
