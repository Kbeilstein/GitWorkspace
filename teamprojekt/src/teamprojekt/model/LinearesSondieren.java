package teamprojekt.model;

import teamprojekt.view.LogView;

public class LinearesSondieren extends Sondieren
{

    private ArrayModel arrayModel;

    private LogView logView;

    private int arrayLaenge;

    public LinearesSondieren(ArrayModel arrayModel, LogView logView)
    {
        super(arrayModel, logView);
        this.arrayModel = arrayModel;
        this.logView = logView;
        this.arrayLaenge = arrayModel.getLength();
    }

    public void add(int wert)
    {
        // Kollisionsbehandlung wird nur durchgefuehrt, wenn das Array noch
        // freie Plaetze enthaelt
        if (isFull())
        {
            logView.full();
        }
        else if (search(wert) != -1)
        {
            logView.available(wert);
        }
        else
        {
            insArrayEintragen(getAddPosition(wert), wert);
        }
        logView.write("");
    }

    // Durchsucht das Array, ob der Wert enthalten ist und gibt den Index zur�ck
    // falls nicht enthalten wird -1 zur�ck gegeben
    @Override
    public int search(int wert)
    {
        // mit -1 initialisiert, kennzeichnet "nicht gefunden"
        int index = -1;

        // Anfangsposition des Hashwertes
        int arrayPosition = wert % arrayLaenge;
        // Wert um den "verschoben" wird
        int i = 1;

        int[] array = arrayModel.getArray();

        // solange nicht der Wert oder ein leere Platz (mit 0 gekennzeichnet)
        // auftritt l�uft die while Schleife das ganze Array einmal durch
        while (i < arrayLaenge && array[arrayPosition] != wert && array[arrayPosition] != 0 && array[arrayPosition] != wert)
        {
            arrayPosition = ((wert % arrayLaenge) + i) % arrayLaenge;
            i++;
        }

        if (array[arrayPosition] == wert)
        {
            index = arrayPosition;
        }
        return index;
    }

    @Override
    public void delete(int wert)
    {
        deleted(search(wert), wert);
    }

    private int getAddPosition(int wert)
    {
        // Anfangsposition des Hashwertes
        int arrayPosition = wert % arrayLaenge;
        // Wert um den "verschoben" wird
        int i = 1;

        int[] array = arrayModel.getArray();

        // freie Arraypositionen sind mit dem int Wert 0 und -1
        // gekennzeichnet
        while (array[arrayPosition] != 0 && array[arrayPosition] != -1)
        {
            logView.colLS(wert, arrayPosition, arrayLaenge, i);
            arrayPosition = ((wert % arrayLaenge) + i) % arrayLaenge;
            i++;
        }
        return arrayPosition;
    }
}