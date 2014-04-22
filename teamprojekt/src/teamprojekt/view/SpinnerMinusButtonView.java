package teamprojekt.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SpinnerMinusButtonView extends JPanel
{
    private int x = 0;

    private int xs = x + 1;

    private int y = x;

    private int ys = y + 1;

    private int widthHeight = 15;

    private int widthHeightSmall = widthHeight - 2;

    private int linePosition = 7;

    private Color minusBackground = Color.DARK_GRAY;

    private Color minusForeground = Color.WHITE;

    private Color borderColor = Color.DARK_GRAY;

    public SpinnerMinusButtonView()
    {
        setSize(new Dimension(30, 30));
        setMinusButtonOff();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Minus Button
        g2d.setColor(borderColor);
        g2d.fillOval(x, y, widthHeight, widthHeight);
        g2d.setColor(minusBackground);
        g2d.fillOval(xs, ys, widthHeightSmall, widthHeightSmall);

        // Beschriftung
        g2d.setColor(minusForeground);
        g2d.drawLine(linePosition - 3, linePosition, linePosition + 3, linePosition);
    }

    public void setMinusButtonOn()
    {
        minusForeground = Color.WHITE;
        minusBackground = Color.LIGHT_GRAY;
        repaint();
    }

    public void setMinusButtonOff()
    {
        minusForeground = Color.GRAY;
        minusBackground = Color.WHITE;
        repaint();
    }

    public void setMinusButtonClicked()
    {
        minusForeground = Color.WHITE;
        minusBackground = Color.GRAY;
        repaint();
    }

}