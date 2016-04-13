package cn.uestc.ssm.po;

/**
 * <p>Title: </p>
 * <p>Description: 商品包装对象</p>
 * <p>School: UESTC</p>
 *
 * @version 1.0
 * @author 罗一峰
 * @date 2016/4/11/17:51
 */
public class ItemsQueryVo {
    //商品信息
    private Items items;

    //为了系统 可扩展性，对原始生成的po进行扩展
    private ItemsCustom itemsCustom;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }
}
