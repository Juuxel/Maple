package juuxel.simpleapps.meta;

import juuxel.simpleapps.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * The application metadata used in application environments.
 * Also contains some event handling.
 */
public abstract class ApplicationMeta
{
    /**
     * The categories of this application.
     */
    private final List<Categories> categories;

    /**
     * The name of this application
     */
    private final String name;

    /**
     * The default constructor.
     */
    public ApplicationMeta(String name)
    {
        categories = new ArrayList<>();
        this.name = name;
    }

    /**
     * Get the categories of this ApplicationMeta.
     * @return The categories of this ApplicationMeta.
     */
    public List<Categories> getCategories()
    {
        return categories;
    }

    /**
     * Get the name of this ApplicationMeta.
     * @return The name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Called by Vee or Fawde when an application is quit.
     * @param app The application that is closed
     */
    public void quit(Application app) {}
}
