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
    private int width = 25;

    private int widthSmall = width - 2;

    private int height = width;

    private int heightSmall = height - 2;

    private int paddyingY = 18;

    private int paddyingX = 200;

    private int paddingText = 34;

    private static final Color INSERT_FREE = new Color(90, 200, 100);

    private static final Color INSERT_COLLISION = new Color(220, 70, 50);

    private static final Color SEARCH_NOT_FOUND = new Color(255, 150, 100);

    private static final Color SEARCH_AND_FOUND = new Color(110, 180, 255);

    private static final Color DELETE = Color.ORANGE;

    public LegendView()
    {
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
        Border titleBorder1 = BorderFactory.createTitledBorder(lineBorder, "Legende");
        setBorder(titleBorder1);
    }

    public void paintComponent(Graphics g)
    {
        // Variabeln werden erst hier deklariert und initialisiert, damit
        // dynamisch auf eine Veränderung vom Layout reagiert werden kann
        int y = this.getHeight() / 2 - 8;
        int ySmall = y + 1;

        int x = this.getWidth() / 2 - 470;
        int xSmall = x + 1;

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("Verdana", Font.PLAIN, 12));

        // Legende der ArrayView gruen bei "einfuegen"
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x, y, width, height);
        g2d.setColor(INSERT_FREE);
        g2d.fillRect(xSmall, ySmall, widthSmall, heightSmall);

        // Legende der ArrayView rot bei "Kollision"
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x + paddyingX - 30, y, width, height);
        g2d.setColor(INSERT_COLLISION);
        g2d.fillRect(xSmall + paddyingX - 30, ySmall, widthSmall, heightSmall);

        // Legende der ArrayView cyan bei "gefunden"
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x + paddyingX * 2, y, width, height);
        g2d.setColor(SEARCH_AND_FOUND);
        g2d.fillRect(xSmall + paddyingX * 2, ySmall, widthSmall, heightSmall);

        // Legende der ArrayView magenta bei "nicht gefunden"
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x + paddyingX * 3 - 40, y, width, height);
        g2d.setColor(SEARCH_NOT_FOUND);
        g2d.fillRect(xSmall + paddyingX * 3 - 40, ySmall, widthSmall, heightSmall);

        // Legende der ArrayView orange bei gelöscht
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x + paddyingX * 4 - 20, y, width, height);
        g2d.setColor(DELETE);
        g2d.fillRect(xSmall + paddyingX * 4 - 20, ySmall, widthSmall, heightSmall);

        // Beschriftung der einzelnen Farben und deren Bedeutung
        g2d.setColor(Color.BLACK);
        g2d.drawString("einf\u00fcgen m\u00f6glich", x + paddingText, y + paddyingY);
        g2d.drawString("Feld schon belegt, Kollision", x + paddyingX + paddingText - 30, y + paddyingY);
        g2d.drawString("gesuchter Wert", x + paddyingX * 2 + paddingText, y + paddyingY);
        g2d.drawString("ungleich gesuchtem Wert", x + paddyingX * 3 - 40 + paddingText, y + paddyingY);
        g2d.drawString("als gel\u00f6scht markiert", x + paddyingX * 4 - 20 + paddingText, y + paddyingY);

    }
}
