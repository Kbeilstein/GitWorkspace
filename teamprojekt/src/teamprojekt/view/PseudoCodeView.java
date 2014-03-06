package teamprojekt.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PseudoCodeView extends JFrame
{
    private JComboBox<String> cbVerfahren;

    private String tab = "     ";

    // private String codeLS =
    // tab + "hi(x) = (h(x) + i) mod m\n"
    // + tab + "h0(x) = h(x)\n\n"
    // + "Hinzufuegen:\n"
    // + tab + "gehe durch das Array, sollange ein Platz frei ist\n"
    // + tab + "wenn ein freier Platz gefunden ist"
    // + tab + "fuege den Wert in das Array[i] ein\n"
    // + tab + "oder das Array ist voll\n"
    // + "Suchen: \n"
    // + tab + "suche ab der Startposition (x mod n-1)\n"
    // + tab + "gehe durch das Array, bis zu einer Uebereinstimmung\n"
    // + tab + "gebe Position zurück (oder Wert nicht vorhanden)\n"
    // + "Loeschen:\n"
    // + tab + "suche ab der Startposition (x mod n-1)\n"
    // + tab + "gehe durch das Array, bis zu einer Uebereinstimmung\n"
    // + tab + "loesche an der Position den Wert (oder Wert nicht vorhanden)\n";

    private String codeLS = "" + "Suchen:\n\tPosition = Wert mod A.size()" + "\n" + tab + "i=1" + "\n" + tab + "loop(i < A.size  UND  A[Position] != Wert  UND  A[Position] != 0)" + "\n" + tab + "{ Position = ((Wert mod A.size) + i) mod A.size); i++ }" + "\n" + tab + "return Position" + "\n\n" + "Hinzufuegen:" + "\n" + tab + "search(Wert)" + "\n" + tab + "if(A != full  UND  Wert nicht im Array)" + "\n" + tab + "{A.setValueAt(Position, Wert)}" + "\n\n" + "Loeschen:" + "\n" + tab + "search(Wert)" + "\n" + tab + "if(Wert im Array)" + "\n" + tab + "{A.delet(Wert)}" + "\n\n";

    private String codeErwLS = "" + "Suchen:" + "\n" + tab + "Position = Wert mod A.size()" + "\n" + tab + "i=1" + "\n" + tab + "loop(i < A.size  UND  A[Position] != Wert  UND  A[Position] != 0)" + "\n" + tab + "{ Position = ((Wert mod A.size) + c * i) mod A.size); i++ }" + "\n" + tab + "return Position" + "\n\n" + "Hinzufuegen:" + "\n" + tab + "search(Wert)" + "\n" + tab + "if(A != full  UND  Wert nicht im Array)" + "\n" + tab + "{A.setValueAt(Position, Wert)}" + "\n\n" + "Loeschen:" + "\n" + tab + "search(Wert)" + "\n" + tab + "if(Wert im Array)" + "\n" + tab + "{A.delet(Wert)}" + "\n\n";

    private String codeQS = "" + "Suchen:" + "\n" + tab + "Position = Wert mod A.size()" + "\n" + tab + "i=1" + "\n" + tab + "loop(i < A.size  &&  A[Position] != Wert  && A[Position] != 0)" + "\n" + tab + "{ Position = ((Wert mod A.size) + i) mod A.size); i++ }" + "\n" + tab + "return Position" + "\n\n" + "Hinzufuegen:" + "\n" + tab + "Position = Wert mod A.size()" + "\n" + tab + "i=1" + "\n" + tab + "loop(i < A.size  &&  A[Position] != Wert  && A[Position] != 0)" + "\n" + tab + "{ Position = ((Wert mod A.size) + i) mod A.size); i++ }" + "\n" + tab + "return Position" + "\n\n" + "Loeschen:" + "\n" + tab + "Position = Wert mod A.size()" + "\n" + tab + "i=1" + "\n" + tab + "loop(i < A.size  &&  A[Position] != Wert  && A[Position] != 0)" + "\n" + tab + "{ Position = ((Wert mod A.size) + i) mod A.size); i++ }" + "\n" + tab + "return Position" + "\n\n";

    private String codeAltQS = "" + "Suchen:" + "\n" + tab + "Position = Wert mod A.size()" + "\n" + tab + "i=1" + "\n" + tab + "loop(i < A.size  &&  A[Position] != Wert  && A[Position] != 0)" + "\n" + tab + "{ Position = ((Wert mod A.size) + i) mod A.size); i++ }" + "\n" + tab + "return Position" + "\n\n" + "Hinzufuegen:" + "\n" + tab + "Position = Wert mod A.size()" + "\n" + tab + "i=1" + "\n" + tab + "loop(i < A.size  &&  A[Position] != Wert  && A[Position] != 0)" + "\n" + tab + "{ Position = ((Wert mod A.size) + i) mod A.size); i++ }" + "\n" + tab + "return Position" + "\n\n" + "Loeschen:" + "\n" + tab + "Position = Wert mod A.size()" + "\n" + tab + "i=1" + "\n" + tab + "loop(i < A.size  &&  A[Position] != Wert  && A[Position] != 0)" + "\n" + tab + "{ Position = ((Wert mod A.size) + i) mod A.size); i++ }" + "\n" + tab + "return Position" + "\n\n";

    private String codeDH = "" + "Suchen:" + "\n" + tab + "Position = Wert mod A.size()" + "\n" + tab + "i=1" + "\n" + tab + "loop(i < A.size  &&  A[Position] != Wert  && A[Position] != 0)" + "\n" + tab + "{ Position = ((Wert mod A.size) + i) mod A.size); i++ }" + "\n" + tab + "return Position" + "\n\n" + "Hinzufuegen:" + "\n" + tab + "Position = Wert mod A.size()" + "\n" + tab + "i=1" + "\n" + tab + "loop(i < A.size  &&  A[Position] != Wert  && A[Position] != 0)" + "\n" + tab + "{ Position = ((Wert mod A.size) + i) mod A.size); i++ }" + "\n" + tab + "return Position" + "\n\n" + "Loeschen:" + "\n" + tab + "Position = Wert mod A.size()" + "\n" + tab + "i=1" + "\n" + tab + "loop(i < A.size  &&  A[Position] != Wert  && A[Position] != 0)" + "\n" + tab + "{ Position = ((Wert mod A.size) + i) mod A.size); i++ }" + "\n" + tab + "return Position" + "\n\n";

    public PseudoCodeView(JComboBox<String> cbVerfahren)
    {
        this.cbVerfahren = cbVerfahren;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setSize(500, 500);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (screenSize.getWidth() / 2 - getSize().getWidth() / 2), (int) (screenSize.getHeight() / 2 - getSize().getHeight() / 2));
        JTextArea text = new JTextArea();
        text.setTabSize(2);
        fillText(text);
        add(text);
        setTitle((String) cbVerfahren.getSelectedItem());
        text.setEditable(false);
        setVisible(true);
    }

    private void fillText(JTextArea text)
    {
        int index = cbVerfahren.getSelectedIndex();
        switch (index)
        {
            case 0:
                text.setText(codeLS);
                break;
            case 1:
                text.setText(codeErwLS);
                break;
            case 2:
                text.setText(codeQS);
                break;
            case 3:
                text.setText(codeAltQS);
                break;
            case 4:
                text.setText(codeDH);
                break;

            default:
                break;
        }

    }
}
