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

    private String cutS = "\n----------------------------------------------------------------------\n\n";

    private String codeLS = ""
        + " Suchen: \n"
        + " int position =  wert % arraylänge; \t\t\t\t\t"                          + "// \n"
        + " while(array[position] != 0) \t\t\t\t\t\t\t"                             + "// suche solange bis leere Zelle \n\t"
            + " if(array[position] == wert) \t\t\t\t\t\t"                           + "// ist der Wert gefunden \n\t\t"
                + " return position; \t\t\t\t\t\t\t"                                    + "// gebe position zurück \n\t"
            + " position++; \t\t\t\t\t\t\t\t\t"                                     + "// lineare progression \n\t"
            + " position = (wert + position)% arraylänge; \t\t"                     + "// \n"
        + " return 0; \t\t\t\t\t\t\t\t\t\t\t"                                       + "// wenn der wert nicht gefunden werden konnte \n"
  
        + cutS 
      
        + " Einf\u00fcgen: \n"
        + " int position =  wert % arraylänge; \t\t\t\t\t"                          + "// \n"
        + " while(array[position] != 0 && array[position] != -1) \t"                + "// suche solange bis leere Zelle oder als gelöscht Markiert \n\t"
            + " position++; \t\t\t\t\t\t\t\t\t"                                     + "// lineare progression \n\t"
            + " position = (wert + position) % arraylänge; \t\t"                    + "// \n"
        + " array[position] = wert; \t\t\t\t\t\t\t\t"                               + "// füge den Wert an \n"
      
        + cutS 
  
        + " L\u00f6schen: \n"
        + " int position =  wert % arraylänge; \t\t\t\t\t"                          + "// \n"
        + " while(array[position] != 0) \t\t\t\t\t\t\t"                             + "// suche solange bis leere Zelle \n\t"
            + " if(array[position] == wert) \t\t\t\t\t\t"                           + "// ist der Wert gefunden \n\t\t"
                + "array[position] = -1; \t\t\t\t\t\t\t"                            + "// Lösche den wert \n\t\t"
                + "return array[position]; \t\t\t\t\t\t"                            + "// als gelöscht Markiert \n\t"
            + " position++; \t\t\t\t\t\t\t\t\t"                                     + "// lineare progression \n\t"
            + " position = (wert + position) %  arraylänge; \t\t"                   + "// \n"
        + " return 0; \t\t\t\t\t\t\t\t\t\t\t"                                       + "// wenn der Wert nicht gefunden wurde";

    private String codeErwLS = "";
    
    private String codeQS = " Suchen: \n position = (wert)mod m \n while( i < arraygr\u00f6ße && array[i] != wert) \n \t position = (wert)mod m; \n\t i++; \n return position; \n" + cutS + " Hinzuf\u00fcgen: \n position = (wert)mod m \n while( i < arraygr\u00f6ße && array[i] != wert) \n \t position = (wert)mod m; \n\t i++; \n if( wert == 0 || wert == -1) \n\t return position; \n else \n\t array[i] = -1 \n\t return position \n " + cutS + " L\u00f6schen: \n position = (wert)mod m \n while( i < arraygr\u00f6ße && array[i] != wert) \n \t position = (wert)mod m; \n\t i++; \n if( wert == 0 || wert == -1) \n\t return position; \n else \n\t array[i] = -1 \n\t return position";;

    private String codeAltQS = " Suchen: \n position = (wert)mod m \n while( i < arraygr\u00f6ße && array[i] != wert) \n \t position = (wert)mod m; \n\t i++; \n return position; \n" + cutS + " Hinzuf\u00fcgen: \n position = (wert)mod m \n while( i < arraygr\u00f6ße && array[i] != wert) \n \t position = (wert)mod m; \n\t i++; \n if( wert == 0 || wert == -1) \n\t return position; \n else \n\t array[i] = -1 \n\t return position \n " + cutS + " L\u00f6schen: \n position = (wert)mod m \n while( i < arraygr\u00f6ße && array[i] != wert) \n \t position = (wert)mod m; \n\t i++; \n if( wert == 0 || wert == -1) \n\t return position; \n else \n\t array[i] = -1 \n\t return position";;

    private String codeDH = " Suchen: \n position = (wert)mod m \n while( i < arraygr\u00f6ße && array[i] != wert) \n \t position = (wert)mod m; \n\t i++; \n return position; \n" + cutS + " Hinzuf\u00fcgen: \n position = (wert)mod m \n while( i < arraygr\u00f6ße && array[i] != wert) \n \t position = (wert)mod m; \n\t i++; \n if( wert == 0 || wert == -1) \n\t return position; \n else \n\t array[i] = -1 \n\t return position \n " + cutS + " L\u00f6schen: \n position = (wert)mod m \n while( i < arraygr\u00f6ße && array[i] != wert) \n \t position = (wert)mod m; \n\t i++; \n if( wert == 0 || wert == -1) \n\t return position; \n else \n\t array[i] = -1 \n\t return position";;

    public PseudoCodeView(JComboBox<String> cbVerfahren)
    {
        this.cbVerfahren = cbVerfahren;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setSize(650, 550);
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
