package teamprojekt.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import teamprojekt.model.ArrayModel;
import teamprojekt.model.Sondieren;

@SuppressWarnings("serial")
public class ArrayView extends JPanel
{
    private int[] array;

    // private String title;

    private int length;

    private int value;

    private int startIndex;

    private int endIndex;

    private int startPaddingX;

    private ArrayModel model;

    private int xMotion;

    private boolean animation;

    private static final Font INHALT_FONT = new Font("Verdana", Font.BOLD, 14);

    private static final Font INDEX_FONT = new Font("Verdana", Font.PLAIN, 12);

    private static final int SPACE = 5;

    private static final int SPACE_SINGLE = SPACE + 5;

    private static final int TOP_PADDING = 60;

    public ArrayView(ArrayModel model, Sondieren sond)
    {
        array = model.getArray();
        this.model = model;
        length = model.getLength();

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        startPaddingX = this.getWidth() / 2 - (length * 15);
        int paddingX = startPaddingX;

        g2d.setColor(Color.BLACK);
        // g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        // g.setFont(new Font("Verdana", Font.BOLD, 12));
        // g.drawString(title + " " + Character.toString('\u2013') +
        // " Arraygröße " + length, 5, 17);
        g2d.setFont(INDEX_FONT);
        g2d.drawString("Index:", paddingX - 40, TOP_PADDING - 10);

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

            // Rechtecke zeichnen, schwarzer Rand
            g2d.drawRect(paddingX, TOP_PADDING, 30, 30);
            // falls das Feld mit -1 gekennzeichnet ist, wird der Hintergrund
            // Orange gezeichnet ansonsten wird ein weißer Hintergrund verwendet
            if (-1 == array[i])
            {
                g2d.setColor(Color.ORANGE);
            }
            else
            {
                g2d.setColor(Color.WHITE);
            }
            g2d.fillRect(paddingX + 1, TOP_PADDING + 1, 29, 29);
            g2d.setColor(Color.BLACK);

            // Unterscheidung ob die einzufügende Zahl einstellig oder
            // zweistellig ist um eine mittige Positionierung zu erreichen
            if (0 < array[i] && array[i] < 10)
            {
                g2d.drawString(Integer.toString(array[i]), SPACE_SINGLE + paddingX, TOP_PADDING + 20);

            }
            else if (9 < array[i] && array[i] < 100)
            {
                g2d.drawString(Integer.toString(array[i]), SPACE + paddingX, TOP_PADDING + 20);
            }

            paddingX += 30;
        }

        if (animation)
        {
            g.drawString(Integer.toString(value), xMotion, TOP_PADDING + 55);
        }
    }

    private void animation(Graphics g)
    {
        updateValues();

    }

    private void updateValues()
    {
        startIndex = model.getStart();
        xMotion = getStartX();
        endIndex = model.getEnd();
        value = model.getValue();
    }

    private int getStartX()
    {
        return (startIndex == 0 ? startIndex : startIndex * 30) + (value < 10 ? SPACE_SINGLE : SPACE) + startPaddingX;
    }
}
