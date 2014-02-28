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
        aView.repaint();
    }
}
