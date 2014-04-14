package teamprojekt.model;

import teamprojekt.view.LogView;

public class VerallgLinearesSondieren extends Sondieren
{
    private ArrayModel arrayModel;

    private LogView logView;

    private int arrayLength;

    private int arrayPosition;

    private int i;

    private int c;

    private int[] array;

    private int value;

    private int index;

    private static final String NAME = "Verallgemeinertes Lineares Sondieren";

    public VerallgLinearesSondieren(ArrayModel arrayModel, LogView logView)
    {
        super(arrayModel, logView);
        this.arrayModel = arrayModel;
        this.logView = logView;
        this.arrayLength = arrayModel.getLength();
        arrayPosition = -1;
        // c anhand der Arraylänge bestimmen (muss Teilerfremd zur Arraylänge
        // sein)
        for (int dummy : new int[]
        { 3, 5, 7 })
        {
            if (arrayLength % dummy != 0)
            {
                c = dummy;
                break;
            }
        }
    }

    @Override
    public void add(int val)
    {
        // Kollisionsbehandlung wird nur durchgefuehrt, wenn das Array noch
        // freie Plaetze enthaelt
        value = val;

        if (isFull())
        {
            logView.full();
        }
        else if (arrayModel.isAvailable(value))
        {
            logView.available(value);
        }
        else
        {
            // Animation "starten"

            // Anfangsposition des Hashwertes
            arrayPosition = val % arrayLength;
            // val um den "verschoben" wird
            i = 1;

            array = arrayModel.getArray();
            logView.write(value + " soll auf Arrayposition " + arrayPosition + " eingefügt werden");
            arrayModel.setValues(arrayPosition, arrayPosition, value, isInsertPossible());
            // nextArrayPosition();
        }
    }

    @Override
    public void search(int val)
    {
        // mit -1 initialisiert, kennzeichnet "nicht gefunden"
        index = -1;
        value = val;

        // Anfangsposition des Hashwertes
        arrayPosition = val % arrayLength;
        // Wert um den "verschoben" wird
        i = 1;

        array = arrayModel.getArray();

        arrayModel.setValuesSearch(arrayPosition, arrayPosition, value, isFound());
        logView.write(value + " wird an Arrayposition " + arrayPosition + " gesucht");

        // solange nicht der Wert oder ein leere Platz (mit 0 gekennzeichnet)
        // auftritt läuft die while Schleife das ganze Array einmal durch
    }

    public void nextInsertPosition()
    {
        if (isInsertPossible())
        {
            insArrayEintragen(arrayPosition, value);
            arrayPosition = -1;
        }
        // es wird nur so lange nach einem Platz zum einfügen gesucht, solange
        // das Array nicht einmal ganz durchlaufen wurde
        // beim Quadratischen sondieren kann es sonst zu einer Endlosschleife
        // kommen
        else if (i <= arrayLength)
        {
            int oldArrayPosition = arrayPosition;
            arrayPosition = ((value % arrayLength) + (c * i)) % arrayLength;
            logView.collisionVerallgLinearesSondieren(value, arrayPosition, arrayLength, c, i);
            i++;
            arrayModel.setValues(oldArrayPosition, arrayPosition, value, isInsertPossible());
        }
        // keinen Platz für das Einfügen gefunden
        else
        {
            logView.error();
            arrayPosition = -1;
            arrayModel.valueFound();
        }
    }

    @Override
    public void nextSearchPosition()
    {
        if (isFound())
        {
            index = arrayPosition;
            arrayModel.valueFound();
            logView.write(value + " an Arrayposition " + arrayPosition + "  gefunden\n");
            arrayPosition = -1;
            if (super.getInsertSearchDelete().equals("delete"))
            {
                deleted(index, value);
            }
        }
        else if (!isFound() && i < arrayLength && array[arrayPosition] != 0)
        {
            int oldArrayPosition = arrayPosition;
            arrayPosition = ((value % arrayLength) + (c * i)) % arrayLength;
            i++;
            logView.write(value + " wird an Arrayposition " + arrayPosition + " gesucht");
            arrayModel.setValuesSearch(oldArrayPosition, arrayPosition, value, isFound());
        }
        else
        {
            arrayModel.valueNotFound();
            if (array[arrayPosition] == 0)
            {
                logView.write(value + " nicht gefunden\n");
            }
            else
            {
                logView.write(value + " nicht gefunden, aber einmal durchlaufen\n");
            }
            index = -1;
            arrayPosition = -1;
        }
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    @Override
    public int getArrayPosition()
    {
        return arrayPosition;
    }

    public boolean isInsertPossible()
    {
        return !(array[arrayPosition] != 0 && array[arrayPosition] != -1);
    }

    public boolean isFound()
    {
        return (array[arrayPosition] == value);
    }
}
