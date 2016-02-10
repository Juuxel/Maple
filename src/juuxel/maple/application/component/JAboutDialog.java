package juuxel.maple.application.component;

import juuxel.maple.application.AppUtils;
import juuxel.maple.application.Application;

import javax.swing.*;
import java.awt.*;

/**
 * A dialog for 'About' screens.
 */
public class JAboutDialog extends JOptionPane
{
    private final String name;
    private final String description;

    /**
     * The default constructor for JAboutDialog.
     *
     * @param app the application
     */
    public JAboutDialog(Application app)
    {
        name = AppUtils.getApplicationName(app);
        description = app.getDescription();

        buildUserInterface();
    }

    private void buildUserInterface()
    {
        setLayout(new BorderLayout());

        JLabel title = new JLabel(name);
        title.setFont(title.getFont().deriveFont(Font.BOLD));

        JLabel subtitle = new JLabel(description);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        JButton close = new JButton("OK");

        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(close);

        add(title, BorderLayout.PAGE_START);
        add(subtitle, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.PAGE_END);
    }
}
