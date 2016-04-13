package cn.uestc.ssm.mapper;

import cn.uestc.ssm.po.ItemsCustom;
import cn.uestc.ssm.po.ItemsQueryVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>School: UESTC</p>
 *
 * @version 1.0
 * @author 罗一峰
 * @date 2016/4/11/18:01
 */
public class ItemsMapperCustomTest {

    private ApplicationContext applicationContext;
    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:spring/applicationContext-dao.xml"
        );
    }

    @Test
    public void testFindItemsList() throws Exception {
        ItemsMapperCustom itemsMapperCustom = (ItemsMapperCustom) applicationContext.getBean("itemsMapperCustom");
        ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
        ItemsCustom itemsCustom = new ItemsCustom();
        itemsCustom.setName("笔记本");
        itemsQueryVo.setItemsCustom(itemsCustom);
        List<ItemsCustom> list = itemsMapperCustom.findItemsList(itemsQueryVo);
        System.out.println(list);
    }
}