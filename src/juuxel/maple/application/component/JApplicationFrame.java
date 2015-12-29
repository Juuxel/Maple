package juuxel.maple.application.component;

import juuxel.maple.application.AppUtils;
import juuxel.maple.application.Application;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Frame for applications.
 */
public class JApplicationFrame extends JDefaultFrame
{
    /**
     * The class constructor.
     * @param app the app for this frame
     * @param title the title for this frame
     */
    public JApplicationFrame(Application app, String title)
    {
        super(title);
        this.setContentPane(app);
        this.setJMenuBar(app.getMenuBar());
        this.addWindowListener(new ApplicationWindowListener(app));
    }

    /**
     * The class constructor. Creates the title based on {@link AppUtils#getApplicationName(Application)} output.
     * @param app the app for this name
     * @see JApplicationFrame#JApplicationFrame(Application, String)
     */
    public JApplicationFrame(Application app)
    {
        this(app, AppUtils.getApplicationName(app));
    }

    private static class ApplicationWindowListener extends WindowAdapter
    {
        private final Application application;

        ApplicationWindowListener(Application a)
        {
            application = a;
        }

        @Override
        public void windowClosing(WindowEvent e)
        {
            application.quit();
        }
    }
}
