package juuxel.maple;

import juuxel.maple.meta.ApplicationMeta;
import juuxel.maple.meta.MetaTypes;
import juuxel.maple.meta.Metadata;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;

/**
 * The application utility class.
 */
public final class AppUtils
{
    private AppUtils() {}

    /**
     * The default frame class for applications.
     * @see juuxel.maple.AFrame
     * @see juuxel.maple.Application
     */
    public static Class<? extends Container> defaultFrameClass = AFrame.class;

    /**
     * Get the default frame class for applications.
     * @return The default frame class.
     */
    public static Class<? extends Container> getDefaultFrameClass()
    {
        return defaultFrameClass;
    }

    /**
     * Returns the name of the app parameter.
     * @param app the application
     * @return the name
     */
    public static String getApplicationName(Application app)
    {
        return getApplicationName(app.getClass());
    }

    /**
     * Returns the name of the {@link Application} defined by appClass.
     * @param appClass the application class
     * @return the name
     */
    public static String getApplicationName(Class<? extends Application> appClass)
    {
        try
        {
            for (Field field : appClass.getFields())
                if (field.isAnnotationPresent(Metadata.class))
                    if (field.getAnnotation(Metadata.class).value() == MetaTypes.NAME)
                        return ((String) field.get(appClass));
                    else if (field.getAnnotation(Metadata.class).value() == MetaTypes.ALL)
                        return ((ApplicationMeta) field.get(appClass)).getName();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return appClass.getSimpleName();
    }

    /**
     * Tries to perform the quit action for the app parameter.
     * @param app the application
     */
    public static void performQuitAction(Application app)
    {
        try
        {
            for (Field field : app.getClass().getFields())
            {
                if (field.isAnnotationPresent(Metadata.class) && field.getAnnotation(Metadata.class).value() == MetaTypes.ALL)
                    ((ApplicationMeta) field.get(app)).quit(app);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Return true if the app parameter has an icon defined using {@link Metadata}.
     * @param app the application to search the icon for
     * @return true if the application has an icon
     * @see Metadata
     * @see MetaTypes#ICON
     */
    public static boolean hasIcon(Application app)
    {
        try
        {
            for (Field field : app.getClass().getFields())
            {
                if (field.isAnnotationPresent(Metadata.class) && field.getAnnotation(Metadata.class).value() == MetaTypes.ICON)
                    return true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Get the icon for the app parameter.
     * @param app the application
     * @return the icon for the app parameter
     * @throws NoSuchFieldException when icon isn't found
     */
    public static Icon getIcon(Application app) throws NoSuchFieldException
    {
        try
        {
            for (Field field : app.getClass().getFields())
            {
                if (field.isAnnotationPresent(Metadata.class) && field.getAnnotation(Metadata.class).value() == MetaTypes.ICON)
                    return (Icon) field.get(app);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        throw new NoSuchFieldException();
    }

    /**
     * Get the icon for the app parameter safely.
     * @param app the application
     * @return the icon for the app parameter if present; otherwise <code>null</code>.
     */
    public static Icon getIconForApplication(Application app)
    {
        try
        {
            return hasIcon(app) ? getIcon(app) : null;
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
