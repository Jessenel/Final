package rocketServer;

import java.io.IOException;


import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;

import exceptions.RateException;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			
			
			
			try {
				double loanRate = _RateBLL.getRate(lq.getiCreditScore());
				double payment = _RateBLL.getPayment(loanRate/1200, lq.getiTerm()*12, lq.getdAmount(), 0, false);
				lq.setdPayment(payment);
				lq.setdRate(loanRate);
			} catch (RateException e) {
				System.out.print("check the credit score");
				e.printStackTrace();
			}
			
		
	
			
			sendToAll(lq);
		}
	}
}
