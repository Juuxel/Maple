package juuxel.maple.plugin;

import juuxel.maple.util.Manageable;

/**
 * The application environment plugin class.
 * Using Plugin you can create your own plugins for Maple.
 */
public class Plugin implements Manageable
{
    private final String name;

    /**
     * Constructs a new Plugin object.
     * @param name the name for this plugin
     */
    public Plugin(String name)
    {
        this.name = name;
    }

    /**
     * @inheritDoc
     */
    public String getName()
    {
        return name;
    }
}
