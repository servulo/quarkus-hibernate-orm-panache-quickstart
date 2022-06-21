package br.com.sprj.hibernate.quickstart;

import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class AppLifecycleBean {
	
	private static final Logger LOGGER = Logger.getLogger("ListenerBean");
	
	@Transactional
	void onStart(@Observes StartupEvent ev) {
		
		LOGGER.info("-------------------------------------------------- Before");
		LOGGER.info(ev.toString());
		
		
		Person person = new Person();
		person.name = "Servulo";
		person.birth=LocalDate.of(1972, Month.NOVEMBER, 30);
		person.status = Status.Alive;
		person.persist();
		
		if(person.isPersistent()) {
			person.delete();
		}
		
		LOGGER.info("-------------------------------------------------- After");
		
	}

}
