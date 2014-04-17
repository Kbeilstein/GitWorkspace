package teamprojekt.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import teamprojekt.model.AnimatorThread;
import teamprojekt.model.ArrayModel;
import teamprojekt.model.Sondieren;
import teamprojekt.model.StartNextThread;

@SuppressWarnings("serial")
public class ArrayView extends JPanel
{
    private int[] array;

    private int length;

    private int value;

    private int startIndex;

    private int endIndex;

    private int startPaddingX;

    private ArrayModel model;

    // benötigt um die Animation auf der X-Achse zu steuern
    private int xMotion;

    // Variable um dem Thread zu melden, das die Animation fertig ist
    private boolean animationDone;

    // um bei einer Animation ein spezielles Index-Feld farblich zu markieren
    private int collisionIndex;

    private int insertIndex;

    private int foundIndex;

    private int notFoundIndex;

    private int endX;

    private boolean isInsertPossible;

    private boolean animationPaintDone;

    private String insertSearchDelete;

    private boolean isFound;

    private Sondieren sond;

    private StartNextThread autoAnimationThread;

    private static final Color INSERT_FREE = new Color(90, 200, 100);

    private static final Color INSERT_COLLISION = new Color(220, 70, 50);

    private static final Color SEARCH_NOT_FOUND = new Color(255, 150, 100);

    private static final Color SEARCH_AND_FOUND = new Color(110, 180, 255);

    private static final Color DELETE = Color.ORANGE;

    private static final Font INHALT_FONT = new Font("Verdana", Font.BOLD, 16);

    private static final Font INDEX_FONT = new Font("Verdana", Font.PLAIN, 14);

    private static final int SPACE = 9;

    private static final int SPACE_SINGLE = SPACE + 7;

    private static final int TOP_PADDING = 60;

    private static final int RECT_PADDING = 40;

    private static final int RECT_SIZE = 40;

    public ArrayView(ArrayModel model, Sondieren sond)
    {
        this.sond = sond;
        array = model.getArray();
        this.model = model;
        length = model.getLength();

        collisionIndex = -1;
        insertIndex = -1;
        foundIndex = -1;
        notFoundIndex = -1;

        // searchDone = true;
        animationPaintDone = true;
        animationDone = true;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        startPaddingX = this.getWidth() / 2 - (length * RECT_SIZE / 2);
        int paddingX = startPaddingX;

        g2d.setColor(Color.BLACK);
        g2d.setFont(INDEX_FONT);
        g2d.drawString("Index:", paddingX - 50, TOP_PADDING - 10);

        for (int i = 0; i < array.length; i++)
        {
            g2d.setFont(INDEX_FONT);
            if (i < 10)
            {
                g2d.drawString(Integer.toString(i), SPACE_SINGLE + paddingX, TOP_PADDING - 10);
            }
            else
            {
                g2d.drawString(Integer.toString(i), SPACE + 2 + paddingX, TOP_PADDING - 10);
            }

            g2d.setFont(INHALT_FONT);

            // Rechtecke zeichnen für den schwarzen Rand
            g2d.drawRect(paddingX, TOP_PADDING, RECT_SIZE, RECT_SIZE);

            // if-Anweisung dient zum passenden einfärben des Feldes
            // falls das Feld mit -1 gekennzeichnet ist, wird der Hintergrund
            // Orange gezeichnet ansonsten wird ein weißer Hintergrund verwendet
            // wenn jedoch bei der Animation (einfügen, suchen, löschen)
            // entsprechende Felder "kurzzeitig" farblich gekenntzeichnet
            // werden, geschieht dies auch an dieser Stelle, über den Index wird
            // das Realisiert und einer entsprechenden Variable zu jedem Fall
            if (i == insertIndex)
            {
                g2d.setColor(INSERT_FREE);
            }
            else if (i == collisionIndex)
            {
                g2d.setColor(INSERT_COLLISION);
            }
            else if (i == foundIndex)
            {
                g2d.setColor(SEARCH_AND_FOUND);
            }
            else if (i == notFoundIndex)
            {
                g2d.setColor(SEARCH_NOT_FOUND);
            }
            else if (-1 == array[i])
            {
                g2d.setColor(DELETE);
            }
            else
            {
                g2d.setColor(Color.WHITE);
            }
            g2d.fillRect(paddingX + 1, TOP_PADDING + 1, RECT_SIZE - 1, RECT_SIZE - 1);
            g2d.setColor(Color.BLACK);

            // Unterscheidung ob die einzufügende Zahl einstellig oder
            // zweistellig ist um eine mittige Positionierung zu erreichen
            if (0 < array[i] && array[i] < 10)
            {
                g2d.drawString(Integer.toString(array[i]), SPACE_SINGLE + paddingX, TOP_PADDING + 26);

            }
            else if (9 < array[i] && array[i] < 100)
            {
                g2d.drawString(Integer.toString(array[i]), SPACE + paddingX, TOP_PADDING + 26);
            }

            paddingX += RECT_PADDING;
        }

        // bei Animation muss das zu Animierende Objekt gezeichnet werden
        if (!animationPaintDone)
        {
            g.drawString(Integer.toString(value), xMotion, TOP_PADDING + 70);
        }
    }

