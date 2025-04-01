package com.ruoyi.web.controller.biz;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.biz.domain.BizProduct;
import com.ruoyi.biz.service.IBizProductService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

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

    @RequiresPermissions("biz:product:view")
    @GetMapping()
    public String product()
    {
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
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品
     */
    @RequiresPermissions("biz:product:add")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BizProduct bizProduct)
    {
        return toAjax(bizProductService.insertBizProduct(bizProduct));
    }

    /**
     * 修改商品
     */
    @RequiresPermissions("biz:product:edit")
    @GetMapping("/edit/{productId}")
    public String edit(@PathVariable("productId") Long productId, ModelMap mmap)
    {
        BizProduct bizProduct = bizProductService.selectBizProductByProductId(productId);
        mmap.put("bizProduct", bizProduct);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品
     */
    @RequiresPermissions("biz:product:edit")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BizProduct bizProduct)
    {
        return toAjax(bizProductService.updateBizProduct(bizProduct));
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
}
