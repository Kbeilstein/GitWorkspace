package teamprojekt;

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
        if (!isFull())
        {
            int arrayPosition = wert % array.length;
            int i = 1;

            // Felder mit dem Wert 100 sind frei
            while (array[arrayPosition] != 100)
            {
                logView.write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> Lineares Sondieren " + (wert % array.length) + " + " + i);
                arrayPosition = (wert + i) % array.length;
                i++;
            }
            logView.write(wert + " auf Feldposition " + arrayPosition + " vom Feld geschrieben");
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
        if (!isFull())
        {
            int arrayPosition = wert % (array.length);
            int i = 1;
            int c;
            if (array.length % 3 != 0)
            {
                c = 3;
            }
            else if (array.length % 5 != 0)
            {
                c = 5;
            }
            else if (array.length % 7 != 0)
            {
                c = 7;
            }
            else
            {
                c = 1;
            }

            logView.write("Fuer c wird " + c + " gewaehlt");

            while (array[arrayPosition] != 100)
            {
                logView.write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> erw. Lineares Sondieren " + (wert % array.length) + " + " + c + " * " + i);
                arrayPosition = (wert + c * i) % array.length;
                i++;
            }
            logView.write(wert + " an Stelle " + arrayPosition + " vom Feld geschrieben");
            array[arrayPosition] = wert;
        }
        else
        {
            logView.write("Array voll");
        }
        aView.changed();
    }

    public void quadratischesSondieren(int wert)
    {
        if (!isFull())
        {
            // int temp = wert % (array.length - 1);
            // int count = array.length;
        }
    }

    public void quadratischesSondierenAlternierendesVZ(int wert)
    {

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
        for (int wert : array)
        {
            System.out.print(wert + " ");
        }
        System.out.println();
    }

    public boolean isFull()
    {
        boolean full = false;

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
