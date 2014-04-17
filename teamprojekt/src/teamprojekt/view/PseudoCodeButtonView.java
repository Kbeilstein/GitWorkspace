package teamprojekt.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PseudoCodeButtonView extends JPanel
{

    private Color pseudoButtonForeground;

    private Color pseudoButtonBackground;

    private Color borderColor = Color.darkGray;

    private int x = 1;

    private int xs = x + 1;

    private int y = 1;

    private int ys = y + 1;

    private int width = 125;

    private int widths = width - 1;

    private int height = 20;

    private int heights = height - 1;

    private int arcWidth = 4;

    private int arcHeight = arcWidth;

    private String pseudoButtonText = "Pseudo-Code";

    private int paddingTextX = 11;

    private int paddingTextY = 16;

    public PseudoCodeButtonView()
    {
        setPseudoButtonOff();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(3));
        g2d.setFont(new Font("Verdana", Font.BOLD, 14));

        // PseudoCode-Button
        g2d.setColor(borderColor);
        g2d.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
        g2d.setColor(pseudoButtonBackground);
        g2d.fillRoundRect(xs, ys, widths, heights, arcWidth, arcHeight);
        g2d.setColor(pseudoButtonForeground);
        g2d.drawString(pseudoButtonText, x + paddingTextX, y + paddingTextY);
    }

    public void setPseudoButtonOn()
    {
        pseudoButtonForeground = Color.WHITE;
        pseudoButtonBackground = Color.LIGHT_GRAY;
        repaint();
    }

    public void setPseudoButtonOff()
    {
        pseudoButtonForeground = Color.DARK_GRAY;
        pseudoButtonBackground = Color.WHITE;
        repaint();
    }

    public void setPseudoButtonClicked()
    {
        pseudoButtonForeground = Color.WHITE;
        pseudoButtonBackground = Color.GRAY;
        repaint();
    }
}