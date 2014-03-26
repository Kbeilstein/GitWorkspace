package teamprojekt.control;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import teamprojekt.view.ArrayView;

public class ArrayViewListener implements ChangeListener
{
    private ArrayView aView;

    public ArrayViewListener(ArrayView aView)
    {
        this.aView = aView;
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        String eventText = (String) e.getSource();
        // beim hinzuf�gen wird als erstes das aktuelle Feld "gepr�ft"
        if (eventText.equals("insert"))
        {
            aView.animationInsert();
        }
        // startet die Animation des Wertes unterhalb des Arrays
        else if (eventText.equals("animationInsert"))
        {
            aView.startAnimation("insert");
        }
        else if (eventText.equals("animationSearch"))
        {
            aView.startAnimation("search");
        }
        else if (eventText.equals("search"))
        {
            aView.animationSearch();
        }
        // Wert wurde eingef�gt, alle Animationen werden "gestoppt" und die
        // Werte zur Animationssteuerung zur�ckgesetzt
        else
        {
            aView.animationSetPaintAnimationDone();
        }

        aView.repaint();
    }
}
