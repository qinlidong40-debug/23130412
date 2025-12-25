package com.ie.controller;

import com.ie.common.ResultVO;
import com.ie.entity.Goods;
import com.ie.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    // 商品列表页
    @GetMapping("/list")
    public String list(Model model) {
        List<Goods> goodsList = goodsService.list(); // MP自带的查询所有方法
        model.addAttribute("goodsList", goodsList);
        return "goods/list";
    }

    // 新增商品页面
    @GetMapping("/add")
    public String addPage() {
        return "goods/add";
    }

    // 提交新增商品
    @PostMapping("/add")
    public String add(Goods goods) {
        goodsService.save(goods); // MP自带的新增方法
        return "redirect:/goods/list"; // 新增后跳转列表页
    }

    // 编辑商品页面（回显数据）
    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Integer id, Model model) {
        Goods goods = goodsService.getById(id); // MP自带的根据ID查询方法
        model.addAttribute("goods", goods);
        return "goods/edit";
    }

    // 提交编辑商品
    @PostMapping("/edit")
    public String edit(Goods goods) {
        goodsService.updateById(goods); // MP自带的更新方法
        return "redirect:/goods/list"; // 编辑后跳转列表页
    }

    // 删除商品
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        goodsService.removeById(id); // MP自带的删除方法
        return "redirect:/goods/list"; // 删除后跳转列表页
    }
    // 批量删除商品（ApiPost测试用接口）
    @PostMapping("/delete/batch")
    @ResponseBody // 标记返回JSON
    public ResultVO batchDelete(@RequestBody List<Integer> ids) {
        boolean success = goodsService.removeBatchByIds(ids); // MP自带批量删除方法
        return success ? ResultVO.success("批量删除成功") : ResultVO.fail("批量删除失败");
    }
}