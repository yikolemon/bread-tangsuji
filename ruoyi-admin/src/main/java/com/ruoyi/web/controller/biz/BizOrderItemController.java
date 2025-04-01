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
import com.ruoyi.biz.domain.BizOrderItem;
import com.ruoyi.biz.service.IBizOrderItemService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品订单项Controller
 * 
 * @author ruoyi
 * @date 2025-04-01
 */
@Controller
@RequestMapping("/biz/item")
public class BizOrderItemController extends BaseController
{
    private String prefix = "biz/item";

    @Autowired
    private IBizOrderItemService bizOrderItemService;

    @RequiresPermissions("biz:item:view")
    @GetMapping()
    public String item()
    {
        return prefix + "/item";
    }

    /**
     * 查询商品订单项列表
     */
    @RequiresPermissions("biz:item:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BizOrderItem bizOrderItem)
    {
        startPage();
        List<BizOrderItem> list = bizOrderItemService.selectBizOrderItemList(bizOrderItem);
        return getDataTable(list);
    }

    /**
     * 导出商品订单项列表
     */
    @RequiresPermissions("biz:item:export")
    @Log(title = "商品订单项", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BizOrderItem bizOrderItem)
    {
        List<BizOrderItem> list = bizOrderItemService.selectBizOrderItemList(bizOrderItem);
        ExcelUtil<BizOrderItem> util = new ExcelUtil<BizOrderItem>(BizOrderItem.class);
        return util.exportExcel(list, "商品订单项数据");
    }

    /**
     * 新增商品订单项
     */
    @RequiresPermissions("biz:item:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品订单项
     */
    @RequiresPermissions("biz:item:add")
    @Log(title = "商品订单项", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BizOrderItem bizOrderItem)
    {
        return toAjax(bizOrderItemService.insertBizOrderItem(bizOrderItem));
    }

    /**
     * 修改商品订单项
     */
    @RequiresPermissions("biz:item:edit")
    @GetMapping("/edit/{itemId}")
    public String edit(@PathVariable("itemId") Long itemId, ModelMap mmap)
    {
        BizOrderItem bizOrderItem = bizOrderItemService.selectBizOrderItemByItemId(itemId);
        mmap.put("bizOrderItem", bizOrderItem);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品订单项
     */
    @RequiresPermissions("biz:item:edit")
    @Log(title = "商品订单项", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BizOrderItem bizOrderItem)
    {
        return toAjax(bizOrderItemService.updateBizOrderItem(bizOrderItem));
    }

    /**
     * 删除商品订单项
     */
    @RequiresPermissions("biz:item:remove")
    @Log(title = "商品订单项", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bizOrderItemService.deleteBizOrderItemByItemIds(ids));
    }
}
