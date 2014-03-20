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

    public abstract int getArrayPosition();

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

    public void nextArrayPosition()
    {
        // TODO Auto-generated method stub
        
    }
}
