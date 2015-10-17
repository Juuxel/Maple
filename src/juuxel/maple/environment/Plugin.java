package juuxel.maple.environment;

public class Plugin
{
    public static final Plugin MENU_BAR_PLUGIN = new Plugin("M_MenuBar");

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
