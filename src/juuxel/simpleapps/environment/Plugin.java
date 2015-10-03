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
}
