package teamprojekt.model;

import teamprojekt.view.LogView;

public class LinearesSondieren extends Sondieren
{
    private static final String NAME = "Lineares Sondieren";

    private static final String FORMULA = "(h(x) + i) mod m";

    public LinearesSondieren(ArrayModel arrayModel, LogView logView)
    {
        super(arrayModel, logView);
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

    public int getNextPosition()
    {
        int nextPosition = ((value % arrayLength) + i) % arrayLength;
        logView.collisionLinearesSondieren(value, nextPosition, arrayLength, i);
        return nextPosition;
    }
}
