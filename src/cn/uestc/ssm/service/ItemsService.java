package cn.uestc.ssm.service;

import cn.uestc.ssm.po.ItemsCustom;
import cn.uestc.ssm.po.ItemsQueryVo;

import java.util.List;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>School: UESTC</p>
 *
 * @version 1.0
 * @author 罗一峰
 * @date 2016/4/11/18:51
 */
public interface ItemsService {
    //查询商品列表
    public List<ItemsCustom> findItemsList (ItemsQueryVo itemsQueryVo) throws Exception;

    //根据id查询商品信息
    public ItemsCustom findItemsById (Integer id) throws Exception;

    //根据id修改商品信息
    public void updateItems (Integer id, ItemsCustom itemsCustom) throws Exception;

    //根据id删除商品信息
    public void deleteItems (Integer[] id) throws Exception;
}
