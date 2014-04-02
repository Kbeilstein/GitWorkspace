package teamprojekt.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SpinnerPlusButtonView extends JPanel
{
    private int x = 0;

    private int xs = x + 1;

    private int y = x;

    private int ys = y + 1;

    private int widthHeight = 15;

    private int widthHeightSmall = widthHeight - 2;

    private int linePosition = 7;

    private Color plusBackground = Color.DARK_GRAY;

    private Color plusForeground = Color.WHITE;

    private Color borderColor = Color.DARK_GRAY;

    public SpinnerPlusButtonView()
    {
        setPlusButtonOff();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Plus Button
        g2d.setColor(borderColor);
        g2d.fillOval(x, y, widthHeight, widthHeight);
        g2d.setColor(plusBackground);
        g2d.fillOval(xs, ys, widthHeightSmall, widthHeightSmall);

        // Beschriftung
        g2d.setColor(plusForeground);

        g2d.drawLine(linePosition - 3, linePosition, linePosition + 3, linePosition);
        g2d.drawLine(linePosition, linePosition - 3, linePosition, linePosition + 3);
    }

    public void setPlusButtonOn()
    {
        plusForeground = Color.WHITE;
        plusBackground = Color.LIGHT_GRAY;
        repaint();
    }

    public void setPlusButtonOff()
    {
        plusForeground = Color.GRAY;
        plusBackground = Color.WHITE;
        repaint();
    }

    public void setPlusButtonClicked()
    {
        plusForeground = Color.WHITE;
        plusBackground = Color.GRAY;
        repaint();
    }

}