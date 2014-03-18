package teamprojekt.demo;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

class UndoRedoModel
{
    private int start;

    private int end;

    private ArrayList<UndoRedoModelChangeListener> listeners;

    private Animator animThread;

    public UndoRedoModel()
    {        
        this.listeners = new ArrayList<UndoRedoModelChangeListener>();
    }

    public int getStart()
    {
        return start;
    }

    public int getEnd()
    {
        return end;
    }

    public void setF(int startVal, int endVal)
    {
        start = startVal;
        end = endVal;
        for (UndoRedoModelChangeListener l : listeners)
        {
            l.changedF(startVal, endVal);
        }
    }

    public void setF(int startVal, int endVal, boolean undo)
    {
        start = startVal;
        end = endVal;
        for (UndoRedoModelChangeListener l : listeners)
        {
            l.changedF(startVal, endVal, undo);
        }
    }

    public void addView(UndoRedoModelChangeListener l)
    {
        listeners.add(l);
    }

    public Thread getThread()
    {
        return animThread;
    }

    public void addThread(Animator animThreadVal)
    {
        animThread = animThreadVal;
    }
}

interface UndoRedoModelChangeListener
{
    public void changedF(int start, int end);

    public void changedF(int start, int end, boolean undo);
}

class XController
{
    protected UndoManager manager;

    private JButton undoButton;

    private JButton redoButton;

    public XController(UndoManager manager, JButton undoButton, JButton redoButton)
    {
        this.manager = manager;
        this.undoButton = undoButton;
        this.redoButton = redoButton;
    }

    protected void update()
    {
        if (manager.canUndo())
        {
            undoButton.setEnabled(true);
        }
        else
        {
            undoButton.setEnabled(false);
        }
        if (manager.canRedo())
        {
            redoButton.setEnabled(true);
            redoButton.setName("redo");
        }
        else
        {
            redoButton.setEnabled(true);
            redoButton.setName("next");
        }
    }
}

abstract class UndoRedoSetAnimationX implements UndoableEdit
{
    public boolean addEdit(UndoableEdit edit)
    {
        return false;
    }

    public boolean canRedo()
    {
        return true;
    }

    public boolean canUndo()
    {
        return true;
    }

    public void die()
    {
    }

    public String getRedoPresentationName()
    {
        return null;
    }

    public String getUndoPresentationName()
    {
        return null;
    }

    public boolean isSignificant()
    {
        return true;
    }

    public boolean replaceEdit(UndoableEdit arg0)
    {
        return false;
    }

    public String getPresentationName()
    {
        return null;
    }
}

class UndoRedoSetAnimation extends UndoRedoSetAnimationX
{
    private UndoRedoModel model;

    private int prevStart;

    private int prevEnd;

    private int newStart;

    private int newEnd;

    public UndoRedoSetAnimation(UndoRedoModel model, int start, int end)
    {
        this.model = model;
        prevStart = model.getStart();
        prevEnd = model.getEnd();
        newStart = start;
        newEnd = end;
    }

    public void undo() throws CannotUndoException
    {
        System.out.println("Undo: Start " + prevEnd + " End " + prevStart);
        model.setF(prevEnd, prevStart, true);
    }

    public void redo() throws CannotRedoException
    {
        System.out.println("Redo: Start " + newStart + " End " + newEnd);
        model.setF(newStart, newEnd);
    }
}

class UndoRedoListener extends XController implements ActionListener
{
    private UndoRedoModel model;

    public UndoRedoListener(UndoRedoModel model, UndoManager manager, JButton undoButton, JButton redoButton)
    {
        super(manager, undoButton, redoButton);
        this.model = model;
    }

    /*
     * public void actionPerformed(ActionEvent event) {
     * if(event.getActionCommand().startsWith("Undo")) { if(manager.canUndo()) {
     * manager.undo(); update(); } else { JOptionPane.showMessageDialog(null,
     * "Kein Undo mehr möglich", "Warnung", JOptionPane.WARNING_MESSAGE); } }
     * else if(event.getActionCommand().startsWith("Redo")) {
     * if(manager.canRedo()) { manager.redo(); update(); } else {
     * JOptionPane.showMessageDialog(null, "Kein Redo mehr möglich", "Warnung",
     * JOptionPane.WARNING_MESSAGE); } } }
     */

    public void actionPerformed(ActionEvent event)
    {
        JButton button = (JButton) event.getSource();
        if (button.getName().startsWith("undo"))
        {
            manager.undo();
        }
        else if (button.getName().startsWith("redo"))
        {
            manager.redo();
        }
        else if (button.getName().startsWith("next"))
        {
            int start = (int) (Math.random() * 1000 % 360);
            int end = (int) (Math.random() * 1000 % 360);
            
            System.out.println("Redo: Start " + start + " End " + end);
            model.setF(start, end);
            UndoRedoSetAnimation command = new UndoRedoSetAnimation(model, start, end);
            manager.addEdit(command);
        }
        update();
    }
}

