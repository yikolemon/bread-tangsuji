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
import com.ruoyi.biz.domain.BizOrder;
import com.ruoyi.biz.service.IBizOrderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品订单Controller
 * 
 * @author ruoyi
 * @date 2025-04-01
 */
@Controller
@RequestMapping("/biz/order")
public class BizOrderController extends BaseController
{
    private String prefix = "biz/order";

    @Autowired
    private IBizOrderService bizOrderService;

    @RequiresPermissions("biz:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询商品订单列表
     */
    @RequiresPermissions("biz:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BizOrder bizOrder)
    {
        startPage();
        List<BizOrder> list = bizOrderService.selectBizOrderList(bizOrder);
        return getDataTable(list);
    }

    /**
     * 导出商品订单列表
     */
    @RequiresPermissions("biz:order:export")
    @Log(title = "商品订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BizOrder bizOrder)
    {
        List<BizOrder> list = bizOrderService.selectBizOrderList(bizOrder);
        ExcelUtil<BizOrder> util = new ExcelUtil<BizOrder>(BizOrder.class);
        return util.exportExcel(list, "商品订单数据");
    }

    /**
     * 新增商品订单
     */
    @RequiresPermissions("biz:order:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品订单
     */
    @RequiresPermissions("biz:order:add")
    @Log(title = "商品订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BizOrder bizOrder)
    {
        return toAjax(bizOrderService.insertBizOrder(bizOrder));
    }

    /**
     * 修改商品订单
     */
    @RequiresPermissions("biz:order:edit")
    @GetMapping("/edit/{orderId}")
    public String edit(@PathVariable("orderId") Long orderId, ModelMap mmap)
    {
        BizOrder bizOrder = bizOrderService.selectBizOrderByOrderId(orderId);
        mmap.put("bizOrder", bizOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品订单
     */
    @RequiresPermissions("biz:order:edit")
    @Log(title = "商品订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BizOrder bizOrder)
    {
        return toAjax(bizOrderService.updateBizOrder(bizOrder));
    }

    /**
     * 删除商品订单
     */
    @RequiresPermissions("biz:order:remove")
    @Log(title = "商品订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bizOrderService.deleteBizOrderByOrderIds(ids));
    }
}
