package teamprojekt.model;

import teamprojekt.view.ArrayView;
import teamprojekt.view.LogView;

public class VerallgLinearesSondieren extends Sondieren
{

    private ArrayModel arrayModel;

    private LogView logView;

    private int arrayLaenge;

    public VerallgLinearesSondieren(ArrayModel arrayModel, LogView logView, ArrayView aView)
    {
        super(arrayModel, logView, aView);
        this.arrayModel = arrayModel;
        this.logView = logView;
        this.arrayLaenge = arrayModel.getLength();
    }

    @Override
    public void add(int wert)
    {
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

            // noch unbelegte Arraypositionen sind mit dem int Wert 0
            // gekennzeichnet
            // while Schleife wird nur bei Kollisionen durchlaufen
            while (arrayModel.getArray()[arrayPosition] != 0)
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
