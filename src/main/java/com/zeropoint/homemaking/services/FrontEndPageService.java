package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.dao.FrontendPageMapper;
import com.zeropoint.homemaking.domain.FrontendPage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author chowhin
 */
public class FrontEndPageService {
    @Autowired
    FrontendPageMapper frontendPageMapper;
   //public List<FrontendPage> getPublicFrontPageList();
}
