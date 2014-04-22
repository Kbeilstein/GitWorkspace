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

import teamprojekt.control.ArraySizeTextListener;
import teamprojekt.control.PseudoCodeButtonListener;
import teamprojekt.control.SpinnerMinusButtonListener;
import teamprojekt.control.SpinnerPlusButtonListener;
import teamprojekt.control.StartButtonListener;

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

        Object child = algorithmComboBox.getAccessibleContext().getAccessibleChild(0);
        BasicComboPopup popup = (BasicComboPopup) child;
        JList<?> list = popup.getList();
        list.setSelectionBackground(new Color(210, 210, 210));

        JComboBox<Integer> constPick = new JComboBox<Integer>();
        constPick.setEditable(false);
        constPick.setBackground(Color.white);
        constPick.setForeground(Color.darkGray);
        constPick.setEnabled(false);

        Object child2 = constPick.getAccessibleContext().getAccessibleChild(0);
        BasicComboPopup popup2 = (BasicComboPopup) child2;
        JList<?> list2 = popup2.getList();
        list2.setSelectionBackground(new Color(210, 210, 210));

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

        // JButton startButton = new JButton("Start");
        // startButton.addActionListener(new
        // StartButtonHandler(algorithmComboBox, spinnerTextView, panel));
        //
        // JButton pseudoCodeButton = new JButton("Pseudo Code");
        // pseudoCodeButton.addActionListener(new
        // PseudoCodeButtonHandler(algorithmComboBox));

        StartButtonView startButton = new StartButtonView();
        StartButtonListener sbl = new StartButtonListener(algorithmComboBox, spinnerTextView, panel, startButton);
        startButton.addMouseListener(sbl);
        startButton.addMouseMotionListener(sbl);

        PseudoCodeButtonView pseudoCodeButton = new PseudoCodeButtonView();
        PseudoCodeButtonListener pcbl = new PseudoCodeButtonListener(pseudoCodeButton);
        pseudoCodeButton.addMouseListener(pcbl);
        pseudoCodeButton.addMouseMotionListener(pcbl);

        Border lineBorder1 = BorderFactory.createLineBorder(Color.BLACK);
        Border titleBorder1 = BorderFactory.createTitledBorder(lineBorder1, "Auswahl");

        setBorder(titleBorder1);

        JLabel selectAlgorithm = new JLabel("Sondierverfahren wählen:");
        JLabel selectArraySize = new JLabel("Arraygröße wählen (5-19):");
        JLabel constPickLabel = new JLabel("geeignetes c wählen:");
        JLabel startButtonLabel = new JLabel("bitte gültigen Wert eingeben");

        AlgorithmPickListener algoPickListener = new AlgorithmPickListener(spinnerTextView, algorithmComboBox, constPick, constPickLabel);
        algorithmComboBox.addActionListener(algoPickListener);
        spinnerTextView.getDocument().addDocumentListener(new ArraySizeTextListener(spinnerTextView, startButtonLabel, algoPickListener));

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
