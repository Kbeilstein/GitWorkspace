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

    private static final Font inhalt = new Font("Verdana", Font.BOLD, 14);

    private static final Font index = new Font("Verdana", Font.PLAIN, 12);

    private static final int space = 5;

    private static final int spaceSingle = space + 5;

    private static final int toppadding = 60;

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
        g.setFont(index);
        g.drawString("Index:", paddingX - 40, toppadding - 10);

        for (int i = 0; i < array.length; i++)
        {
            g.setFont(index);
            if (i < 10)
            {
                g.drawString(Integer.toString(i), spaceSingle + paddingX, toppadding - 10);
            }
            else
            {
                g.drawString(Integer.toString(i), space + 2 + paddingX, toppadding - 10);
            }

            g.setFont(inhalt);

            // Rechtecke zeichnen, schwarzer Rand
            g.drawRect(paddingX, toppadding, 30, 30);
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
            g.fillRect(paddingX + 1, toppadding + 1, 29, 29);
            g.setColor(Color.BLACK);

            // Unterscheidung ob die einzufügende Zahl einstellig oder
            // zweistellig ist um eine mittige Position zu erreichen
            if (0 < array[i] && array[i] < 10)
            {
                g.drawString(Integer.toString(array[i]), spaceSingle + paddingX, toppadding + 20);

            }
            else if (9 < array[i] && array[i] < 100)
            {
                g.drawString(Integer.toString(array[i]), space + paddingX, toppadding + 20);
            }

            paddingX += 30;
        }
    }
}
