package com.kerjox.dardos.modes;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("301")
public class TresCeroUnoMode implements Mode {

	@Override
	public int getMaxPoints() {
		return 301;
	}
}
