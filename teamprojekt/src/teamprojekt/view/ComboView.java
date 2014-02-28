package teamprojekt.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    private int[] arrayGroesse =
    { 5, 7, 11, 13, 17, 19 };

    public ComboView()
    {
        setLayout(new GridLayout(0, 1));

        JComboBox<String> versVerf = new JComboBox<String>(verfahren);
        versVerf.setEditable(false);
        add(versVerf);

        JComboBox<Integer> versArryLaenge = new JComboBox<Integer>();
        versArryLaenge.setEditable(false);
        add(versArryLaenge);
        versVerf.addActionListener(new ComboHashHandler(versArryLaenge));

        JButton start = new JButton("Start");
        start.addActionListener(new StartButtonHandler(versVerf, versArryLaenge));
        add(start);
        
        

    }

}
