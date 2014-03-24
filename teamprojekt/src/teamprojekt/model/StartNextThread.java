package teamprojekt.model;

public class StartNextThread extends Thread
{
    private Sondieren sond;

    public StartNextThread(Sondieren sond)
    {
        this.sond = sond;
        start();
    }

    public synchronized void run()
    {
        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
        }
        sond.listenerNext();
    }
}
