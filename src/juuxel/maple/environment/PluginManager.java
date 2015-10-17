package juuxel.maple.environment;

import java.util.HashSet;
import java.util.Set;

public final class PluginManager
{
    /**
     * A set of {@link Plugin} instances. All plugins go here.
     */
    private static final Set<Plugin> PLUGINS = new HashSet<>();

    /**
     * Returns true if a plugin with name matching {@code name} is found in {@link PluginManager#PLUGINS}.
     * @param name a String to search for in PLUGINS
     * @return is a plugin with name matching {@code name} is found in PLUGINS
     */
    public static boolean isPluginRegistered(String name)
    {
        for (Plugin plugin : PLUGINS)
            if (plugin.getName().equals(name))
                return true;

        return false;
    }

    /**
     * Returns true if a plugin matching the plugin argument is registered.
     * @param plugin the plugin to search for
     * @return is {@code plugin} registered
     */
    public static boolean isPluginRegistered(Plugin plugin)
    {
        return PLUGINS.contains(plugin);
    }

    /**
     * Register plugins in PluginRegistry.
     * @param plugin a plugin to register
     */
    public static void registerPlugin(Plugin plugin)
    {
        PLUGINS.add(plugin);
    }
}
