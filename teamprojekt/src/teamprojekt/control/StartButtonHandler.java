package teamprojekt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import teamprojekt.model.AlternierendesQuadratischesSondieren;
import teamprojekt.model.ArrayModel;
import teamprojekt.model.DoppelHashing;
import teamprojekt.model.LinearesSondieren;
import teamprojekt.model.QuadratischesSondieren;
import teamprojekt.model.Sondieren;
import teamprojekt.model.VerallgLinearesSondieren;
import teamprojekt.view.LogView;
import teamprojekt.view.MainView;

public class StartButtonHandler implements ActionListener
{
    private JComboBox<String> cbVerfahren;

    private JComboBox<?> cbArraySize;

    private MainView panel;

    public StartButtonHandler(JComboBox<String> cbVerfahren, JComboBox<Integer> cbArraySize, MainView panel)
    {
        this.cbVerfahren = cbVerfahren;
        this.cbArraySize = cbArraySize;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(cbVerfahren.getSelectedItem());
        System.out.println(cbArraySize.getSelectedItem());
        // ArrayModel array = new ArrayModel((int)
        // cbArraySize.getSelectedItem());
        Sondieren sond;

        LogView lv = new LogView();
        ArrayModel arrayModel = new ArrayModel((int) cbArraySize.getSelectedItem());

        switch (cbVerfahren.getSelectedIndex())
        {
            case 0:
                sond = new LinearesSondieren(arrayModel, lv);
                break;
            case 1:
                sond = new VerallgLinearesSondieren(arrayModel, lv);
                break;
            case 2:
                sond = new QuadratischesSondieren(arrayModel, lv);
                break;
            case 3:
                sond = new AlternierendesQuadratischesSondieren(arrayModel, lv);
                break;
            case 4:
                sond = new DoppelHashing(arrayModel, lv);
                break;
            default:
                sond = new LinearesSondieren(arrayModel, lv);
                break;
        }

        panel.fill(arrayModel, lv, sond);
    }
}
