package com.ruoyi.biz.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品对象 biz_product
 * 
 * @author ruoyi
 * @date 2025-04-01
 */
public class BizProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品id */
    private Long productId;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 商品描述 */
    @Excel(name = "商品描述")
    private String description;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal price;

    /** 商品图片路径 */
    @Excel(name = "商品图片路径")
    private String image;

    /** 分类id */
    @Excel(name = "分类id")
    private Long categoryId;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long stock;

    /** 上架状态 0 未上架 1 上架 */
    @Excel(name = "上架状态 0 未上架 1 上架")
    private String status;

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }

    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }

    public void setStock(Long stock) 
    {
        this.stock = stock;
    }

    public Long getStock() 
    {
        return stock;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productId", getProductId())
            .append("name", getName())
            .append("description", getDescription())
            .append("price", getPrice())
            .append("image", getImage())
            .append("categoryId", getCategoryId())
            .append("stock", getStock())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