    public synchronized void animationNext()
    {
        if (xMotion < endX)
        {
            xMotion++;
        }
        else if (xMotion > endX)
        {
            xMotion--;
        }
        else
        {
            animationDone = true;
            if (insertSearchDelete.equals("insert"))
            {
                if (isInsertPossible)
                {
                    insertIndex = endIndex;
                    collisionIndex = -1;
                }
                else
                {
                    insertIndex = -1;
                    collisionIndex = endIndex;
                }
            }
            else if (insertSearchDelete.equals("search"))
            {
                if (isFound)
                {
                    foundIndex = endIndex;
                    notFoundIndex = -1;
                }
                else
                {
                    foundIndex = -1;
                    notFoundIndex = endIndex;
                }
            }
        }
        repaint();
    }

    public synchronized void animationInsert()
    {
        update();
        if (isInsertPossible)
        {
            insertIndex = endIndex;
            collisionIndex = -1;
        }
        else
        {
            insertIndex = -1;
            collisionIndex = endIndex;
        }
        repaint();
        startNext();
    }

    public void animationSetPaintAnimationDone()
    {
        animationPaintDone = true;
        animationDone();
    }

    public synchronized void animationUndo()
    {

    }

    public synchronized void startAnimation(String insSearchDel)
    {
        insertSearchDelete = insSearchDel;
        update();
        AnimatorThread animThread = (AnimatorThread) model.getThread();
        if (animThread != null && animThread.isAlive())
        {
            // //animationNext();
            animThread.interrupt();
            // animThread.wake();
        }
        else
        {
            animThread = new AnimatorThread(this, model);
            model.setThread(animThread);
            animThread.start();
        }
    }

    private void update()
    {
        updateValues();
        animationPaintDone = false;
        animationDone = false;
        repaint();
    }

    public synchronized void animationDone()
    {
        // insertionDone = true;
        // searchDone = true;
        animationDone = true;
        insertIndex = -1;
        collisionIndex = -1;
        foundIndex = -1;
        notFoundIndex = -1;
        repaint();
        startNext();
    }

    public synchronized boolean getAnimationDone()
    {
        return animationDone;
    }

    private void updateValues()
    {
        value = model.getValue();
        startIndex = model.getStart();
        xMotion = getXPosition(startIndex);
        endIndex = model.getEnd();
        endX = getXPosition(endIndex);
        isInsertPossible = model.getInsertPossible();
        isFound = model.getValueFound();
    }

    // liefert den passenden x-Wert zu einem angegebenen Index
    private int getXPosition(int val)
    {
        return (val * RECT_PADDING + (value < 10 ? SPACE_SINGLE : SPACE) + startPaddingX);
    }

    public synchronized void animationSearch()
    {
        update();
        if (isFound)
        {
            foundIndex = endIndex;
            notFoundIndex = -1;
        }
        else
        {
            foundIndex = -1;
            notFoundIndex = endIndex;
        }
        startNext();
    }

    public synchronized void startNext()
    {
        // wird nur "betreten" um die Animation automatisch ablaufen zu lassen
        if (!animationPaintDone && sond.getPlay())
        {
            if (autoAnimationThread == null || !autoAnimationThread.isAlive())
            {
                autoAnimationThread = new StartNextThread(sond);
                model.setAutoAnimationThread(autoAnimationThread);
            }
        }
    }

    public synchronized boolean getPlay()
    {
        return sond.getPlay();
    }

    public void animationToEnd()
    {
        xMotion = endX;
        animationNext();
    }
}
