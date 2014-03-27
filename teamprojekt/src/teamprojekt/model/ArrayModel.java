package teamprojekt.model;

import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ArrayModel
{
    private int[] array;

    private int startIndex;

    private int endIndex;

    private int value;

    private ArrayList<ChangeListener> listeners;

    private Thread animThread;

    private boolean isInsertPossible;

    private boolean valueFound;

    private StartNextThread snThread;

    public ArrayModel(int length)
    {
        array = new int[length];
        listeners = new ArrayList<>();
    }

    // public void printArray()
    // {
    // for (int wert : array)
    // {
    // System.out.print(wert + " ");
    // }
    // System.out.println();
    // }

    public int[] getArray()
    {
        return array;
    }

    public int getLength()
    {
        return array.length;
    }

    public void setValueAt(int index, int val)
    {
        array[index] = val;
        fireAll("inserted");
    }

    public void delete(int index)
    {
        array[index] = -1;
        fireAll("deleted");
    }

    public void addListener(ChangeListener l)
    {
        listeners.add(l);
    }

    private void fireAll(String event)
    {
        for (ChangeListener listener : listeners)
        {
            listener.stateChanged(new ChangeEvent(event));
        }
    }

    public void setValues(int start, int end, int val, boolean insertPos)
    {
        startIndex = start;
        endIndex = end;
        value = val;
        isInsertPossible = insertPos;        
        if (end == start)
        {
            fireAll("insert");
        }        
        else
        {
            fireAll("animationInsert");
        }
    }

    public void setValuesSearch(int start, int end, int val, boolean found)
    {
        startIndex = start;
        endIndex = end;
        value = val;
        valueFound = found;
        if (end == start)
        {
            fireAll("search");
        }
        else
        {
            fireAll("animationSearch");
        }
    }

    public void valueFound()
    {
        fireAll("found");
    }

    public void valueNotFound()
    {
        fireAll("not found");
    }

    public void setThread(Thread thread)
    {
        animThread = thread;
    }

    public synchronized Thread getThread()
    {
        return animThread;
    }

    public int getValue()
    {
        return value;
    }

    public int getStart()
    {
        return startIndex;
    }

    public int getEnd()
    {
        return endIndex;
    }

    public boolean getInsertPossible()
    {
        return isInsertPossible;
    }

    public boolean getValueFound()
    {
        return valueFound;
    }

    public int getValueAt(int index)
    {
        int dummy = 100;
        if (index < array.length)
        {
            dummy = array[index];
        }
        return dummy;
    }

    public boolean isAvailable(int val)
    {
        boolean dummy = false;
        for (int arrayVal : array)
        {
            if (arrayVal == val)
            {
                dummy = true;
                break;
            }
        }
        return dummy;
    }

    public void setAutoAnimationThread(StartNextThread autoAnimationThread)
    {
        snThread = autoAnimationThread;
    }

    public StartNextThread getAutoAnimationThread()
    {
        return snThread;
    }
}
