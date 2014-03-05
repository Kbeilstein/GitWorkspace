package teamprojekt.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class HashingView extends JFrame
{
    public HashingView()
    {
        super("Hasing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(0, 2));
        // Neue Views HIER anmelden

        MainView panel = new MainView();
        add(new ComboView(panel));
        add(panel);

        // Variable um die Bildschirmbreite abzuspeichern
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Fenstergröße dem Bildschirm entsprechend anpassen (Breite - 400, Höhe
        // - 200)
        setSize((int) (screenSize.getWidth() - 400), (int) (screenSize.getHeight() - 200));
        // Hauptfenster zentriert positionieren
        setLocation((int) (screenSize.getWidth() / 2 - getSize().getWidth() / 2), (int) (screenSize.getHeight() / 2 - getSize().getHeight() / 2));
        setVisible(true);
    }
}
