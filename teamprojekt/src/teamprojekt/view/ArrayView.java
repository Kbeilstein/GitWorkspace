package teamprojekt.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ArrayView extends JPanel
{
    private int[] array;

    private static final Font inhalt = new Font("Verdana", Font.BOLD, 14);

    private static final Font index = new Font("Verdana", Font.PLAIN, 12);

    private static final int space = 5;

    private static final int spaceSingle = space + 5;

    public ArrayView(int[] array)
    {
        this.array = array;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int paddingX = 40;

        g.setColor(Color.BLACK);

        g.setFont(index);
        g.drawString("Index:", 0, 30);

        for (int i = 0; i < array.length; i++)
        {
            g.setFont(index);
            g.drawString(Integer.toString(i), spaceSingle + paddingX, 30);
            g.setFont(inhalt);

            // Rechtecke zeichnen, schwarzer Rand
            g.drawRect(paddingX, 40, 30, 30);
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
            g.fillRect(paddingX + 1, 41, 29, 29);
            g.setColor(Color.BLACK);

            // Unterscheidung ob die einzufügende Zahl einstellig oder
            // zweistellig ist um eine mittige Position zu erreichen
            if (0 < array[i] && array[i] < 10)
            {
                g.drawString(Integer.toString(array[i]), spaceSingle + paddingX, 60);

            }
            else if (0 < array[i] && array[i] < 100)
            {
                g.drawString(Integer.toString(array[i]), space + paddingX, 60);
            }

            paddingX += 30;
        }
    }
}
