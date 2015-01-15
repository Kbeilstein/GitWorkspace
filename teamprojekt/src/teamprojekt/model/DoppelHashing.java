package teamprojekt.model;

import teamprojekt.view.LogView;

public class DoppelHashing extends Sondieren
{
    private static final String NAME = "Doppel-Hashing";

    private static final String FORMULA = "(h(x) - i * ( 1 + x mod (m-2))) mod m";

    public DoppelHashing(ArrayModel arrayModel, LogView logView)
    {
        super(arrayModel, logView);
    }

    // h(k) = k mod m
    // h'(k) = 1 + k mod (m-2)
    // h(k), h(k)-h(k), h(k)-2*h(k), ... , h(k)-(m-1)*h(k)
    // h(x) - i * ( 1 + x mod (m-2))
    // (value % arrayLength) - i * (1 + value % (arrayLength - 2))

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
        int nextPosition = (((value % arrayLength) - i * (1 + value % (arrayLength - 2))) % arrayLength + arrayLength) % arrayLength;
        logView.collisionDoppelHashing(value, nextPosition, arrayLength, i, insertSearchDelete);
        return nextPosition;
    }
}
