package teamprojekt.model;

import teamprojekt.view.LogView;

public class AlternierendesQuadratischesSondieren extends Sondieren
{

    private ArrayModel arrayModel;

    private LogView logView;

    private int arrayLaenge;

    private static final String NAME = "alternierendes Quadratisches Sondieren";

    public AlternierendesQuadratischesSondieren(ArrayModel arrayModel, LogView logView)
    {
        super(arrayModel, logView);
        this.arrayModel = arrayModel;
        this.logView = logView;
        this.arrayLaenge = arrayModel.getLength();
    }

    // h_(2i-1)(x) = (h(x) + i^2) mod m
    // h_(2i)(x) = (h(x) - i^2) mod m
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
        // Variablen um bei Kollision die
        int i = 1;
        int j = 1;

        int[] array = arrayModel.getArray();

        // freie Arraypositionen sind mit dem int Wert 0 und -1
        // gekennzeichnet
        // falls nach so vielen Durchläufen wie der Arraylänge nichts gefunden
        // wird, wird abgebrochen und ein -1 als Kenzeichnung zurück gegeben
        while (array[arrayPosition] != 0 && i < arrayLaenge && array[arrayPosition] != wert)
        {
            // wenn i und j gleich sind, wird + gerechnet
            if (i == j)
            {
                arrayPosition = ((wert % arrayLaenge) + i * i) % arrayLaenge;
                i++;
            }
            // da nach dem + rechnen nur i erhoeht wird, wird der else Fall
            // aufgerufen und hier mit - gerechnet, und danach j erhoeht,
            // damit beim
            // naechsten Durchlauf wieder mit + gerechnet wird
            else
            {
                // Loesung um ein "-" bei modulo abzufangen
                // (a % b + b) % b
                arrayPosition = (((wert % arrayLaenge) - j * j) % arrayLaenge + arrayLaenge) % arrayLaenge;
                j++;
            }
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
        // Variablen um bei Kollision die
        int i = 1;
        int j = 1;

        int[] array = arrayModel.getArray();

        // freie Arraypositionen sind mit dem int Wert 0 und -1
        // gekennzeichnet
        // falls nach so vielen Durchläufen wie der Arraylänge nichts gefunden
        // wird, wird abgebrochen und ein -1 als Kenzeichnung zurück gegeben
        while (array[arrayPosition] != 0 && array[arrayPosition] != -1 && i < arrayLaenge)
        {
            // wenn i und j gleich sind, wird + gerechnet
            if (i == j)
            {
                logView.colQSi(wert, arrayPosition, arrayLaenge, i);
                arrayPosition = ((wert % arrayLaenge) + i * i) % arrayLaenge;
                i++;
            }
            // da nach dem + rechnen nur i erhoeht wird, wird der else Fall
            // aufgerufen und hier mit - gerechnet, und danach j erhoeht,
            // damit beim
            // naechsten Durchlauf wieder mit + gerechnet wird
            else
            {
                logView.colQSj(wert, arrayPosition, arrayLaenge, j);
                // Loesung um ein "-" bei modulo abzufangen
                // (a % b + b) % b
                arrayPosition = (((wert % arrayLaenge) - j * j) % arrayLaenge + arrayLaenge) % arrayLaenge;
                j++;
            }
        }
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
}
