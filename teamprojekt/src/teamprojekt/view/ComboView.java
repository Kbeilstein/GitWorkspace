package teamprojekt.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;

import teamprojekt.control.ComboHashHandler;
import teamprojekt.control.PseudoCodeButtonHandler;
import teamprojekt.control.StartButtonHandler;

@SuppressWarnings("serial")
public class ComboView extends JPanel
{
    final private String[] verfahren =
    { "Lineares Sondieren", "Verallg. Lineares Sondieren", "Quadratisches Sondieren", "alternierendes Quad. Sondieren", "Doppelhashing" };

    public ComboView(MainView panel)
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JComboBox<String> versVerf = new JComboBox<String>(verfahren);
        versVerf.setEditable(false);
        // versVerf.setFocusable(false);
        c.insets = new Insets(10, 10, 0, 10); // top padding
        c.gridx = 0;
        c.gridy = 0;
        versVerf.setBackground(Color.white);
        versVerf.setForeground(Color.darkGray);
        add(versVerf, c);

        JComboBox<Integer> versArryLaenge = new JComboBox<Integer>();
        versArryLaenge.setEditable(false);
        // versArryLaenge.setFocusable(false);
        versArryLaenge.setBackground(Color.white);
        versArryLaenge.setForeground(Color.darkGray);
        c.fill = GridBagConstraints.HORIZONTAL;
        // c.anchor = GridBagConstraints.EAST;

        c.gridy = 1;
        add(versArryLaenge, c);
        versVerf.addActionListener(new ComboHashHandler(versArryLaenge));

        JButton start = new JButton("Start");
        start.addActionListener(new StartButtonHandler(versVerf, versArryLaenge, panel));

        c.fill = GridBagConstraints.NONE;
        // c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(30, 0, 0, 0); // top padding
        c.gridy = 2; // third row
        add(start, c);

        JButton pseudoCode = new JButton("Pseudo Code");
        pseudoCode.addActionListener(new PseudoCodeButtonHandler(versVerf));
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(50, 0, 17, 0);
        c.gridy = 3;
        add(pseudoCode, c);
        Border lineBorder1 = BorderFactory.createLineBorder(Color.BLACK);
        Border titleBorder1 = BorderFactory.createTitledBorder(lineBorder1, "Auswahl");

        setBorder(titleBorder1);
    }
}
