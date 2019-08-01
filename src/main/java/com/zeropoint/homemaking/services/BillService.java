package com.zeropoint.homemaking.services;

import com.zeropoint.homemaking.domain.Income;
import com.zeropoint.homemaking.domain.Withdraw;

import java.util.List;

/**
 * @author Administrator
 */
public interface BillService {
   List<Income> findByPersonnelId(Integer personnelId);
   Double getInput(String date,Integer personnelId);
   Double getOutput(String date,Integer personnelId);
   List<Income> findByPersonnelIdAndDate(Integer personnelId,String date);
   List<Withdraw> withdrawlistByPersonnelAndDate(Integer personnelId,String date);
   int addWithdraw(Withdraw withdraw);
   int orderCheckout(Integer personnelId, Integer orderId);

}
