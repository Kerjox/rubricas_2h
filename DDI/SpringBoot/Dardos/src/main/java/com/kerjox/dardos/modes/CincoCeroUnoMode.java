package com.kerjox.dardos.modes;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("501")
public class CincoCeroUnoMode implements Mode {

	@Override
	public Integer getMaxPoints() {
		return 501;
	}
}
