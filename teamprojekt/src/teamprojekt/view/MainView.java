package teamprojekt.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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
        aView.setMinimumSize(new Dimension(100, 5));

        Border lineBorder1 = BorderFactory.createLineBorder(Color.BLACK);
        Border titleBorder1 = BorderFactory.createTitledBorder(lineBorder1, "Array");

        JButton addButton = new JButton("add");
        JButton deleteButton = new JButton("delete");

        TextBoxView textBox = new TextBoxView();
        AddDeleteButtonHandler nextBHandler = new AddDeleteButtonHandler(textBox, sond);
        addButton.addActionListener(nextBHandler);
        deleteButton.addActionListener(nextBHandler);

        lv.setEditable(false);
        lv.setAutoscrolls(true);

        JScrollPane sp = new JScrollPane(lv);

        setLayout(null);

        add(aView);
        add(textBox);
        add(addButton);
        add(deleteButton);
        add(sp);
        setBorder(titleBorder1);

        Insets insets = getInsets();
        aView.setBounds(40, 5, 400, 50);
        textBox.setBounds(65, 60 + insets.top, 70, 20);
        addButton.setBounds(165, 60 + insets.top, 70, 20);
        deleteButton.setBounds(245, 60 + insets.top, 70, 20);
        sp.setBounds(5 + insets.left, 90, 410, 200);
        updateUI();
    }
}
