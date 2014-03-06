package teamprojekt.model;

import teamprojekt.view.LogView;

public class VerallgLinearesSondieren extends Sondieren
{

    private ArrayModel arrayModel;

    private LogView logView;

    private int arrayLaenge;

    private int c;

    private static final String name = "Verallgemeinertes Lineares Sondieren";

    public VerallgLinearesSondieren(ArrayModel arrayModel, LogView logView)
    {
        super(arrayModel, logView);
        this.arrayModel = arrayModel;
        this.logView = logView;
        this.arrayLaenge = arrayModel.getLength();
        // c anhand der Arraylänge bestimmen (muss Teilerfremd zur Arraylänge
        // sein)
        for (int dummy : new int[]
        { 3, 5, 7 })
        {
            if (arrayLaenge % dummy != 0)
            {
                c = dummy;
                break;
            }
        }
    }

    @Override
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

    @Override
    public int search(int wert)
    {
        // mit -1 initialisiert, kennzeichnet "nicht gefunden"
        int index = -1;

        // Anfangsposition des Hashwertes
        int arrayPosition = wert % (arrayLaenge);
        // Teil der Summe um die "verschoben" wird
        int i = 1;

        int[] array = arrayModel.getArray();

        // noch unbelegte Arraypositionen sind mit dem int Wert 0, gelöschte mit
        // -1
        // gekennzeichnet
        // while Schleife wird nur bei Kollisionen durchlaufen
        while (i < arrayLaenge && array[arrayPosition] != wert && array[arrayPosition] != 0 && array[arrayPosition] != wert)
        {
            arrayPosition = ((wert % arrayLaenge) + c * i) % arrayLaenge;
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
        int arrayPosition = wert % (arrayLaenge);
        // Teil der Summe um die "verschoben" wird
        int i = 1;

        int[] array = arrayModel.getArray();

        // ÄNDERN Ausgabe in Label evtl
        logView.choosenC(c);

        // noch unbelegte Arraypositionen sind mit dem int Wert 0, gelöschte mit
        // -1
        // gekennzeichnet
        // while Schleife wird nur bei Kollisionen durchlaufen
        while (array[arrayPosition] != 0 && array[arrayPosition] != -1)
        {
            logView.colErwLS(wert, arrayPosition, arrayLaenge, c, i);
            arrayPosition = ((wert % arrayLaenge) + c * i) % arrayLaenge;
            i++;
        }
        return arrayPosition;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
