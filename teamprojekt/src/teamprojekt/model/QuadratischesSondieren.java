package teamprojekt.model;

import teamprojekt.view.ArrayView;
import teamprojekt.view.LogView;

public class QuadratischesSondieren extends Sondieren
{

    private ArrayModel arrayModel;

    private LogView logView;

    private int arrayLaenge;

    public QuadratischesSondieren(ArrayModel arrayModel, LogView logView, ArrayView aView)
    {
        super(arrayModel, logView, aView);
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
        if (!isFull())
        {
            // Anfangsposition des Hashwertes
            int arrayPosition = wert % (arrayLaenge);
            int i = 1;

            // noch unbelegte Arraypositionen sind mit dem int Wert 0
            // gekennzeichnet
            // while Schleife wird nur bei Kollisionen durchlaufen
            while (arrayModel.getArray()[arrayPosition] != 0 && i < arrayLaenge)
            {
                logView.write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> Quadratisches Sondieren " + (wert % arrayLaenge) + " + " + i + "^2");
                arrayPosition = ((wert % arrayLaenge) + (i * i)) % arrayLaenge;
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
