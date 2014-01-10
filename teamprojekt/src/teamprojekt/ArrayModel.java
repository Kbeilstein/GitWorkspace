package teamprojekt;

public class ArrayModel
{
    private int[] array;

    public ArrayModel(int length)
    {
        array = new int[length];
        for (int i = 0; i < length; i++)
        {
            array[i] = 100;
        }
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
