package teamprojekt.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class ControlButtonsView extends JPanel
{

    private static final long serialVersionUID = 1L;

    private int xPolyBack[] =
    { 17, 27, 27 };

    private int yPolyPBack[] =
    { 21, 16, 26 };

    private int xPolyPlay[] =
    { 66, 66, 80 };

    private int yPolyPlay[] =
    { 13, 29, 21 };

    private int xPolyNext[] =
    { 116, 116, 126 };

    private int yPolyNext[] =
    { 16, 26, 21 };

    private boolean play;

    private Color borderColor = Color.BLACK;

    private Color backButtonBackground;

    private Color backButtonForeground;

    private Color playButtonBackground;

    private Color playButtonForeground;

    private Color nextButtonBackground;

    private Color nextButtonForeground;

    private int rectWidth = 40;

    private int rectHeight = rectWidth / 2;

    private int rectWidhts = rectWidth - 1;

    private int rectHeights = rectWidhts / 2;

    private int paddingY1 = 11;

    private int paddingY2 = 1;

    private int paddingY1s = paddingY1 + 1;

    private int paddingY2s = paddingY2 + 1;

    private int paddingX = 1;

    private int paddingXs = paddingX + 1;

    private int paddingB = 50;

    private int arcSize = 10;

    public ControlButtonsView()
    {
        play = true;
        setBackButtonOff();
        setPlayButtonOff();
        setNextButtonOff();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(2));

        // Back-Button
        g2d.setColor(borderColor);
        g2d.drawRoundRect(paddingX, paddingY1, rectWidth, rectHeight, arcSize, arcSize);
        g2d.setColor(backButtonBackground);
        g2d.fillRoundRect(paddingXs, paddingY1s, rectWidhts, rectHeights, arcSize, arcSize);
        g2d.setColor(backButtonForeground);
        g2d.fillPolygon(xPolyBack, yPolyPBack, 3);
        g2d.fillRect(15, 16, 2, 10);

        // Play / Stop -Button
        g2d.setColor(borderColor);
        g2d.drawRoundRect(paddingX + paddingB, paddingY2, rectWidth, rectWidth, arcSize, arcSize);
        g2d.setColor(playButtonBackground);
        g2d.fillRoundRect(paddingXs + paddingB, paddingY2s, rectWidhts, rectWidhts, arcSize, arcSize);

        // Next Button
        g2d.setColor(borderColor);
        g2d.drawRoundRect(paddingX + paddingB * 2, paddingY1, rectWidth, rectHeight, arcSize, arcSize);
        g2d.setColor(nextButtonBackground);
        g2d.fillRoundRect(paddingXs + paddingB * 2, paddingY1s, rectWidhts, rectHeights, arcSize, arcSize);
        g2d.setColor(nextButtonForeground);
        g2d.fillPolygon(xPolyNext, yPolyNext, 3);
        g2d.fillRect(126, 16, 2, 10);

        // Paint in Play/Stop Button a Polygon or a Rect
        g2d.setColor(playButtonForeground);
        if (play)
        {
            g2d.fillPolygon(xPolyPlay, yPolyPlay, 3);
        }
        else
        {
            g2d.fillRect(64, 14, 15, 15);
        }
    }

    // Change from Play to Stop Button
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

    public boolean getPlay()
    {
        return play;
    }

    public void setBackButtonOn()
    {
        backButtonBackground = Color.LIGHT_GRAY;
        backButtonForeground = Color.WHITE;
        repaint();
    }

    public void setBackButtonOff()
    {
        backButtonBackground = Color.WHITE;
        backButtonForeground = Color.GRAY;
        repaint();
    }

    public void setBackButtonClicked()
    {
        backButtonBackground = Color.GRAY;
        backButtonForeground = Color.WHITE;
        repaint();
    }

    public void setPlayButtonOn()
    {
        playButtonBackground = Color.LIGHT_GRAY;
        playButtonForeground = Color.WHITE;
        repaint();
    }

    public void setPlayButtonOff()
    {
        playButtonBackground = Color.WHITE;
        playButtonForeground = Color.GRAY;
        repaint();
    }

    public void setPlayButtonClicked()
    {
        playButtonBackground = Color.GRAY;
        playButtonForeground = Color.WHITE;
        repaint();
    }

    public void setNextButtonOn()
    {
        nextButtonBackground = Color.LIGHT_GRAY;
        nextButtonForeground = Color.WHITE;
        repaint();
    }

    public void setNextButtonOff()
    {
        nextButtonBackground = Color.WHITE;
        nextButtonForeground = Color.GRAY;
        repaint();
    }

    public void setNextButtonClicked()
    {
        nextButtonBackground = Color.GRAY;
        nextButtonForeground = Color.WHITE;
        repaint();
    }
}
