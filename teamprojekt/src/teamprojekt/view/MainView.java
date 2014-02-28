package teamprojekt.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import teamprojekt.control.AddDeleteButtonHandler;
import teamprojekt.control.ArrayViewListener;
import teamprojekt.model.ArrayModel;
import teamprojekt.model.LinearesSondieren;
import teamprojekt.model.Sondieren;

public class MainView extends JFrame
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MainView()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(0, 2));
        // Neue Views HIER anmelden

        add(new ComboView());

        ArrayModel arrayModel = new ArrayModel(11);

        ArrayView aView = new ArrayView(arrayModel.getArray());
        arrayModel.addListener(new ArrayViewListener(aView));
        aView.setMinimumSize(new Dimension(100, 5));

        Border lineBorder1 = BorderFactory.createLineBorder(Color.BLACK);
        Border titleBorder1 = BorderFactory.createTitledBorder(lineBorder1, "Array");

        LogView lv = new LogView();
        Sondieren sond = new LinearesSondieren(arrayModel, lv);

        JButton addButton = new JButton("add");
        JButton deleteButton = new JButton("delete");

        TextBoxView textBox = new TextBoxView();
        AddDeleteButtonHandler nextBHandler = new AddDeleteButtonHandler(textBox, sond);
        addButton.addActionListener(nextBHandler);
        deleteButton.addActionListener(nextBHandler);

        lv.setEditable(false);
        lv.setAutoscrolls(true);

        JScrollPane sp = new JScrollPane(lv);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        panel.add(aView);
        panel.add(textBox);
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(sp);
        panel.setBorder(titleBorder1);
        add(panel);

        Insets insets = getInsets();
        aView.setBounds(40, 5, 400, 50);
        textBox.setBounds(65, 60 + insets.top, 70, 20);
        addButton.setBounds(165, 60 + insets.top, 70, 20);
        deleteButton.setBounds(245, 60 + insets.top, 70, 20);
        sp.setBounds(5 + insets.left, 90, 410, 200);

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
