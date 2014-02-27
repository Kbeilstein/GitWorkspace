package teamprojekt.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ArrayView extends JPanel
{
    private int[] array;

    public ArrayView(int[] array)
    {
        this.array = array;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int dummy = 10;
        int space = 8;

        for (int i = 0; i < array.length; i++)
        {
            g.setColor(Color.BLACK);
            g.drawRect(dummy, 10, 30, 30);

            if (array[i] < 10)
            {
                g.drawString(" " + array[i], space + dummy, 30);
            }
            else if (array[i] < 100)
            {
                g.drawString(array[i] + "", space + dummy, 30);
            }

            dummy += 30;
        }
    }

    public void changed()
    {
        repaint();
    }
}
