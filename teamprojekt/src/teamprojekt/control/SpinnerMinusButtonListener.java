package teamprojekt.control;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import teamprojekt.view.SpinnerMinusButtonView;
import teamprojekt.view.SpinnerTextView;

public class SpinnerMinusButtonListener implements MouseInputListener
{
    private SpinnerMinusButtonView minusButtonView;

    private boolean minusClicked;

    private double radius = 7.5;

    private double xButtonCenter = radius;

    private double yButtonCenter = radius;

    private SpinnerTextView spinnerTextView;

    public SpinnerMinusButtonListener(SpinnerMinusButtonView decre, SpinnerTextView text)
    {
        minusButtonView = decre;
        spinnerTextView = text;
    }

    public void mouseClicked(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
        minusButtonView.setMinusButtonOff();
    }

    public void mousePressed(MouseEvent e)
    {
        if (isMinus(e))
        {
            minusClicked = true;
            minusButtonView.setMinusButtonClicked();
            int valueOfTextfield;
            // Falls das Textfeld leer ist, setze den Wert auf 11 beende die
            // Methode
            if (spinnerTextView.getText().isEmpty())
            {
                spinnerTextView.setText("11");
                return;
            }
            else
            {
                valueOfTextfield = Integer.parseInt(spinnerTextView.getText());
            }

            if (valueOfTextfield < 5)
            {
                spinnerTextView.setText("5");
            }
            else if (valueOfTextfield > 19)
            {
                spinnerTextView.setText("19");
            }
            else if (valueOfTextfield > 5)
            {
                valueOfTextfield--;
                spinnerTextView.setText("" + valueOfTextfield);
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
            minusButtonView.setMinusButtonClicked();
        }
        else if (isMinus(e))
        {
            minusButtonView.setMinusButtonOn();
        }
        else
        {
            minusButtonView.setMinusButtonOff();
        }
    }

    // Abstand von Punkt 1 zu Punkt 2 =
    // Wurzel aus (xPunkt1 - xPunkt2)^2 + (yPunkt1 - yPunkt2)^2
    private boolean isMinus(MouseEvent e)
    {
        return Math.sqrt(Math.pow((e.getX() - xButtonCenter), 2) + Math.pow(e.getY() - yButtonCenter, 2)) < radius;
    }
}
