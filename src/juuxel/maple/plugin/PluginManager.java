package juuxel.maple.plugin;

import juuxel.maple.util.ModuleManager;

public final class PluginManager extends ModuleManager<Plugin>
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
        return MANAGER.hasModule(name);
    }

    /**
     * Returns true if a plugin matching the plugin argument is registered.
     * @param plugin the plugin to search for
     * @return is {@code plugin} registered
     */
    public static boolean isPluginRegistered(Plugin plugin)
    {
        return MANAGER.hasModule(plugin);
    }

    /**
     * Register plugins in PluginManager.
     * @param plugin a plugin to register
     */
    public static void registerPlugin(Plugin plugin)
    {
        MANAGER.addModule(plugin);
    }
}
