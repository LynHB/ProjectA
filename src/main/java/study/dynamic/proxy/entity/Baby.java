package study.dynamic.proxy.entity;


import lombok.extern.slf4j.Slf4j;

/**
 * @Author LynHB
 * @Description :
 *      Baby 实现来自IPerson接口的类
 * @Date 23:17 2020/7/8
 **/
@Slf4j
public class Baby implements IPerson {
    @Override
    public String eat(String dishName) {
        log.info("mother feed me {}",dishName);
        return "eat end";
    }

    @Override
    public String hungry() {
        log.info("wa wa wa");
        return "wa wa wa";
    }

}
