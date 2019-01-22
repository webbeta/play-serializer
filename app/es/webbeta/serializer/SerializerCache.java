package es.webbeta.serializer;

import es.webbeta.serializer.base.Cache;
import play.cache.CacheApi;

import javax.inject.Inject;

public class SerializerCache implements Cache {

    private final CacheApi cacheApi;

    @Inject
    public SerializerCache(CacheApi cacheApi) {
        this.cacheApi = cacheApi;
    }

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

}
