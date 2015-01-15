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

    private AnimatorThread animThread;

    private boolean isInsertPossible;

    private boolean valueFound;

    private StartNextThread snThread;

    private int animationSpeed;

    public ArrayModel(int length)
    {
        array = new int[length];
        listeners = new ArrayList<>();
    }

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
        // hier gab es einen Fehler beim quadratischen Sondieren, da end ==
        // start auch regulär vorkommen kann und es muss zusätzlich noch auf
        // isInsertPossible geprüft werden
        if (end == start && isInsertPossible)
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
        // hier gab es einen Fehler beim quadratischen Sondieren, da end ==
        // start auch da vorkommen kann und es muss zusätzlich noch auf found
        // geprüft werden
        if (end == start && valueFound)
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

    public void setThread(AnimatorThread thread)
    {
        animThread = thread;
    }

    public AnimatorThread getThread()
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

    public boolean exists(int val)
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

    public int getSpeed()
    {
        return animationSpeed;
    }

    public void setSpeed(int val)
    {
        animationSpeed = val;
    }
}
