package teamprojekt.control;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import teamprojekt.model.Sondieren;
import teamprojekt.view.ControlButtonsView;

public class ControlButtonsListener implements MouseInputListener
{
    private ControlButtonsView button;

    private boolean backClicked;

    private boolean playClicked;

    private boolean nextClicked;

    private Sondieren sond;

    public ControlButtonsListener(ControlButtonsView b, Sondieren sond)
    {
        button = b;
        this.sond = sond;
    }

    public void mouseClicked(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
        button.setBackButtonOff();
        button.setPlayButtonOff();
        button.setNextButtonOff();
    }

    public void mousePressed(MouseEvent e)
    {
        // Clicked Back-Button
        if (isBack(e))
        {
            backClicked = true;
            button.setBackButtonClicked();
        }
        // Clicked Play-Button
        else if (isPlay(e))
        {
            playClicked = true;
            button.setPlay();
            sond.setPlay();
            if (!button.getPlay())
            {
                sond.listenerNext();
            }
            else
            {
                // Thread-Pausieren
            }
            button.setPlayButtonClicked();
        }
        // Clicked Next-Button
        else if (isNext(e))
        {
            nextClicked = true;
            button.setNextButtonClicked();
            nextButtonClicked();
        }
    }

    public void nextButtonClicked()
    {
        String insertSearchDelete = sond.getInsertSearchDelete();
        if (sond.getArrayPosition() != -1 && insertSearchDelete.equals("insert"))
        {
            sond.nextInsertPosition();
        }
        else if (sond.getArrayPosition() != -1 && insertSearchDelete.equals("search"))
        {
            sond.nextSearchPosition();
        }
        else if (sond.getArrayPosition() != -1 && insertSearchDelete.equals("delete"))
        {
            sond.nextSearchPosition();
        }
    }

    public void mouseReleased(MouseEvent e)
    {
        backClicked = false;
        playClicked = false;
        nextClicked = false;
        mouseMoved(e);
    }

    public void mouseDragged(MouseEvent e)
    {
        mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        // Clicked Back-Button Color
        if (isBack(e) && backClicked)
        {
            button.setBackButtonClicked();
            button.setPlayButtonOff();
            button.setNextButtonOff();
        }
        // Clicked Play-Button Color
        else if (isPlay(e) && playClicked)
        {
            button.setPlayButtonClicked();
            button.setBackButtonOff();
            button.setNextButtonOff();
        }

        // Clicked Next-Button Color
        else if (isNext(e) && nextClicked)
        {
            button.setNextButtonClicked();
            button.setBackButtonOff();
            button.setPlayButtonOff();
        }

        // Clicked Back-Button Color
        else if (isBack(e))
        {
            button.setBackButtonOn();
            button.setPlayButtonOff();
            button.setNextButtonOff();
        }
        // Clicked Play-Button Color
        else if (isPlay(e))
        {
            button.setPlayButtonOn();
            button.setBackButtonOff();
            button.setNextButtonOff();
        }

        // Clicked Next-Button Color
        else if (isNext(e))
        {
            button.setNextButtonOn();
            button.setBackButtonOff();
            button.setPlayButtonOff();
        }
        // Set Buttons OFF
        else
        {
            button.setBackButtonOff();
            button.setPlayButtonOff();
            button.setNextButtonOff();
        }

    }

    private boolean isBack(MouseEvent e)
    {
        return (e.getX() > 0 && e.getY() > 10 && e.getX() < 43 && e.getY() < 33);
    }

    private boolean isPlay(MouseEvent e)
    {
        return e.getX() > 50 && e.getY() > 0 && e.getX() < 93 && e.getY() < 43;
    }

    private boolean isNext(MouseEvent e)
    {
        return (e.getX() > 100 && e.getY() > 10 && e.getX() < 143 && e.getY() < 33);
    }

}
