package teamprojekt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class ComboHashListener implements ActionListener
{

    private static final int[] LINEARES_SONDIEREN =
    { 5, 7, 11, 13, 17, 19 };

    private static final int[] VERALLG_LINEARES_SONDIEREN =
    { 5, 7, 11, 13, 17, 19 };

    private static final int[] QUADRATISCHES_SONDIEREN =
    { 11, 13 };

    private static final int[] ALTERNIERENDES_QUADRATISCHES_SONDIEREN =
    { 5, 7, 17, 19 };

    private static final int[] DOPPEL_HASHING =
    { 5, 7, 11, 13, 17 };

    private JComboBox<Integer> versArrayLaenge;

    public ComboHashListener(JComboBox<Integer> versArryLaenge)
    {
        this.versArrayLaenge = versArryLaenge;
        fillBox(LINEARES_SONDIEREN);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        @SuppressWarnings("unchecked")
        JComboBox<String> cb = (JComboBox<String>) e.getSource();
        int index = cb.getSelectedIndex();
        switch (index)
        {
            case 0:
                fillBox(LINEARES_SONDIEREN);
                break;
            case 1:
                fillBox(VERALLG_LINEARES_SONDIEREN);
                break;
            case 2:
                fillBox(QUADRATISCHES_SONDIEREN);
                break;
            case 3:
                fillBox(ALTERNIERENDES_QUADRATISCHES_SONDIEREN);
                break;
            case 4:
                fillBox(DOPPEL_HASHING);
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
