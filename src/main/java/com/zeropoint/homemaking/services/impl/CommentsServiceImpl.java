package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.CommentMapper;
import com.zeropoint.homemaking.domain.Comment;
import com.zeropoint.homemaking.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentMapper commentMapper;


    @Override
    public int insert1(Comment record) {
        return commentMapper.insert1(record);
    }

    @Override
    public List<Comment> selectAll1() {
        return commentMapper.selectAll1();
    }

    @Override
    public List<Comment> selectPage1(Integer page, Integer rows, String name, String endTime, String startTime) {
        return commentMapper.selectPage1(page, rows, name, endTime, startTime);
    }

    @Override
    public int count1(String name, String endTime, String startTime) {
        return commentMapper.count1(name, endTime, startTime);
    }

    @Override
    public int delete1(Integer[] ids) {
        return commentMapper.delete1(ids);
    }
}
