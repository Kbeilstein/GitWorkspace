package teamprojekt.model;

import teamprojekt.view.LogView;

public class QuadratischesSondieren extends Sondieren
{

    private ArrayModel arrayModel;

    private LogView logView;

    private int arrayLaenge;

    private static final String NAME = "Quadratisches Sondieren";

    public QuadratischesSondieren(ArrayModel arrayModel, LogView logView)
    {
        super(arrayModel, logView);
        this.arrayModel = arrayModel;
        this.logView = logView;
        this.arrayLaenge = arrayModel.getLength();
    }

    // h_i(x) = (h(x) + i^2) mod m
    @Override
    public void add(int wert)
    {
        // Kollisionsbehandlung wird nur durchgefuehrt, wenn das Array noch
        // freie Plaetze enthaelt
        if (isFull())
        {
            logView.full();
        }
        else if (arrayModel.isAvailable(wert))
        {
            logView.available(wert);
        }
        else
        {
            int addPosition = getAddPosition(wert);

            if (addPosition != -1)
            {
                insArrayEintragen(getAddPosition(wert), wert);
            }
            else
            {
                logView.error();
            }
        }
        logView.write("");
    }

    @Override
    public void search(int wert)
    {
        // mit -1 initialisiert, kennzeichnet "nicht gefunden"
        int index = -1;

        // Anfangsposition des Hashwertes
        int arrayPosition = wert % (arrayLaenge);
        // Wert um den "verschoben" wird
        int i = 1;

        int[] array = arrayModel.getArray();

        // freie Arraypositionen sind mit dem int Wert 0 und -1
        // gekennzeichnet
        // falls nach so vielen Durchläufen wie der Arraylänge nichts gefunden
        // wird, wird abgebrochen und ein -1 als Kenzeichnung zurück gegeben
        while (array[arrayPosition] != 0 && i < arrayLaenge && array[arrayPosition] != wert)
        {
            arrayPosition = ((wert % arrayLaenge) + (i * i)) % arrayLaenge;
            i++;
        }

        if (array[arrayPosition] == wert)
        {
            index = arrayPosition;
        }
    }

    @Override
    public void delete(int wert)
    {
        // deleted(search(wert), wert);
    }

    private int getAddPosition(int wert)
    {
        // Anfangsposition des Hashwertes
        int arrayPosition = wert % (arrayLaenge);
        // Wert um den "verschoben" wird
        int i = 1;

        int[] array = arrayModel.getArray();

        // freie Arraypositionen sind mit dem int Wert 0 und -1
        // gekennzeichnet
        // falls nach so vielen Durchläufen wie der Arraylänge nichts gefunden
        // wird, wird abgebrochen und ein -1 als Kenzeichnung zurück gegeben
        while (array[arrayPosition] != 0 && array[arrayPosition] != -1 && i < arrayLaenge)
        {
            logView.colQSi(wert, arrayPosition, arrayLaenge, i);
            arrayPosition = ((wert % arrayLaenge) + (i * i)) % arrayLaenge;
            i++;
        }

        // falls das Sondieren bei einem nicht vollen Array keinen leeren
        // Platz findet
        if (i >= arrayLaenge)
        {
            arrayPosition = -1;
        }
        return arrayPosition;
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    @Override
    public int getArrayPosition()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void nextInsertPosition()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void nextSearchPosition()
    {
        // TODO Auto-generated method stub

    }
}
