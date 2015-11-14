package juuxel.maple.util;

public class Module
{
    private final String name;

    /**
     * Constructs a new Module object.
     * @param name the name for this module
     */
    public Module(String name)
    {
        this.name = name;
    }

    /**
     * Get the name of this module.
     * @return the module name
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
        return object instanceof Module && ((Module) object).getName().equals(name);
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
