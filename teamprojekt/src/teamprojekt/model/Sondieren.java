package teamprojekt.model;

import java.util.ArrayList;

import teamprojekt.control.ControlButtonsListener;
import teamprojekt.view.LogView;

public abstract class Sondieren
{

    private ArrayModel array;

    private LogView logView;

    private String insertSearchDelete;

    private ArrayList<ControlButtonsListener> listeners;

    public Sondieren(ArrayModel arrayModel, LogView logView)
    {
        this.array = arrayModel;
        this.logView = logView;
        this.listeners = new ArrayList<>();
    }

    public abstract void add(int value);

    public abstract void search(int value);

    public abstract void delete(int value);

    public abstract String getName();

    public abstract int getArrayPosition();

    public void insArrayEintragen(int arrayPosition, int value)
    {
        // Ausgabe in die LogView
        logView.added(value, arrayPosition);
        // schreiben des valuees ins Array
        array.setValueAt(arrayPosition, value);
    }

    public void deleted(int index, int value)
    {
        if (index != -1)
        {
            array.delete(index);
            logView.deleted(index, value);
        }
        else
        {
            logView.unAvailable(value);
        }
    }

    // kontrollfunktion, ob das Array noch freie Plätze enthält
    public boolean isFull()
    {
        boolean full = true;

        // das Array wird bis zum Ende durchlaufen, falls der Wert 0 oder -1
        // auftritt, welcher eine noch leere Arrayposition kennzeichnet bricht
        // die Schleife ab und full wird auf false gesetzt
        for (int value : array.getArray())
        {
            if (value == 0 || value == -1)
            {
                full = false;
                break;
            }
        }

        return full;
    }

    abstract public void nextInsertPosition();

    public void setInsertSearchDelete(String newVal)
    {
        insertSearchDelete = newVal;
    }

    public String getInsertSearchDelete()
    {
        return insertSearchDelete;
    }

    public void nextSearchPosition()
    {
        // TODO Auto-generated method stub
    }

    public void addListener(ControlButtonsListener ml)
    {
        listeners.add(ml);
    }

    public void listenerNext()
    {
        for (ControlButtonsListener listener : listeners)
        {
            listener.nextButtonClicked();
        }
    }
}
