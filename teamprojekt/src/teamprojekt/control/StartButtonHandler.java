package teamprojekt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import teamprojekt.model.ArrayModel;

public class StartButtonHandler implements ActionListener
{
    private JComboBox<?> cvVerfahren;

    private int[] arraySize;

    private JComboBox<?> cbArraySize;

    public StartButtonHandler(JComboBox<?> cbVerfahren, JComboBox<?> cbArraySize, int[] arraySize)
    {
        this.cvVerfahren = cbVerfahren;
        this.cbArraySize = cbArraySize;
        this.arraySize = arraySize;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        ArrayModel array = new ArrayModel(arraySize[cbArraySize.getSelectedIndex()]);

    }
}
