package teamprojekt.model;

import teamprojekt.view.ArrayView;
import teamprojekt.view.LogView;

public class Sondieren
{

    private int[] array;

    private LogView logView;

    private ArrayView aView;

    private int arrayLaenge;

    public Sondieren(ArrayModel arrayModel, LogView logView, ArrayView aView)
    {
        this.array = arrayModel.getArray();
        this.logView = logView;
        this.aView = aView;
        this.arrayLaenge = this.array.length;
    }

    public void linearesSondieren(int wert)
    {
        // Kollisionsbehandlung wird nur durchgefuehrt, wenn das Array noch
        // freie Plaetze enthaelt
        if (!isFull())
        {
            // Anfangsposition des Hashwertes
            int arrayPosition = wert % arrayLaenge;
            // Wert um den "verschoben" wird
            int i = 1;

            // noch unbelegte Arraypositionen sind mit dem int Wert 100
            // gekennzeichnet
            // while Schleife wird nur bei Kollisionen durchlaufen
            while (array[arrayPosition] != 0)
            {
                logView.write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> Lineares Sondieren " + (wert % arrayLaenge) + " + " + i);
                arrayPosition = ((wert % arrayLaenge) + i) % arrayLaenge;
                i++;
            }

            insArrayEintragen(arrayPosition, wert);
        }
        else
        {
            logView.write("Array voll");
        }
    }

    public void verallgLinearesSondieren(int wert)
    {
        // Kollisionsbehandlung wird nur durchgefuehrt, wenn das Array noch
        // freie Plaetze enthaelt
        if (!isFull())
        {
            // Anfangsposition des Hashwertes
            int arrayPosition = wert % (arrayLaenge);
            // Teil der Summe um die "verschoben" wird
            int i = 1;

            // c und m muessen teilerfremd sein, daher wird ein c gewaehlt, das
            // bis Arraylaenge 17 auf jeden Fall diese Eigenschaft erfuellt
            int c;
            // gilt fuer m = 5, 7, 8, 10, 11, 13, 14, 16
            if (arrayLaenge % 3 != 0)
            {
                c = 3;
            }
            // gilt fuer m = 6, 9, 12, 17
            else if (arrayLaenge % 5 != 0)
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
            // while Schleife wird nur bei Kollisionen durchlaufen
            while (array[arrayPosition] != 0)
            {
                logView.write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> erw. Lineares Sondieren " + (wert % arrayLaenge) + " + " + c + " * " + i);
                arrayPosition = ((wert % arrayLaenge) + c * i) % arrayLaenge;
                i++;
            }

            insArrayEintragen(arrayPosition, wert);
        }
        else
        {
            logView.write("Array voll");
        }
    }

    // h_i(x) = (h(x) + i^2) mod m
    public void quadratischesSondieren(int wert)
    {
        // Kollisionsbehandlung wird nur durchgefuehrt, wenn das Array noch
        // freie Plaetze enthaelt
        if (!isFull())
        {
            // Anfangsposition des Hashwertes
            int arrayPosition = wert % (arrayLaenge);
            int i = 1;

            // noch unbelegte Arraypositionen sind mit dem int Wert 100
            // gekennzeichnet
            // while Schleife wird nur bei Kollisionen durchlaufen
            while (array[arrayPosition] != 0 && i < arrayLaenge)
            {
                logView.write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> Quadratisches Sondieren " + (wert % arrayLaenge) + " + " + i + "^2");
                arrayPosition = ((wert % arrayLaenge) + (i * i)) % arrayLaenge;
                System.out.println(arrayPosition + " i " + i);
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

    // h_(2i-1)(x) = (h(x) + i^2) mod m
    // h_(2i)(x) = (h(x) - i^2) mod m
    public void alternierendesQuadratischesSondieren(int wert)
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

            // noch unbelegte Arraypositionen sind mit dem int Wert 100
            // gekennzeichnet
            // while Schleife wird nur bei Kollisionen durchlaufen
            while (array[arrayPosition] != 0 && i < arrayLaenge)
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

    // h(k) = k mod m
    // h'(k) = 1 + k mod (m-2)
    // h(k), h(k)-h(k), h(k)-2*h(k), ... , h(k)-(m-1)*h(k)
    public void doppelHashing(int wert)
    {
        // Kollisionsbehandlung wird nur durchgefuehrt, wenn das Array noch
        // freie Plaetze enthaelt
        if (!isFull())
        {
            // Anfangsposition des Hashwertes
            int arrayPosition = wert % (arrayLaenge);
            // Variablen um bei Kollision die Hashfunktion weiter zu zaehlen
            int i = 1;

            // noch unbelegte Arraypositionen sind mit dem int Wert 100
            // gekennzeichnet
            // while Schleife wird nur bei Kollisionen durchlaufen
            while (array[arrayPosition] != 0 && i < arrayLaenge)
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

    // public void kuckucksHashing(int wert)
    // {
    //
    // }

    private void insArrayEintragen(int arrayPosition, int wert)
    {
        // Ausgabe in die LogView
        logView.write(wert + " an Stelle " + arrayPosition + " vom Feld geschrieben");
        // schreiben des Wertes ins Array
        array[arrayPosition] = wert;
        // Array muss neu gezeichnet werden
        aView.changed();
    }

    // Ausgabe des Array in die Konsole
    public void printArray()
    {
        // Array wird durchlaufen und die int-Werte in die Konsole ausgegeben
        for (int wert : array)
        {
            System.out.print(wert + " ");
        }
        System.out.println();
    }

    // kontrollfunktion, ob das Array noch freie Plätze enthält
    public boolean isFull()
    {
        boolean full = false;

        // das Array wird durchlaufen bis zum Ende und full auf "true" gesetzt
        // oder der Wert 100 auftritt, welcher ein noch leere Arrayposition
        // kennzeichnet
        for (int wert : array)
        {
            if (wert == 0 || wert == -1)
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
