package teamprojekt.control;

import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.event.MouseInputListener;

import teamprojekt.view.PseudoCodeButtonView;
import teamprojekt.view.PseudoCodeView;

public class PseudoCodeButtonListener implements MouseInputListener
{
    private PseudoCodeButtonView psCoButton;
    
    private JComboBox<String> cbVerfahren;

    private boolean pseudoCodeClicked;
    
    public PseudoCodeButtonListener(PseudoCodeButtonView b, JComboBox<String> cbVerfahren)
    {
        this.psCoButton = b;
        this.cbVerfahren = cbVerfahren;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        new PseudoCodeView(cbVerfahren);
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (isPseudoCode(e))
        {
            pseudoCodeClicked = true;
            psCoButton.setPseudoButtonClicked();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        pseudoCodeClicked = false;
        mouseMoved(e);
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        psCoButton.setPseudoButtonOff();
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        if (isPseudoCode(e) && pseudoCodeClicked)
        {
            psCoButton.setPseudoButtonClicked();
        }
        else if (isPseudoCode(e))
        {
            psCoButton.setPseudoButtonOn();
        }
        else
        {
            psCoButton.setPseudoButtonOff();
        }
    }

    private boolean isPseudoCode(MouseEvent e)
    {
        return e.getX() > 1 && e.getY() > 1 && e.getX() < 126 && e.getY() < 21;
    }
}
