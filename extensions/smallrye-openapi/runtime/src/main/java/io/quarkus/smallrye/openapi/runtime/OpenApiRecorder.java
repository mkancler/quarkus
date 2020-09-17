package io.quarkus.smallrye.openapi.runtime;

import io.quarkus.runtime.ShutdownContext;
import io.quarkus.runtime.annotations.Recorder;

@Recorder
public class OpenApiRecorder {

    public void setupClDevMode(ShutdownContext shutdownContext) {
        OpenApiConstants.classLoader = Thread.currentThread().getContextClassLoader();
        shutdownContext.addShutdownTask(new Runnable() {
            @Override
            public void run() {
                OpenApiConstants.classLoader = null;
            }
        });
    }

}
