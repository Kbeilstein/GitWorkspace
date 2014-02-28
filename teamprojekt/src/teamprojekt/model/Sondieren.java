package teamprojekt.model;

import teamprojekt.view.ArrayView;
import teamprojekt.view.LogView;

public abstract class Sondieren
{

    private int[] array;

    private LogView logView;

    private ArrayView aView;

    public Sondieren(ArrayModel arrayModel, LogView logView, ArrayView aView)
    {
        this.array = arrayModel.getArray();
        this.logView = logView;
        this.aView = aView;
    }

    public abstract void add(int wert);

    public abstract int search(int wert);

    public abstract void delete(int wert);

    protected void insArrayEintragen(int arrayPosition, int wert)
    {
        // Ausgabe in die LogView
        logView.write(wert + " an Stelle " + arrayPosition + " vom Feld geschrieben");
        // schreiben des Wertes ins Array
        array[arrayPosition] = wert;
        // Array muss neu gezeichnet werden
        aView.changed();
    }

    // Ausgabe des Array in die Konsole
    public void printArray()
    {
        // Array wird durchlaufen und die int-Werte in die Konsole ausgegeben
        for (int wert : array)
        {
            System.out.print(wert + " ");
        }
        System.out.println();
    }

    // kontrollfunktion, ob das Array noch freie Plätze enthält
    public boolean isFull()
    {
        boolean full = false;

        // das Array wird durchlaufen bis zum Ende und full auf "true" gesetzt
        // oder der Wert 0 auftritt, welcher ein noch leere Arrayposition
        // kennzeichnet
        for (int wert : array)
        {
            if (wert == 0 || wert == -1)
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
