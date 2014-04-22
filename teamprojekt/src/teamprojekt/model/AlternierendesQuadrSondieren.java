package teamprojekt.model;

import teamprojekt.view.LogView;

public class AlternierendesQuadrSondieren extends Sondieren
{
    private ArrayModel arrayModel;

    private LogView logView;

    private int arrayLength;

    private int arrayPosition;

    private int i;

    private int j;

    private int[] array;

    private int value;

    private int index;

    private static final String NAME = "alternierendes Quadratisches Sondieren";

    public AlternierendesQuadrSondieren(ArrayModel arrayModel, LogView logView)
    {
        super(arrayModel, logView);
        this.arrayModel = arrayModel;
        this.logView = logView;
        this.arrayLength = arrayModel.getLength();
        arrayPosition = -1;
    }

    // h_(2i-1)(x) = (h(x) + i^2) mod m
    // h_(2i)(x) = (h(x) - i^2) mod m
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
            j = 1;

            array = arrayModel.getArray();
            logView.write(value + " soll auf Arrayposition " + arrayPosition + " eingefügt werden");
            arrayModel.setValues(arrayPosition, arrayPosition, value, isInsertPossible());
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
        j = 1;

        array = arrayModel.getArray();

        arrayModel.setValuesSearch(arrayPosition, arrayPosition, value, isFound());
        logView.write(value + " wird an Arrayposition " + arrayPosition + " gesucht");

        // solange nicht der Wert oder ein leere Platz (mit 0 gekennzeichnet)
        // auftritt läuft die while Schleife das ganze Array einmal durch
    }

    @Override
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

            // wenn i und j gleich sind, wird + gerechnet
            if (i == j)
            {
                arrayPosition = ((value % arrayLength) + i * i) % arrayLength;
                logView.collisionAlternierendesQuadrSondierenPlus(value, arrayPosition, arrayLength, i);
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
                arrayPosition = (((value % arrayLength) - j * j) % arrayLength + arrayLength) % arrayLength;
                logView.collisionAlternierendesQuadrSondierenMinus(value, arrayPosition, arrayLength, j);
                j++;
            }

            arrayModel.setValues(oldArrayPosition, arrayPosition, value, isInsertPossible());
        }
        else
        {
            logView.error();
            arrayPosition = -1;
            // keinen Platz für das Einfügen gefunden
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

            // wenn i und j gleich sind, wird + gerechnet
            if (i == j)
            {
                arrayPosition = ((value % arrayLength) + i * i) % arrayLength;
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
                arrayPosition = (((value % arrayLength) - j * j) % arrayLength + arrayLength) % arrayLength;
                j++;
            }

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