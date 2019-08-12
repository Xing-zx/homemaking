package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.FaqMapper;
import com.zeropoint.homemaking.domain.Faq;
import com.zeropoint.homemaking.services.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqServiceImpl implements FaqService {

    @Autowired
    private FaqMapper faqMapper;

    @Override
    public List<Faq> selectPage1(Integer page, Integer rows) {
        return faqMapper.selectPage1(page, rows);
    }

    @Override
    public int count() {
        return faqMapper.count();
    }

    @Override
    public int deleteByPrimaryKey(Integer[] id) {
        return faqMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Faq record) {
        return faqMapper.insert(record);
    }

    @Override
    public Faq selectByPrimaryKey(Integer id) {
        return faqMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Faq record) {
        return faqMapper.updateByPrimaryKey(record);
    }
}
