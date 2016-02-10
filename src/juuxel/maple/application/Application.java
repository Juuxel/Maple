package juuxel.maple.application;

import juuxel.maple.application.component.JApplicationFrame;
import juuxel.maple.plugin.PluginManager;
import juuxel.maple.reference.Plugins;

import javax.swing.*;
import java.awt.Container;

/**
 * The Maple application class.
 */
public abstract class Application extends JPanel
{
    /**
     * The menu bar of this application.
     */
    private final JMenuBar menuBar = new JMenuBar();

    /**
     * A short description of this application.
     */
    private String description;

    /**
     * Default constructor for {@link Application}.
     * @see Application#Application(boolean)
     * @see Application#Application(Class, boolean)
     */
    public Application()
    {
        this(!PluginManager.isPluginRegistered(Plugins.INTERNAL_ENVIRONMENT_PLUGIN));
    }

    /**
     * One of the alternate constructors for {@link Application}.
     * @param generateFrame Generate the frame automatically or generate it manually
     * @see Application#Application()
     * @see Application#Application(Class, boolean)
     */
    public Application(boolean generateFrame)
    {
        this(AppUtils.getDefaultFrameClass(), generateFrame);
    }

    /**
     * One of the alternate constructors for {@link Application}.
     * @param frameClass The frame class for this application.
     * @param generateFrame Generate the frame automatically or generate it manually
     * @see Application#Application()
     * @see Application#Application(boolean)
     */
    public Application(Class<? extends Container> frameClass, boolean generateFrame)
    {
        super();
        initialize(new String[0]);
        setDescription("A Maple application.");
        buildUserInterface();

        if (generateFrame)
            if (frameClass == JApplicationFrame.class)
                new JApplicationFrame(this);
            else
                try
                {
                    Container parent = frameClass.newInstance();
                    parent.add(this);
                }
                catch (InstantiationException | IllegalAccessException e)
                {
                    e.printStackTrace();
                }
    }

    /**
     * The initializer method for applications.
     * @param args The initializer arguments.
     */
    public void initialize(String[] args) {}

    /**
     * Build the UI of this app.
     */
    public abstract void buildUserInterface();

    /**
     * Get the menu bar of this application.
     * @return The menu bar of this application.
     */
    public final JMenuBar getMenuBar()
    {
        return menuBar;
    }

    /**
     * Returns true if this Application has a main menu. (A main menu is a menu with label text being the application name.)
     * @return true if this Application has a main menu.
     */
    public boolean hasMainMenu()
    {
        return PluginManager.isPluginRegistered(Plugins.MENU_BAR_PLUGIN);
    }

    /**
     * Executed when the application is closed.
     */
    public void quit()
    {}

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
