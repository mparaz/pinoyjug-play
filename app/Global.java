import play.Application;
import play.GlobalSettings;
import play.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: mparaz
 * Date: 5/19/13
 * Time: 3:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class Global extends GlobalSettings {
    @Override
    public void onStart(Application application) {
        Logger.info("Startup");
    }
}
