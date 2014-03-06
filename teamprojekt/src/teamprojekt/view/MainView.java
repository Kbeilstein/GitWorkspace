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
import teamprojekt.model.ArrayModel;
import teamprojekt.model.Sondieren;

public class MainView extends JPanel
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final int firstRowHeight = 100;

    private static final int secondRowHeight = 30;

    private static final int firstRow = 15;

    private static final int secondRow = firstRowHeight;

    private static final int thirdRow = firstRowHeight + secondRowHeight;

    public MainView()
    {
    }

    public void fill(ArrayModel arrayModel, LogView lv, Sondieren sond)
    {
        removeAll();

        ArrayView aView = new ArrayView(arrayModel.getArray());
        arrayModel.addListener(new ArrayViewListener(aView));

        Border lineBorder1 = BorderFactory.createLineBorder(Color.BLACK);
        Border titleBorder1 = BorderFactory.createTitledBorder(lineBorder1, sond.getName() + " " + Character.toString('\u2013') + " Arraygröße " + arrayModel.getLength());

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

        setLayout(null);

        JScrollPane sp = new JScrollPane(lv);
        add(aView);

        textBox.setColumns(2);
        add(textBoxLabel);
        add(textBox);
        add(addButton);
        add(deleteButton);

        add(sp);
        setBorder(titleBorder1);

        Insets insets = getInsets();
        aView.setBounds(10, firstRow, 620, firstRowHeight);
        textBoxLabel.setBounds(30, secondRow + insets.top, 50, 20);
        textBox.setBounds(90, secondRow + insets.top, 50, 20);
        addButton.setBounds(155, secondRow + insets.top, 100, 20);
        deleteButton.setBounds(265, secondRow + insets.top, 80, 20);
        sp.setBounds(5 + insets.left, thirdRow + insets.top, 410, 200);
        updateUI();
    }
}
