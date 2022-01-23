package com.kerjox.bloque5_rubrica_2.Services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String userid, String password) {
		// in28minutes, dummy
		return userid.equalsIgnoreCase("alcachofa")
						&& password.equalsIgnoreCase("IVSZ2e12");
	}
}
