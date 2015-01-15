package teamprojekt.model;

public class Pair
{
    private String action;

    private int value;

    public Pair(int value, String action)
    {
        this.value = value;
        this.action = action;
    }

    public int getValue()
    {
        return value;
    }

    public String getAction()
    {
        return action;
    }

    @Override
    public String toString()
    {
        return value + " " + action;
    }
}
