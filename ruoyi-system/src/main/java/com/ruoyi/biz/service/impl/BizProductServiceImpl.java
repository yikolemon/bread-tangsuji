package com.ruoyi.biz.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biz.mapper.BizProductMapper;
import com.ruoyi.biz.domain.BizProduct;
import com.ruoyi.biz.service.IBizProductService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class BizProductServiceImpl implements IBizProductService 
{
    @Autowired
    private BizProductMapper bizProductMapper;

    /**
     * 查询商品
     * 
     * @param productId 商品主键
     * @return 商品
     */
    @Override
    public BizProduct selectBizProductByProductId(Long productId)
    {
        return bizProductMapper.selectBizProductByProductId(productId);
    }

    /**
     * 查询商品列表
     * 
     * @param bizProduct 商品
     * @return 商品
     */
    @Override
    public List<BizProduct> selectBizProductList(BizProduct bizProduct)
    {
        return bizProductMapper.selectBizProductList(bizProduct);
    }

    /**
     * 新增商品
     * 
     * @param bizProduct 商品
     * @return 结果
     */
    @Override
    public int insertBizProduct(BizProduct bizProduct)
    {
        bizProduct.setCreateTime(DateUtils.getNowDate());
        return bizProductMapper.insertBizProduct(bizProduct);
    }

    /**
     * 修改商品
     * 
     * @param bizProduct 商品
     * @return 结果
     */
    @Override
    public int updateBizProduct(BizProduct bizProduct)
    {
        bizProduct.setUpdateTime(DateUtils.getNowDate());
        return bizProductMapper.updateBizProduct(bizProduct);
    }

    /**
     * 批量删除商品
     * 
     * @param productIds 需要删除的商品主键
     * @return 结果
     */
    @Override
    public int deleteBizProductByProductIds(String productIds)
    {
        return bizProductMapper.deleteBizProductByProductIds(Convert.toStrArray(productIds));
    }

    /**
     * 删除商品信息
     * 
     * @param productId 商品主键
     * @return 结果
     */
    @Override
    public int deleteBizProductByProductId(Long productId)
    {
        return bizProductMapper.deleteBizProductByProductId(productId);
    }
}
