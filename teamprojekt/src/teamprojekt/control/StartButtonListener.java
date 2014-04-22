package teamprojekt.control;

import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.event.MouseInputListener;

import teamprojekt.model.AlternierendesQuadrSondieren;
import teamprojekt.model.ArrayModel;
import teamprojekt.model.DoppelHashing;
import teamprojekt.model.LinearesSondieren;
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

    public StartButtonListener(JComboBox<String> cbVerfahren, SpinnerTextView textField, MainView panel, StartButtonView b)
    {
        this.cbVerfahren = cbVerfahren;
        this.arraySize = textField;
        this.panel = panel;
        this.startButton = b;
    }

    private void action()
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
                    sond = new AlternierendesQuadrSondieren(arrayModel, lv);
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
            arraySize.setText("11");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        action();
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
            action();
        }
        mouseMoved(e);
    }

    @Override
    public void mouseEntered(MouseEvent e)
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
