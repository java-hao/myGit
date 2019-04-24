package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;

import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.entity.PageResult;
import com.pinyougou.sellergoods.service.BrandService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;


    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }


    public TbBrand findById(Long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }


    public void delete(Long[] ids) {
        for (Long id : ids) {
            tbBrandMapper.deleteByPrimaryKey(id);
        }
    }


    public void update(TbBrand tbBrand) {
        tbBrandMapper.updateByPrimaryKey(tbBrand);
    }


    public void insert(TbBrand tbBrand) {
         tbBrandMapper.insert(tbBrand);
    }


    /*public PageResult findPage(int pageNo, int PageSize) {
        PageHelper.startPage(pageNo, PageSize);
        Page page = (Page) tbBrandMapper.selectByExample(null);
        return new PageResult(page.getTotal(),page.getResult());
    }*/

    @Override
    public PageResult findPage(TbBrand brand, int pageNo, int PageSize) {
        PageHelper.startPage(pageNo, PageSize);
        //构建查询条件，TbBrandExample已将查询条件进行了封装
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        //首相需要判断此时用户输入内容的不为空
        if (brand !=null){
            //其次判断用户输入的名字不为空且长度大于0
            if (brand.getName()!=null && brand.getName().length()>0){
                criteria.andNameLike("%"+brand.getName()+"%");
            }
            //再次判断用户输入的首位字母不为空切大于0
            if (brand.getFirstChar()!=null && brand.getFirstChar().length()>0){
                criteria.andFirstCharLike("%"+brand.getFirstChar()+"%");
            }
        }
        Page page = (Page) tbBrandMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }

}
