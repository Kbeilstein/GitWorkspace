package teamprojekt;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class Test extends JFrame
{
    public Test()
    {

        super("Array Liste");
        ArrayModel arrayModel = new ArrayModel(10);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ArrayView aView = new ArrayView(arrayModel.getArray());
        aView.setMinimumSize(new Dimension(100, 5));

        LogView lv = new LogView();
        Sondieren sond = new Sondieren(arrayModel, lv, aView);

        NextButtonView nextB = new NextButtonView(sond);
        NextButtonHandler nextBHandler = new NextButtonHandler();
        nextB.addActionListener(nextBHandler);

        lv.setEditable(false);
        lv.setAutoscrolls(true);

        JScrollPane sp = new JScrollPane(lv);

        // setLayout(new BorderLayout());
        //
        // JPanel centerPanel = new JPanel(new GridLayout(0,1));
        // centerPanel.add(aView);
        // centerPanel.add(nextB);
        //
        // add(centerPanel, BorderLayout.PAGE_START);
        // add(sp, BorderLayout.CENTER);
        setLayout(null);
        add(aView);
        add(nextB);
        add(sp);

        Insets insets = getInsets();
        aView.setBounds(40, 5, 400, 50);
        nextB.setBounds(165, 60 + insets.top, 70, 20);
        sp.setBounds(5 + insets.left, 90, 400, 200);

        setLocation(600, 200);
        setSize(426, 330);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Test();
    }
}
