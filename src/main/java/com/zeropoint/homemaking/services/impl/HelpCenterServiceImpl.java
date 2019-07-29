package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.CommentMapper;
import com.zeropoint.homemaking.dao.ComplaintMapper;
import com.zeropoint.homemaking.dao.FaqMapper;
import com.zeropoint.homemaking.dao.HelpCenterMapper;
import com.zeropoint.homemaking.domain.Comment;
import com.zeropoint.homemaking.domain.Complaint;
import com.zeropoint.homemaking.domain.Faq;
import com.zeropoint.homemaking.domain.HelpCenter;
import com.zeropoint.homemaking.services.HelpCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chowhin
 */
@Service
public class HelpCenterServiceImpl implements HelpCenterService {
    @Autowired
    HelpCenterMapper helpCenterMapper;
    @Autowired
    FaqMapper faqMapper;
    @Autowired
    ComplaintMapper complaintMapper;
    @Autowired
    CommentMapper commentMapper;

    @Override
    public int addComplaint(Complaint complaint) {
        return complaintMapper.insert(complaint);
    }

    @Override
    public int addComment(Comment comment) {
        return commentMapper.insert(comment) ;
    }

    @Override
    public HelpCenter findByName(String name) {
        return helpCenterMapper.selectByName(name);
    }

    @Override
    public List<Faq> getFaqList() {
        return faqMapper.selectAll();
    }

    @Override
    public HelpCenter findById(Integer id) {
        return helpCenterMapper.selectByPrimaryKey(id);
    }
}
