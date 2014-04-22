package teamprojekt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import teamprojekt.view.PseudoCodeView;

public class PseudoCodeButtonHandler implements ActionListener
{
    private JComboBox<String> cbVerfahren;

    public PseudoCodeButtonHandler(JComboBox<String> cbVerfahren)
    {
        this.cbVerfahren = cbVerfahren;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        new PseudoCodeView(cbVerfahren);
    }
}
