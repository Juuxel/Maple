package juuxel.maple.component;

import juuxel.maple.AppUtils;
import juuxel.maple.Application;

import javax.swing.*;

/**
 * Frame for applications.
 */
public class JApplicationFrame extends JFrame
{
    /**
     * The class constructor.
     * @param app the app for this frame
     * @param title the title for this frame
     */
    public JApplicationFrame(Application app, String title)
    {
        super(title);
        this.getContentPane().add(app);
        this.setJMenuBar(app.getMenuBar());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SwingUtilities.invokeLater(() -> {
            setVisible(true);
            setSize(750, 600);
        });
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
}
