package teamprojekt.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import teamprojekt.control.AddDeleteListener;
import teamprojekt.control.AnimationSpeedListener;
import teamprojekt.control.ArrayViewListener;
import teamprojekt.control.ControlButtonsListener;
import teamprojekt.model.ArrayModel;
import teamprojekt.model.Sondieren;

@SuppressWarnings("serial")
public class MainView extends JPanel
{
    private static final int FIRST_ROW_HEIGHT = 160;

    private static final int SECOND_ROW_HEIGHT = 30;

    private static final int FIRST_ROW = 15;

    private static final int SECOND_ROW = FIRST_ROW_HEIGHT + FIRST_ROW + 10;

    private static final int THIRD_ROW = SECOND_ROW + SECOND_ROW_HEIGHT;

    public MainView()
    {
        setLayout(null);
    }

    public void fill(ArrayModel arrayModel, LogView lv, Sondieren sond)
    {
        removeAll();

        ArrayView aView = new ArrayView(arrayModel, sond);
        arrayModel.addListener(new ArrayViewListener(aView));

        JLabel textBoxLabel = new JLabel();
        textBoxLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        textBoxLabel.setText("Eingabe:");
        textBoxLabel.setToolTipText("Zahlen von 1-99");
        InsertValueTextBoxView textBox = new InsertValueTextBoxView();

        JScrollPane sp = new JScrollPane(lv);
        sp.setAutoscrolls(true);
        textBox.setColumns(2);

        AddDeleteButtonView adbView = new AddDeleteButtonView();
        AddDeleteListener adl = new AddDeleteListener(adbView, textBox, sond);

        adbView.addMouseMotionListener(adl);
        adbView.addMouseListener(adl);

        ControlButtonsView cbView = new ControlButtonsView();
        ControlButtonsListener ml = new ControlButtonsListener(cbView, sond, arrayModel);
        cbView.addMouseListener(ml);
        cbView.addMouseMotionListener(ml);
        sond.addListener(ml);

        // Pane für Wert-Eingabe Feld und hinzufügen-suchen-löschen Buttons
        JPanel pane = new JPanel();
        pane.setLayout(null);
        pane.add(textBoxLabel);
        pane.add(textBox);
        pane.add(adbView);
        // JSlider slider = new JSlider(0, 30, 15);
        // AnimationSpeedListener asl = new AnimationSpeedListener(arrayModel);
        // slider.addChangeListener(asl);
        // // der Listener wird zum richtigen initialiseren des Startwertes
        // // einmalig von Hand ausgeführt
        // asl.stateChanged(new ChangeEvent(slider));

        AnimationSpeedSliderView slider = new AnimationSpeedSliderView();
        AnimationSpeedListener asl = new AnimationSpeedListener(arrayModel, slider);
        slider.addMouseListener(asl);
        slider.addMouseMotionListener(asl);

        // alle angelegten Views werden zur "Hauptpane" hinzugefügt
        add(aView);
        add(cbView);
        add(pane);
        add(slider);
        add(sp);

        // Rahmen der das Panel umgibt und das aktuelle Sondierverfahren und die
        // Arraygröße angibt
        Border lineBorder1 = BorderFactory.createLineBorder(Color.BLACK);
        Border titleBorder1 = BorderFactory.createTitledBorder(lineBorder1, sond.getName() + " " + Character.toString('\u2013') + " Arraygröße " + arrayModel.getLength());
        setBorder(titleBorder1);

        Insets insets = getInsets();
        aView.setBounds((this.getWidth() - 10 - 900) / 2, FIRST_ROW, 900, FIRST_ROW_HEIGHT);
        cbView.setBounds((this.getWidth() - 10 - 250) / 2, SECOND_ROW - 10, 150, 50);
        slider.setBounds((this.getWidth() + 50) / 2, SECOND_ROW - 10, 200, 50);
        pane.setBounds((this.getWidth() - 10 - 500) / 2, SECOND_ROW + 60, 700, 30);
        textBoxLabel.setBounds(10, 2, 70, 20);
        textBox.setBounds(80, 1, 50, 24);
        adbView.setBounds(155, 1, 360, 30);        
        sp.setBounds((this.getWidth() - 10 - (this.getWidth() - 40)) / 2 + insets.left, THIRD_ROW + insets.top + 60, this.getWidth() - 40, 260);
        updateUI();
    }
}
