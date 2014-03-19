package teamprojekt.model;

import teamprojekt.view.LogView;

public class LinearesSondieren extends Sondieren
{

    private ArrayModel arrayModel;

    private LogView logView;

    private int arrayLength;

    private int arrayPosition;

    private int i;

    private int[] array;

    private int value;

    private static final String NAME = "lineares Sondieren";

    public LinearesSondieren(ArrayModel arrayModel, LogView logView)
    {
        super(arrayModel, logView);
        this.arrayModel = arrayModel;
        this.logView = logView;
        this.arrayLength = arrayModel.getLength();
        arrayPosition = -1;
    }

    public void add(int wert)
    {
        // Kollisionsbehandlung wird nur durchgefuehrt, wenn das Array noch
        // freie Plaetze enthaelt
        value = wert;

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
            // Animation "starten"

            // Anfangsposition des Hashwertes
            arrayPosition = wert % arrayLength;
            // Wert um den "verschoben" wird
            i = 1;

            array = arrayModel.getArray();

            // nextArrayPosition();
        }
        logView.write("");
    }

    // Durchsucht das Array, ob der Wert enthalten ist und gibt den Index zurück
    // falls nicht enthalten wird -1 zurück gegeben
    @Override
    public int search(int wert)
    {
        // mit -1 initialisiert, kennzeichnet "nicht gefunden"
        int index = -1;

        // Anfangsposition des Hashwertes
        arrayPosition = wert % arrayLength;
        // Wert um den "verschoben" wird
        i = 1;

        array = arrayModel.getArray();

        // solange nicht der Wert oder ein leere Platz (mit 0 gekennzeichnet)
        // auftritt läuft die while Schleife das ganze Array einmal durch
        while (i < arrayLength && array[arrayPosition] != wert && array[arrayPosition] != 0 && array[arrayPosition] != wert)
        {
            arrayPosition = ((wert % arrayLength) + i) % arrayLength;
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

    @Override
    public String getName()
    {
        return NAME;
    }

    public int getArrayPosition()
    {
        if (arrayPosition != -1)
        {
            nextArrayPosition();
        }
        return arrayPosition;
    }

    private void nextArrayPosition()
    {
        if (array[arrayPosition] != 0 && array[arrayPosition] != -1)
        {
            logView.colLS(value, arrayPosition, arrayLength, i);
            arrayPosition = ((value % arrayLength) + i) % arrayLength;
            i++;
        }
        else
        {
            insArrayEintragen(arrayPosition, value);
            arrayPosition = -1;
        }
    }
}
