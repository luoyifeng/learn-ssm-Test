package cn.uestc.ssm.service.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>School: UESTC</p>
 *
 * @version 1.0
 * @author 罗一峰
 * @date 2016/4/11/19:37
 */
public class ItemsServiceImplTest {

    @Test
    public void testFindItemsList() throws Exception {
        ItemsServiceImpl itemsService = new ItemsServiceImpl();
        itemsService.findItemsList(null);
    }
}