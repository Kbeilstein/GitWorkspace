package teamprojekt.control;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import teamprojekt.view.ControlButtonsView;

public class ControlButtonsListener implements MouseInputListener
{
    private ControlButtonsView button;

    public ControlButtonsListener(ControlButtonsView b)
    {
        this.button = b;
    }

    public void mouseClicked(MouseEvent e)
    {
        // Clicked Back-Button
        if (isBack(e))
        {
            System.out.println("Back");
        }
        // Clicked Play-Button
        else if (isPlay(e))
        {
            System.out.println("Play/Stop");
            button.setPlayOrStop();
        }

        // Clicked Next-Button
        else if (isNext(e))
        {
            System.out.println("Next");
        }
        else
        {
            System.out.println("nein");
        }

    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
        button.setBackColorButtonOff();
        button.setPlayColorButtonOff();
        button.setNextColorButtonOff();
    }

    public void mousePressed(MouseEvent e)
    {
    }

    public void mouseReleased(MouseEvent e)
    {
    }

    public void mouseDragged(MouseEvent e)
    {
        // Clicked Back-Button Color
        if (isBack(e))
        {

            button.setBackColorButtonOn();

        }
        // Clicked Play-Button Color
        else if (isPlay(e))
        {
            button.setPlayColorButtonOn();
        }

        // Clicked Next-Button Color
        else if (isNext(e))
        {
            button.setNextColorButtonOn();
        }
        // Set Buttons OFF
        else
        {
            button.setBackColorButtonOff();
            button.setPlayColorButtonOff();
            button.setNextColorButtonOff();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        // Clicked Back-Button Color
        if (isBack(e))
        {
            button.setBackColorButtonOn();
        }
        // Clicked Play-Button Color
        else if (isPlay(e))
        {
            button.setPlayColorButtonOn();
        }

        // Clicked Next-Button Color
        else if (isNext(e))
        {
            button.setNextColorButtonOn();
        }
        // Set Buttons OFF
        else
        {
            button.setBackColorButtonOff();
            button.setPlayColorButtonOff();
            button.setNextColorButtonOff();
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
