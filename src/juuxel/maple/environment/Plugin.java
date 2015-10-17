package juuxel.maple.environment;

/**
 * The application environment plugin class.
 * Using Plugin you can create your own plugins for Maple.
 */
public class Plugin
{
    /**
     * The name of this plugin.
     */
    private String name;

    /**
     * Constructs a new Plugin object.
     * @param name the name for this plugin
     */
    public Plugin(String name)
    {
        this.name = name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public boolean equals(Object object)
    {
        return object instanceof Plugin && ((Plugin) object).getName().equals(name);
    }

    @Override
    public int hashCode()
    {
        return name.hashCode();
    }
}
