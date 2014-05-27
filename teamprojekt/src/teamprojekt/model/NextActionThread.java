package teamprojekt.model;

public class NextActionThread extends Thread
{

    private Sondieren sond;

    public NextActionThread(Sondieren sond)
    {
        this.sond = sond;
        start();
    }

    @Override
    public void run()
    {
        try
        {
            sleep(100);
        }
        catch (InterruptedException e)
        {
        }
        sond.nextAction();
    }

}
