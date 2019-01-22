package es.webbeta.serializer;

import com.google.inject.AbstractModule;
import es.webbeta.Serializer;
import es.webbeta.serializer.base.MetadataAccessor;

public class SerializerModule extends AbstractModule
{

    @Override
    protected void configure() {
        bind(Serializer.class).toProvider(SerializerProvider.class);
        bind(MetadataAccessor.class).toProvider(MetadataAccesorProvider.class);
    }

}
