package com.ruoyi.biz.mapper;

import java.util.List;
import com.ruoyi.biz.domain.BizCategory;

/**
 * 商品分类Mapper接口
 * 
 * @author ruoyi
 * @date 2025-04-01
 */
public interface BizCategoryMapper 
{
    /**
     * 查询商品分类
     * 
     * @param categoryId 商品分类主键
     * @return 商品分类
     */
    public BizCategory selectBizCategoryByCategoryId(Long categoryId);

    /**
     * 查询商品分类列表
     * 
     * @param bizCategory 商品分类
     * @return 商品分类集合
     */
    public List<BizCategory> selectBizCategoryList(BizCategory bizCategory);

    /**
     * 新增商品分类
     * 
     * @param bizCategory 商品分类
     * @return 结果
     */
    public int insertBizCategory(BizCategory bizCategory);

    /**
     * 修改商品分类
     * 
     * @param bizCategory 商品分类
     * @return 结果
     */
    public int updateBizCategory(BizCategory bizCategory);

    /**
     * 删除商品分类
     * 
     * @param categoryId 商品分类主键
     * @return 结果
     */
    public int deleteBizCategoryByCategoryId(Long categoryId);

    /**
     * 批量删除商品分类
     * 
     * @param categoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizCategoryByCategoryIds(String[] categoryIds);
}
