package teamprojekt.control;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import teamprojekt.model.AnimatorThread;
import teamprojekt.model.ArrayModel;
import teamprojekt.view.AnimationSpeedSliderView;

/**
 * Klasse die auf Aenderungen des Geschwindigkeits-Slider reagiert
 * 
 * nur bei einem "click" oder dem "drag" wird auf die Eingabe reagiert
 **/

public class AnimationSpeedListener implements MouseInputListener
{
    private ArrayModel model;

    private AnimationSpeedSliderView sliderPanel;

    private int sizeX;

    // langsamste moegliche Geschwindigkeit, 30ms "sleep"
    private static final double MAX_VALUE = 30.0;

    public AnimationSpeedListener(ArrayModel model, AnimationSpeedSliderView panel)
    {
        this.model = model;
        this.sliderPanel = panel;
        refreshValue(sliderPanel.getLineX());
    }

    private void changeSpeed(int animationSpeed)
    {
        model.setSpeed(animationSpeed);
        AnimatorThread animiator = model.getThread();
        if (animiator != null && animiator.isAlive())
        {
            animiator.setSpeed();
        }
    }

    // Berechnung der Sliderposition und der sich daraus ergebenden
    // Geschwindigkeit
    private void refreshValue(int newX)
    {
        int paddingX = sliderPanel.getPaddingX();

        if (newX < paddingX)
        {
            newX = paddingX;
        }
        else if (newX > sliderPanel.getWidth() - paddingX)
        {
            newX = sliderPanel.getWidth() - paddingX;
        }

        sizeX = sliderPanel.getWidth() - paddingX * 2;
        changeSpeed((int) ((newX - paddingX) * (MAX_VALUE / sizeX)));

        sliderPanel.setLine(newX);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        refreshValue(e.getX());
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        refreshValue(e.getX());
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
    }
}
