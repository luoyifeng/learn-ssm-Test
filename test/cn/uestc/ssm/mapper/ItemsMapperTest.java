package cn.uestc.ssm.mapper;

import cn.uestc.ssm.po.ItemsCustom;
import cn.uestc.ssm.po.ItemsQueryVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>School: UESTC</p>
 *
 * @version 1.0
 * @author 罗一峰
 * @date 2016/4/12/19:35
 */
public class ItemsMapperTest {

    private ApplicationContext applicationContext;
    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:spring/applicationContext-dao.xml"
        );
    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        ItemsMapper itemsMapper = (ItemsMapper) applicationContext.getBean("itemsMapper");
        itemsMapper.deleteByPrimaryKey(1);
    }
}