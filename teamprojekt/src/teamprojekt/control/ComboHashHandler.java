package teamprojekt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class ComboHashHandler implements ActionListener
{

    final private int[] linearesSondieren =
    { 5, 7, 11, 13, 17, 19 };

    final private int[] verallgLinearesSondieren =
    { 5, 7, 11, 13, 17, 19 };

    final private int[] quadratischesSondieren =
    { 11, 13 };

    final private int[] alternierendesQuadratischesSondieren =
    { 5, 7, 17, 19 };

    final private int[] doppetHashing =
    { 5, 7, 11, 13, 17 };

    private JComboBox<Integer> versArrayLaenge;

    public ComboHashHandler(JComboBox<Integer> versArryLaenge)
    {
        // TODO Auto-generated constructor stub
        this.versArrayLaenge = versArryLaenge;
        fillBox(linearesSondieren);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JComboBox<String> cb = (JComboBox<String>) e.getSource();
        int index = cb.getSelectedIndex();
        switch (index)
        {
            case 0:
                fillBox(linearesSondieren);
                break;
            case 1:
                fillBox(verallgLinearesSondieren);
                break;
            case 2:
                fillBox(quadratischesSondieren);
                break;
            case 3:
                fillBox(alternierendesQuadratischesSondieren);
                break;
            case 4:
                fillBox(doppetHashing);
                break;

            default:
                break;
        }

    }

    private void fillBox(int[] fi)
    {
        versArrayLaenge.removeAllItems();
        for (int wert : fi)
        {
            versArrayLaenge.addItem(wert);
        }
        versArrayLaenge.setEnabled(true);
    }

}
