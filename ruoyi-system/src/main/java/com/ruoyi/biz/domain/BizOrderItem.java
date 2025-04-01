package com.ruoyi.biz.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品订单项对象 biz_order_item
 * 
 * @author ruoyi
 * @date 2025-04-01
 */
public class BizOrderItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单项id */
    private Long itemId;

    /** 订单id */
    @Excel(name = "订单id")
    private Long orderId;

    /** 商品id */
    @Excel(name = "商品id")
    private Long productId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productName;

    /** 数量 */
    @Excel(name = "数量")
    private Long num;

    /** 商品单价 */
    @Excel(name = "商品单价")
    private BigDecimal singlePrice;

    public void setItemId(Long itemId) 
    {
        this.itemId = itemId;
    }

    public Long getItemId() 
    {
        return itemId;
    }

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }

    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }

    public void setSinglePrice(BigDecimal singlePrice) 
    {
        this.singlePrice = singlePrice;
    }

    public BigDecimal getSinglePrice() 
    {
        return singlePrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("itemId", getItemId())
            .append("orderId", getOrderId())
            .append("productId", getProductId())
            .append("productName", getProductName())
            .append("num", getNum())
            .append("singlePrice", getSinglePrice())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
