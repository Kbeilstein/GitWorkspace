package teamprojekt.model;

public class StartNextThread extends Thread
{
    private Sondieren sond;

    public StartNextThread(Sondieren sond)
    {
        this.sond = sond;
        start();
    }

    @Override
    public synchronized void run()
    {
        try
        {
            sleep(500);
            if (!sond.getPlay())
            {
                wait();
            }
        }
        catch (InterruptedException e)
        {
        }
        sond.listenerNext();
    }

    public synchronized void wake()
    {
        notify();
    }
}
