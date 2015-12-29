package juuxel.maple.application;

import java.util.HashSet;
import java.util.Set;

/**
 * The registry for applications.
 */
public final class AppRegistry
{
    private static final HashSet<Class<? extends Application>> set = new HashSet<>();

    /**
     * Registers an Application in AppRegistry.
     * @param appClass the Application to register
     */
    public static void registerApplication(Class<? extends Application> appClass)
    {
        set.add(appClass);
    }

    /**
     * Gets the registers Application objects from AppRegistry.
     * @return the Set of Applications registered
     */
    public static Set<Class<? extends Application>> getRegisteredApplications()
    {
        return set;
    }
}
