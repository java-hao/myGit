package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.entity.PageResult;
import entity.Result;

import java.util.List;


public interface BrandService {

    public List<TbBrand> findAll();

    public TbBrand findById(Long id);

    public void delete(Long[] ids);

    public void update(TbBrand tbBrand);

    public void insert(TbBrand tbBrand);

    /*public PageResult findPage( int pageNo, int PageSize);*/

    public PageResult findPage(TbBrand brand,int pageNo, int PageSize);
}
