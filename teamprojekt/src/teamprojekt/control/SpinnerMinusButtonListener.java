package teamprojekt.control;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import teamprojekt.view.SpinnerMinusButtonView;
import teamprojekt.view.SpinnerTextView;

public class SpinnerMinusButtonListener implements MouseInputListener
{
    private SpinnerMinusButtonView minusButton;

    private boolean minusClicked;

    private double radius = 7.5;

    private double xMittelPunkt = radius;

    private double yMittelPunkt = radius;

    private SpinnerTextView spinnerText;

    public SpinnerMinusButtonListener(SpinnerMinusButtonView decre, SpinnerTextView text)
    {
        minusButton = decre;
        spinnerText = text;
    }

    public void mouseClicked(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
        minusButton.setMinusButtonOff();
    }

    public void mousePressed(MouseEvent e)
    {
        if (isMinus(e))
        {
            minusClicked = true;
            minusButton.setMinusButtonClicked();
            int valueOfTextfield;
            if (spinnerText.getText().isEmpty())
            {
                valueOfTextfield = 5;
            }
            else
            {
                valueOfTextfield = Integer.parseInt(spinnerText.getText());
            }

            if (valueOfTextfield < 5)
            {
                spinnerText.setText("5");
            }
            else if (valueOfTextfield > 19)
            {
                spinnerText.setText("19");
            }
            else if (valueOfTextfield > 5)
            {
                valueOfTextfield--;
                spinnerText.setText("" + valueOfTextfield);
            }
        }
    }

    public void mouseReleased(MouseEvent e)
    {
        minusClicked = false;
        mouseMoved(e);
    }

    public void mouseDragged(MouseEvent e)
    {
        mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        if (isMinus(e) && minusClicked)
        {
            minusButton.setMinusButtonClicked();
        }
        else if (isMinus(e))
        {
            minusButton.setMinusButtonOn();
        }
        else
        {
            minusButton.setMinusButtonOff();
        }
    }

    private boolean isMinus(MouseEvent e)
    {
        double dx = e.getX() - xMittelPunkt;
        double dy = e.getY() - yMittelPunkt;
        return Math.sqrt(dx * dx + dy * dy) < radius;
    }
}
