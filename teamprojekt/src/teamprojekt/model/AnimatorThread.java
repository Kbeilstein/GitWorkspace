package teamprojekt.model;

import teamprojekt.view.ArrayView;

public class AnimatorThread extends Thread
{

    private ArrayView animPanel;

    private int speed;

    public AnimatorThread(ArrayView animPanel)
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
        animPanel.startNext();
    }

    public void setSpeed(int value)
    {
        speed = value * -1;
    }

}
