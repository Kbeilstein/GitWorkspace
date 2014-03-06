package teamprojekt.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class HashingView extends JFrame
{
    public HashingView()
    {
        super("Hasing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        // Neue Views HIER anmelden

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.insets = new Insets(10, 10, 10, 0);

        MainView panel = new MainView();
        add(new ComboView(panel), constraints);
        setBackground(Color.white);
        constraints.gridx = GridBagConstraints.RELATIVE;
        constraints.anchor = GridBagConstraints.FIRST_LINE_END;
        constraints.gridheight = 3;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.ipadx = 700;
        constraints.ipady = 440;
        add(panel, constraints);

        // Variable um die Bildschirmbreite abzuspeichern
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setMinimumSize(new Dimension(990, 500));
        setLocationRelativeTo(panel);

        // Fenstergröße dem Bildschirm entsprechend anpassen (Breite - 400, Höhe
        // - 200)
        // setSize((int) (screenSize.getWidth() - 400), (int)
        // (screenSize.getHeight() - 200));
        // Hauptfenster zentriert positionieren
        setLocation((int) (screenSize.getWidth() / 2 - getSize().getWidth() / 2), (int) (screenSize.getHeight() / 2 - getSize().getHeight() / 2));
        setVisible(true);
    }
}
