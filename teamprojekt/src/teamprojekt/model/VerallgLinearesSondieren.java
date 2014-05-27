package teamprojekt.model;

import teamprojekt.view.LogView;

public class VerallgLinearesSondieren extends Sondieren
{
    private int c;

    private static final String NAME = "Verallgemeinertes Lineares Sondieren";

    private static final String FORMULA = "(h(x) + c * i) mod m";

    public VerallgLinearesSondieren(ArrayModel arrayModel, LogView logView, int c)
    {
        super(arrayModel, logView);
        this.c = c;
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
        int nextPosition = ((value % arrayLength) + (c * i)) % arrayLength;
        logView.collisionVerallgLinearesSondieren(value, nextPosition, arrayLength, c, i);
        return nextPosition;
    }
}
