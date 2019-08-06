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
    private HelpCenterMapper helpCenterMapper;
    @Autowired
    private FaqMapper faqMapper;
    @Autowired
    private ComplaintMapper complaintMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int addComplaint(Complaint complaint) {
        return complaintMapper.insert(complaint);
    }

    @Override
    public int addComment(Comment comment) {
        return commentMapper.insert(comment) ;
    }

    @Override
    public int update1(HelpCenter helpCenter) {
        return helpCenterMapper.update1(helpCenter);
    }

    @Override
    public HelpCenter select1(Integer id) {
        return helpCenterMapper.select1(id);
    }

    @Override
    public int update2(HelpCenter helpCenter) {
        return helpCenterMapper.update2(helpCenter);
    }

    @Override
    public HelpCenter select2(Integer id) {
        return helpCenterMapper.select2(id);
    }

    @Override
    public int update3(HelpCenter helpCenter) {
        return helpCenterMapper.update3(helpCenter);
    }

    @Override
    public HelpCenter select3(Integer id) {
        return helpCenterMapper.select3(id);
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
