package cn.uestc.ssm.mapper;

import cn.uestc.ssm.po.ItemsCustom;
import cn.uestc.ssm.po.ItemsQueryVo;

import java.util.List;

public interface ItemsMapperCustom {
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}