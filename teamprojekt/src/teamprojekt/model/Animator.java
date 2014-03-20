package teamprojekt.model;

import teamprojekt.view.ArrayView;

public class Animator extends Thread
{

    private ArrayView animPanel;

    private int speed;

    public Animator(ArrayView animPanel)
    {
        this.animPanel = animPanel;
        speed = 20;
    }

    public synchronized void run()
    {
        while (!animPanel.getAnimationDone())
        {
            animPanel.animationNext();
            try
            {
                Thread.sleep(speed);
            }
            catch (InterruptedException e)
            {
                break;
            }
        }
    }

    public void setSpeed(int value)
    {
        speed = value * -1;
    }

}
