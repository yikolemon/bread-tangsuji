package com.ruoyi.biz.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biz.mapper.BizCategoryMapper;
import com.ruoyi.biz.domain.BizCategory;
import com.ruoyi.biz.service.IBizCategoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class BizCategoryServiceImpl implements IBizCategoryService 
{
    @Autowired
    private BizCategoryMapper bizCategoryMapper;

    /**
     * 查询商品分类
     * 
     * @param categoryId 商品分类主键
     * @return 商品分类
     */
    @Override
    public BizCategory selectBizCategoryByCategoryId(Long categoryId)
    {
        return bizCategoryMapper.selectBizCategoryByCategoryId(categoryId);
    }

    /**
     * 查询商品分类列表
     * 
     * @param bizCategory 商品分类
     * @return 商品分类
     */
    @Override
    public List<BizCategory> selectBizCategoryList(BizCategory bizCategory)
    {
        return bizCategoryMapper.selectBizCategoryList(bizCategory);
    }

    /**
     * 新增商品分类
     * 
     * @param bizCategory 商品分类
     * @return 结果
     */
    @Override
    public int insertBizCategory(BizCategory bizCategory)
    {
        bizCategory.setCreateTime(DateUtils.getNowDate());
        return bizCategoryMapper.insertBizCategory(bizCategory);
    }

    /**
     * 修改商品分类
     * 
     * @param bizCategory 商品分类
     * @return 结果
     */
    @Override
    public int updateBizCategory(BizCategory bizCategory)
    {
        bizCategory.setUpdateTime(DateUtils.getNowDate());
        return bizCategoryMapper.updateBizCategory(bizCategory);
    }

    /**
     * 批量删除商品分类
     * 
     * @param categoryIds 需要删除的商品分类主键
     * @return 结果
     */
    @Override
    public int deleteBizCategoryByCategoryIds(String categoryIds)
    {
        return bizCategoryMapper.deleteBizCategoryByCategoryIds(Convert.toStrArray(categoryIds));
    }

    /**
     * 删除商品分类信息
     * 
     * @param categoryId 商品分类主键
     * @return 结果
     */
    @Override
    public int deleteBizCategoryByCategoryId(Long categoryId)
    {
        return bizCategoryMapper.deleteBizCategoryByCategoryId(categoryId);
    }
}
