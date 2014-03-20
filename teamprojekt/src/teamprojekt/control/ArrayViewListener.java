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
        if (eventText.equals("insert"))
        {
            aView.animationInsert();
        }
        else if (eventText.equals("inserted"))
        {
            aView.animationDone();
        }
        else if (eventText.equals("deleted"))
        {
        }
        else if (eventText.equals("animation"))
        {
            aView.startAnimation();
        }
        aView.repaint();
    }
}
