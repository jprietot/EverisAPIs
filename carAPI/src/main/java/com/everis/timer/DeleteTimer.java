package com.everis.timer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;


@Startup
@Singleton
public class DeleteTimer {
	
	private static final Logger LOG = Logger.getLogger(DeleteTimer.class);
	
	@Resource
    private TimerService timerService;
	
	@PersistenceContext(unitName = "carAPI")
	private EntityManager em;
 
    @PostConstruct
    private void init() {
        timerService.createTimer(1000, 300000, "IntervalTimer_DeleteCars");
    }
	
	@Timeout
	public void deleteCars() {
		LOG.info("Proceeding to delete marked cars");
		
		Query query = em.createQuery("DELETE FROM Car c WHERE c.deleted = true");
		query.executeUpdate();
		
		LOG.info("Marked cars deletion completed");
	}

}
