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

    // / h(k) = k mod m
    // h'(k) = 1 + k mod (m-2)
    // h(k), h(k)-h(k), h(k)-2*h(k), ... , h(k)-(m-1)*h(k)
    @Override
    public void add(int wert)
    {
        // Kollisionsbehandlung wird nur durchgefuehrt, wenn das Array noch
        // freie Plaetze enthaelt
        if (!isFull())
        {
            // Anfangsposition des Hashwertes
            int arrayPosition = wert % (arrayLaenge);
            // Variablen um bei Kollision die Hashfunktion weiter zu zaehlen
            int i = 1;

            // noch unbelegte Arraypositionen sind mit dem int Wert 0
            // gekennzeichnet
            // while Schleife wird nur bei Kollisionen durchlaufen
            while (arrayModel.getArray()[arrayPosition] != 0 && i < arrayLaenge)
            {
                logView.write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> Doppel-Hashing " + arrayPosition + " - " + i + " * (1 + " + wert + " mod " + (arrayLaenge - 2) + ")");
                // Loesung um ein "-" bei modulo abzufangen
                // (a % b + b) % b
                arrayPosition = (((wert % arrayLaenge) - i * (1 + wert % (arrayLaenge - 2))) % arrayLaenge + arrayLaenge) % arrayLaenge;
                i++;
            }

            // falls das Sondieren bei einem nicht vollen Array keinen leeren
            // Platz findet
            if (i < arrayLaenge)
            {
                insArrayEintragen(arrayPosition, wert);
            }
            else
            {
                logView.write("FEHLER - Wert kann nicht eingefügt werden");
            }
        }
        else
        {
            // Ausgabe in die LogView bei vollem Array
            logView.write("Array voll");
        }
    }

    @Override
    public int search(int wert)
    {
        return 0;
    }

    @Override
    public void delete(int wert)
    {
        // TODO Auto-generated method stub

    }
}
