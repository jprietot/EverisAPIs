package com.everis.timer;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.everis.control.CarService;
import com.everis.entity.Car;


@Startup
@Singleton
public class DeleteTimer {
	
	private static final Logger LOG = Logger.getLogger(DeleteTimer.class);
	
	@Resource
    private TimerService timerService;
	
	@EJB
	private CarService carService;
 
    @PostConstruct
    private void init() {
        timerService.createTimer(1000, 300000, "IntervalTimer_DeleteCars");
    }
	
	@Timeout
	public void deleteCars() {
		LOG.info("Proceeding to delete marked cars");
		carService.deleteMarkedCars();
		LOG.info("Marked cars deletion completed");
	}

}
