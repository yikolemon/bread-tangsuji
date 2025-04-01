package com.ruoyi.web.controller.biz.vo;

import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 商品请求对象
 * 
 * @author ruoyi
 * @date 2025-04-01
 */
public class BizProductReqVO extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    private Long productId;

    /** 商品名称 */
    private String name;

    /** 商品分类ID */
    private Long categoryId;

    /** 商品图片 */
    private MultipartFile image;

    /** 商品单价 */
    private BigDecimal price;

    /** 商品库存 */
    private Long stock;

    /** 商品描述 */
    private String description;

    /** 商品状态 */
    private String status;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}