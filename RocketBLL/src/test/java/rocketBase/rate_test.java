package rocketBase;

import static org.junit.Assert.*;


import org.junit.Test;

import java.util.ArrayList;

import exceptions.RateException;
import rocketDomain.RateDomainModel;
import rocketBase.RateBLL;


public class rate_test {


	
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
	
	@Test
	public void test3(){
	
	double pymt = RateBLL.getPayment(.0034376, 360.00, -100000.00, 0.00, false);
	
	assertEquals(484.65, pymt, .01 );
	}
	@Test
	public void test() {
		assert(1==1);
	}

}
