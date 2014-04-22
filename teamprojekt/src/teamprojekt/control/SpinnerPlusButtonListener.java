package teamprojekt.control;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import teamprojekt.view.SpinnerPlusButtonView;
import teamprojekt.view.SpinnerTextView;

public class SpinnerPlusButtonListener implements MouseInputListener
{
    private SpinnerPlusButtonView plusButtonView;

    private boolean plusClicked;

    private double radius = 7.5;

    private double xButtonCenter = radius;

    private double yButtonCenter = radius;

    private SpinnerTextView spinnerTextView;

    public SpinnerPlusButtonListener(SpinnerPlusButtonView plusBView, SpinnerTextView text)
    {
        plusButtonView = plusBView;
        spinnerTextView = text;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        plusButtonView.setPlusButtonOff();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (isPlus(e))
        {
            plusClicked = true;
            plusButtonView.setPlusButtonClicked();
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
                valueOfTextfield = 5;
            }
            else if (valueOfTextfield > 19)
            {
                valueOfTextfield = 19;
            }
            else if (valueOfTextfield < 19)
            {
                valueOfTextfield++;
            }
            spinnerTextView.setText("" + valueOfTextfield);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        plusClicked = false;
        mouseMoved(e);
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        if (isPlus(e) && plusClicked)
        {
            plusButtonView.setPlusButtonClicked();
        }
        else if (isPlus(e))
        {
            plusButtonView.setPlusButtonOn();
        }
        else
        {
            plusButtonView.setPlusButtonOff();
        }
    }

    // Abstand von Punkt 1 zu Punkt 2 =
    // Wurzel aus (xPunkt1 - xPunkt2)^2 + (yPunkt1 - yPunkt2)^2
    private boolean isPlus(MouseEvent e)
    {
        return Math.sqrt(Math.pow((e.getX() - xButtonCenter), 2) + Math.pow(e.getY() - yButtonCenter, 2)) < radius;
    }

}
