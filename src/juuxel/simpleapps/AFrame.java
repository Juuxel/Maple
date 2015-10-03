package juuxel.simpleapps;

import juuxel.simpleapps.util.AppUtils;

import javax.swing.*;

/**
 * An awesome frame. The name comes from Awesome JFrame or Application Frame.
 */
public class AFrame extends JFrame
{
    public AFrame(Application app, String title)
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

    public AFrame(Application app)
    {
        this(app, AppUtils.getApplicationName(app));
    }
}
