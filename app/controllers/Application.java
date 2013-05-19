package controllers;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.pattern.Patterns;
import com.mparaz.pinoyjugplay.WebActor;
import play.*;
import play.api.data.ObjectMapping;
import play.libs.Akka;
import play.mvc.*;
import play.libs.F.Function;

import scala.Function1;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Miguel, Your new application is ready."));
    }

    public static Result actor(String q) {

        final String name = q;

        // Get a hold of the webActor
        final ActorRef webActor = Akka.system().actorOf(new Props(WebActor.class));

        // ask() is more appropriate for the web (at least for http, not websocket or polling)
        return async(Akka.asPromise(Patterns.ask(webActor, name, 1000)).map(
                new Function<Object, Result>() {

                    @Override
                    public Result apply(Object o) throws Throwable {
                        return ok(o.toString());
                    }
                }));

    }
}
