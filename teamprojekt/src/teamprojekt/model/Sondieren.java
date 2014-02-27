package teamprojekt.model;

import teamprojekt.view.ArrayView;
import teamprojekt.view.LogView;

public class Sondieren
{
    private int[] array;

    private LogView logView;

    private ArrayView aView;

    public Sondieren(ArrayModel arrayModel, LogView logView, ArrayView aView)
    {
        this.array = arrayModel.getArray();
        this.logView = logView;
        this.aView = aView;
    }

    public void linearesSondieren(int wert)
    {
        // Kollisionsbehandlung wird nur durchgefuehrt, wenn das Array noch
        // freie Plaetze enthaelt
        if (!isFull())
        {
            // Anfangsposition des Hashwertes
            int arrayPosition = wert % array.length;
            // Wert um den "verschoben" wird
            int i = 1;

            // noch unbelegte Arraypositionen sind mit dem int Wert 100
            // gekennzeichnet
            while (array[arrayPosition] != 100)
            {
                logView.write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> Lineares Sondieren " + (wert % array.length) + " + " + i);
                arrayPosition = ((wert % array.length) + i) % array.length;
                i++;
            }
            logView.write(wert + " auf Feldposition " + arrayPosition + " vom Feld geschrieben");
            // schreiben des Wertes ins Array
            array[arrayPosition] = wert;
        }
        else
        {
            logView.write("Array voll");
        }
        aView.changed();
    }

    public void verallgLinearesSondieren(int wert)
    {
        // Kollisionsbehandlung wird nur durchgefuehrt, wenn das Array noch
        // freie Plaetze enthaelt
        if (!isFull())
        {
            // Anfangsposition des Hashwertes
            int arrayPosition = wert % (array.length);
            // Teil der Summe um die "verschoben" wird
            int i = 1;

            // c und m muessen teilerfremd sein, daher wird ein c gewaehlt, das
            // bis Arraylaenge 17 auf jeden Fall diese Eigenschaft erfuellt
            int c;
            // gilt fuer m = 5, 7, 8, 10, 11, 13, 14, 16
            if (array.length % 3 != 0)
            {
                c = 3;
            }
            // gilt fuer m = 6, 9, 12, 17
            else if (array.length % 5 != 0)
            {
                c = 5;
            }
            // gilt fuer m = 15
            else
            {
                c = 7;
            }

            logView.write("Fuer c wird " + c + " gewaehlt");

            // noch unbelegte Arraypositionen sind mit dem int Wert 100
            // gekennzeichnet
            while (array[arrayPosition] != 100)
            {
                logView.write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> erw. Lineares Sondieren " + (wert % array.length) + " + " + c + " * " + i);
                arrayPosition = ((wert % array.length) + c * i) % array.length;
                i++;
            }
            logView.write(wert + " an Stelle " + arrayPosition + " vom Feld geschrieben");
            // schreiben des Wertes ins Array
            array[arrayPosition] = wert;
        }
        else
        {
            logView.write("Array voll");
        }
        aView.changed();
    }

    // h_i(x) = (h(x) + i^2) mod m
    public void quadratischesSondieren(int wert)
    {
        // Kollisionsbehandlung wird nur durchgefuehrt, wenn das Array noch
        // freie Plaetze enthaelt
        if (!isFull())
        {
            // Anfangsposition des Hashwertes
            int arrayPosition = wert % (array.length);
            int i = 1;

            // noch unbelegte Arraypositionen sind mit dem int Wert 100
            // gekennzeichnet
            while (array[arrayPosition] != 100)
            {
                logView.write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> Quadratisches Sondieren " + (wert % array.length) + " + " + i + "^2");
                arrayPosition = ((wert % array.length) + i * i) % array.length;
                i++;
                System.out.println(i);
            }
            logView.write(wert + " an Stelle " + arrayPosition + " vom Feld geschrieben");
            // schreiben des Wertes ins Array
            array[arrayPosition] = wert;
        }
        else
        {
            logView.write("Array voll");
        }
        aView.changed();
    }

    // h_(2i-1)(x) = (h(x) + i^2) mod m
    // h_(2i)(x) = (h(x) - i^2) mod m
    public void quadratischesSondierenAlternierendesVZ(int wert)
    {
        // Kollisionsbehandlung wird nur durchgefuehrt, wenn das Array noch
        // freie Plaetze enthaelt
        if (!isFull())
        {
            // Anfangsposition des Hashwertes
            int arrayPosition = wert % (array.length);
            // Variablen um bei Kollision die
            int i = 1;
            int j = 1;

            // noch unbelegte Arraypositionen sind mit dem int Wert 100
            // gekennzeichnet
            while (array[arrayPosition] != 100)
            {
                // wenn i und j gleich sind, wird + gerechnet
                if (i == j)
                {
                    logView.write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> Quadratisches Sondieren " + (wert % array.length) + " + " + i + "^2");
                    arrayPosition = ((wert % array.length) + i * i) % array.length;
                    i++;
                }
                // da nach dem + rechnen nur i erhoeht wird, wird der else Fall
                // aufgerufen und hier mit - gerechnet, und danach j erhoeht,
                // damit beim
                // naechsten Durchlauf wieder mit + gerechnet wird
                else
                {
                    logView.write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> Quadratisches Sondieren " + (wert % array.length) + " - " + j + "^2");
                    arrayPosition = ((wert % array.length) - j * j) % array.length;
                    // negative Arrayposition abfangen
                    while (arrayPosition < 0)
                    {
                        arrayPosition += array.length;
                    }
                    j++;
                }
            }
            // Ausgabe in die LogView
            logView.write(wert + " an Stelle " + arrayPosition + " vom Feld geschrieben");
            // schreiben des Wertes ins Array
            array[arrayPosition] = wert;
        }
        else
        {
            // Ausgabe in die LogView bei vollem Array
            logView.write("Array voll");
        }
        // Array muss neu gezeichnet werden
        aView.changed();
    }

    public void doppelHashingDivision(int wert)
    {

    }

    public void doppelHashingMulti(int wert)
    {

    }

    public void kuckucksHashing(int wert)
    {

    }

    public void printArray()
    {
        // Array wird durchlaufen und die int-Werte in die Konsole ausgegeben
        for (int wert : array)
        {
            System.out.print(wert + " ");
        }
        System.out.println();
    }

    public boolean isFull()
    {
        boolean full = false;

        // das Array wird durchlaufen bis zum Ende und full auf "true" gesetzt
        // oder der Wert 100 auftritt, welcher ein noch leere Arrayposition
        // kennzeichnet
        for (int wert : array)
        {
            if (wert == 100)
            {
                full = false;
                break;
            }
            else
            {
                full = true;
            }
        }

        return full;
    }
}
