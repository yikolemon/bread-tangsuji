package com.ruoyi.biz.service;

import java.util.List;
import com.ruoyi.biz.domain.BizProduct;

/**
 * 商品Service接口
 * 
 * @author ruoyi
 * @date 2025-04-01
 */
public interface IBizProductService 
{
    /**
     * 查询商品
     * 
     * @param productId 商品主键
     * @return 商品
     */
    public BizProduct selectBizProductByProductId(Long productId);

    /**
     * 查询商品列表
     * 
     * @param bizProduct 商品
     * @return 商品集合
     */
    public List<BizProduct> selectBizProductList(BizProduct bizProduct);

    /**
     * 新增商品
     * 
     * @param bizProduct 商品
     * @return 结果
     */
    public int insertBizProduct(BizProduct bizProduct);

    /**
     * 修改商品
     * 
     * @param bizProduct 商品
     * @return 结果
     */
    public int updateBizProduct(BizProduct bizProduct);

    /**
     * 批量删除商品
     * 
     * @param productIds 需要删除的商品主键集合
     * @return 结果
     */
    public int deleteBizProductByProductIds(String productIds);

    /**
     * 删除商品信息
     * 
     * @param productId 商品主键
     * @return 结果
     */
    public int deleteBizProductByProductId(Long productId);
}
