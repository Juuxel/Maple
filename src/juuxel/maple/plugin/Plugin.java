package juuxel.maple.plugin;

/**
 * The application environment plugin class.
 * Using Plugin you can create your own plugins for Maple.
 */
public class Plugin
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
     * Get the name of this plugin.
     * @return the plugin name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object object)
    {
        return object instanceof Plugin && ((Plugin) object).getName().equals(name);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode()
    {
        return name.hashCode();
    }
}
