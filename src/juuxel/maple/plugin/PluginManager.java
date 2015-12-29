package juuxel.maple.plugin;

import juuxel.maple.util.Manager;

public final class PluginManager extends Manager<Plugin>
{
    private static final PluginManager MANAGER = new PluginManager();

    private PluginManager()
    {}

    /**
     * Returns true if a plugin with name matching {@code name} is found in PluginManager.
     * @param name a String to search for
     * @return is a plugin with name matching {@code name} is found
     */
    public static boolean isPluginRegistered(String name)
    {
        return MANAGER.has(name);
    }

    /**
     * Returns true if a plugin matching the plugin argument is registered.
     * @param plugin the plugin to search for
     * @return is {@code plugin} registered
     */
    public static boolean isPluginRegistered(Plugin plugin)
    {
        return MANAGER.has(plugin);
    }

    /**
     * Register plugins in PluginManager.
     * @param plugin a plugin to register
     */
    public static void registerPlugin(Plugin plugin)
    {
        MANAGER.add(plugin);
    }
}
