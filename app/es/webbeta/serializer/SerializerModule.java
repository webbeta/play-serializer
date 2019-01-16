package es.webbeta.serializer;

import com.google.inject.AbstractModule;
import es.webbeta.Serializer;

public class SerializerModule extends AbstractModule
{

    @Override
    protected void configure() {
        bind(Serializer.class).toProvider(SerializerProvider.class);
    }

}
