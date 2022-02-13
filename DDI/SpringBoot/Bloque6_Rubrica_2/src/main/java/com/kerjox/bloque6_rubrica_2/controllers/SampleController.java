package com.kerjox.bloque6_rubrica_2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SampleController {

	@RequestMapping("/sample")
	public Map<String,String> sample(@RequestParam(value="name", defaultValue="World") String name) {
		Map<String,String> result = new HashMap<>();
		result.put("message", String.format("Hello, %s", name));
		return result;
	}
}
