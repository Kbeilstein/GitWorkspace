package teamprojekt.view;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class HelpFrameView extends JFrame
{

    public HelpFrameView()
    {
        super("Hilfe");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JPanel panel = new JPanel();

        // JEditorPane pane = new
        // JEditorPane(getClass().getResource("test.html"));
        // panel.add(pane);
        // add(panel);

        // Ein Textfeld um den Hilfetext darzustellen
        JTextArea textField = new JTextArea();
        textField.setText("Dieses Programm dient zur Veranschaulichung des geschlossenen Hashings.");

        JScrollPane scrollPane = new JScrollPane(textField);

        textField.setLineWrap(true);
        textField.setWrapStyleWord(true);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textField.setEditable(false);

        textField.setMargin(new Insets(10, 10, 10, 10));

        add(textField);

        setLocation((int) (screenSize.getWidth() / 2 - getSize().getWidth() / 2) - 300, (int) (screenSize.getHeight() / 2 - getSize().getHeight() / 2) - 400);
        setSize(600, 800);
        // pack();
        setVisible(true);
    }
}
