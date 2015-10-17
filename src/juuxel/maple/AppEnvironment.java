package juuxel.maple;

import javax.swing.*;
import java.awt.*;

/**
 * The application environment class.
 */
public final class AppEnvironment
{
    /**
     * Is debug output enabled in the environment.
     * @see juuxel.maple.util.Debug
     */
    public static boolean debugOutputEnabled = false;

    /**
     * The default frame class for applications.
     * @see juuxel.maple.AFrame
     * @see juuxel.maple.Application
     */
    public static Class<? extends Container> defaultFrameClass = AFrame.class;

    /**
     * The default file manager class for applications.
     * @see juuxel.maple.environment.FileManager
     * @see juuxel.maple.environment.FileChanger
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
