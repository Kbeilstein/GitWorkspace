package teamprojekt.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;

import teamprojekt.control.PseudoCodeButtonHandler;
import teamprojekt.control.SpinnerMinusButtonListener;
import teamprojekt.control.SpinnerPlusButtonListener;
import teamprojekt.control.StartButtonHandler;

@SuppressWarnings("serial")
public class ComboView extends JPanel
{
    final private String[] algorithm =
    { "Lineares Sondieren", "Verallg. Lineares Sondieren", "Quadratisches Sondieren", "alternierendes Quad. Sondieren", "Doppelhashing" };

    public ComboView(MainView panel)
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JComboBox<String> algorithmComboBox = new JComboBox<String>(algorithm);
        algorithmComboBox.setEditable(false);
        algorithmComboBox.setBackground(Color.white);
        algorithmComboBox.setForeground(Color.darkGray);

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

        c.insets = new Insets(10, 10, 20, 10);
        c.gridx = 0;
        c.gridy = 0;
        add(algorithmComboBox, c);

        c.gridy = 1;
        add(spinnerPane, c);

        c.insets = new Insets(30, 0, 0, 0);
        c.gridy = 2;
        add(startButton, c);

        c.insets = new Insets(50, 0, 17, 0);
        c.gridy = 3;
        add(pseudoCodeButton, c);
    }
}
