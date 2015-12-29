package juuxel.maple.reference;

import juuxel.maple.plugin.Plugin;

/**
 * Contains the default Maple plugins.
 */
public final class Plugins
{
    /**
     * The menu bar plugin. If this plugin is present, the environment should have a main menu.
     */
    public static final Plugin MENU_BAR_PLUGIN = new Plugin("M_MenuBar");

    /**
     * The internal environment plugin. If this plugin is present,
     * the environment should support multiple Applications in a single frame.
     */
    public static final Plugin INTERNAL_ENVIRONMENT_PLUGIN = new Plugin("M_InternalEnvironment");
}
