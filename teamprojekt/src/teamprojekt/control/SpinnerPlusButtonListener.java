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

    private double xMittelPunkt = radius;

    private double yMittelPunkt = radius;

    private SpinnerTextView spinnerTextView;

    public SpinnerPlusButtonListener(SpinnerPlusButtonView plusBView, SpinnerTextView text)
    {
        plusButtonView = plusBView;
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
        plusButtonView.setPlusButtonOff();
    }

    public void mousePressed(MouseEvent e)
    {
        if (isPlus(e))
        {
            plusClicked = true;
            plusButtonView.setPlusButtonClicked();
            int valueOfTextfield;
            if (spinnerTextView.getText().isEmpty())
            {
                valueOfTextfield = 19;
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

    public void mouseReleased(MouseEvent e)
    {
        plusClicked = false;
        mouseMoved(e);
    }

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

    private boolean isPlus(MouseEvent e)
    {
        double dx = e.getX() - xMittelPunkt;
        double dy = e.getY() - yMittelPunkt;
        return (Math.sqrt(dx * dx + dy * dy)) < radius;
    }

}
