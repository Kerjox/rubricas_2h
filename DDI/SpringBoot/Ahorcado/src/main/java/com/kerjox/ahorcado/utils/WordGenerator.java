package com.kerjox.ahorcado.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Component;

@Component
public class WordGenerator {

	@Value("${city.generator.api}")
	private String apiUrl = "https://api.generadordni.es/v2/misc/city?results=100";

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getWord(Integer maxLength) {

		System.out.println(apiUrl);
		JSONArray jsonArray = JsonUtils.readJsonFromUrl(apiUrl);

		for (int i = 0; i < jsonArray.length(); i++) {

			String word = null;
			try {
				word = jsonArray.getString(i);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			assert word != null;
			if (word.length() <= maxLength) {

				return word;
			}
		}

		return null;
	}


}
