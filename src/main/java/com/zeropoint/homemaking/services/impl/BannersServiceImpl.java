package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.BannersMapper;
import com.zeropoint.homemaking.domain.Banners;
import com.zeropoint.homemaking.services.BannersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannersServiceImpl implements BannersService {

    @Autowired
    private BannersMapper bannersmapper;

    @Override
    public List<Banners> selectAll() {
        return bannersmapper.selectAll();
    }

    @Override
    public List<Banners> selectAllPage(Integer page, Integer rows) {
        return bannersmapper.selectAllPage1(page, rows);
    }

    @Override
    public int count() {
        return bannersmapper.count1();
    }

    @Override
    public int insert(Banners record) {
        return bannersmapper.insert(record);
    }

    @Override
    public int delete(Integer[] ids) {
        return bannersmapper.delete1(ids);
    }

    @Override
    public int update(Integer id, Integer status) {
        return bannersmapper.update1(id,status);
    }

    @Override
    public Banners selectByPrimaryKey(Integer id) {
        return bannersmapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Banners record) {
        return bannersmapper.updateByPrimaryKey(record);
    }

    @Override
    public int delete1(Integer[] ids) {
        return bannersmapper.delete1(ids);
    }

    @Override
    public int insert1(Banners record) {
        return bannersmapper.insert1(record);
    }

    @Override
    public Banners selectByPrimaryKey1(Integer id) {
        return bannersmapper.selectByPrimaryKey1(id);
    }

    @Override
    public List<Banners> selectAll1() {
        return bannersmapper.selectAll1();
    }

    @Override
    public List<Banners> selectAllPage1(Integer page, Integer rows) {
        return bannersmapper.selectAllPage1(page,rows);
    }

    @Override
    public int count1() {
        return bannersmapper.count1();
    }

    @Override
    public int updateByPrimaryKey1(Banners record) {
        return bannersmapper.updateByPrimaryKey1(record);
    }

    @Override
    public int update1(Integer id, Integer status) {
        return bannersmapper.update1(id, status);
    }
}
