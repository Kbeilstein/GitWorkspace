package teamprojekt.model;

import teamprojekt.view.LogView;

public class LinearesSondieren extends Sondieren
{

    private ArrayModel arrayModel;

    private LogView logView;

    private int arrayLength;

    private int arrayPosition;

    private int i;

    private int[] array;

    private int value;

    private int index;

    private static final String NAME = "Lineares Sondieren";

    private static final String FORMULA = "(h(x) + i)";

    public LinearesSondieren(ArrayModel arrayModel, LogView logView)
    {
        super(arrayModel, logView);
        this.arrayModel = arrayModel;
        this.logView = logView;
        this.arrayLength = arrayModel.getLength();
        arrayPosition = -1;
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
            // Wert um den "verschoben" wird
            i = 1;

            array = arrayModel.getArray();
            logView.write(value + " soll auf Arrayposition " + arrayPosition + " eingefügt werden");
            arrayModel.setValues(arrayPosition, arrayPosition, value, isInsertPossible());
            // nextArrayPosition();
        }
    }

    // Durchsucht das Array, ob der Wert enthalten ist und gibt den Index zurück
    // falls nicht enthalten wird -1 zurück gegeben
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
            arrayPosition = ((value % arrayLength) + i) % arrayLength;
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
                logView.write(value + " nicht gefunden, aber das Array wurde einmal durchlaufen\n");
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
    public String getFormula()
    {
        return FORMULA;
    }

    @Override
    public int getArrayPosition()
    {
        return arrayPosition;
    }

    @Override
    public void nextInsertPosition()
    {
        if (isInsertPossible())
        {
            insArrayEintragen(arrayPosition, value);
            arrayPosition = -1;
        }
        else
        {
            int oldArrayPosition = arrayPosition;
            arrayPosition = ((value % arrayLength) + i) % arrayLength;
            logView.collisionLinearesSondieren(value, arrayPosition, arrayLength, i);
            i++;
            arrayModel.setValues(oldArrayPosition, arrayPosition, value, isInsertPossible());
        }
    }

    private boolean isInsertPossible()
    {
        return !(array[arrayPosition] != 0 && array[arrayPosition] != -1);
    }

    private boolean isFound()
    {
        return (array[arrayPosition] == value);
    }

}
