package com.pinyougou.manager.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.entity.PageResult;
import com.pinyougou.sellergoods.service.BrandService;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService ;


     @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
         return brandService.findAll();
     }
    //模糊查询
     @RequestMapping("/findPage")
     public PageResult findPage(@RequestBody TbBrand brand, int pageNo,int pageSize){
         return brandService.findPage(brand,pageNo,pageSize);
     }

    @RequestMapping("/insert")
    public Result insert(@RequestBody TbBrand tbBrand){
        try {
            brandService.insert(tbBrand);
            return new Result(true,"新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"新增失败");
        }
    }
    @RequestMapping("/findOne")
    public TbBrand findOne(Long id){
        TbBrand byId = brandService.findById(id);
        return byId;
    }

    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand tbBrand){
        try {
            brandService.update(tbBrand);
            return new Result(true,"修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }
    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        try {
            brandService.delete(ids);
            return new Result(true,"删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }


}
