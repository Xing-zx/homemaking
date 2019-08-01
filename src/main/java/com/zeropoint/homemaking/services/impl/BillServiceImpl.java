package com.zeropoint.homemaking.services.impl;

import com.zeropoint.homemaking.dao.IncomeMapper;
import com.zeropoint.homemaking.dao.WithdrawMapper;
import com.zeropoint.homemaking.domain.Income;

import com.zeropoint.homemaking.domain.Order;
import com.zeropoint.homemaking.domain.Withdraw;
import com.zeropoint.homemaking.services.BillService;
import com.zeropoint.homemaking.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author chowhin
 */
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    IncomeMapper incomeMapper;
    @Autowired
    WithdrawMapper withdrawMapper;
    @Autowired
    OrderService orderService;
    @Override
    public List<Income> findByPersonnelId(Integer personnelId) {
        return incomeMapper.selectByPersonnelId(personnelId);
    }

    @Override
    public Double getInput(String date,Integer personnelId) {
        Double input=0.0;
        List<Income> list=incomeMapper.selectByPersonnelIdAndDate(personnelId,date);
        if(list!=null) {
            for (Income income : list) {
                input += income.getMoney();
            }
        }
        return input;
    }

    @Override
    public Double getOutput(String date,Integer personnelId) {
        Double output=0.0;
        List<Withdraw> list=withdrawMapper.selectByPersonnelAndDate(personnelId,date);
        if(list !=null) {
            for (Withdraw withdraw : list) {
                output += withdraw.getMoney();
            }
        }
        return output;
    }

    @Override
    public List<Income> findByPersonnelIdAndDate(Integer personnelId, String date) {
        return incomeMapper.selectByPersonnelIdAndDate(personnelId,date);
    }

    @Override
    public List<Withdraw> withdrawlistByPersonnelAndDate(Integer personnelId, String date) {
        return withdrawMapper.selectByPersonnelAndDate(personnelId,date);
    }

    @Override
    public int addWithdraw(Withdraw withdraw) {
        return withdrawMapper.insert(withdraw);
    }

    @Override
    public int orderCheckout(Integer personnelId, Integer orderId) {
        Income income=new Income();
        Order order=orderService.findById(orderId);
        income.setPersonnelId(personnelId);
        income.setMoney(order.getMoneyActual());
        income.setCreateTime(new Date());
        income.setType(order.getType());
        income.setTitle("服务费结算");
        return incomeMapper.insert(income);
    }
}
