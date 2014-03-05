package teamprojekt.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PseudoCodeView extends JFrame
{
    private JComboBox<String> cbVerfahren;

    public PseudoCodeView(JComboBox<String> cbVerfahren)
    {
        this.cbVerfahren = cbVerfahren;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setSize(500, 500);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (screenSize.getWidth() / 2 - getSize().getWidth() / 2), (int) (screenSize.getHeight() / 2 - getSize().getHeight() / 2));
        JLabel label = new JLabel();
        fillLabel(label);
        add(label);
        setTitle((String) cbVerfahren.getSelectedItem());
        setVisible(true);
    }

    private void fillLabel(JLabel label)
    {
        int index = cbVerfahren.getSelectedIndex();
        switch (index)
        {
            case 0:
                label.setText("linearesSondieren");
                break;
            case 1:
                label.setText("verallgLinearesSondieren");
                break;
            case 2:
                label.setText("quadratischesSondieren");
                break;
            case 3:
                label.setText("alternierendesQuadratischesSondieren");
                break;
            case 4:
                label.setText("doppelHashing");
                break;

            default:
                break;
        }

    }
}
