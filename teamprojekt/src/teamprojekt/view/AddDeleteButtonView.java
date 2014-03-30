package teamprojekt.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AddDeleteButtonView extends JPanel
{
    private Color insertForeground;

    private Color insertBackground;

    private Color searchForeground;

    private Color searchBackground;

    private Color deleteForeground;

    private Color deleteBackground;

    private Color borderColor = Color.darkGray;

    private int x = 1;

    private int xs = x + 1;

    private int y = 1;

    private int ys = y + 1;

    private int width = 100;

    private int widths = width - 1;

    private int height = 20;

    private int heights = height - 1;

    private int arcWidth = 2;

    private int arcHeight = arcWidth;

    private String insertButtonText = "hinzuf\u00fcgen";

    private String searchButtonText = "suchen";

    private String deleteButtonText = "l\u00f6schen";

    private int paddingB = width + 20;

    private int paddingText = 16;

    private int paddingTexts = 7;

    public AddDeleteButtonView()
    {
        setInsertButtonOff();
        setSearchButtonOff();
        setDeleteButtonOff();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(3));
        g2d.setFont(new Font("Verdana", Font.BOLD, 14));

        // Insert-Button
        g2d.setColor(borderColor);
        g2d.drawRoundRect(x, y, width + 10, height, arcWidth, arcHeight);
        g2d.setColor(insertBackground);
        g2d.fillRoundRect(xs, ys, widths + 10, heights, arcWidth, arcHeight);
        g2d.setColor(insertForeground);
        g2d.drawString(insertButtonText, x + paddingTexts + 5, y + paddingText);

        // Search-Button
        g2d.setColor(borderColor);
        g2d.drawRoundRect(x + paddingB + 5, y, width, height, arcWidth, arcHeight);
        g2d.setColor(searchBackground);
        g2d.fillRoundRect(xs + paddingB + 5, ys, widths, heights, arcWidth, arcHeight);
        g2d.setColor(searchForeground);
        g2d.drawString(searchButtonText, x + paddingB + paddingText + paddingTexts + 5, y + paddingText);

        // Delete-Button
        g2d.setColor(borderColor);
        g2d.drawRoundRect(x + paddingB * 2, y, width, height, arcWidth, arcHeight);
        g2d.setColor(deleteBackground);
        g2d.fillRoundRect(xs + paddingB * 2, ys, widths, heights, arcWidth, arcHeight);
        g2d.setColor(deleteForeground);
        g2d.drawString(deleteButtonText, x + paddingB * 2 + paddingText + paddingTexts, y + paddingText);
    }

    public void setInsertButtonOn()
    {
        insertForeground = Color.WHITE;
        insertBackground = Color.LIGHT_GRAY;
        repaint();
    }

    public void setInsertButtonOff()
    {
        insertForeground = Color.DARK_GRAY;
        insertBackground = Color.WHITE;
        repaint();
    }

    public void setInsertButtonClicked()
    {
        insertForeground = Color.WHITE;
        insertBackground = Color.GRAY;
        repaint();
    }

    public void setSearchButtonOn()
    {
        searchForeground = Color.WHITE;
        searchBackground = Color.LIGHT_GRAY;
        repaint();
    }

    public void setSearchButtonOff()
    {
        searchForeground = Color.DARK_GRAY;
        searchBackground = Color.WHITE;
        repaint();
    }

    public void setSearchButtonClicked()
    {
        searchForeground = Color.WHITE;
        searchBackground = Color.GRAY;
        repaint();
    }

    public void setDeleteButtonOn()
    {
        deleteForeground = Color.WHITE;
        deleteBackground = Color.LIGHT_GRAY;
        repaint();
    }

    public void setDeleteButtonOff()
    {
        deleteForeground = Color.DARK_GRAY;
        deleteBackground = Color.WHITE;
        repaint();
    }

    public void setDeleteButtonClicked()
    {
        deleteForeground = Color.WHITE;
        deleteBackground = Color.GRAY;
        repaint();
    }
}
