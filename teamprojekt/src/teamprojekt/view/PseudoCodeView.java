package teamprojekt.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class PseudoCodeView extends JFrame
{
    private JComboBox<String> cbVerfahren;

    private String cutS = "\n----------------------------------------------------------------------\n\n";

    // Pseudo-Code für das lineare Sondieren mit Kommentaren
    private String codeLS = ""
        + " Suchen:"                                        + "\n"
        + " int position =  wert % arraylänge;"             + "\t\t\t\t\t"              + "// Anfangsposition / h0"                 + "\n"
        + " while(array[position] != 0)"                    + "\t\t\t\t\t\t\t"          + "// suche solange bis leere Zelle"        + "\n\t"
            + " if(array[position] == wert)"                + "\t\t\t\t\t\t"            + "// ist der Wert gefunden"                + "\n\t\t"
                + " return position;"                       + "\t\t\t\t\t\t\t\t"        + "// gebe Position zurueck"                + "\n\t"
            + " position = (wert + position)% arraylänge;"  + "\t\t"                    + "// naechste Position / hX"               + "\n\t"
            + " position++;"                                + "\t\t\t\t\t\t\t\t\t\t"    + "// Position erhoehen"                    + "\n"
        + " return 0;"                                      + "\t\t\t\t\t\t\t\t\t\t\t"  + "// Wert nicht gefunden"                  + "\n"
        + cutS 
        + " Einf\u00fcgen:"                                 + "\n"
        + " int position =  wert % arraylänge;"             + "\t\t\t\t\t"              + "// Anfangsposition / h0"                 + "\n"
        + " while(array[position] != 0 && array[position] != -1)"   + "\t"              + "// suche bis Zelle leer oder als geloescht Markiert " + "\n\t"
            + " position = (wert + position) % arraylänge;" + "\t\t"                    + "// naechste Position / hX"               + "\n\t"
            + " position++;"                                + "\t\t\t\t\t\t\t\t\t\t"    + "// Position erhoehen"                    + "\n"
        + " array[position] = wert;"                        + "\t\t\t\t\t\t\t\t"        + "// fuege den Wert an"                    + "\n"
        + cutS 
        + " L\u00f6schen:"                                  + "\n"
        + " int position =  wert % arraylänge;"             + "\t\t\t\t\t"              + "// Anfangsposition / h0"                 + "\n"
        + " while(array[position] != 0)"                    + "\t\t\t\t\t\t\t"          + "// suche solange bis leere Zelle"        + "\n\t"
            + " if(array[position] == wert)"                + "\t\t\t\t\t\t"            + "// ist der Wert gefunden"                + "\n\t\t"
                + "array[position] = -1;"                   + "\t\t\t\t\t\t\t"          + "// Loesche den wert"                     + "\n\t\t"
                + "return array[position];"                 + "\t\t\t\t\t\t"            + "// als geloescht Markiert"               + "\n\t"
            + " position = (wert + position) %  arraylänge;"+ "\t\t"                    + "// naechste Position / hX"               + "\n\t"
            + " position++;"                                + "\t\t\t\t\t\t\t\t\t\t"    + "// Position erhoehen"                    + "\n"
        + " return 0;"                                      + "\t\t\t\t\t\t\t\t\t\t\t"  + "// Wert nicht gefunden";

    // Pseudo-Code für das Verallgemeinerte lineare Sondieren mit Kommentaren
    private String codeErwLS = ""
        + " Suchen:"                                        + "\n"
        + " int position =  wert % arraylänge;"             + "\t\t\t\t\t"              + "// Anfangsposition / h0"                 + "\n"
        + " while(array[position] != 0)"                    + "\t\t\t\t\t\t\t"          + "// suche solange bis leere Zelle"        + "\n\t"
            + " if(array[position] == wert)"                + "\t\t\t\t\t\t"            + "// ist der Wert gefunden"                + "\n\t\t"
                + " return position;"                       + "\t\t\t\t\t\t\t\t"        + "// gebe Position zurueck"                + "\n\t"
            + " position = (wert + c * position)% arraylänge;"  + "\t\t"                + "// naechste Position / hX"               + "\n\t"
            + " position++;"                                + "\t\t\t\t\t\t\t\t\t\t"    + "// Position erhoehen"                    + "\n"
        + " return 0;"                                      + "\t\t\t\t\t\t\t\t\t\t\t"  + "// Wert nicht gefunden"                  + "\n"
        + cutS 
        + " Einf\u00fcgen:"                                 + "\n"
        + " int position =  wert % arraylänge;"             + "\t\t\t\t\t"              + "// Anfangsposition / h0"                 + "\n"
        + " while(array[position] != 0 && array[position] != -1)"   + "\t"              + "// suche bis Zelle leer oder als geloescht Markiert " + "\n\t"
            + " position = (wert + c * position) % arraylänge;" + "\t"                  + "// naechste Position / hX"               + "\n\t"
            + " position++;"                                + "\t\t\t\t\t\t\t\t\t\t"    + "// Position erhoehen"                    + "\n"
        + " array[position] = wert;"                        + "\t\t\t\t\t\t\t\t"        + "// fuege den Wert an"                    + "\n"
        + cutS 
        + " L\u00f6schen:"                                  + "\n"
        + " int position =  wert % arraylänge;"             + "\t\t\t\t\t"              + "// Anfangsposition / h0"                 + "\n"
        + " while(array[position] != 0)"                    + "\t\t\t\t\t\t\t"          + "// suche solange bis leere Zelle"        + "\n\t"
            + " if(array[position] == wert)"                + "\t\t\t\t\t\t"            + "// ist der Wert gefunden"                + "\n\t\t"
                + "array[position] = -1;"                   + "\t\t\t\t\t\t\t"          + "// Loesche den wert"                     + "\n\t\t"
                + "return array[position];"                 + "\t\t\t\t\t\t"            + "// als geloescht Markiert"               + "\n\t"
            + " position = (wert + c * position) %  arraylänge;"+ "\t"                  + "// naechste Position / hX"               + "\n\t"
            + " position++;"                                + "\t\t\t\t\t\t\t\t\t\t"    + "// Position erhoehen"                    + "\n"
        + " return 0;"                                      + "\t\t\t\t\t\t\t\t\t\t\t"  + "// Wert nicht gefunden";
    
    // Pseudo-Code für das quadratisches Sondieren mit Kommentaren
    private String codeQS = ""
        + " Suchen:"                                        + "\n"
        + " int position =  wert % arraylänge;"             + "\t\t\t\t\t"              + "// Anfangsposition / h0"                 + "\n"
        + " while(array[position] != 0)"                    + "\t\t\t\t\t\t\t"          + "// suche solange bis leere Zelle"        + "\n\t"
            + " if(array[position] == wert)"                + "\t\t\t\t\t\t"            + "// ist der Wert gefunden"                + "\n\t\t"
                + " return position;"                       + "\t\t\t\t\t\t\t\t"        + "// gebe Position zurueck"                + "\n\t"
            + " position = (wert + position^2)% arraylänge;"+ "\t\t"                    + "// naechste Position / hX"               + "\n\t"
            + " position++;"                                + "\t\t\t\t\t\t\t\t\t\t"    + "// Position erhoehen"                    + "\n"
        + " return 0;"                                      + "\t\t\t\t\t\t\t\t\t\t\t"  + "// Wert nicht gefunden"                  + "\n"
        + cutS 
        + " Einf\u00fcgen:"                                 + "\n"
        + " int position =  wert % arraylänge;"             + "\t\t\t\t\t"              + "// Anfangsposition / h0"                 + "\n"
        + " while(array[position] != 0 && array[position] != -1)"   + "\t"              + "// suche bis Zelle leer oder als geloescht Markiert " + "\n\t"
            + " position = (wert + position^2) % arraylänge;" + "\t\t"                  + "// naechste Position / hX"               + "\n\t"
            + " position++;"                                + "\t\t\t\t\t\t\t\t\t\t"    + "// Position erhoehen"                    + "\n"
        + " array[position] = wert;"                        + "\t\t\t\t\t\t\t\t"        + "// fuege den Wert an"                    + "\n"
        + cutS 
        + " L\u00f6schen:"                                  + "\n"
        + " int position =  wert % arraylänge;"             + "\t\t\t\t\t"              + "// Anfangsposition / h0"                 + "\n"
        + " while(array[position] != 0)"                    + "\t\t\t\t\t\t\t"          + "// suche solange bis leere Zelle"        + "\n\t"
            + " if(array[position] == wert)"                + "\t\t\t\t\t\t"            + "// ist der Wert gefunden"                + "\n\t\t"
                + "array[position] = -1;"                   + "\t\t\t\t\t\t\t"          + "// Loesche den wert"                     + "\n\t\t"
                + "return array[position];"                 + "\t\t\t\t\t\t"            + "// als geloescht Markiert"               + "\n\t"
            + " position = (wert + position^2) %  arraylänge;" + "\t\t"                 + "// naechste Position / hX"               + "\n\t"
            + " position++;"                                + "\t\t\t\t\t\t\t\t\t\t"    + "// Position erhoehen"                    + "\n"
        + " return 0;"                                      + "\t\t\t\t\t\t\t\t\t\t\t"  + "// Wert nicht gefunden";
    
    // Pseudo-Code für das alternierendes quadratisches Sondieren mit Kommentaren
    private String codeAltQS = ""
        + " Suchen:"                                        + "\n"
        + " int position =  wert % arraylänge;"             + "\t\t\t\t\t"              + "// Anfangsposition / h0"                 + "\n"
        + " while(array[position] != 0)"                    + "\t\t\t\t\t\t\t"          + "// suche solange bis leere Zelle"        + "\n\t"
            + " if(array[position] == wert)"                + "\t\t\t\t\t\t"            + "// ist der Wert gefunden"                + "\n\t\t"
                + " return position;"                       + "\t\t\t\t\t\t\t\t"        + "// gebe Position zurueck"                + "\n\t"
            + " position = (wert (+/-) position^2)% arraylänge;"+ "\t"                  + "// naechste Position / hX"               + "\n\t"
            + " position++;"                                + "\t\t\t\t\t\t\t\t\t\t"    + "// Position erhoehen"                    + "\n"
        + " return 0;"                                      + "\t\t\t\t\t\t\t\t\t\t\t"  + "// Wert nicht gefunden"                  + "\n"
        + cutS 
        + " Einf\u00fcgen:"                                 + "\n"
        + " int position =  wert % arraylänge;"             + "\t\t\t\t\t"              + "// Anfangsposition / h0"                 + "\n"
        + " while(array[position] != 0 && array[position] != -1)"   + "\t"              + "// suche bis Zelle leer oder als geloescht Markiert " + "\n\t"
            + " position = (wert (+/-) position^2) % arraylänge;"   + "\t"              + "// naechste Position / hX"               + "\n\t"
            + " position++;"                                + "\t\t\t\t\t\t\t\t\t\t"    + "// Position erhoehen"                    + "\n"
        + " array[position] = wert;"                        + "\t\t\t\t\t\t\t\t"        + "// fuege den Wert an"                    + "\n"
        + cutS 
        + " L\u00f6schen:"                                  + "\n"
        + " int position =  wert % arraylänge;"             + "\t\t\t\t\t"              + "// Anfangsposition / h0"                 + "\n"
        + " while(array[position] != 0)"                    + "\t\t\t\t\t\t\t"          + "// suche solange bis leere Zelle"        + "\n\t"
            + " if(array[position] == wert)"                + "\t\t\t\t\t\t"            + "// ist der Wert gefunden"                + "\n\t\t"
                + "array[position] = -1;"                   + "\t\t\t\t\t\t\t"          + "// Loesche den wert"                     + "\n\t\t"
                + "return array[position];"                 + "\t\t\t\t\t\t"            + "// als geloescht Markiert"               + "\n\t"
            + " position = (wert (+/-) position^2) %  arraylänge;" + "\t"               + "// naechste Position / hX"               + "\n\t"
            + " position++;"                                + "\t\t\t\t\t\t\t\t\t\t"    + "// Position erhoehen"                    + "\n"
        + " return 0;"                                      + "\t\t\t\t\t\t\t\t\t\t\t"  + "// Wert nicht gefunden";

    // Pseudo-Code für das Doppel-Hashing mit Kommentaren
    private String codeDH = ""
        + " Suchen:"                                        + "\n"
        + " int position =  wert % arraylänge;"             + "\t\t\t\t\t"              + "// Anfangsposition / h0"                 + "\n"
        + " while(array[position] != 0)"                    + "\t\t\t\t\t\t\t"          + "// suche solange bis leere Zelle"        + "\n\t"
            + " if(array[position] == wert)"                + "\t\t\t\t\t\t"            + "// ist der Wert gefunden"                + "\n\t\t"
                + " return position;"                       + "\t\t\t\t\t\t\t\t"        + "// gebe Position zurueck"                + "\n\t"
            + " position = (value % arrayLength) - i *"     + "\t\t\t"                  + "// naechste Position / hX"               + "\n\t\t\t"
            + " (1 + value % (arrayLength - 2))% arraylänge;"                                                                       + "\n\t"
            + " position++;"                                + "\t\t\t\t\t\t\t\t\t\t"    + "// Position erhoehen"                    + "\n"
        + " return 0;"                                      + "\t\t\t\t\t\t\t\t\t\t\t"  + "// Wert nicht gefunden"                  + "\n"
        + cutS 
        + " Einf\u00fcgen:"                                 + "\n"
        + " int position =  wert % arraylänge;"             + "\t\t\t\t\t"              + "// Anfangsposition / h0"                 + "\n"
        + " while(array[position] != 0 && array[position] != -1)"   + "\t"              + "// suche bis Zelle leer oder als geloescht Markiert " + "\n\t"
            + " position = (value % arrayLength) - i *"     + "\t\t\t"                  + "// naechste Position / hX"               + "\n\t\t\t"
            + " (1 + value % (arrayLength - 2))% arraylänge;"                                                                       + "\n\t"
            + " position++;"                                + "\t\t\t\t\t\t\t\t\t\t"    + "// Position erhoehen"                    + "\n"
        + " array[position] = wert;"                        + "\t\t\t\t\t\t\t\t"        + "// fuege den Wert an"                    + "\n"
        + cutS 
        + " L\u00f6schen:"                                  + "\n"
        + " int position =  wert % arraylänge;"             + "\t\t\t\t\t"              + "// Anfangsposition / h0"                 + "\n"
        + " while(array[position] != 0)"                    + "\t\t\t\t\t\t\t"          + "// suche solange bis leere Zelle"        + "\n\t"
            + " if(array[position] == wert)"                + "\t\t\t\t\t\t"            + "// ist der Wert gefunden"                + "\n\t\t"
                + "array[position] = -1;"                   + "\t\t\t\t\t\t\t"          + "// Loesche den wert"                     + "\n\t\t"
                + "return array[position];"                 + "\t\t\t\t\t\t"            + "// als geloescht Markiert"               + "\n\t"
            + " position = (value % arrayLength) - i *"     + "\t\t\t"                  + "// naechste Position / hX"               + "\n\t\t\t"
            + " (1 + value % (arrayLength - 2))% arraylänge;"                                                                       + "\n\t"
            + " position++;"                                + "\t\t\t\t\t\t\t\t\t\t"    + "// Position erhoehen"                    + "\n"
        + " return 0;"                                      + "\t\t\t\t\t\t\t\t\t\t\t"  + "// Wert nicht gefunden";

    public PseudoCodeView(JComboBox<String> cbVerfahren)
    {
        this.cbVerfahren = cbVerfahren;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setSize(650, 570);
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
