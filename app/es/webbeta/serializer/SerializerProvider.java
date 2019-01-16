package es.webbeta.serializer;

import com.google.inject.Provider;
import es.webbeta.Serializer;
import es.webbeta.SerializerBuilder;
import es.webbeta.serializer.base.Cache;
import es.webbeta.serializer.base.ConfigurationProvider;
import es.webbeta.serializer.base.Logger;
import play.Configuration;
import play.Environment;
import play.cache.CacheApi;

import javax.inject.Inject;

public class SerializerProvider implements Provider<Serializer> {

    @Inject
    private Configuration configuration;

    @Inject
    private Environment environment;

    @Inject
    private CacheApi cacheApi;

    @Override
    public Serializer get() {
        return SerializerBuilder.build()
                .withCache(new Cache() {
                    @Override
                    public String get(String key) {
                        return cacheApi.get(key);
                    }

                    @Override
                    public void set(String key, String content) {
                        cacheApi.set(key, content);
                    }

                    @Override
                    public void remove(String key) {
                        cacheApi.remove(key);
                    }
                })
                .withEnvironment(() -> environment.isProd())
                .withConfigurationProvider(new ConfigurationProvider() {
                    @Override
                    public boolean getBoolean(String key, boolean defaultValue) {
                        return configuration.getBoolean(key, defaultValue);
                    }

                    @Override
                    public String getString(String key, String defaultValue) {
                        return configuration.getString(key, defaultValue);
                    }
                })
                .withLogger(new Logger() {
                    @Override
                    public Level getLevel() {
                        return Level.ERROR;
                    }

                    @Override
                    public void setLevel(Level level) {}

                    @Override
                    public void error(String message) {
                        play.Logger.error(message);
                    }
                })
                .get();
    }

}