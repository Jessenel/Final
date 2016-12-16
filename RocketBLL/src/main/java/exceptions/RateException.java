package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {


	
	private int creditScore;
	
	private RateDomainModel rdm;
	
	
	public RateException(int score){
		this.creditScore = score;
		
	}
	
	
	public int getCreditScore(){
		return this.creditScore;
	}
}