@SuppressWarnings("serial")
class AnimationPanel extends JPanel implements UndoRedoModelChangeListener
{
    private int xMotion;

    private int y = 50;

    private int start;

    private int end;

    private boolean done;

    private UndoRedoModel model;

    private boolean undo;

    // private Color buttonBkgColor;
    //
    // private Color buttonColor;

    public AnimationPanel(UndoRedoModel model)
    {
        this.model = model;
        start = 60;
        xMotion = start;
        end = xMotion;
        done = false;
        // nextButtonOff();
    }

    public synchronized void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(new Font("Verdana", Font.BOLD, 14));

        // von links nach rechts animieren
        if (xMotion < end - 10 && !undo)
        {
            g.drawLine(xMotion + 10, y - 5, end, y - 5);
            g.drawLine(end, y - 5, end, y - 15);
        }

        // von rechts nach links animieren
        else if (xMotion > end + 10 && !undo)
        {
            g.drawLine(xMotion - 10, y - 5, end, y - 5);
            g.drawLine(end, y - 5, end, y - 15);
        }
        else if (start > end && undo && xMotion < start - 10)
        {
            g.drawLine(start, y - 5, xMotion + 10, y - 5);
            g.drawLine(start, y - 5, start, y - 15);
        }
        else if (start < end && undo && xMotion > start + 10)
        {
            g.drawLine(start, y - 5, xMotion - 10, y - 5);
            g.drawLine(start, y - 5, start, y - 15);
        }
        g.drawString("4", xMotion - 5, y);
    }

    public synchronized void next()
    {
        if (xMotion < end)
        {
            xMotion++;
        }
        else if (xMotion > end)
        {
            xMotion--;
        }
        else
        {
            done = true;
        }
        repaint();
    }

    public synchronized boolean done()
    {
        return done;
    }

    public synchronized void setDoneFalse()
    {
        done = false;
    }

    public void setValues(int startVal, int endVal)
    {
        start = startVal;
        xMotion = startVal;
        end = endVal;
    }

    @Override
    public void changedF(int startVal, int endVal)
    {
        undo = false;
        change(startVal, endVal);
    }

    public void changedF(int startVal, int endVal, boolean undoVal)
    {
        undo = undoVal;
        change(startVal, endVal);
    }

    private void change(int startVal, int endVal)
    {
        if (model.getThread() != null && model.getThread().isAlive())
        {
            model.getThread().interrupt();
        }
        Animator animThread = new Animator(this);
        model.addThread(animThread);
        start = startVal;
        xMotion = startVal;
        end = endVal;
        animThread.start();
    }
}

class Animator extends Thread
{
    private AnimationPanel animPanel;

    private int speed;

    public Animator(AnimationPanel animPanel)
    {
        this.animPanel = animPanel;
        speed = 10;
    }

    public synchronized void run()
    {
        animPanel.setDoneFalse();
        while (!animPanel.done())
        {
            animPanel.next();
            try
            {
                Thread.sleep(speed);
            }
            catch (InterruptedException e)
            {
                break;
            }
        }
    }

    public void setSpeed(int value)
    {
        speed = value * -1;
    }
}

public class UndoRedo
{
    public static void main(String[] args)
    {
        JFrame f = new JFrame("Beispiel für Undo / Redo");
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setLayout(new BorderLayout());

        UndoRedoModel model = new UndoRedoModel();
        UndoManager manager = new UndoManager();

        JPanel undoredoPanel = new JPanel(new GridLayout(1, 0));
        JButton undoButton = new JButton("undo");
        undoButton.setName("undo");
        undoButton.setEnabled(false);
        JButton redoButton = new JButton("next");
        redoButton.setName("next");
        redoButton.setEnabled(true);

        UndoRedoListener unreHandler = new UndoRedoListener(model, manager, undoButton, redoButton);
        redoButton.addActionListener(unreHandler);
        undoButton.addActionListener(unreHandler);
        undoredoPanel.add(undoButton);
        undoredoPanel.add(redoButton);
        f.add(undoredoPanel, BorderLayout.SOUTH);

        // UndoRedoModelView view = new UndoRedoModelView();
        AnimationPanel animPanel = new AnimationPanel(model);
        model.addView(animPanel);

        JPanel mainPanel = new JPanel(new GridLayout(1, 0));
        mainPanel.add(animPanel);
        f.add(mainPanel, BorderLayout.CENTER);

        f.setLocation(300, 250);
        f.setSize(500, 150); // f.pack();
        f.setVisible(true);
    }
}
