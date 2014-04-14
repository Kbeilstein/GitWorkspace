package teamprojekt.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import teamprojekt.control.ArraySizeTextListener;
import teamprojekt.control.PseudoCodeButtonHandler;
import teamprojekt.control.SpinnerMinusButtonListener;
import teamprojekt.control.SpinnerPlusButtonListener;
import teamprojekt.control.StartButtonHandler;

@SuppressWarnings("serial")
public class ComboView extends JPanel
{
    private static final String[] ALGORITHM =
    { "Lineares Sondieren", "Verallg. Lineares Sondieren", "Quadratisches Sondieren", "Alternierendes Quadr. Sondieren", "Doppel-Hashing" };

    public ComboView(MainView panel)
    {
        JComboBox<String> algorithmComboBox = new JComboBox<String>(ALGORITHM);
        algorithmComboBox.setEditable(false);
        algorithmComboBox.setBackground(Color.white);
        algorithmComboBox.setForeground(Color.darkGray);

        JComboBox<Integer> constPick = new JComboBox<Integer>();
        constPick.setEditable(false);
        constPick.setBackground(Color.white);
        constPick.setForeground(Color.darkGray);
        constPick.setEnabled(false);

        JPanel spinnerPane = new JPanel();
        spinnerPane.setLayout(new FlowLayout(FlowLayout.CENTER));

        SpinnerMinusButtonView minusButtonView = new SpinnerMinusButtonView();
        FlowLayout flowLayout = (FlowLayout) minusButtonView.getLayout();
        flowLayout.setVgap(8);
        flowLayout.setHgap(8);

        SpinnerTextView spinnerTextView = new SpinnerTextView();

        SpinnerPlusButtonView plusButtonView = new SpinnerPlusButtonView();
        flowLayout = (FlowLayout) plusButtonView.getLayout();
        flowLayout.setVgap(8);
        flowLayout.setHgap(8);

        SpinnerMinusButtonListener m = new SpinnerMinusButtonListener(minusButtonView, spinnerTextView);
        minusButtonView.addMouseMotionListener(m);
        minusButtonView.addMouseListener(m);

        SpinnerPlusButtonListener p = new SpinnerPlusButtonListener(plusButtonView, spinnerTextView);
        plusButtonView.addMouseMotionListener(p);
        plusButtonView.addMouseListener(p);

        spinnerPane.add(minusButtonView);
        spinnerPane.add(spinnerTextView);
        spinnerPane.add(plusButtonView);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new StartButtonHandler(algorithmComboBox, spinnerTextView, panel));

        JButton pseudoCodeButton = new JButton("Pseudo Code");
        pseudoCodeButton.addActionListener(new PseudoCodeButtonHandler(algorithmComboBox));

        Border lineBorder1 = BorderFactory.createLineBorder(Color.BLACK);
        Border titleBorder1 = BorderFactory.createTitledBorder(lineBorder1, "Auswahl");

        setBorder(titleBorder1);

        JLabel selectAlgorithm = new JLabel("Sondierverfahren wählen:");
        JLabel selectArraySize = new JLabel("Arraygröße wählen (5-19):");
        JLabel constPickLabel = new JLabel("geeignetes c wählen:");
        JLabel startButtonLabel = new JLabel("bitte gültigen Wert eingeben");

        AlgorithmPickListener algoPickListener = new AlgorithmPickListener(spinnerTextView, algorithmComboBox, constPick, constPickLabel);
        algorithmComboBox.addActionListener(algoPickListener);
        spinnerTextView.getDocument().addDocumentListener(new ArraySizeTextListener(spinnerTextView, startButton, startButtonLabel, algoPickListener));

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

        c.insets = new Insets(10, 0, 0, 0);
        c.gridy = 7;
        add(startButton, c);

        c.insets = new Insets(30, 0, 17, 0);
        c.gridy = 8;
        add(pseudoCodeButton, c);
    }
}
