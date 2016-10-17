package br.com.mobshop.adyen;


import java.util.Date;

import org.apache.axis.client.Call;
import org.apache.axis.client.Stub;

import br.com.mobshop.ws.model.StatusAdyen;

import com.adyen.services.common.Address;
import com.adyen.services.common.Amount;
import com.adyen.services.payment.Card;
import com.adyen.services.payment.PaymentLocator;
import com.adyen.services.payment.PaymentPortType;
import com.adyen.services.payment.PaymentRequest;
import com.adyen.services.payment.PaymentResult;


public class Payment {
    
	public StatusAdyen pagamentoCartaoDebito(){
		StatusAdyen statusAdyen;
		try {		
			
			statusAdyen = new StatusAdyen();
			PaymentPortType ws = new PaymentLocator().getPaymentHttpPort( new java.net.URL( Credentials.test_address) );
			
			//Basic HTTP Authentication:
			( (Stub) ws )._setProperty( Call.USERNAME_PROPERTY, Credentials.ws_user );
			( (Stub) ws )._setProperty( Call.PASSWORD_PROPERTY, Credentials.pwd_user );
			
			// Payment data
			PaymentRequest request = new PaymentRequest();
			request.setMerchantAccount( Credentials.merchant_account );
			request.setAmount( new Amount( "BRL", 199) );
			request.setReference( "Payment Test 1" );
			
			
			request.setShopperEmail( "feehpaiva1992@gmail.com" );
			request.setShopperReference( "shopperreference" );
						
			Card card = new Card();
			card.setHolderName( "John Smith" );
			card.setCvc( "737" );
			card.setExpiryMonth( "06" );
			card.setExpiryYear( "2016" );
			card.setBillingAddress(new Address("São Bernardo do Campo", "BR", "268", "09635080", "S]ao Paulo", "Rua Mauricio Jacquey, 268"));
			card.setNumber("5555555555554444");
			request.setCard( card );
			
			PaymentResult result = ws.authorise( request );
			
			System.out.println( new Date() );
			
			statusAdyen.setPspReference(result.getPspReference());
			statusAdyen.setAuthCode(result.getAuthCode());
			statusAdyen.setRefusalReason(result.getRefusalReason());
			statusAdyen.setResultCode(result.getResultCode());
		}
		catch ( Exception ex ) {
			ex.printStackTrace();
			return null;
		}
		
		return statusAdyen;
		
	}
	
	

}
