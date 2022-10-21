package com.yanhuo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yanhou.service.CheckItemService;
import com.yanhuo.POJO.CheckItem;
import com.yanhuo.dao.CheckItemDao;
import com.yanhuo.entity.PageResult;

public class CheckItemServiceImpl implements CheckItemService {
    public CheckItemDao checkItemDao;
    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        PageHelper.startPage(currentPage,pageSize);
        Page<CheckItem> page = checkItemDao.selectByCondition(queryString);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void add(CheckItem checkItem) {

    }

    @Override
    public void delete(Integer id) {
        //查询当前检查项是否和检查组关联
        long count = checkItemDao.findCountByCheckItemId(id);
        if(count > 0){
            //当前检查项被引用，不能删除
            throw new RuntimeException("当前检查项被引用，不能删除");
        }
        checkItemDao.deleteById(id);
    }
    public void edit(CheckItem checkItem) {
        checkItemDao.edit(checkItem);
    }

    public CheckItem findById(Integer id) {
        return checkItemDao.findById(id);
    }
}
