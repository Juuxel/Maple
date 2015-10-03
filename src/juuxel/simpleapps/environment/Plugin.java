package juuxel.simpleapps.environment;

public class Plugin
{
    private String name;

    public Plugin(String name)
    {
        this.name = name;
    }

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
