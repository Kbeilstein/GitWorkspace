package teamprojekt.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import teamprojekt.model.ArrayModel;
import teamprojekt.model.Sondieren;

@SuppressWarnings("serial")
public class ArrayView extends JPanel
{
    private int[] array;

    // private String title;

    private int length;

    private static final Font INHALT_FONT = new Font("Verdana", Font.BOLD, 14);

    private static final Font INDEX_FONT = new Font("Verdana", Font.PLAIN, 12);

    private static final int SPACE = 5;

    private static final int SPACE_SINGLE = SPACE + 5;

    private static final int TOP_PADDING = 60;

    public ArrayView(ArrayModel model, Sondieren sond)
    {
        array = model.getArray();
        length = model.getLength();
        // title = sond.getName();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int paddingX = this.getWidth() / 2 - (length * 15);

        g.setColor(Color.BLACK);
        // g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        // g.setFont(new Font("Verdana", Font.BOLD, 12));
        // g.drawString(title + " " + Character.toString('\u2013') +
        // " Arraygröße " + length, 5, 17);
        g.setFont(INDEX_FONT);
        g.drawString("Index:", paddingX - 40, TOP_PADDING - 10);

        for (int i = 0; i < array.length; i++)
        {
            g.setFont(INDEX_FONT);
            if (i < 10)
            {
                g.drawString(Integer.toString(i), SPACE_SINGLE + paddingX, TOP_PADDING - 10);
            }
            else
            {
                g.drawString(Integer.toString(i), SPACE + 2 + paddingX, TOP_PADDING - 10);
            }

            g.setFont(INHALT_FONT);

            // Rechtecke zeichnen, schwarzer Rand
            g.drawRect(paddingX, TOP_PADDING, 30, 30);
            // falls das Feld mit -1 gekennzeichnet ist, wird der Hintergrund
            // Orange gezeichnet ansonsten wird ein weißer Hintergrund verwendet
            if (-1 == array[i])
            {
                g.setColor(Color.ORANGE);
            }
            else
            {
                g.setColor(Color.WHITE);
            }
            g.fillRect(paddingX + 1, TOP_PADDING + 1, 29, 29);
            g.setColor(Color.BLACK);

            // Unterscheidung ob die einzufügende Zahl einstellig oder
            // zweistellig ist um eine mittige Position zu erreichen
            if (0 < array[i] && array[i] < 10)
            {
                g.drawString(Integer.toString(array[i]), SPACE_SINGLE + paddingX, TOP_PADDING + 20);

            }
            else if (9 < array[i] && array[i] < 100)
            {
                g.drawString(Integer.toString(array[i]), SPACE + paddingX, TOP_PADDING + 20);
            }

            paddingX += 30;
        }
    }
}
