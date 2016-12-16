package rocketBase;

import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {
	
	@Test
	public void test1() {

		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		System.out.println ("Rates size: " + rates.size());
		assert(rates.size() > 0);
		
		for(int i=1;i<rates.size();i++){
			if(rates.get(i).getiMinCreditScore() == 650 ){
				assert(rates.get(i).getdInterestRate() == 4.5);
			}
		}
	}
	/*
	@Test(expected = RateException.class)
	public void test2() throws RateException {
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		System.out.println ("Rates size: " + rates.size());
		assert(rates.size() > 0);
		
		for(int i=1;i<rates.size();i++){
			if(rates.get(i).getiMinCreditScore() == 400 ){
				assert(rates.get(i).getdInterestRate() == 4.5);
			}else {
				throw new RateException(400);
			}
		}
	}
	*/
	
	//TODO - RocketDAL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketDAL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void test() {
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		System.out.println ("Rates size: " + rates.size());
		assert(rates.size() > 0);
		
		assert(1==1);
	}

}
