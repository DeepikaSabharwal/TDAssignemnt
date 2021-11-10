package com.td.bank.factories;

import java.io.IOException;

import com.td.bank.dataProvider.ConfigurationDataProvider;

/*
 * This class does the following:
 * - Create Data Provider Reader
 * - Maintain an instance of the Data Provider Reader so that single reader can be used across tests/framework
 */
public class DataProviderFactory {
	private static ConfigurationDataProvider configurationDataProvider = null;
	private static String configurationFilePath = "config.properties";

	public static ConfigurationDataProvider getConfigurationDataProvider() {
		if (configurationDataProvider == null) {
			try {
				configurationDataProvider = new ConfigurationDataProvider(configurationFilePath);
			} catch (IOException e) {
				System.out.println("Not able to create Configuration file " + e.getMessage());
			}
		}

		return configurationDataProvider;
	}

}
