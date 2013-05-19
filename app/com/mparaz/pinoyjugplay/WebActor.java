package com.mparaz.pinoyjugplay;

import akka.actor.UntypedActor;
import play.Logger;

/**
 * Actor fired up from the web
 */
public class WebActor extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            Logger.debug("web actor");
            getSender().tell("hello " + message, null);
        } else {
            unhandled(message);
        }
    }
}
