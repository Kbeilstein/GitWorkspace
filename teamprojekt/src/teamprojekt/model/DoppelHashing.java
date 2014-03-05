package teamprojekt.model;

import teamprojekt.view.LogView;

public class DoppelHashing extends Sondieren
{

    private ArrayModel arrayModel;

    private LogView logView;

    private int arrayLaenge;

    public DoppelHashing(ArrayModel arrayModel, LogView logView)
    {
        super(arrayModel, logView);
        this.arrayModel = arrayModel;
        this.logView = logView;
        this.arrayLaenge = arrayModel.getLength();
    }

    // h(k) = k mod m
    // h'(k) = 1 + k mod (m-2)
    // h(k), h(k)-h(k), h(k)-2*h(k), ... , h(k)-(m-1)*h(k)
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
    public int search(int wert)
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
            // Loesung um ein "-" bei modulo abzufangen
            // (a % b + b) % b
            arrayPosition = (((wert % arrayLaenge) - i * (1 + wert % (arrayLaenge - 2))) % arrayLaenge + arrayLaenge) % arrayLaenge;
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
        // Variablen um bei Kollision die Hashfunktion weiter zu zaehlen
        int i = 1;

        int[] array = arrayModel.getArray();

        // noch unbelegte Arraypositionen sind mit dem int Wert 0
        // gekennzeichnet
        // while Schleife wird nur bei Kollisionen durchlaufen
        while (array[arrayPosition] != 0 && array[arrayPosition] != -1 && i < arrayLaenge)
        {
            logView.colDH(wert, arrayPosition, arrayLaenge, i);            
            // Loesung um ein "-" bei modulo abzufangen
            // (a % b + b) % b
            arrayPosition = (((wert % arrayLaenge) - i * (1 + wert % (arrayLaenge - 2))) % arrayLaenge + arrayLaenge) % arrayLaenge;
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
}
