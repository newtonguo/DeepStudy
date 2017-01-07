package org.springframework.cloud.config.server.jpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Criteria;
import org.springframework.beans.factory.config.YamlProcessor;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.cloud.config.server.jpa.ConfigInfoRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

/**
 * Implementation of {@link EnvironmentRepository} that is backed by MongoDB. The
 * resulting {@link Environment} is composed of property sources where the
 * {@literal application-name} is identified by the collection's {@literal name} and a
 * MongoDB document's {@literal profile} and {@literal label} values represent the Spring
 * application's {@literal profile} and {@literal label} respectively. All properties must
 * be listed under the {@literal source} key of the document.
 *
 * @author Venil Noronha
 */
@Slf4j
public class JdbcEnvironmentRepository implements EnvironmentRepository {

	private static final String LABEL = "label";
	private static final String PROFILE = "profile";
	private static final String DEFAULT = "default";
	private static final String DEFAULT_PROFILE = null;
	private static final String DEFAULT_LABEL = null;

	private JdbcTemplate jdbcTemplate;
	private ConfigInfoRepository configInfoRepository;

	public JdbcEnvironmentRepository(ConfigInfoRepository configInfoRepository) {
		this.configInfoRepository = configInfoRepository;
	}

	@Override
	public Environment findOne(String application, String profile, String label) {

        String[] profilesArr = StringUtils.commaDelimitedListToStringArray(profile);
        List<String> profiles = new ArrayList<String>(Arrays.asList(profilesArr.clone()));
        for (int i = 0; i < profiles.size(); i++) {
            if (DEFAULT.equals(profiles.get(i))) {
                profiles.set(i, DEFAULT_PROFILE);
            }
        }
        profiles.add(DEFAULT_PROFILE); // Default configuration will have 'null' profile
        profiles = sortedUnique(profiles);

        List<String> labels = Arrays.asList(label, DEFAULT_LABEL); // Default configuration will have 'null' label
        labels = sortedUnique(labels);



        Environment environment = null;
		try {

            environment = new Environment(application,profilesArr, label, null,null) ;
			log.info("application:{},profile:{}",application,profile);
            for (String tmpPro : profiles) {
				List<ConfigInfo> selList = configInfoRepository.findByApplicationAndProfile(application, profile);
                Map<String, Object> flatSource = Maps.newHashMap();
                String sourceName = application + tmpPro;
                for (ConfigInfo configInfo : selList) {
                    flatSource.put(configInfo.getKey(),configInfo.getValue());

                }
                PropertySource propSource = new PropertySource(sourceName, flatSource);
                environment.add(propSource);

            }

		}
		catch (Exception e) {
			throw new IllegalStateException("Cannot load environment", e);
		}
		log.info("sel result:{}", JSON.toJSONString(environment));
		return environment;
	}

	private ArrayList<String> sortedUnique(List<String> values) {
		return new ArrayList<String>(new LinkedHashSet<String>(values));
	}

	private void sortSourcesByLabel(List<MongoPropertySource> sources,
			final List<String> labels) {
		Collections.sort(sources, new Comparator<MongoPropertySource>() {

			@Override
			public int compare(MongoPropertySource s1, MongoPropertySource s2) {
				int i1 = labels.indexOf(s1.getLabel());
				int i2 = labels.indexOf(s2.getLabel());
				return Integer.compare(i1, i2);
			}

		});
	}

	private void sortSourcesByProfile(List<MongoPropertySource> sources,
			final List<String> profiles) {
		Collections.sort(sources, new Comparator<MongoPropertySource>() {

			@Override
			public int compare(MongoPropertySource s1, MongoPropertySource s2) {
				int i1 = profiles.indexOf(s1.getProfile());
				int i2 = profiles.indexOf(s2.getProfile());
				return Integer.compare(i1, i2);
			}

		});
	}

	private String generateSourceName(String environmentName, MongoPropertySource source) {
		String sourceName;
		String profile = source.getProfile() != null ? source.getProfile() : DEFAULT;
		String label = source.getLabel();
		if (label != null) {
			sourceName = String.format("%s-%s-%s", environmentName, profile, label);
		}
		else {
			sourceName = String.format("%s-%s", environmentName, profile);
		}
		return sourceName;
	}

	public static class MongoPropertySource {

		private String profile;
		private String label;
		private LinkedHashMap<String, Object> source = new LinkedHashMap<String, Object>();

		public String getProfile() {
			return profile;
		}

		public void setProfile(String profile) {
			this.profile = profile;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public LinkedHashMap<String, Object> getSource() {
			return source;
		}

		public void setSource(LinkedHashMap<String, Object> source) {
			this.source = source;
		}

	}

	private static class MapFlattener extends YamlProcessor {

		public Map<String, Object> flatten(Map<String, Object> source) {
			return getFlattenedMap(source);
		}

	}

}
