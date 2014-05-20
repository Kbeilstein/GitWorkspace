package teamprojekt.view;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class HelpFrameView extends JFrame
{
    public HelpFrameView()
    {
        super("Hilfe");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // setSize(400, 200);
        setLocation((int) (screenSize.getWidth() / 2 - getSize().getWidth() / 2), (int) (screenSize.getHeight() / 2 - getSize().getHeight() / 2));

        // Ein Textfeld um den Hilfetext darzustellen
        JTextArea textField = new JTextArea();
        textField.setText("Dieses Programm dient zur Veranschaulichung des geschlossenen Hashings.");
        textField.setEditable(false);
        add(textField);
        textField.setMargin(new Insets(10, 10, 10, 10));

        pack();
        setVisible(true);
    }
}
