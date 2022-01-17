package com.kerjox.ahorcado.levels;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("veryHard")
public class VeryHard implements Level {

	@Override
	public int getTries() {
		return 20;
	}

	@Override
	public int getMaxLength() {
		return 15;
	}

	@Override
	public int getMinLength() {
		return 10;
	}
}
