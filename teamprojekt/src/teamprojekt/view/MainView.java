package teamprojekt.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainView extends JFrame
{
    public MainView()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new GridLayout(0,2));
        // Neue Views HIER anmelden        
        
        
        

        // ArrayModel arrayModel = new ArrayModel(11);
        //
        // ArrayView aView = new ArrayView(arrayModel.getArray());
        // aView.setMinimumSize(new Dimension(100, 5));
        //
        // Border lineBorder1 = BorderFactory.createLineBorder(Color.BLACK);
        // Border titleBorder1 = BorderFactory.createTitledBorder(lineBorder1,
        // "Array");
        //
        // LogView lv = new LogView();
        // Sondieren sond = new Sondieren(arrayModel, lv, aView);
        //
        // NextButtonView nextB = new NextButtonView(sond);
        // NextButtonHandler nextBHandler = new NextButtonHandler();
        // nextB.addActionListener(nextBHandler);
        //
        // lv.setEditable(false);
        // lv.setAutoscrolls(true);
        //
        // JScrollPane sp = new JScrollPane(lv);
        //
        //
        // JPanel panel = new JPanel();
        // panel.setLayout(null);
        //
        // panel.add(aView);
        // panel.add(nextB);
        // panel.add(sp);
        // panel.setBorder(titleBorder1);
        // add(panel);
        //
        // Insets insets = getInsets();
        // aView.setBounds(40, 5, 400, 50);
        // nextB.setBounds(165, 60 + insets.top, 70, 20);
        // sp.setBounds(5 + insets.left, 90, 410, 200);

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
