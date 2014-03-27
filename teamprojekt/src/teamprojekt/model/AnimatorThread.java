package teamprojekt.model;

import teamprojekt.view.ArrayView;

public class AnimatorThread extends Thread
{

    private ArrayView animPanel;

    private int speed;

    private boolean wait;

    public AnimatorThread(ArrayView animPanel)
    {
        this.animPanel = animPanel;
        speed = 20;
    }

    public synchronized void run()
    {
        while (!animPanel.getAnimationDone())
        {
            try
            {
                if (wait && !animPanel.getPlay())
                {
                    System.out.println("thread wartet");
                    wait();
                    System.out.println("thread fertig gewartet");
                }
                Thread.sleep(speed);
            }
            catch (InterruptedException e)
            {
                System.out.println("thread interrupted");
                animPanel.animationToEnd();
                break;
            }
            animPanel.animationNext();
        }
        animPanel.startNext();
    }

    public void setSpeed(int value)
    {
        speed = value * -1;
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
