package teamprojekt.model;

import teamprojekt.view.LogView;

public class AlternierendesQuadrSondieren extends Sondieren
{
    private static final String NAME = "alternierendes Quadratisches Sondieren";

    private static final String FORMULA = "(h1(x) + i^2) mod m, (h2(x) - i^2) mod m, ...";

    public AlternierendesQuadrSondieren(ArrayModel arrayModel, LogView logView)
    {
        super(arrayModel, logView);
    }

    // h_(2i-1)(x) = (h(x) + i^2) mod m
    // h_(2i)(x) = (h(x) - i^2) mod m

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
        int nextPosition;
        if ((i % 2) != 0)
        {
            nextPosition = ((value % arrayLength) + i * i) % arrayLength;
            logView.collisionAlternierendesQuadrSondierenPlus(value, nextPosition, arrayLength, i);
        }
        // da nach dem + rechnen nur i erhoeht wird, wird der else Fall
        // aufgerufen und hier mit - gerechnet, und danach j erhoeht,
        // damit beim
        // naechsten Durchlauf wieder mit + gerechnet wird
        else
        {
            // Loesung um ein "-" bei modulo abzufangen
            // (a % b + b) % b
            nextPosition = (((value % arrayLength) - i * i) % arrayLength + arrayLength) % arrayLength;
            logView.collisionAlternierendesQuadrSondierenMinus(value, nextPosition, arrayLength, i);
        }

        return nextPosition;
    }
}