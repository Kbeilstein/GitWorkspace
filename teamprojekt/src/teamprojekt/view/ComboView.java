package teamprojekt.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboPopup;

import teamprojekt.control.AlgorithmPickListener;
import teamprojekt.control.ArraySizeTextListener;
import teamprojekt.control.HelpButtonListener;
import teamprojekt.control.LogOpenButtonListener;
import teamprojekt.control.PseudoCodeButtonListener;
import teamprojekt.control.SpinnerMinusButtonListener;
import teamprojekt.control.SpinnerPlusButtonListener;
import teamprojekt.control.StartButtonListener;

/**
 * 
 * View zur Darstellung/Anordnung aller Komponenten in der Box oben links
 * 
 */

@SuppressWarnings("serial")
public class ComboView extends JPanel
{
    // vordefinierte Auswahl der verfuegbaren Verfahren
    private static final String[] ALGORITHM =
    { "Lineares Sondieren", "Verallg. Lineares Sondieren", "Quadratisches Sondieren", "Alternierendes Quadr. Sondieren", "Doppel-Hashing" };

    public ComboView(MainView panel)
    {
        // erste ComboBox, Anzeige der verfuegbaren Verfahren
        JComboBox<String> algorithmComboBox = new JComboBox<String>(ALGORITHM);
        algorithmComboBox.setEditable(false);
        algorithmComboBox.setBackground(Color.white);
        algorithmComboBox.setForeground(Color.darkGray);

        Object child = algorithmComboBox.getAccessibleContext().getAccessibleChild(0);
        BasicComboPopup popup = (BasicComboPopup) child;
        JList<?> list = popup.getList();
        list.setSelectionBackground(new Color(210, 210, 210));

        // zweite ComboBox, zur Auswahl der Konstante c, wird nur bei verwendung
        // von verallg. linearem Sondieren verwendet
        JComboBox<Integer> constPick = new JComboBox<Integer>();
        constPick.setEditable(false);
        constPick.setBackground(Color.white);
        constPick.setForeground(Color.darkGray);
        constPick.setEnabled(false);

        Object child2 = constPick.getAccessibleContext().getAccessibleChild(0);
        BasicComboPopup popup2 = (BasicComboPopup) child2;
        JList<?> list2 = popup2.getList();
        list2.setSelectionBackground(new Color(210, 210, 210));

        // Anlegen eines Panel um die 3 Views fuer den Slider richtig zu
        // platzieren
        JPanel spinnerPane = new JPanel();
        spinnerPane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // View fuer den Minus-Button
        SpinnerMinusButtonView minusButtonView = new SpinnerMinusButtonView();
        FlowLayout flowLayout = (FlowLayout) minusButtonView.getLayout();
        flowLayout.setVgap(8);
        flowLayout.setHgap(8);

        // View fuer das Eingabefeld
        SpinnerTextView spinnerTextView = new SpinnerTextView();

        // View fuer den Plus-Button
        SpinnerPlusButtonView plusButtonView = new SpinnerPlusButtonView();
        flowLayout = (FlowLayout) plusButtonView.getLayout();
        flowLayout.setVgap(8);
        flowLayout.setHgap(8);

        // minus-Listener anmelden
        SpinnerMinusButtonListener m = new SpinnerMinusButtonListener(minusButtonView, spinnerTextView);
        minusButtonView.addMouseMotionListener(m);
        minusButtonView.addMouseListener(m);

        // plus-Listener anmelden
        SpinnerPlusButtonListener p = new SpinnerPlusButtonListener(plusButtonView, spinnerTextView);
        plusButtonView.addMouseMotionListener(p);
        plusButtonView.addMouseListener(p);

        // alle Views dem Panel hinzufuegen
        spinnerPane.add(minusButtonView);
        spinnerPane.add(spinnerTextView);
        spinnerPane.add(plusButtonView);

        // Button zum starten des gewaehlten Hash-Verfahrens
        StartButtonView startButton = new StartButtonView();
        StartButtonListener sbl = new StartButtonListener(algorithmComboBox, constPick, spinnerTextView, panel, startButton);
        startButton.addMouseListener(sbl);
        startButton.addMouseMotionListener(sbl);

        // Button zur anzeige des Pseudo-Code Fensters
        PseudoCodeButtonView pseudoCodeButton = new PseudoCodeButtonView();
        PseudoCodeButtonListener pcbl = new PseudoCodeButtonListener(pseudoCodeButton, algorithmComboBox);
        pseudoCodeButton.addMouseListener(pcbl);
        pseudoCodeButton.addMouseMotionListener(pcbl);

        // Buttin zum laden des Log
        LogOpenButtonView logOpenButton = new LogOpenButtonView();
        LogOpenButtonListener lobListener = new LogOpenButtonListener(logOpenButton, sbl);
        logOpenButton.addMouseListener(lobListener);
        logOpenButton.addMouseMotionListener(lobListener);

        // Buttin zum laden des Log
        HelpButtonView helpButton = new HelpButtonView();
        HelpButtonListener helpListener = new HelpButtonListener(helpButton);
        helpButton.addMouseListener(helpListener);
        helpButton.addMouseMotionListener(helpListener);

        // Zeichnen eines Rahmens um die aktuelle View, inkl. Ueberschrift
        Border lineBorder1 = BorderFactory.createLineBorder(Color.BLACK);
        Border titleBorder1 = BorderFactory.createTitledBorder(lineBorder1, "Auswahl");

        setBorder(titleBorder1);

        // Labels zum beschreiben der einzelnen Funktionen
        JLabel selectAlgorithm = new JLabel("Sondierverfahren wählen:");
        JLabel selectArraySize = new JLabel("Arraygröße wählen (5-19):");
        JLabel constPickLabel = new JLabel("geeignetes c wählen:");
        JLabel startButtonLabel = new JLabel("bitte gültigen Wert eingeben");

        // Listener, der bei veraendernung der Arraygroesse die Werte fuer c
        // anpasst
        AlgorithmPickListener algoPickListener = new AlgorithmPickListener(spinnerTextView, algorithmComboBox, constPick, constPickLabel);
        algorithmComboBox.addActionListener(algoPickListener);
        // Listener der die Eingae im Textfeld auf gueltigkeit prueft
        spinnerTextView.getDocument().addDocumentListener(new ArraySizeTextListener(spinnerTextView, startButtonLabel, algoPickListener));

        // einrichten des GridBagLayouts und entsprechendes hinzufuegen der
        // Views
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridy = 0;
        add(selectAlgorithm, c);

        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(2, 10, 10, 10);
        c.gridy = 1;
        add(algorithmComboBox, c);

        c.insets = new Insets(20, 10, 0, 10);
        c.gridy = 2;
        add(selectArraySize, c);

        c.insets = new Insets(2, 10, 10, 10);
        c.gridy = 3;
        add(spinnerPane, c);

        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(10, 10, 0, 10);
        c.gridy = 4;
        add(constPickLabel, c);

        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(5, 10, 20, 10);
        c.gridy = 5;
        add(constPick, c);

        c.insets = new Insets(10, 0, 0, 0);
        c.gridy = 6;
        add(startButtonLabel, c);

        c.gridy = 7;
        add(startButton, c);

        c.insets = new Insets(30, 0, 10, 0);
        c.gridy = 8;
        add(pseudoCodeButton, c);

        c.insets = new Insets(10, 0, 10, 0);
        c.gridy = 9;
        add(logOpenButton, c);

        c.insets = new Insets(10, 0, 17, 0);
        c.gridy = 10;
        add(helpButton, c);
    }
}
