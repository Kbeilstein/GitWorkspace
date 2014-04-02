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
import teamprojekt.view.SpinnerTextView;

public class StartButtonHandler implements ActionListener
{
    private JComboBox<String> cbVerfahren;

    private SpinnerTextView arraySize;

    private MainView panel;

    public StartButtonHandler(JComboBox<String> cbVerfahren, SpinnerTextView textField, MainView panel)
    {
        this.cbVerfahren = cbVerfahren;
        this.arraySize = textField;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Sondieren sond;

        LogView lv = new LogView();

        String arraySizeText = arraySize.getText();

        if (!arraySizeText.isEmpty() && !arraySizeText.equals("1") && !arraySizeText.equals("0"))
        {
            ArrayModel arrayModel = new ArrayModel(Integer.parseInt(arraySizeText));

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
        else
        {
            System.out.println("ungültge Eingabe");
        }
    }
}
