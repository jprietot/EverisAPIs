package com.everis.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.ws.rs.NotFoundException;

import org.apache.log4j.Logger;

import com.everis.control.CarService;
import com.everis.entity.Car;

@MessageDriven(name = "carsmbd", activationConfig = {
	    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/cars"),
	    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
	    @ActivationConfigProperty(propertyName = "destination", propertyValue = "CARS"),
	    @ActivationConfigProperty(propertyName = "resourceAdapter", propertyValue = "activemq-rar-5.16.2")})
public class Listener implements MessageListener{
	
	private static final Logger LOG = Logger.getLogger(Listener.class);
	
	@EJB
	private CarService carService;

	@Override
	public void onMessage(Message message) {
		TextMessage msg = (TextMessage) message;
        try {
            String id = msg.getText();
            try {
                Car car = this.carService.getCar(id);
                
                LOG.info("Listener got the car id: " + id);
                LOG.info("The car is: " + car.toString());

            } 
            catch (NotFoundException ex) {
            	LOG.info(ex);
            }
        }catch (JMSException e) {
			LOG.info(e);
		}
		
	}

}
