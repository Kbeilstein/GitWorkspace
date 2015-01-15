package teamprojekt.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

import teamprojekt.control.AddDeleteListener;
import teamprojekt.control.AnimationSpeedListener;
import teamprojekt.control.ArrayViewListener;
import teamprojekt.control.ControlButtonsListener;
import teamprojekt.control.LogSaveButtonListener;
import teamprojekt.control.MainViewResizeListener;
import teamprojekt.model.ArrayModel;
import teamprojekt.model.Sondieren;

/**
 * 
 * View zur Darstellung/Anordnung der Komponenten des eigentlichen Hauptteils
 * 
 * die Klasse ist zunaechst ohne Inhalt, erst nach druecken des Start-Buttons
 * wird entsprechend der gewaehlten Optionen die Views angelegt
 * 
 */

@SuppressWarnings("serial")
public class MainView extends JPanel
{
    public void fill(ArrayModel arrayModel, LogView lv, Sondieren sond)
    {
        // vor neuzeichnen wird erstmal alles "alte" entfernt
        removeAll();

        // View die das Array zeichnet wird angelegt + Listener dem Model
        // hinzugefuegt
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

        AnimationSpeedSliderView slider = new AnimationSpeedSliderView();
        AnimationSpeedListener asl = new AnimationSpeedListener(arrayModel, slider);
        slider.addMouseListener(asl);
        slider.addMouseMotionListener(asl);
        slider.setToolTipText("Animationsgeschwindigkeit");

        // Panel zur Anzeige von Animationssteuerungs-Buttons und Slider
        JPanel anicontrolPanel = new JPanel();
        anicontrolPanel.setLayout(null);
        anicontrolPanel.add(cbView);
        anicontrolPanel.add(slider);

        // Pane für Wert-Eingabe Feld und hinzufügen-suchen-löschen Buttons
        JPanel valueInSeDelPanel = new JPanel();
        valueInSeDelPanel.setLayout(null);
        valueInSeDelPanel.add(textBoxLabel);
        valueInSeDelPanel.add(textBox);
        valueInSeDelPanel.add(adbView);

        valueInSeDelPanel.addComponentListener(new MainViewResizeListener(cbView, slider, this, textBoxLabel, textBox, adbView));

        LogSaveButtonView lsbView = new LogSaveButtonView();
        LogSaveButtonListener lsbListener = new LogSaveButtonListener(lsbView, lv);
        lsbView.addMouseListener(lsbListener);
        lsbView.addMouseMotionListener(lsbListener);

        JLabel formula = new JLabel();
        formula.setFont(new Font("Verdana", Font.PLAIN, 14));
        formula.setForeground(Color.DARK_GRAY);
        formula.setText("Algorithmus: hi(x) = " + sond.getFormula());

        // Rahmen der das Panel umgibt und das aktuelle Sondierverfahren und die
        // Arraygröße angibt
        Border lineBorder1 = BorderFactory.createLineBorder(Color.BLACK);
        Border titleBorder1 = BorderFactory.createTitledBorder(lineBorder1, sond.getName() + " " + Character.toString('\u2013') + " Arraygröße " + arrayModel.getLength());
        setBorder(titleBorder1);

        /** @formatter:off **/
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout.createSequentialGroup().addGap(12).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lsbView, GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE).addComponent(aView, GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE).addComponent(anicontrolPanel, GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE).addComponent(valueInSeDelPanel, GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE).addGroup(groupLayout.createSequentialGroup().addComponent(sp).addPreferredGap(ComponentPlacement.RELATED)).addComponent(formula)).addGap(10)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(formula).addPreferredGap(ComponentPlacement.RELATED).addComponent(aView, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE).addGap(10).addComponent(anicontrolPanel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE).addGap(10).addComponent(valueInSeDelPanel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(sp, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE).addPreferredGap(ComponentPlacement.RELATED).addComponent(lsbView, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE).addGap(8)));
        /** @formatter:on **/
        setLayout(groupLayout);
    }
}
