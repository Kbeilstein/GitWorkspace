package teamprojekt.view;

import java.awt.event.*;

import javax.swing.*;

public class ComboView extends JFrame implements ActionListener

{

    private static final long serialVersionUID = 7692824654665347324L;

    public ComboView(String title, String[] selItem)
    {

        super(title);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JComboBox<?> versVerf = new JComboBox(selItem);

        versVerf.setEditable(true);
        versVerf.addActionListener(this);
        add(versVerf);
        setLocation(200, 200);
        setSize(400, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt)
    {
        JComboBox<?> cb = (JComboBox<?>) evt.getSource();
        // System.out.println("ActionEvent: selected " + cb.getSelectedItem() +
        // " (Index " + cb.getSelectedIndex() + ")");
    }

    public static void main(String[] args)
    {
        new ComboView("Auswahl des Verfahrens", args);
    }
}
