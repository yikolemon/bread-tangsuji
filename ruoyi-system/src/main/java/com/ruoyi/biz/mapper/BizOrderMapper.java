package com.ruoyi.biz.mapper;

import java.util.List;
import com.ruoyi.biz.domain.BizOrder;

/**
 * 商品订单Mapper接口
 * 
 * @author ruoyi
 * @date 2025-04-01
 */
public interface BizOrderMapper 
{
    /**
     * 查询商品订单
     * 
     * @param orderId 商品订单主键
     * @return 商品订单
     */
    public BizOrder selectBizOrderByOrderId(Long orderId);

    /**
     * 查询商品订单列表
     * 
     * @param bizOrder 商品订单
     * @return 商品订单集合
     */
    public List<BizOrder> selectBizOrderList(BizOrder bizOrder);

    /**
     * 新增商品订单
     * 
     * @param bizOrder 商品订单
     * @return 结果
     */
    public int insertBizOrder(BizOrder bizOrder);

    /**
     * 修改商品订单
     * 
     * @param bizOrder 商品订单
     * @return 结果
     */
    public int updateBizOrder(BizOrder bizOrder);

    /**
     * 删除商品订单
     * 
     * @param orderId 商品订单主键
     * @return 结果
     */
    public int deleteBizOrderByOrderId(Long orderId);

    /**
     * 批量删除商品订单
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizOrderByOrderIds(String[] orderIds);
}
