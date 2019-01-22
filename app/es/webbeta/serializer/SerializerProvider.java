package es.webbeta.serializer;

import com.google.inject.Provider;
import es.webbeta.Serializer;
import es.webbeta.SerializerBuilder;
import es.webbeta.serializer.base.Logger;
import play.Environment;

import javax.inject.Inject;

public class SerializerProvider implements Provider<Serializer> {

    @Inject
    private SerializerCache cache;

    @Inject
    private SerializerConfigurationProvider configurationProvider;

    @Inject
    private SerializerLogger logger;

    @Inject
    private Environment environment;

    @Override
    public Serializer get() {
        return SerializerBuilder.build()
                .withCache(cache)
                .withEnvironment(() -> environment.isProd())
                .withConfigurationProvider(configurationProvider)
                .withLogger(logger)
                .get();
    }

}