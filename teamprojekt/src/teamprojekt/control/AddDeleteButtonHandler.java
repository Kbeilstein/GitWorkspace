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
        if (!textBox.getText().isEmpty() && sondieren.getArrayPosition() == -1)
        {
            if (button.getText().equals("hinzuf\u00fcgen"))
            {
                sondieren.setInsertSearchDelete("insert");
                sondieren.add(Integer.parseInt(textBox.getText()));
            }
            
            if (button.getText().equals("suchen"))
            {
                sondieren.setInsertSearchDelete("search");
                sondieren.search(Integer.parseInt(textBox.getText()));                
            }
            
            if (button.getText().equals("l\u00f6schen"))
            {
                sondieren.setInsertSearchDelete("delete");
                sondieren.delete(Integer.parseInt(textBox.getText()));
            }
        }
        textBox.setText("");
    }

}
