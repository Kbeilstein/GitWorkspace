package teamprojekt.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import teamprojekt.control.ComboHashHandler;
import teamprojekt.control.StartButtonHandler;

@SuppressWarnings("serial")
public class ComboView extends JPanel
{
    private String[] verfahren =
    { "Lineares Sondieren", "Verallg. Lineares Sondieren", "Quadratisches Sondieren", "altanierendes Quad. Sondieren", "Doppelthashing" };

    public ComboView()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JComboBox<String> versVerf = new JComboBox<String>(verfahren);
        versVerf.setEditable(false);
        c.insets = new Insets(10, 0, 0, 0); // top padding        
        c.gridx = 0;
        c.gridy = 0;
        add(versVerf, c);

        JComboBox<Integer> versArryLaenge = new JComboBox<Integer>();
        versArryLaenge.setEditable(false);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        add(versArryLaenge, c);
        versVerf.addActionListener(new ComboHashHandler(versArryLaenge));

        JButton start = new JButton("Start");
        start.addActionListener(new StartButtonHandler(versVerf, versArryLaenge));

        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(30, 0, 0, 0); // top padding
        c.gridx = 0; // aligned with button 2
        c.gridy = 2; // third row        
        add(start, c);
    }
}
