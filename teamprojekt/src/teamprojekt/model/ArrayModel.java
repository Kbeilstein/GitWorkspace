package teamprojekt.model;

import java.util.ArrayList;

import javax.swing.event.ChangeListener;

public class ArrayModel
{
    private int[] array;

    private ArrayList<ChangeListener> listeners;

    public ArrayModel(int length)
    {
        array = new int[length];
        listeners = new ArrayList<>();
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

    public int getLength()
    {
        return array.length;
    }

    public void setValueAt(int index, int value)
    {
        array[index] = value;
        fireAll();
    }

    public void delete(int index)
    {
        array[index] = -1;
        fireAll();
    }

    public void addListener(ChangeListener l)
    {
        listeners.add(l);
    }

    private void fireAll()
    {
        for (ChangeListener listener : listeners)
        {
            listener.stateChanged(null);
        }
    }
}
