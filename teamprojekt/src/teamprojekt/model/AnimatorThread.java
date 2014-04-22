package teamprojekt.model;

import teamprojekt.view.ArrayView;

public class AnimatorThread extends Thread
{

    private ArrayView animPanel;

    private int speed;

    private boolean wait;

    private ArrayModel model;

    public AnimatorThread(ArrayView animPanel, ArrayModel model)
    {
        this.animPanel = animPanel;
        this.model = model;
        setSpeed();
    }

    @Override
    public synchronized void run()
    {
        while (!animPanel.getAnimationDone())
        {
            try
            {
                if (wait && !animPanel.getPlay())
                {
                    wait();
                }
                Thread.sleep(speed);
            }
            catch (InterruptedException e)
            {
                animPanel.animationToEnd();
                break;
            }
            animPanel.animationNext();
        }
        animPanel.startNext();
    }

    public void setSpeed()
    {
        speed = model.getSpeed();
    }

    public void setWait()
    {
        wait = true;
    }

    public synchronized void wake()
    {
        wait = false;
        notify();
    }

    public boolean getWait()
    {
        return wait;
    }
}
