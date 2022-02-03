package com.kerjox.ahorcado.utils;

import org.springframework.boot.configurationprocessor.json.JSONArray;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class JsonUtils {

	private static String Read(Reader re) throws IOException {     // class Declaration
		StringBuilder str = new StringBuilder();     // To Store Url Data In String.
		int temp;
		do {

			temp = re.read();       //reading Charcter By Chracter.
			str.append((char) temp);

		} while (temp != -1);
		//  re.read() return -1 when there is end of buffer , data or end of file.

		return str.toString();

	}

	public static JSONArray readJsonFromUrl(String link) {
		// Input Stream Object To Start Streaming.
		try (InputStream input = new URL(link).openStream()) {                                 // try catch for checked exception
			BufferedReader re = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
			// Buffer Reading In UTF-8
			String Text = Read(re);         // Handy Method To Read Data From BufferReader
			return new JSONArray(Text);    // Returning JSON
		} catch (Exception e) {
			return null;
		}
	}
}
