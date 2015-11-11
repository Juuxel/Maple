package juuxel.maple.application.meta;

import juuxel.maple.application.Application;

/**
 * The application metadata used in application environments.
 * Also contains some event handling.
 */
public abstract class ApplicationMeta
{
    /**
     * The name of this application
     */
    private final String name;

    /**
     * The default constructor.
     */
    public ApplicationMeta(String name)
    {
        this.name = name;
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
