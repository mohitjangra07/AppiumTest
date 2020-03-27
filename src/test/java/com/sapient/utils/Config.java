package com.sapient.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class Config {

	public static Map<String, Object> allCaps() {
		Yaml yaml = new Yaml();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File("src/test/resources/Capabilities/capabilities.yaml"));
		} catch (FileNotFoundException e) {
			System.out.println("File is missing or valid");
			e.printStackTrace();
		}
		Map<String, Object> obj = yaml.load(inputStream);

		return obj;
	}
}
