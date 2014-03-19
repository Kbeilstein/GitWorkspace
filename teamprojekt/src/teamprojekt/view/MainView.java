package teamprojekt.view;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import teamprojekt.control.AddDeleteButtonHandler;
import teamprojekt.control.ArrayViewListener;
import teamprojekt.control.ControlButtonsListener;
import teamprojekt.model.ArrayModel;
import teamprojekt.model.Sondieren;

@SuppressWarnings("serial")
public class MainView extends JPanel
{
    private static final int FIRST_ROW_HEIGHT = 140;

    private static final int SECOND_ROW_HEIGHT = 30;

    private static final int FIRST_ROW = 15;

    private static final int SECOND_ROW = FIRST_ROW_HEIGHT + FIRST_ROW + 10;

    private static final int THIRD_ROW = SECOND_ROW + SECOND_ROW_HEIGHT;

    public MainView()
    {
        // setLayout(new GridBagLayout());
        setLayout(null);
    }

    public void fill(ArrayModel arrayModel, LogView lv, Sondieren sond)
    {
        removeAll();

        ArrayView aView = new ArrayView(arrayModel, sond);
        arrayModel.addListener(new ArrayViewListener(aView));

        JButton addButton = new JButton("hinzuf\u00FCgen");
        JButton deleteButton = new JButton("l\u00f6schen");

        JLabel textBoxLabel = new JLabel();
        textBoxLabel.setText("Eingabe:");
        TextBoxView textBox = new TextBoxView();
        AddDeleteButtonHandler nextBHandler = new AddDeleteButtonHandler(textBox, sond);
        addButton.addActionListener(nextBHandler);
        deleteButton.addActionListener(nextBHandler);
        lv.setEditable(false);
        lv.setAutoscrolls(true);

        // setLayout(null);
        // GridBagConstraints constraints = new GridBagConstraints();
        // constraints.gridx = 0;
        // constraints.gridy = 0;
        // constraints.gridwidth = GridBagConstraints.RELATIVE;
        // constraints.gridheight = 1;
        // constraints.fill = GridBagConstraints.NONE;
        // constraints.weightx = 0.0;
        // constraints.weighty = 0.0;
        // constraints.anchor = GridBagConstraints.CENTER;
        // constraints.insets = new Insets(0, 0, 0, 0);
        // constraints.ipadx = 660;
        // constraints.ipady = 180;

        JScrollPane sp = new JScrollPane(lv);
        add(aView);
        // add(aView, constraints);
        // constraints = new GridBagConstraints();
        // constraints.gridx = 1;
        // constraints.gridy = 1;
        textBox.setColumns(2);
        JPanel pane = new JPanel();
        pane.setLayout(null);
        pane.add(textBoxLabel);
        // add(textBoxLabel, constraints);
        // constraints.gridx = 2;
        pane.add(textBox);
        // add(textBox, constraints);
        // constraints.gridx = 3;
        pane.add(addButton);
        // add(addButton, constraints);
        // constraints.gridx = 4;
        pane.add(deleteButton);
        // add(deleteButton, constraints);
        //
        // constraints.gridx = 0;
        // constraints.gridy = 2;
        // constraints.gridwidth = GridBagConstraints.RELATIVE;
        // constraints.fill = GridBagConstraints.BOTH;
        ControlButtonsView cbView = new ControlButtonsView();
        ControlButtonsListener ml = new ControlButtonsListener(cbView, sond);
        cbView.addMouseListener(ml);
        cbView.addMouseMotionListener(ml);

        add(cbView);
        add(pane);
        add(sp);
        // add(sp, constraints);
        Border lineBorder1 = BorderFactory.createLineBorder(Color.BLACK);
        Border titleBorder1 = BorderFactory.createTitledBorder(lineBorder1, sond.getName() + " " + Character.toString('\u2013') + " Arraygröße " + arrayModel.getLength());
        setBorder(titleBorder1);

        Insets insets = getInsets();
        aView.setBounds((this.getWidth() - 10 - 660) / 2, FIRST_ROW, 660, FIRST_ROW_HEIGHT);
        cbView.setBounds((this.getWidth() - 10 - 150) / 2, SECOND_ROW - 10, 150, 50);
        pane.setBounds((this.getWidth() - 10 - 400) / 2, SECOND_ROW + 60, 400, 20);
        textBoxLabel.setBounds(24, 0, 50, 20);
        textBox.setBounds(80, 1, 50, 20);
        addButton.setBounds(155, 0, 100, 20);
        deleteButton.setBounds(265, 0, 80, 20);
        sp.setBounds((this.getWidth() - 10 - (this.getWidth() - 40)) / 2 + insets.left, THIRD_ROW + insets.top + 55, this.getWidth() - 40, 190);
        updateUI();
    }
}
