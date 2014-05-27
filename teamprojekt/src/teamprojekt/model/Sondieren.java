package teamprojekt.model;

import java.util.ArrayList;

import teamprojekt.control.ControlButtonsListener;
import teamprojekt.view.LogView;

public abstract class Sondieren
{
    protected int i;

    private int[] array;

    protected int value;

    private int index;

    private ArrayModel arrayModel;

    protected LogView logView;

    protected int arrayLength;

    protected int arrayPosition;

    private String insertSearchDelete;

    private ArrayList<ControlButtonsListener> listeners;

    private ArrayList<Pair> sequence;

    private boolean play;

    public Sondieren(ArrayModel arrayModel, LogView logView)
    {
        this.arrayModel = arrayModel;
        this.logView = logView;
        this.listeners = new ArrayList<>();
        this.arrayLength = arrayModel.getLength();
        arrayPosition = -1;
    }

    public abstract String getName();

    public abstract String getFormula();

    public abstract int getNextPosition();

    public void nextSearchPosition()
    {
        if (isFound())
        {
            index = arrayPosition;
            arrayModel.valueFound();
            logView.write(value + " an Arrayposition " + arrayPosition + "  gefunden\n");
            arrayPosition = -1;
            if (getInsertSearchDelete().equals("delete"))
            {
                deleted(index, value);
            }
        }
        else if (!isFound() && i < arrayLength && array[arrayPosition] != 0)
        {
            int oldArrayPosition = arrayPosition;
            arrayPosition = getNextPosition();
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

        // da loeschen und suchen die gleiche Funktion nutzen muss um es Log
        // eindeutig zu unterscheiden, geprueft werden, um was es sich handelt
        if (getInsertSearchDelete().equals("search"))
        {
            logView.writeSearch(value);
        }
        logView.writeFirstSearch(value, arrayPosition);
    }

    public void insert(int val)
    {
        // vor dem einfuegen muss erst geprueft werden, ob das Array nicht schon
        // voll ist oder der Wert bereits schon existiert
        if (isFull())
        {
            logView.full();
            nextAction();
        }
        else if (arrayModel.exists(val))
        {
            logView.exists(val);
            nextAction();
        }
        else
        {
            value = val;

            // Anfangsposition des Hashwertes
            arrayPosition = val % arrayLength;
            // Wert um den "verschoben" wird
            i = 1;

            array = arrayModel.getArray();
            logView.writeInsert(val);
            logView.writeFirstInsert(value, arrayPosition);
            arrayModel.setValues(arrayPosition, arrayPosition, value, isInsertPossible());
        }
    }

    public void nextInsertPosition()
    {
        if (isInsertPossible())
        {
            insArrayEintragen(arrayPosition, value);
            arrayPosition = -1;
        }
        else if (i < arrayLength)
        {
            int oldArrayPosition = arrayPosition;
            arrayPosition = getNextPosition();
            i++;
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

    protected boolean isInsertPossible()
    {
        return !(array[arrayPosition] != 0 && array[arrayPosition] != -1);
    }

    protected boolean isFound()
    {
        return (array[arrayPosition] == value);
    }

    public void delete(int val)
    {
        logView.writeDelete(val);
        search(val);
    }

    public void insArrayEintragen(int arrayPos, int val)
    {
        // Ausgabe in die LogView
        logView.added(val, arrayPos);
        // schreiben des valuees ins Array
        arrayModel.setValueAt(arrayPos, val);
    }

    public void deleted(int inx, int val)
    {
        if (inx != -1)
        {
            arrayModel.delete(inx);
            logView.deleted(inx, val);
        }
        else
        {
            logView.unAvailable(val);
        }
    }

    // kontrollfunktion, ob das Array noch freie Plätze enthält
    public boolean isFull()
    {
        boolean full = true;

        // das Array wird bis zum Ende durchlaufen, falls der Wert 0 oder -1
        // auftritt, welcher eine noch leere Arrayposition kennzeichnet bricht
        // die Schleife ab und full wird auf false gesetzt
        for (int val : arrayModel.getArray())
        {
            if (val == 0 || val == -1)
            {
                full = false;
                break;
            }
        }

        return full;
    }

    public void setInsertSearchDelete(String newVal)
    {
        insertSearchDelete = newVal;
    }

    public String getInsertSearchDelete()
    {
        return insertSearchDelete;
    }

    // Method um neue Listener anzumelden
    public void addListener(ControlButtonsListener ml)
    {
        listeners.add(ml);
    }

    // alle angemeldeten Listener werden benachrichtig, das der Next-Button
    // geclicked wird
    public void listenerNext()
    {
        for (ControlButtonsListener listener : listeners)
        {
            listener.nextButtonClicked();
        }
    }

    // Methode um den Play-Button von Play auf "Not"Play und umgekehrt zu setzen
    public void setPlay()
    {
        if (play)
        {
            play = false;
        }
        else
        {
            play = true;
        }
    }

    // gibt true zurück, wenn der Play button auf "play" steht, sonst false
    public boolean getPlay()
    {
        return play;
    }

    public void threadWait()
    {
        // beim drücken des Play Buttons zu Stop, wird der Thread der die
        // Animation ausführt auf wait gesetzt
        AnimatorThread dummy = arrayModel.getThread();
        if (dummy != null && dummy.isAlive())
        {
            dummy.setWait();
        }
    }

    public void threadGo()
    {
        // Threads werden geweckt, dazu wird geschaut, welcher Thread aktiv ist
        // und entsprechend mit der wake Methode geweckt
        // falls kein Thread wartet, wird der nächste Schritt ausgeführt
        StartNextThread snThread = arrayModel.getAutoAnimationThread();
        AnimatorThread animThread = arrayModel.getThread();
        if (snThread != null && snThread.isAlive())
        {
            snThread.wake();
        }
        else if (animThread != null && animThread.isAlive())
        {
            animThread.wake();
        }
        else
        {
            listenerNext();
        }
    }

    // Methode zum Automatischen fuellen des Feldes wenn Log geladen wird
    public void nextAction()
    {
        // erst wird geprueft ob noch offene Aktionen ausgefuehrt werden muessen
        if (!autoActionDone())
        {
            // das erste Paar in der ArrayList wird verarbeitet
            Pair next = sequence.remove(0);

            // Werte des Paars "besorgen" und abspeichern
            String nextAction = next.getAction();
            int nextValue = next.getValue();

            setInsertSearchDelete(nextAction);

            // die hinterlegte Aktion wird entsprechend ausgefuehrt
            switch (nextAction)
            {
                case "insert":
                    insert(nextValue);
                    break;
                case "search":
                    search(nextValue);
                    break;
                case "delete":
                    delete(nextValue);
                    break;

                default:
                    break;
            }
        }
    }

    public boolean autoActionDone()
    {
        boolean actionDone = false;
        if (sequence.isEmpty())
        {
            actionDone = true;
        }
        return actionDone;
    }

    public int getArrayPosition()
    {
        return arrayPosition;
    }

    public void setArrayList(ArrayList<Pair> seq)
    {
        this.sequence = seq;
        if (!seq.isEmpty())
        {
            new NextActionThread(this);
        }
    }
}
