package es.webbeta.serializer;

import es.webbeta.serializer.base.ConfigurationProvider;
import play.Configuration;

import javax.inject.Inject;

public class SerializerConfigurationProvider implements ConfigurationProvider {

    private final Configuration configuration;

    @Inject
    public SerializerConfigurationProvider(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        return configuration.getBoolean(key, defaultValue);
    }

    @Override
    public String getString(String key, String defaultValue) {
        return configuration.getString(key, defaultValue);
    }

}
