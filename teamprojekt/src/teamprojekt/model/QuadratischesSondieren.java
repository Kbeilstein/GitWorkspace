package teamprojekt.model;

import teamprojekt.view.LogView;

public class QuadratischesSondieren extends Sondieren
{
    private static final String NAME = "Quadratisches Sondieren";

    private static final String FORMULA = "(h(x) + i^2) mod m";

    public QuadratischesSondieren(ArrayModel arrayModel, LogView logView)
    {
        super(arrayModel, logView);
    }

    // h_i(x) = (h(x) + i^2) mod m
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
    public int getNextPosition()
    {
        int nexPosition = ((value % arrayLength) + (i * i)) % arrayLength;
        logView.collisionAlternierendesQuadrSondierenPlus(value, nexPosition, arrayLength, i, insertSearchDelete);
        return nexPosition;
    }
}
