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
        
        int[] array = arrayModel.getArray();

        // solange nicht der Wert oder ein leere Platz (mit 0 gekennzeichnet)
        // auftritt läuft die while Schleife das ganze Array einmal durch
        while (i < arrayLaenge && array[arrayPosition] != wert && array[arrayPosition] != 0)
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

        // noch unbelegte Arraypositionen sind mit dem int Wert 0
        // gekennzeichnet
        // while Schleife wird nur bei Kollisionen durchlaufen
        while (array[arrayPosition] != 0 && array[arrayPosition] != -1 )
        {
            logView.write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> Lineares Sondieren " + (wert % arrayLaenge) + " + " + i);
            arrayPosition = ((wert % arrayLaenge) + i) % arrayLaenge;
            System.out.println("endlos");
            i++;
        }
        return arrayPosition;
    }
}
