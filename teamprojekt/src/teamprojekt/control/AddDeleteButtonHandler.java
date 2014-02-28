package teamprojekt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import teamprojekt.model.Sondieren;

public class AddDeleteButtonHandler implements ActionListener
{
    private JTextField textBox;

    private Sondieren sondieren;

    public AddDeleteButtonHandler(JTextField textBox, Sondieren sondieren)
    {
        this.textBox = textBox;
        this.sondieren = sondieren;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton button = (JButton) e.getSource();
        if (!textBox.getText().isEmpty())
        {
            if (button.getText().equals("add"))
            {
                sondieren.add(Integer.parseInt(textBox.getText()));
            }
            if (button.getText().equals("delete"))
            {
                sondieren.delete(Integer.parseInt(textBox.getText()));
            }
        }
        textBox.setText("");
    }

}
