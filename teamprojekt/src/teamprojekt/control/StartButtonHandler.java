package teamprojekt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class StartButtonHandler implements ActionListener
{
    private JComboBox<String> cbVerfahren;

    private JComboBox<?> cbArraySize;

    public StartButtonHandler(JComboBox<String> cbVerfahren, JComboBox<Integer> cbArraySize)
    {
        this.cbVerfahren = cbVerfahren;
        this.cbArraySize = cbArraySize;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(cbVerfahren.getSelectedItem());
        System.out.println(cbArraySize.getSelectedItem());
        // ArrayModel array = new ArrayModel((int)
        // cbArraySize.getSelectedItem());
    }
}
