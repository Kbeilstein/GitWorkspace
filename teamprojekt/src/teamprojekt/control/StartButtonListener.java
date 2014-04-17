package teamprojekt.control;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import teamprojekt.view.StartButtonView;

public class StartButtonListener implements MouseInputListener
{
    private StartButtonView startButton;

    private boolean startClicked;

    public StartButtonListener(StartButtonView b)
    {
        this.startButton = b;
    }

    public void mouseClicked(MouseEvent e)
    {
    }

    public void mousePressed(MouseEvent e)
    {
        if (isStart(e))
        {
            startClicked = true;
            startButton.setStartButtonClicked();
        }
    }

    public void mouseReleased(MouseEvent e)
    {
        startClicked = false;
        mouseMoved(e);
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
        startButton.setStartButtonOff();
    }

    public void mouseDragged(MouseEvent e)
    {
        mouseMoved(e);
    }

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
        return e.getX() > 1 && e.getY() > 1 && e.getX() < 71 && e.getY() < 21;
    }
}
