package teamprojekt.model;

import java.util.ArrayList;

import javax.swing.undo.UndoManager;

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

    protected ArrayList<Integer> arrayPosition;

    protected String insertSearchDelete;

    private ArrayList<ControlButtonsListener> listeners;

    private ArrayList<Pair> sequence;

    private boolean play;

    private int posIndex;

    private UndoManager manager;

    public Sondieren(ArrayModel arrayModel, LogView logView)
    {
        this.arrayModel = arrayModel;
        this.logView = logView;
        this.listeners = new ArrayList<>();
        this.arrayLength = arrayModel.getLength();
        resetArrayPos();
    }

    private void resetArrayPos()
    {
        arrayPosition = new ArrayList<Integer>();
        manager = new UndoManager();
        posIndex = 0;
    }

    public abstract String getName();

    public abstract String getFormula();

    public abstract int getNextPosition();

    public void nextSearchPosition()
    {
        if (isFound())
        {
            index = arrayPosition.get(posIndex);
            arrayModel.valueFound();
            logView.write(value + " an Arrayposition " + arrayPosition.get(posIndex) + "  gefunden\n");
            resetArrayPos();
            if (getInsertSearchDelete().equals("delete"))
            {
                deleted(index, value);
            }
        }
        else if (!isFound() && i < arrayLength && array[arrayPosition.get(posIndex)] != 0)
        {
            arrayPosition.add(getNextPosition());
            i++;
            posIndex++;
            arrayModel.setValuesSearch(arrayPosition.get(posIndex - 1), arrayPosition.get(posIndex), value, isFound());
        }
        else
        {
            arrayModel.valueNotFound();
            if (array[arrayPosition.get(posIndex)] == 0)
            {
                logView.write(value + " nicht gefunden\n");
            }
            else
            {
                logView.write(value + " nicht gefunden, aber das Array wurde einmal durchlaufen\n");
            }
            index = -1;
            resetArrayPos();
        }
    }

    public void search(int val)
    {
        // mit -1 initialisiert, kennzeichnet "nicht gefunden"
        index = -1;
        value = val;

        // Anfangsposition des Hashwertes
        arrayPosition.add(val % arrayLength);
        // Wert um den "verschoben" wird
        i = 1;

        array = arrayModel.getArray();

        arrayModel.setValuesSearch(arrayPosition.get(posIndex), arrayPosition.get(posIndex), value, isFound());

        // da loeschen und suchen die gleiche Funktion nutzen muss um es Log
        // eindeutig zu unterscheiden, geprueft werden, um was es sich handelt
        if (getInsertSearchDelete().equals("search"))
        {
            logView.writeSearch(value);
            logView.writeFirstSearch(value, arrayPosition.get(posIndex));
        }
        else
        {
            logView.writeDelete(val);
            logView.writeFirstDelete(value, arrayPosition.get(posIndex));
        }

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
            arrayPosition.add(val % arrayLength);
            // Wert um den "verschoben" wird
            i = 1;
            posIndex = 0;

            array = arrayModel.getArray();
            logView.writeInsert(val);
            logView.writeFirstInsert(value, arrayPosition.get(posIndex));
            arrayModel.setValues(arrayPosition.get(posIndex), arrayPosition.get(posIndex), value, isInsertPossible());
        }
    }

    public void prevPosition()
    {
        if (getInsertSearchDelete().equals("insert"))
        {
            arrayModel.setValues(arrayPosition.get(posIndex), arrayPosition.get(posIndex - 1), value, isInsertPossibleRedo());
        }
        else
        {
            arrayModel.setValuesSearch(arrayPosition.get(posIndex), arrayPosition.get(posIndex - 1), value, isFound());
        }

        logView.deleteLast();

        arrayPosition.remove(posIndex);
        posIndex--;
        i--;
    }

    public void redoPosition()
    {
        if (getInsertSearchDelete().equals("insert"))
        {
            nextInsertPosition();
        }
        else
        {
            nextSearchPosition();
        }
    }

    public void nextInsertPosition()
    {
        if (isInsertPossible())
        {
            insArrayEintragen(arrayPosition.get(posIndex), value);
            resetArrayPos();
        }
        else if (i < arrayLength)
        {
            arrayPosition.add(getNextPosition());
            posIndex++;
            i++;
            arrayModel.setValues(arrayPosition.get(posIndex - 1), arrayPosition.get(posIndex), value, isInsertPossible());
        }
        else
        {
            logView.error();
            resetArrayPos();
            // keinen Platz f�r das Einf�gen gefunden
            arrayModel.valueFound();
        }
    }

    protected boolean isInsertPossible()
    {
        return !(array[arrayPosition.get(posIndex)] != 0 && array[arrayPosition.get(posIndex)] != -1);
    }

    protected boolean isInsertPossibleRedo()
    {
        return !(array[arrayPosition.get(posIndex - 1)] != 0 && array[arrayPosition.get(posIndex - 1)] != -1);
    }

    protected boolean isFound()
    {
        return (array[arrayPosition.get(posIndex)] == value);
    }

    public void delete(int val)
    {
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

    // kontrollfunktion, ob das Array noch freie Pl�tze enth�lt
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

    // gibt true zur�ck, wenn der Play button auf "play" steht, sonst false
    public boolean getPlay()
    {
        return play;
    }

    public void threadWait()
    {
        // beim dr�cken des Play Buttons zu Stop, wird der Thread der die
        // Animation ausf�hrt auf wait gesetzt
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
        // falls kein Thread wartet, wird der n�chste Schritt ausgef�hrt
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

    public boolean getArrayPosition()
    {
        return arrayPosition.isEmpty();
    }

    public void setArrayList(ArrayList<Pair> seq)
    {
        this.sequence = seq;
        if (!seq.isEmpty())
        {
            new NextActionThread(this);
        }
    }

    public UndoManager getManager()
    {
        return manager;
    }
}
