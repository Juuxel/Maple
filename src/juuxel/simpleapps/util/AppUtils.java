package juuxel.simpleapps.util;

import juuxel.simpleapps.Application;
import juuxel.simpleapps.meta.ApplicationMeta;
import juuxel.simpleapps.meta.MetaTypes;
import juuxel.simpleapps.meta.Metadata;

import javax.swing.*;
import java.lang.reflect.Field;

public final class AppUtils
{
    private AppUtils() {}

    public static String getApplicationName(Application app)
    {
        return getApplicationName(app.getClass());
    }

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
        {}

        return appClass.getSimpleName();
    }

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
        {}
    }

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
        {}

        return false;
    }

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
        {}

        throw new NoSuchFieldException();
    }
}
