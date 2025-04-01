package com.ruoyi.biz.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biz.mapper.BizOrderItemMapper;
import com.ruoyi.biz.domain.BizOrderItem;
import com.ruoyi.biz.service.IBizOrderItemService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品订单项Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class BizOrderItemServiceImpl implements IBizOrderItemService 
{
    @Autowired
    private BizOrderItemMapper bizOrderItemMapper;

    /**
     * 查询商品订单项
     * 
     * @param itemId 商品订单项主键
     * @return 商品订单项
     */
    @Override
    public BizOrderItem selectBizOrderItemByItemId(Long itemId)
    {
        return bizOrderItemMapper.selectBizOrderItemByItemId(itemId);
    }

    /**
     * 查询商品订单项列表
     * 
     * @param bizOrderItem 商品订单项
     * @return 商品订单项
     */
    @Override
    public List<BizOrderItem> selectBizOrderItemList(BizOrderItem bizOrderItem)
    {
        return bizOrderItemMapper.selectBizOrderItemList(bizOrderItem);
    }

    /**
     * 新增商品订单项
     * 
     * @param bizOrderItem 商品订单项
     * @return 结果
     */
    @Override
    public int insertBizOrderItem(BizOrderItem bizOrderItem)
    {
        bizOrderItem.setCreateTime(DateUtils.getNowDate());
        return bizOrderItemMapper.insertBizOrderItem(bizOrderItem);
    }

    /**
     * 修改商品订单项
     * 
     * @param bizOrderItem 商品订单项
     * @return 结果
     */
    @Override
    public int updateBizOrderItem(BizOrderItem bizOrderItem)
    {
        bizOrderItem.setUpdateTime(DateUtils.getNowDate());
        return bizOrderItemMapper.updateBizOrderItem(bizOrderItem);
    }

    /**
     * 批量删除商品订单项
     * 
     * @param itemIds 需要删除的商品订单项主键
     * @return 结果
     */
    @Override
    public int deleteBizOrderItemByItemIds(String itemIds)
    {
        return bizOrderItemMapper.deleteBizOrderItemByItemIds(Convert.toStrArray(itemIds));
    }

    /**
     * 删除商品订单项信息
     * 
     * @param itemId 商品订单项主键
     * @return 结果
     */
    @Override
    public int deleteBizOrderItemByItemId(Long itemId)
    {
        return bizOrderItemMapper.deleteBizOrderItemByItemId(itemId);
    }
}
