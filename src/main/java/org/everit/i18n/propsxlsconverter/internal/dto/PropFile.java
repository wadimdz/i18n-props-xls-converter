/*
 * Copyright (C) 2017 WD
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.i18n.propsxlsconverter.internal.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class PropFile {
	private Parameters parameters = new Parameters();

	private FileBasedConfigurationBuilder<FileBasedConfiguration> builder;

	private Configuration conf;

	public PropFile(String fname) throws ConfigurationException {
		builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class);
		builder.configure(parameters.fileBased().setFileName(fname));
		conf = builder.getConfiguration();
	}

	public Configuration getConfiguration() {
		return conf;
	}

	public List<String> getKeys() {
		List<String> ret = new ArrayList<String>();
		Iterator<String> it = conf.getKeys();

		while (it.hasNext()) {
			ret.add(it.next());
		}

		return ret;
	}

	public String getStringValue(String key) {
		return conf.getString(key);
	}
}
