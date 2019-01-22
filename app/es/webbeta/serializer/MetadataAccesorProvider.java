package es.webbeta.serializer;

import com.google.inject.Provider;
import es.webbeta.serializer.base.MetadataAccessor;
import play.Environment;

import javax.inject.Inject;

public class MetadataAccesorProvider implements Provider<MetadataAccessor> {

    @Inject
    private SerializerCache cache;

    @Inject
    private SerializerConfigurationProvider configurationProvider;

    @Inject
    private Environment environment;

    @Override
    public MetadataAccessor get() {
        return new ConfigurationManager(configurationProvider, () -> environment.isProd(), cache)
                .getMetadataAccessor();
    }

}