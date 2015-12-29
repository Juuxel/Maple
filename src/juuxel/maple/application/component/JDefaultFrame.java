package juuxel.maple.application.component;

import javax.swing.*;

public class JDefaultFrame extends JFrame
{
    /**
     * The class constructor.
     * @param title the title for this frame
     */
    public JDefaultFrame(String title)
    {
        super(title);
        init();
    }

    /**
     * The class constructor.
     */
    public JDefaultFrame()
    {
        init();
    }

    private void init()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SwingUtilities.invokeLater(() -> {
            setVisible(true);
            setSize(640, 480);
        });
    }
}
