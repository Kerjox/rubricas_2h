package es.salesianos.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("nivel2")
public class BagLevel2 extends AbstractBag {

	public BagLevel2() {
		capacity = 50;
	}
}
