package com.kerjox.ahorcado.config;

import com.kerjox.ahorcado.entities.Ahorcado;
import com.kerjox.ahorcado.levels.Level;
import com.kerjox.ahorcado.utils.WordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeans {


	@Autowired
	private Level level;

	@Autowired
	private WordGenerator wordGenerator;


	@Bean
	Ahorcado ahorcado() {

		return new Ahorcado(wordGenerator.getWord(level.getMinLength(), level.getMaxLength()), level.getTries());
	}
}
