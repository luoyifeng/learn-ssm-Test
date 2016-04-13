package cn.uestc.ssm.service.impl;

import cn.uestc.ssm.exception.CustomException;
import cn.uestc.ssm.mapper.ItemsMapper;
import cn.uestc.ssm.mapper.ItemsMapperCustom;
import cn.uestc.ssm.po.Items;
import cn.uestc.ssm.po.ItemsCustom;
import cn.uestc.ssm.po.ItemsQueryVo;
import cn.uestc.ssm.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>School: UESTC</p>
 *
 * @version 1.0
 * @author 罗一峰
 * @date 2016/4/11/18:53
 */
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Autowired
    private ItemsMapper itemsMapper;

    //查询商品列表
    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        //通过ItemsMapperCustom查询数据库
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }

    //根据id查询商品信息
    @Override
    public ItemsCustom findItemsById(Integer id) throws Exception {
        Items items = itemsMapper.selectByPrimaryKey(id);

        if (items == null) {
            throw new CustomException("修改的商品信息不存在！！！");
        }

        //返回ItemsCustom
        ItemsCustom itemsCustom = null;

        if (items != null) {
            itemsCustom = new ItemsCustom();
            //将items的属性值拷贝到itemsCustom中
            BeanUtils.copyProperties(items, itemsCustom);
        }
        return itemsCustom;
    }

    //根据商品id更新商品信息
    @Override
    public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
        //添加业务校验，通常在service接口对关键参数进行校验
        //校验 id是否为空，如果为空抛出异常

        //更新商品信息使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括 大文本类型字段
        //updateByPrimaryKeyWithBLOBs要求必须转入id
        itemsCustom.setId(id);
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
    }

    @Override
    public void deleteItems(Integer[] id) throws Exception {
        for (int items_id : id){
            itemsMapper.deleteByPrimaryKey(items_id);
        }

    }
}
