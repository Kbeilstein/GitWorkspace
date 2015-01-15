package teamprojekt.control;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.event.MouseInputListener;

import teamprojekt.model.AlternierendesQuadrSondieren;
import teamprojekt.model.ArrayModel;
import teamprojekt.model.DoppelHashing;
import teamprojekt.model.LinearesSondieren;
import teamprojekt.model.Pair;
import teamprojekt.model.QuadratischesSondieren;
import teamprojekt.model.Sondieren;
import teamprojekt.model.VerallgLinearesSondieren;
import teamprojekt.view.LogView;
import teamprojekt.view.MainView;
import teamprojekt.view.SpinnerTextView;
import teamprojekt.view.StartButtonView;

public class StartButtonListener implements MouseInputListener
{
    private StartButtonView startButton;

    private boolean startClicked;

    private JComboBox<String> cbVerfahren;

    private SpinnerTextView arraySize;

    private MainView panel;

    private JComboBox<Integer> constPick;

    public StartButtonListener(JComboBox<String> cbVerfahren, JComboBox<Integer> constPick, SpinnerTextView textField, MainView panel, StartButtonView b)
    {
        this.cbVerfahren = cbVerfahren;
        this.constPick = constPick;
        this.arraySize = textField;
        this.panel = panel;
        this.startButton = b;
    }

    public void action(ArrayList<Pair> sequence)
    {
        // Falls bei Log laden abgebrochen wurde soll keine neues Verfahren
        // gestartet werden, daher die zuerst die if Anweisung
        if (sequence != null)
        {
            Sondieren sond;

            LogView lv = new LogView();

            String arraySizeText = arraySize.getText();

            if (arraySizeText.isEmpty() || arraySizeText.equals("1") || arraySizeText.equals("0"))
            {
                arraySize.setText("11");
            }

            ArrayModel arrayModel = new ArrayModel(Integer.parseInt(arraySize.getText()));

            switch (cbVerfahren.getSelectedIndex())
            {
                case 0:
                    sond = new LinearesSondieren(arrayModel, lv);
                    break;
                case 1:
                    sond = new VerallgLinearesSondieren(arrayModel, lv, (int) constPick.getSelectedItem());
                    break;
                case 2:
                    sond = new QuadratischesSondieren(arrayModel, lv);
                    break;
                case 3:
                    sond = new AlternierendesQuadrSondieren(arrayModel, lv);
                    break;
                case 4:
                    sond = new DoppelHashing(arrayModel, lv);
                    break;
                default:
                    sond = new LinearesSondieren(arrayModel, lv);
            }

            sond.setArrayList(sequence);
            panel.fill(arrayModel, lv, sond);
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (isStart(e))
        {
            startClicked = true;
            startButton.setStartButtonClicked();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        startClicked = false;
        if (isStart(e))
        {
            action(new ArrayList<Pair>());
        }
        mouseMoved(e);
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        startButton.setStartButtonOff();
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        if (isStart(e) && startClicked)
        {
            startButton.setStartButtonClicked();
        }
        else if (isStart(e))
        {
            startButton.setStartButtonOn();
        }
        else
        {
            startButton.setStartButtonOff();
        }
    }

    private boolean isStart(MouseEvent e)
    {
        return e.getX() > 1 && e.getY() > 1 && e.getX() < 93 && e.getY() < 29;
    }
}
