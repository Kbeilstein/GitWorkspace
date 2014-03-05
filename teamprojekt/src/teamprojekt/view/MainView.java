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

    public MainView()
    {
    }

    public void fill(ArrayModel arrayModel, LogView lv, Sondieren sond)
    {
        removeAll();

        ArrayView aView = new ArrayView(arrayModel.getArray());
        arrayModel.addListener(new ArrayViewListener(aView));

        Border lineBorder1 = BorderFactory.createLineBorder(Color.BLACK);
        Border titleBorder1 = BorderFactory.createTitledBorder(lineBorder1, "Array");

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
        aView.setBounds(40, 15, 600, 50);
        textBoxLabel.setBounds(35, 60 + insets.top, 50, 20);
        textBox.setBounds(95, 60 + insets.top, 50, 20);
        addButton.setBounds(75, 90 + insets.top, 100, 20);
        deleteButton.setBounds(185, 90 + insets.top, 80, 20);
        sp.setBounds(5 + insets.left, 130 + insets.top, 410, 200);
        updateUI();
    }
}
