package teamprojekt.model;

public class ArrayModel
{
    private int[] array;

    public ArrayModel(int length)
    {
        array = new int[length];
    }

    public void printArray()
    {
        for (int wert : array)
        {
            System.out.print(wert + " ");
        }
        System.out.println();
    }

    public int[] getArray()
    {
        return array;
    }
}
