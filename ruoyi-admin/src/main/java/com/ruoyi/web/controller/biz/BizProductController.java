package com.ruoyi.web.controller.biz;

import java.util.List;

import com.ruoyi.web.controller.biz.vo.BizProductReqVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.biz.domain.BizProduct;
import com.ruoyi.biz.domain.BizCategory;
import com.ruoyi.biz.service.IBizProductService;
import com.ruoyi.biz.service.IBizCategoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.file.FileUploadUtils;

/**
 * 商品Controller
 * 
 * @author ruoyi
 * @date 2025-04-01
 */
@Controller
@RequestMapping("/biz/product")
public class BizProductController extends BaseController
{
    private String prefix = "biz/product";

    @Autowired
    private IBizProductService bizProductService;
    
    @Autowired
    private IBizCategoryService bizCategoryService;

    @RequiresPermissions("biz:product:view")
    @GetMapping()
    public String product(ModelMap mmap)
    {
        List<BizCategory> categories = bizCategoryService.selectBizCategoryList(new BizCategory());
        mmap.put("categories", categories);
        return prefix + "/product";
    }

    /**
     * 查询商品列表
     */
    @RequiresPermissions("biz:product:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BizProduct bizProduct)
    {
        startPage();
        List<BizProduct> list = bizProductService.selectBizProductList(bizProduct);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @RequiresPermissions("biz:product:export")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BizProduct bizProduct)
    {
        List<BizProduct> list = bizProductService.selectBizProductList(bizProduct);
        ExcelUtil<BizProduct> util = new ExcelUtil<BizProduct>(BizProduct.class);
        return util.exportExcel(list, "商品数据");
    }

    /**
     * 新增商品
     */
    @RequiresPermissions("biz:product:add")
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        List<BizCategory> categories = bizCategoryService.selectBizCategoryList(new BizCategory());
        mmap.put("categories", categories);
        return prefix + "/add";
    }

    /**
     * 新增保存商品
     */
    @RequiresPermissions("biz:product:add")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BizProductReqVO reqVO)
    {
        try {
            BizProduct bizProduct = new BizProduct();
            bizProduct.setName(reqVO.getName());
            bizProduct.setCategoryId(reqVO.getCategoryId());
            bizProduct.setPrice(reqVO.getPrice());
            bizProduct.setStock(reqVO.getStock());
            bizProduct.setDescription(reqVO.getDescription());
            bizProduct.setStatus(reqVO.getStatus());

            if (reqVO.getImage() != null && !reqVO.getImage().isEmpty()) {
                String imagePath = FileUploadUtils.upload(reqVO.getImage());
                bizProduct.setImage(imagePath);
            }
            return toAjax(bizProductService.insertBizProduct(bizProduct));
        } catch (Exception e) {
            return error("新增商品失败：" + e.getMessage());
        }
    }

    /**
     * 修改商品
     */
    @RequiresPermissions("biz:product:edit")
    @GetMapping("/edit/{productId}")
    public String edit(@PathVariable("productId") Long productId, ModelMap mmap)
    {
        BizProduct bizProduct = bizProductService.selectBizProductByProductId(productId);
        List<BizCategory> categories = bizCategoryService.selectBizCategoryList(new BizCategory());
        mmap.put("bizProduct", bizProduct);
        mmap.put("categories", categories);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品
     */
    @RequiresPermissions("biz:product:edit")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BizProductReqVO reqVO)
    {
        try {
            BizProduct bizProduct = new BizProduct();
            bizProduct.setProductId(reqVO.getProductId());
            bizProduct.setName(reqVO.getName());
            bizProduct.setCategoryId(reqVO.getCategoryId());
            bizProduct.setPrice(reqVO.getPrice());
            bizProduct.setStock(reqVO.getStock());
            bizProduct.setDescription(reqVO.getDescription());
            bizProduct.setStatus(reqVO.getStatus());

            if (reqVO.getImage() != null && !reqVO.getImage().isEmpty()) {
                String imagePath = FileUploadUtils.upload(reqVO.getImage());
                bizProduct.setImage(imagePath);
            }
            return toAjax(bizProductService.updateBizProduct(bizProduct));
        } catch (Exception e) {
            return error("修改商品失败：" + e.getMessage());
        }
    }

    /**
     * 删除商品
     */
    @RequiresPermissions("biz:product:remove")
    @Log(title = "商品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bizProductService.deleteBizProductByProductIds(ids));
    }

    /**
     * 修改商品状态
     */
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(Long productId, String status)
    {
        BizProduct product = new BizProduct();
        product.setProductId(productId);
        product.setStatus(status);
        return toAjax(bizProductService.updateBizProduct(product));
    }

    /**
     * 修改商品库存
     */
    @RequiresPermissions("biz:product:edit")
    @PostMapping("/updateStock")
    @ResponseBody
    public AjaxResult updateStock(Long productId, Long stock)
    {
        BizProduct product = new BizProduct();
        product.setProductId(productId);
        product.setStock(stock);
        return toAjax(bizProductService.updateBizProduct(product));
    }
}
