package teamprojekt.model;

import teamprojekt.view.ArrayView;
import teamprojekt.view.LogView;

public class LinearesSondieren extends Sondieren
{

    private ArrayModel arrayModel;

    private LogView logView;

    private int arrayLaenge;

    public LinearesSondieren(ArrayModel arrayModel, LogView logView, ArrayView aView)
    {
        super(arrayModel, logView, aView);
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
            logView.write("Array voll");
        }
        else if (search(wert) != -1)
        {
            logView.write(wert + " schon im Array vorhanden");
        }
        else
        {
            insArrayEintragen(getAddPosition(wert), wert);
        }
        logView.write("");
    }

    // Durchsucht das Array, ob der Wert enthalten ist und gibt den Index zurück
    // falls nicht enthalten wird -1 zurück gegeben
    @Override
    public int search(int wert)
    {
        int index = -1;

        // Anfangsposition des Hashwertes
        int arrayPosition = wert % arrayLaenge;
        // Wert um den "verschoben" wird
        int i = 1;

        // solange nicht der Wert oder ein leere Platz (mit 0 gekennzeichnet)
        // auftritt läuft die while Schleife das ganze Array einmal durch
        while (i < arrayLaenge && arrayModel.getArray()[arrayPosition] != wert && arrayModel.getArray()[arrayPosition] != 0)
        {
            arrayPosition = ((wert % arrayLaenge) + i) % arrayLaenge;
            i++;
        }
        if (arrayModel.getArray()[arrayPosition] == wert)
        {
            index = arrayPosition;
        }
        return index;
    }

    @Override
    public void delete(int wert)
    {
        // TODO Auto-generated method stub

    }

    private int getAddPosition(int wert)
    {
        // Anfangsposition des Hashwertes
        int arrayPosition = wert % arrayLaenge;
        // Wert um den "verschoben" wird
        int i = 1;

        // noch unbelegte Arraypositionen sind mit dem int Wert 0
        // gekennzeichnet
        // while Schleife wird nur bei Kollisionen durchlaufen
        while (arrayModel.getArray()[arrayPosition] != 0)
        {
            logView.write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> Lineares Sondieren " + (wert % arrayLaenge) + " + " + i);
            arrayPosition = ((wert % arrayLaenge) + i) % arrayLaenge;
            i++;
        }
        return arrayPosition;
    }
}
