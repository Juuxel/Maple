package juuxel.maple.environment;

import juuxel.maple.AppEnvironment;

import javax.swing.*;
import java.lang.reflect.Method;

public final class FileManager
{
    public static int showDialog(String str) throws Exception
    {
        if (AppEnvironment.defaultFileManagerClass == JFileChooser.class)
            return new JFileChooser().showDialog(null, str);

        for (Method method : AppEnvironment.defaultFileManagerClass.getMethods())
        {
            if (method.isAnnotationPresent(FileChanger.class) && method.getAnnotation(FileChanger.class).value() == FileChanger.FileManagementTypes.GENERAL)
            {
                return (int) method.invoke(AppEnvironment.defaultFileManagerClass.newInstance(), str);
            }
        }

        throw new NoSuchMethodException();
    }

    public static int showOpenDialog() throws Exception
    {
        if (AppEnvironment.defaultFileManagerClass == JFileChooser.class)
            return new JFileChooser().showOpenDialog(null);

        for (Method method : AppEnvironment.defaultFileManagerClass.getMethods())
        {
            if (method.isAnnotationPresent(FileChanger.class) && method.getAnnotation(FileChanger.class).value() == FileChanger.FileManagementTypes.OPEN)
            {
                return (int) method.invoke(AppEnvironment.defaultFileManagerClass.newInstance());
            }
        }

        throw new NoSuchMethodException();
    }

    public static int showSaveDialog() throws Exception
    {
        if (AppEnvironment.defaultFileManagerClass == JFileChooser.class)
            return new JFileChooser().showSaveDialog(null);

        for (Method method : AppEnvironment.defaultFileManagerClass.getMethods())
        {
            if (method.isAnnotationPresent(FileChanger.class) && method.getAnnotation(FileChanger.class).value() == FileChanger.FileManagementTypes.SAVE)
            {
                return (int) method.invoke(AppEnvironment.defaultFileManagerClass.newInstance());
            }
        }

        throw new NoSuchMethodException();
    }
}
