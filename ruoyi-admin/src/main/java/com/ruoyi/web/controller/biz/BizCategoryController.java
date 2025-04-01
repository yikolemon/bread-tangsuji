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
import com.ruoyi.biz.domain.BizCategory;
import com.ruoyi.biz.service.IBizCategoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品分类Controller
 * 
 * @author ruoyi
 * @date 2025-04-01
 */
@Controller
@RequestMapping("/biz/category")
public class BizCategoryController extends BaseController
{
    private String prefix = "biz/category";

    @Autowired
    private IBizCategoryService bizCategoryService;

    @RequiresPermissions("biz:category:view")
    @GetMapping()
    public String category()
    {
        return prefix + "/category";
    }

    /**
     * 查询商品分类列表
     */
    @RequiresPermissions("biz:category:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BizCategory bizCategory)
    {
        startPage();
        List<BizCategory> list = bizCategoryService.selectBizCategoryList(bizCategory);
        return getDataTable(list);
    }

    /**
     * 导出商品分类列表
     */
    @RequiresPermissions("biz:category:export")
    @Log(title = "商品分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BizCategory bizCategory)
    {
        List<BizCategory> list = bizCategoryService.selectBizCategoryList(bizCategory);
        ExcelUtil<BizCategory> util = new ExcelUtil<BizCategory>(BizCategory.class);
        return util.exportExcel(list, "商品分类数据");
    }

    /**
     * 新增商品分类
     */
    @RequiresPermissions("biz:category:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品分类
     */
    @RequiresPermissions("biz:category:add")
    @Log(title = "商品分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BizCategory bizCategory)
    {
        return toAjax(bizCategoryService.insertBizCategory(bizCategory));
    }

    /**
     * 修改商品分类
     */
    @RequiresPermissions("biz:category:edit")
    @GetMapping("/edit/{categoryId}")
    public String edit(@PathVariable("categoryId") Long categoryId, ModelMap mmap)
    {
        BizCategory bizCategory = bizCategoryService.selectBizCategoryByCategoryId(categoryId);
        mmap.put("bizCategory", bizCategory);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品分类
     */
    @RequiresPermissions("biz:category:edit")
    @Log(title = "商品分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BizCategory bizCategory)
    {
        return toAjax(bizCategoryService.updateBizCategory(bizCategory));
    }

    /**
     * 删除商品分类
     */
    @RequiresPermissions("biz:category:remove")
    @Log(title = "商品分类", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bizCategoryService.deleteBizCategoryByCategoryIds(ids));
    }
}
