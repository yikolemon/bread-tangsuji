package com.ruoyi.biz.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biz.mapper.BizOrderMapper;
import com.ruoyi.biz.domain.BizOrder;
import com.ruoyi.biz.service.IBizOrderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class BizOrderServiceImpl implements IBizOrderService 
{
    @Autowired
    private BizOrderMapper bizOrderMapper;

    /**
     * 查询商品订单
     * 
     * @param orderId 商品订单主键
     * @return 商品订单
     */
    @Override
    public BizOrder selectBizOrderByOrderId(Long orderId)
    {
        return bizOrderMapper.selectBizOrderByOrderId(orderId);
    }

    /**
     * 查询商品订单列表
     * 
     * @param bizOrder 商品订单
     * @return 商品订单
     */
    @Override
    public List<BizOrder> selectBizOrderList(BizOrder bizOrder)
    {
        return bizOrderMapper.selectBizOrderList(bizOrder);
    }

    /**
     * 新增商品订单
     * 
     * @param bizOrder 商品订单
     * @return 结果
     */
    @Override
    public int insertBizOrder(BizOrder bizOrder)
    {
        bizOrder.setCreateTime(DateUtils.getNowDate());
        return bizOrderMapper.insertBizOrder(bizOrder);
    }

    /**
     * 修改商品订单
     * 
     * @param bizOrder 商品订单
     * @return 结果
     */
    @Override
    public int updateBizOrder(BizOrder bizOrder)
    {
        bizOrder.setUpdateTime(DateUtils.getNowDate());
        return bizOrderMapper.updateBizOrder(bizOrder);
    }

    /**
     * 批量删除商品订单
     * 
     * @param orderIds 需要删除的商品订单主键
     * @return 结果
     */
    @Override
    public int deleteBizOrderByOrderIds(String orderIds)
    {
        return bizOrderMapper.deleteBizOrderByOrderIds(Convert.toStrArray(orderIds));
    }

    /**
     * 删除商品订单信息
     * 
     * @param orderId 商品订单主键
     * @return 结果
     */
    @Override
    public int deleteBizOrderByOrderId(Long orderId)
    {
        return bizOrderMapper.deleteBizOrderByOrderId(orderId);
    }
}
