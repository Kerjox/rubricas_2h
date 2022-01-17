package com.kerjox.ahorcado.levels;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("hard")
public class Hard implements Level {

	@Override
	public int getTries() {
		return 20;
	}

	@Override
	public int getMaxLength() {
		return 10;
	}

	@Override
	public int getMinLength() {
		return 8;
	}
}
