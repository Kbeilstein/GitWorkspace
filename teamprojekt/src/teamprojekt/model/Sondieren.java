package teamprojekt.model;

import java.util.ArrayList;

import teamprojekt.control.ControlButtonsListener;
import teamprojekt.view.LogView;

public abstract class Sondieren
{

    private ArrayModel arrayModel;

    private LogView logView;

    private String insertSearchDelete;

    private ArrayList<ControlButtonsListener> listeners;

    private boolean play;

    public Sondieren(ArrayModel arrayModel, LogView logView)
    {
        this.arrayModel = arrayModel;
        this.logView = logView;
        this.listeners = new ArrayList<>();
    }

    public abstract String getName();

    public abstract String getFormula();

    public abstract int getArrayPosition();

    public abstract void nextInsertPosition();

    public abstract void nextSearchPosition();

    public abstract void add(int value);

    public abstract void search(int value);

    public void delete(int value)
    {
        search(value);
    }

    public void insArrayEintragen(int arrayPosition, int value)
    {
        // Ausgabe in die LogView
        logView.added(value, arrayPosition);
        // schreiben des valuees ins Array
        arrayModel.setValueAt(arrayPosition, value);
    }

    public void deleted(int index, int value)
    {
        if (index != -1)
        {
            arrayModel.delete(index);
            logView.deleted(index, value);
        }
        else
        {
            logView.unAvailable(value);
        }
    }

    // kontrollfunktion, ob das Array noch freie Pl�tze enth�lt
    public boolean isFull()
    {
        boolean full = true;

        // das Array wird bis zum Ende durchlaufen, falls der Wert 0 oder -1
        // auftritt, welcher eine noch leere Arrayposition kennzeichnet bricht
        // die Schleife ab und full wird auf false gesetzt
        for (int value : arrayModel.getArray())
        {
            if (value == 0 || value == -1)
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

    // public boolean isAnimationThreadAlive()
    // {
    // return arrayModel.getThread() != null &&
    // arrayModel.getThread().isAlive();
    // }
}
