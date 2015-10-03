package juuxel.simpleapps;

import juuxel.simpleapps.environment.Plugin;

import javax.swing.*;
import java.awt.Container;
import java.util.HashSet;
import java.util.Set;

/**
 * The application environment class.
 */
public final class AppEnvironment
{
    /**
     * A Set of Plugin instances. Used by Notes++ for detecting Fawde compatibility.
     */
    public static final Set<Plugin> PLUGINS = new HashSet<>();

    /**
     * Is debug output enabled in the environment.
     * @see juuxel.simpleapps.util.Debug
     */
    public static boolean debugOutputEnabled = false;

    /**
     * The default frame class for applications.
     * @see juuxel.simpleapps.AFrame
     * @see juuxel.simpleapps.Application
     */
    public static Class<? extends Container> defaultFrameClass = AFrame.class;

    /**
     * The default file manager class for applications.
     * @see juuxel.simpleapps.environment.FileManager
     * @see juuxel.simpleapps.environment.FileChanger
     */
    public static Class<?> defaultFileManagerClass = JFileChooser.class;

    private AppEnvironment() {}

    /**
     * Get the default frame class for applications.
     * @return The default frame class.
     */
    public static Class<? extends Container> getDefaultFrameClass()
    {
        return defaultFrameClass;
    }

    /**
     * Get the value of {@link AppEnvironment#debugOutputEnabled}
     * @return the value of the boolean
     */
    public static boolean isDebugOutputEnabled()
    {
        return debugOutputEnabled;
    }
}
