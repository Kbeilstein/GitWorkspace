package teamprojekt.model;

import teamprojekt.view.LogView;

public abstract class Sondieren
{

    private ArrayModel array;

    private LogView logView;

    public Sondieren(ArrayModel arrayModel, LogView logView)
    {
        this.array = arrayModel;
        this.logView = logView;
    }

    public abstract void add(int value);

    public abstract int search(int value);

    public abstract void delete(int value);

    public abstract String getName();

    protected void insArrayEintragen(int arrayPosition, int value)
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
        logView.write("");
    }

    // kontrollfunktion, ob das Array noch freie Plätze enthält
    public boolean isFull()
    {
        boolean full = false;

        // das Array wird durchlaufen bis zum Ende und full auf "true" gesetzt
        // oder der value 0 auftritt, welcher ein noch leere Arrayposition
        // kennzeichnet
        for (int value : array.getArray())
        {
            if (value == 0 || value == -1)
            {
                full = false;
                break;
            }
            else
            {
                full = true;
            }
        }

        return full;
    }
}
