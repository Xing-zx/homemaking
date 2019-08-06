package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.CategoryMapper;
import com.zeropoint.homemaking.domain.Category;
import com.zeropoint.homemaking.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorysServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Category record) {
        return categoryMapper.insert(record);
    }

    @Override
    public Category selectByPrimaryKey(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Category> selectAll() {
        return categoryMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        return categoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<String> getChildListByName(String parentName) {
        return categoryMapper.getChildListByName(parentName);
    }

    @Override
    public int insertByParent(String parent, String child) {
        return categoryMapper.insertByParent(parent, child);
    }

    @Override
    public int deleteByPrimaryKey1(Integer id) {
        return categoryMapper.deleteByPrimaryKey1(id);
    }

    @Override
    public int insert1(Category record) {
        return categoryMapper.insert1(record);
    }

    @Override
    public Category selectByPrimaryKey1(Integer id) {
        return categoryMapper.selectByPrimaryKey1(id);
    }

    @Override
    public List<Category> selectAll1() {
        return categoryMapper.selectAll1();
    }

    @Override
    public int updateByPrimaryKey1(Category record) {
        return categoryMapper.updateByPrimaryKey1(record);
    }

    @Override
    public List<String> getChildListByName1(String parentName) {
        return categoryMapper.getChildListByName1(parentName);
    }

    @Override
    public int insertByParent1(String parent, String child) {
        return categoryMapper.insertByParent1(parent, child);
    }

    @Override
    public List<Category> selectByCondition1() {
        return categoryMapper.selectByCondition1();
    }

    @Override
    public int count1() {
        return categoryMapper.count1();
    }

    @Override
    public List<Category> selectTree1(Integer parent) {
        return categoryMapper.selectTree1(parent);
    }

    @Override
    public int updateStatus1(Integer id, Integer status) {
        return categoryMapper.updateStatus1(id, status);
    }

    @Override
    public int delete1(Integer[] ids) {
        return categoryMapper.delete1(ids);
    }
}
