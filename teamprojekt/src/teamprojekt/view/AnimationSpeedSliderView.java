package teamprojekt.view;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Klasse die zur Darstellung des Slider verwendet wird
 **/

@SuppressWarnings("serial")
public class AnimationSpeedSliderView extends JPanel
{
    private int lineX;

    private static final int PADDING_X = 20;

    public AnimationSpeedSliderView()
    {
        setSize(200, 50);
        lineX = (int) (getSize().getWidth() / 2);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setFont(new Font("Verdana", Font.PLAIN, 10));
        g.drawString("schneller", 5, 8);
        g.fillRect(PADDING_X, (getHeight() / 2) - 1, this.getWidth() - PADDING_X * 2, 3);
        g.drawLine(lineX, 15, lineX, this.getHeight() - 15);
        g.drawString("langsamer", this.getWidth() - 70, 8);
    }

    // Methode um die X-Achse des "Schiebers" von Aussen zu veraendern
    public void setLine(int newX)
    {
        lineX = newX;
        repaint();
    }

    // gibt das festgelegte Padding zurueck, wird vom Listener verwendet um die
    // Linie korrekt zu zeichnen
    public int getPaddingX()
    {
        return PADDING_X;
    }

    // gibt die aktuelle Position der Linie zurueck, wird beim Initialisieren
    // vom Listener benoetigt, damit die Anfangsgeschwindigkeit mit der
    // Slider-Position uebereinstimmt
    public int getLineX()
    {
        return lineX;
    }
}
