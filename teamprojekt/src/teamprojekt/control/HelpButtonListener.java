package teamprojekt.control;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;

import teamprojekt.view.HelpButtonView;
import teamprojekt.view.LayoutConfigView;

public class HelpButtonListener implements MouseInputListener
{
    private HelpButtonView helpButton;

    private boolean helpClicked;

    public HelpButtonListener(HelpButtonView b)
    {
        this.helpButton = b;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (isHelpButton(e))
        {
            // die LayoutConfigView ermitteln und dort die Methode zum
            // Hilfefenster oeffnen ausfuehren
            LayoutConfigView topFrame = (LayoutConfigView) SwingUtilities.getWindowAncestor(helpButton);
            topFrame.openHelpFrame();
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (isHelpButton(e))
        {
            helpClicked = true;
            helpButton.setPseudoButtonClicked();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        helpClicked = false;
        mouseMoved(e);
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        helpButton.setPseudoButtonOff();
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        if (isHelpButton(e) && helpClicked)
        {
            helpButton.setPseudoButtonClicked();
        }
        else if (isHelpButton(e))
        {
            helpButton.setPseudoButtonOn();
        }
        else
        {
            helpButton.setPseudoButtonOff();
        }
    }

    private boolean isHelpButton(MouseEvent e)
    {
        return e.getX() > 1 && e.getY() > 1 && e.getX() < 126 && e.getY() < 21;
    }
}
