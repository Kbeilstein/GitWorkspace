package teamprojekt.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class LegendView extends JLabel
{
    private int x = 30;

    private int xs = x + 1;

    private int y = 30;

    private int ys = y + 1;

    private int width = 25;

    private int widths = width - 2;

    private int height = width;

    private int heights = height - 2;

    private int paddyingY = 18;

    private int paddyingX = 200;

    private int paddingText = 160;

    private static final Color GREEN = new Color(90, 200, 100);

    private static final Color RED = new Color(220, 70, 50);

    public LegendView()
    {
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
        Border titleBorder1 = BorderFactory.createTitledBorder(lineBorder, "Legende");
        setBorder(titleBorder1);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("Verdana", Font.BOLD, 14));

        // Legende der ArrayView gruen bei "einfuegen"
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x, y, width, height);
        g2d.setColor(GREEN);
        g2d.fillRect(xs, ys, widths, heights);

        // Legende der ArrayView rot bei "Kollision"
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x + paddyingX, y, width, height);
        g2d.setColor(RED);
        g2d.fillRect(xs + paddyingX, ys, widths, heights);

        // Legende der ArrayView cyan bei "gefunden"
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x + paddyingX * 2, y, width, height);
        g2d.setColor(Color.CYAN);
        g2d.fillRect(xs + paddyingX * 2, ys, widths, heights);

        // Legende der ArrayView magenta bei "nicht gefunden"
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x + paddyingX * 3, y, width, height);
        g2d.setColor(Color.MAGENTA);
        g2d.fillRect(xs + paddyingX * 3, ys, widths, heights);

        // Legende der ArrayView orange bei gelöscht
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x + paddyingX * 4, y, width, height);
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(xs + paddyingX * 4, ys, widths, heights);

        // Beschriftung der einzelnen Farben und deren Bedeutung
        g2d.setColor(Color.DARK_GRAY);
        g2d.drawString("einf\u00fcgen", x + paddyingX - paddingText, y + paddyingY);
        g2d.drawString("Kollision", x + paddyingX * 2 - paddingText, y + paddyingY);
        g2d.drawString("gefunden", x + paddyingX * 3 - paddingText, y + paddyingY);
        g2d.drawString("nicht gefunden", x + paddyingX * 4 - paddingText, y + paddyingY);
        g2d.drawString("gel\u00f6scht", x + paddyingX * 5 - paddingText, y + paddyingY);

    }
}
