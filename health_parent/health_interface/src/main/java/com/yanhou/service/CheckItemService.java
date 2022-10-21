package com.yanhou.service;

import com.yanhuo.POJO.CheckItem;
import com.yanhuo.entity.PageResult;


/**
 * 检查项服务接口
 */
public interface CheckItemService {
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    public void add(CheckItem checkItem);

    public void delete(Integer id);
    public void edit(CheckItem checkItem);
    public CheckItem findById(Integer id);
}