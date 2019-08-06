package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.Comment;
import com.zeropoint.homemaking.domain.Complaint;
import com.zeropoint.homemaking.domain.Faq;
import com.zeropoint.homemaking.domain.HelpCenter;

import java.util.List;

public interface HelpCenterService {
    HelpCenter findByName(String name);
    List<Faq> getFaqList();
    HelpCenter findById(Integer id);
    int addComplaint(Complaint complaint);
    int addComment(Comment comment);

    int update1(HelpCenter helpCenter);

    HelpCenter select1(Integer id);

    int update2(HelpCenter helpCenter);

    HelpCenter select2(Integer id);

    int update3(HelpCenter helpCenter);

    HelpCenter select3(Integer id);
}
