package es.salesianos.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("nivel1")
public class BagLevel1 extends AbstractBag {

	public BagLevel1() {
		capacity = 20;
	}





}
