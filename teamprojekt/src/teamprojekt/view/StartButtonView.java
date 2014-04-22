package teamprojekt.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartButtonView extends JPanel
{
    private Color startButtonForeground;

    private Color startButtonBackground;

    private Color borderColor = Color.darkGray;

    private int x = 1;

    private int xs = x + 1;

    private int y = 1;

    private int ys = y + 1;

    private int width = 90;

    private int widths = width - 1;

    private int height = 26;

    private int heights = height - 1;

    private int arcWidth = 4;

    private int arcHeight = arcWidth;

    private String startButtonText = "Start";

    private int paddingTextX = 19;

    private int paddingTextY = 20;

    public StartButtonView()
    {
        setStartButtonOff();
        setPreferredSize(new Dimension(93, 29));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(3));

        g2d.setFont(new Font("Verdana", Font.PLAIN, 18));

        // Start-Button
        g2d.setColor(borderColor);
        g2d.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
        g2d.setColor(startButtonBackground);
        g2d.fillRoundRect(xs, ys, widths, heights, arcWidth, arcHeight);
        g2d.setColor(startButtonForeground);

        Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
        attributes.put(TextAttribute.TRACKING, 0.1);
        Font font2 = g2d.getFont().deriveFont(attributes);
        g2d.setFont(font2);

        g2d.drawString(startButtonText, x + paddingTextX, y + paddingTextY);
    }

    public void setStartButtonOn()
    {
        startButtonForeground = Color.WHITE;
        startButtonBackground = Color.LIGHT_GRAY;
        repaint();
    }

    public void setStartButtonOff()
    {
        startButtonForeground = Color.DARK_GRAY;
        startButtonBackground = Color.WHITE;
        repaint();
    }

    public void setStartButtonClicked()
    {
        startButtonForeground = Color.WHITE;
        startButtonBackground = Color.GRAY;
        repaint();
    }

}