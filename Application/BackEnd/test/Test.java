package com.interlet.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import com.interlet.beans.Asset;
import com.interlet.beans.BorrowedAsset;
import com.interlet.exceptions.AssetsNotFoundException;
import com.interlet.user.admin.dao.services.AdminDaoServices;
import com.interlet.user.admin.dao.services.impl.AdminDaoServicesImpl;



public class Test {

	public static void main(String[] args) {
	/*	SimpleDateFormat dtf=new SimpleDateFormat("yyyy-MM-dd");
		LocalDate date=LocalDate.now();
		
		Date borrowedAsset = null;
		try {
			borrowedAsset = dtf.parse("2023-09-08");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LocalDate date2=borrowedAsset.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		 Period diff= Period.between(date2,date);
		 System.out.println(diff.getDays());*/
		AdminDaoServicesImpl obj=new AdminDaoServicesImpl();
		try {
			List<BorrowedAsset> ans=obj.overDueAssetsByAssetName("asset1");
			for(BorrowedAsset borrowedAsset:ans)
			{
				System.out.println(borrowedAsset);
			}
			System.out.println(ans.size());
			
			
			
			
		} catch (AssetsNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
		

}
