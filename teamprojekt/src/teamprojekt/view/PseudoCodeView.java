package teamprojekt.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class PseudoCodeView extends JFrame
{
    private JComboBox<String> cbVerfahren;

    private String codeLS = "\t";

    private String codeErwLS = "";

    private String codeQS = "";

    private String codeAltQS = "";

    private String codeDH = "";

    public PseudoCodeView(JComboBox<String> cbVerfahren)
    {
        this.cbVerfahren = cbVerfahren;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setSize(500, 500);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (screenSize.getWidth() / 2 - getSize().getWidth() / 2), (int) (screenSize.getHeight() / 2 - getSize().getHeight() / 2));
        JTextArea text = new JTextArea();
        text.setTabSize(2);
        fillText(text);
        add(text);
        setTitle((String) cbVerfahren.getSelectedItem());
        text.setEditable(false);
        setVisible(true);
    }

    private void fillText(JTextArea text)
    {
        int index = cbVerfahren.getSelectedIndex();
        switch (index)
        {
            case 0:
                text.setText(codeLS);
                break;
            case 1:
                text.setText(codeErwLS);
                break;
            case 2:
                text.setText(codeQS);
                break;
            case 3:
                text.setText(codeAltQS);
                break;
            case 4:
                text.setText(codeDH);
                break;

            default:
                break;
        }

    }
}
