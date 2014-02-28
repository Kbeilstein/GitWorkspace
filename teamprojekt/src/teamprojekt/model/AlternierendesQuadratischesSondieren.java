package teamprojekt.model;

import teamprojekt.view.LogView;

public class AlternierendesQuadratischesSondieren extends Sondieren
{

    private ArrayModel arrayModel;

    private LogView logView;

    private int arrayLaenge;

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
        if (!isFull())
        {
            // Anfangsposition des Hashwertes
            int arrayPosition = wert % (arrayLaenge);
            // Variablen um bei Kollision die
            int i = 1;
            int j = 1;

            // noch unbelegte Arraypositionen sind mit dem int Wert 0
            // gekennzeichnet
            // while Schleife wird nur bei Kollisionen durchlaufen
            while (arrayModel.getArray()[arrayPosition] != 0 && i < arrayLaenge)
            {
                // wenn i und j gleich sind, wird + gerechnet
                if (i == j)
                {
                    logView.write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> Quadratisches Sondieren " + (wert % arrayLaenge) + " + " + i + "^2");
                    arrayPosition = ((wert % arrayLaenge) + i * i) % arrayLaenge;
                    i++;
                }
                // da nach dem + rechnen nur i erhoeht wird, wird der else Fall
                // aufgerufen und hier mit - gerechnet, und danach j erhoeht,
                // damit beim
                // naechsten Durchlauf wieder mit + gerechnet wird
                else
                {
                    logView.write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> Quadratisches Sondieren " + (wert % arrayLaenge) + " - " + j + "^2");
                    // Loesung um ein "-" bei modulo abzufangen
                    // (a % b + b) % b
                    arrayPosition = (((wert % arrayLaenge) - j * j) % arrayLaenge + arrayLaenge) % arrayLaenge;
                    j++;
                }
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
