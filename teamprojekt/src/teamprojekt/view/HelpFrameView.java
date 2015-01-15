package teamprojekt.view;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class HelpFrameView extends JFrame
{
    public HelpFrameView()
    {
        super("Hilfe");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Ein Textfeld um den Hilfetext darzustellen
        try
        {
            JEditorPane textfield = new JEditorPane(getClass().getResource("HilfeText.html"));
            JScrollPane scrollPane = new JScrollPane(textfield);
            textfield.setEditable(false);
            textfield.setMargin(new Insets(0, 10, 10, 10));
            add(scrollPane);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        setLocation((int) (screenSize.getWidth() / 2 - getSize().getWidth() / 2) - 400, (int) (screenSize.getHeight() / 2 - getSize().getHeight() / 2) - 400);
        setSize(920, 780);
        setVisible(true);
    }
}
