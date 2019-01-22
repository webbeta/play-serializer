package es.webbeta.serializer;

import es.webbeta.serializer.base.Logger;

public class SerializerLogger implements Logger {

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

}
