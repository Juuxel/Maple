package juuxel.simpleapps;

import javax.swing.*;
import java.awt.Container;

/**
 * The SimpleApps application class.
 */
public abstract class Application extends JPanel
{
    /**
     * The menu bar of this application.
     */
    private final JMenuBar menuBar = new JMenuBar();

    /**
     * Default constructor for {@link Application}.
     * @see Application#Application(boolean)
     * @see Application#Application(Class, boolean)
     */
    public Application()
    {
        this(false);
    }

    /**
     * One of the alternate constructors for {@link Application}.
     * @param generateFrame Generate the frame automatically or generate it manually
     * @see Application#Application()
     * @see Application#Application(Class, boolean)
     */
    public Application(boolean generateFrame)
    {
        this(AppEnvironment.getDefaultFrameClass(), generateFrame);
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
        buildUserInterface();

        if (generateFrame)
            if (frameClass == AFrame.class)
                new AFrame(this);
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
}
