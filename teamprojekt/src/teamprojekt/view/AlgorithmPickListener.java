package teamprojekt.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class AlgorithmPickListener implements ActionListener
{
    private JComboBox<Integer> constPickComboBox;

    private JLabel constPickLabel;

    private SpinnerTextView spinnerTextView;

    private JComboBox<String> algorithmComboBox;

    public AlgorithmPickListener(SpinnerTextView spinnerTextView, JComboBox<String> algorithmComboBox, JComboBox<Integer> constPickComboBox, JLabel constPickLabel)
    {
        this.spinnerTextView = spinnerTextView;
        this.algorithmComboBox = algorithmComboBox;
        this.constPickComboBox = constPickComboBox;
        this.constPickLabel = constPickLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        update();
    }

    public void update()
    {
        if (algorithmComboBox.getSelectedIndex() == 1)
        {
            constPickComboBox.removeAllItems();
            // fügte alle c in die ComboBox, deren Werte zur Arraylänge
            // teilerfremd sind
            for (int i = 1; !spinnerTextView.getText().isEmpty() && i <= Integer.parseInt(spinnerTextView.getText()); i++)
            {
                if (Integer.parseInt(spinnerTextView.getText()) % i != 0)
                {
                    constPickComboBox.addItem(i);
                }
            }
            constPickComboBox.setEnabled(true);
            constPickLabel.setForeground(null);
        }
        else
        {
            constPickComboBox.setEnabled(false);
            constPickLabel.setForeground(Color.GRAY);
        }
    }
}
