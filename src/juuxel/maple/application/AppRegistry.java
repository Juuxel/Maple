package juuxel.maple.application;

import java.util.HashSet;
import java.util.Set;

/**
 * The registry for applications.
 */
public final class AppRegistry
{
    private static final HashSet<Class<? extends Application>> set = new HashSet<>();

    public static void registerApplication(Class<? extends Application> appClass)
    {
        set.add(appClass);
    }

    public static Set<Class<? extends Application>> getRegisteredApplications()
    {
        return set;
    }
}
