package com.ubalde.bloque3_rubrica_5.utils;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class Utils {

	public static Integer getAge(Date birthDate) {

		if ((birthDate != null)) {
			LocalDate birthday = Instant.ofEpochMilli(birthDate.getTime())
							.atZone(ZoneId.systemDefault())
							.toLocalDate();

			return Period.between(birthday, LocalDate.now()).getYears();
		} else {
			return 0;
		}
	}
}
