package es.salesianos.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("nivel3")
public class BagLevel3 extends AbstractBag {

	public BagLevel3() {
		capacity = 100;
	}


}
