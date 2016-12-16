package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import rocketDomain.RateDomainModel;

import exceptions.RateException;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException
	{
		
		ArrayList<RateDomainModel> listOfRates = RateDAL.getAllRates();
		
		if( (GivenCreditScore >= 600) && (GivenCreditScore <= 800) ){
			for(int i=1;i<listOfRates.size();i++){
				if(listOfRates.get(i).getiMinCreditScore() <= GivenCreditScore ){
					return listOfRates.get(i).getdInterestRate();
				}
			}
		}else{
			throw new RateException(GivenCreditScore);
		}
		return 0;
		
		
	}
	
	
	
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
