package com.ruoyi.biz.service;

import java.util.List;
import com.ruoyi.biz.domain.BizOrderItem;

/**
 * 商品订单项Service接口
 * 
 * @author ruoyi
 * @date 2025-04-01
 */
public interface IBizOrderItemService 
{
    /**
     * 查询商品订单项
     * 
     * @param itemId 商品订单项主键
     * @return 商品订单项
     */
    public BizOrderItem selectBizOrderItemByItemId(Long itemId);

    /**
     * 查询商品订单项列表
     * 
     * @param bizOrderItem 商品订单项
     * @return 商品订单项集合
     */
    public List<BizOrderItem> selectBizOrderItemList(BizOrderItem bizOrderItem);

    /**
     * 新增商品订单项
     * 
     * @param bizOrderItem 商品订单项
     * @return 结果
     */
    public int insertBizOrderItem(BizOrderItem bizOrderItem);

    /**
     * 修改商品订单项
     * 
     * @param bizOrderItem 商品订单项
     * @return 结果
     */
    public int updateBizOrderItem(BizOrderItem bizOrderItem);

    /**
     * 批量删除商品订单项
     * 
     * @param itemIds 需要删除的商品订单项主键集合
     * @return 结果
     */
    public int deleteBizOrderItemByItemIds(String itemIds);

    /**
     * 删除商品订单项信息
     * 
     * @param itemId 商品订单项主键
     * @return 结果
     */
    public int deleteBizOrderItemByItemId(Long itemId);
}
