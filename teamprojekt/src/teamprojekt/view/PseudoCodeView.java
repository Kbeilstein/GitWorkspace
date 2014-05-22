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
        + " Suchen / L\u00f6schen:"                                     + "\n"
        + " int index = -1;"                                            + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// markiere als nicht gefunden"                  + "\n"
        + " int i = 1;"                                                 + "\t\t\t\t\t\t\t\t\t\t\t\t\t"      + "// Wert um den verschoben wird"                  + "\n"
        + " int position = wert % arraylaenge;"                         + "\t\t\t\t\t\t\t"                  + "// Anfangsposition / h0"                         + "\n"
        + " while(array[position] != 0 && index == -1)"                 + "\t\t\t\t\t"                      + "// suche bis leere Zelle oder Wert gefunden"     + "\n\t"
            + " if(array[position] == wert)"                            + "\t\t\t\t\t\t\t\t"                + "// ist der Wert gefunden"                        + "\n\t\t"
                + " index= position;"                                   + "\t\t\t\t\t\t\t\t\t"              + "// setze die Position auf den Index"             + "\n\t\t"
                + " if(loeschen)"                                       + "\t\t\t\t\t\t\t\t\t\t"            + "// wenn der Wert geloescht werden soll"          + "\n\t\t\t"
                    + " array[position] = -1;"                          + "\t\t\t\t\t\t\t\t"                + "// markiere als geloescht"                       + "\n\t"
            + " position = ((wert % arraylaenge) + i) % arraylaenge;"   + "\t\t"                            + "// naechste Position / hX"                       + "\n\t"
            + " i++;"                                                   + "\t\t\t\t\t\t\t\t\t\t\t\t\t"      + "// Zaehler um 1 erhoehen"                        + "\n"
        + " return index;"                                              + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// Rueckgabe: Wert gefunden oder nicht gefunden" + "\n"
        + cutS 
        + " Einf\u00fcgen:"                                             + "\n"
        + " if(!arrayVoll && suche(wert)==-1)"                          + "\t\t\t\t\t\t\t"                  + "// Array nicht voll und Wert nicht gefunden"     + "\n\t"
            + " int position =  wert % arraylaenge;"                    + "\t\t\t\t\t\t"                    + "// Anfangsposition / h0"                         + "\n\t"
            + " int i= 1;"                                              + "\t\t\t\t\t\t\t\t\t\t\t\t\t"      + "// Wert um den verschoben wird"                  + "\n\t"
            + " while(array[position] != 0 && array[position] != -1)"   + "\t\t"                            + "// suche bis leere oder als geloescht markierte Zelle" + "\n\t\t"
                        + " position = ((wert % arraylaenge) + i) % arraylaenge;" + "\t"                    + "// naechste Position / hX"                       + "\n\t\t"
                        + " i++;"                                       + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// Zaehler um 1 erhoehen"                        + "\n\t"
            + " array[position] = wert;"                                + "\t\t\t\t\t\t\t\t\t"              + "// fuege den Wert ein"                           + "\n";
                    
    // Pseudo-Code für das Verallgemeinerte lineare Sondieren mit Kommentaren
    private String codeErwLS = ""
        + " Suchen / L\u00f6schen:"                                     + "\n"
        + " int index = -1;"                                            + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// markiere als nicht gefunden"                  + "\n"
        + " int i = 1;"                                                 + "\t\t\t\t\t\t\t\t\t\t\t\t\t"      + "// Wert um den verschoben wird"                  + "\n"
        + " int c = {z.B.: 3,5,7};"                                     + "\t\t\t\t\t\t\t\t\t\t\t"          + "// waehle ein c welches teilerfremd mit Arraylaenge" + "\n"
        + " int position = wert % arraylaenge;"                         + "\t\t\t\t\t\t\t"                  + "// Anfangsposition / h0"                             + "\n"
        + " while(array[position] != 0 && index == -1)"                 + "\t\t\t\t\t"                      + "// suche bis leere Zelle oder Wert gefunden"     + "\n\t"
            + " if(array[position] == wert)"                            + "\t\t\t\t\t\t\t\t"                + "// ist der Wert gefunden"                        + "\n\t\t"
                + " index= position;"                                   + "\t\t\t\t\t\t\t\t\t"              + "// setze die Position auf den Index"             + "\n\t\t"
                + " if(loeschen)"                                       + "\t\t\t\t\t\t\t\t\t\t"            + "// wenn der Wert geloescht werden soll"          + "\n\t\t\t"
                    + " array[position] = -1;"                          + "\t\t\t\t\t\t\t\t"                + "// markiere als geloescht"                       + "\n\t"
            + " position = ((wert % arraylaenge) + (c * i)) % arraylaenge;"   + "\t"                        + "// naechste Position / hX"                       + "\n\t"
            + " i++;"                                                   + "\t\t\t\t\t\t\t\t\t\t\t\t\t"      + "// Zaehler um 1 erhoehen"                        + "\n"
        + " return index;"                                              + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// Rueckgabe: Wert gefunden oder nicht gefunden" + "\n"
        + cutS 
        + " Einf\u00fcgen:"                                             + "\n"
        + " if(!arrayVoll && suche(wert)==-1)"                          + "\t\t\t\t\t\t\t"                  + "// Array nicht voll oder Wert nicht gefunden"    + "\n\t"
            + " int position =  wert % arraylaenge;"                    + "\t\t\t\t\t\t"                    + "// Anfangsposition / h0"                         + "\n\t"
            + " int i= 1;"                                              + "\t\t\t\t\t\t\t\t\t\t\t\t\t"      + "// Wert um den verschoben wird"                  + "\n\t"
            + " int c = {z.B.: 3,5,7};"                                 + "\t\t\t\t\t\t\t\t\t\t"            + "// waehle ein c welches teilerfremd mit Arraylaenge"     + "\n\t"
            + " while(array[position] != 0 && array[position] != -1 "   + "\t\t"                            + "// suche bis leere oder als geloescht markierte Zelle"   + "\n\t\t"
            + "     && i <= arraylaenge)"                               + "\t\t\t\t\t\t\t\t"                + "// oder bis einmal durch Array gelaufen"         + "\n\t\t"
                        + " position = ((wert % arraylaenge) + (c * i)) % arraylaenge;" + "\t\t"            + "// naechste Position / hX"                       + "\n\t\t"
                        + " i++;"                                       + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// Zaehler um 1 erhoehen"                        + "\n\t"
            + " array[position] = wert;"                                + "\t\t\t\t\t\t\t\t\t"              + "// fuege den Wert ein"                           + "\n";
                    
    // Pseudo-Code für das quadratisches Sondieren mit Kommentaren
    private String codeQS = ""
        + " Suchen / L\u00f6schen:"                                     + "\n"
        + " int index = -1;"                                            + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// markiere als nicht gefunden"              + "\n"
        + " int i = 1;"                                                 + "\t\t\t\t\t\t\t\t\t\t\t\t\t"      + "// Wert um den verschoben wird"              + "\n"
        + " int position = wert % arraylaenge;"                         + "\t\t\t\t\t\t\t"                  + "// Anfangsposition / h0"                     + "\n"
        + " while(array[position] != 0 && index == -1"                  + "\t\t\t\t\t\t"                    + "// suche bis leere Zelle oder Wert gefunden" + "\n"
        + "     && i <= arraylaenge)"                                   + "\t\t\t\t\t\t\t\t\t\t"            + "// oder bis einmal durch Array gelaufen"     + "\n\t"
            + " if(array[position] == wert)"                            + "\t\t\t\t\t\t\t\t"                + "// ist der Wert gefunden"                    + "\n\t\t"
                + " index= position;"                                   + "\t\t\t\t\t\t\t\t\t"              + "// setze die Position auf den Index"         + "\n\t\t"
                + " if(loeschen)"                                       + "\t\t\t\t\t\t\t\t\t\t"            + "// wenn der Wert geloescht werden soll"      + "\n\t\t\t"
                    + " array[position] = -1;"                          + "\t\t\t\t\t\t\t\t"                + "// markiere als geloescht"                   + "\n\t"
            + " position = ((wert % arraylaenge) + (i * i)) % arraylaenge;"   + "\t"                        + "// naechste Position / hX"                   + "\n\t"
            + " i++;"                                                   + "\t\t\t\t\t\t\t\t\t\t\t\t\t"      + "// Zaehler um 1 erhoehen"                    + "\n"
        + " return index;"                                              + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// Rueckgabe: Wert gefunden oder nicht gefunden" + "\n"
        + cutS 
        + " Einf\u00fcgen:"                                             + "\n"
        + " if(!arrayVoll && suche(wert)==-1)"                          + "\t\t\t\t\t\t\t"                  + "// Array nicht voll oder Wert nicht gefunden"    + "\n\t"
            + " int position =  wert % arraylaenge;"                    + "\t\t\t\t\t\t"                    + "// Anfangsposition / h0"                         + "\n\t"
            + " int i= 1;"                                              + "\t\t\t\t\t\t\t\t\t\t\t\t\t"      + "// Wert um den verschoben wird"                  + "\n\t"
            + " while(array[position] != 0 && array[position] != -1"    + "\t\t\t"                          + "// suche bis leere oder als geloescht markierte Zelle" + "\n\t\t"
            + "     && i <= arraylaenge)"                               + "\t\t\t\t\t\t\t\t"                + "// oder bis einmal durch Array gelaufen"         + "\n\t\t"
                        + " position = ((wert % arraylaenge) + (i * i)) % arraylaenge;" + "\t"              + "// naechste Position / hX"                       + "\n\t\t"
                        + " i++;"                                       + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// Zaehler um 1 erhoehen"                        + "\n\t"
            + " array[position] = wert;"                                + "\t\t\t\t\t\t\t\t\t"              + "// fuege den Wert ein"                           + "\n";
             
    // Pseudo-Code für das alternierendes quadratisches Sondieren mit Kommentaren
    private String codeAltQS = ""
        + " Suchen / L\u00f6schen:"                                     + "\n"
        + " int index = -1;"                                            + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// markiere als nicht gefunden"          + "\n"
        + " int i = 1;"                                                 + "\t\t\t\t\t\t\t\t\t\t\t\t\t"      + "// Wert um den verschoben wird"          + "\n"
        + " int j = 1;"                                                 + "\t\t\t\t\t\t\t\t\t\t\t\t\t"      + "// Wert um den verschoben wird"          + "\n"
        + " int position = wert % arraylaenge;"                         + "\t\t\t\t\t\t\t"                  + "// Anfangsposition / h0"                 + "\n"
        + " while(array[position] != 0 && index == -1"                  + "\t\t\t\t\t\t"                    + "// suche bis leere Zelle oder Wert gefunden"     + "\n"
        + "     && i <= arraylaenge)"                                   + "\t\t\t\t\t\t\t\t\t\t"            + "// oder bis einmal durch Array gelaufen"         + "\n\t"
            + " if(array[position] == wert)"                            + "\t\t\t\t\t\t\t\t"                + "// ist der Wert gefunden"                + "\n\t\t"
                + " index= position;"                                   + "\t\t\t\t\t\t\t\t\t"              + "// setze die Position auf den Index"     + "\n\t\t"
                + " if(loeschen)"                                       + "\t\t\t\t\t\t\t\t\t\t"            + "// wenn der Wert geloescht werden soll"  + "\n\t\t\t"
                    + " array[position] = -1;"                          + "\t\t\t\t\t\t\t\t"                + "// markiere als geloescht"               + "\n\t"
            + " else"                                                   + "\t\t\t\t\t\t\t\t\t\t\t\t\t"      + "// ist der Wert nicht gefunden"          + "\n\t\t"
                + " if(i == j)"                                         + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// bestimme Vorzeichen abwaechseld / +"  + "\n\t\t\t"
                    + " position = ((wert % arraylaenge) + (i * i)) % arraylaenge;"   + "\t"                + "// naechste Position / hX "              + "\n\t\t\t"
                    + " i++;"                                           + "\t\t\t\t\t\t\t\t\t\t\t"          + "// Zaehler um 1 erhoehen"                      + "\n\t\t"
                + " else"                                               + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// oder -"                               + "\n\t\t\t"
                    + " position = ((wert % arraylaenge) - (j * j)) % arraylaenge;"   + "\t"                + "// naechste Position / hX"               + "\n\t\t\t"
                    + " j++;"                                           + "\t\t\t\t\t\t\t\t\t\t\t"          + "// Zaehler um 1 erhoehen"                      + "\n"
        + " return index;"                                              + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// Rueckgabe: Wert gefunden oder nicht gefunden"     + "\n"
        + cutS 
        + " Einf\u00fcgen:"                                             + "\n"
        + " if(!arrayVoll && suche(wert)==-1)"                          + "\t\t\t\t\t\t\t"                  + "// Array nicht voll oder Wert nicht gefunden"        + "\n\t"
            + " int position =  wert % arraylaenge;"                    + "\t\t\t\t\t\t"                    + "// Anfangsposition / h0"                             + "\n\t"
            + " int i= 1;"                                              + "\t\t\t\t\t\t\t\t\t\t\t\t\t"      + "// Wert um den verschoben wird"                      + "\n\t"
            + " int j = 1;"                                             + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// Wert um den verschoben wird"                      + "\n\t"
            + " while(array[position] != 0 && array[position] != -1"    + "\t\t\t"                          + "// suche bis leere oder als geloescht markierte Zelle"   + "\n\t\t"
            + "     && i <= arraylaenge)"                               + "\t\t\t\t\t\t\t\t"                + "// oder bis einmal durch Array gelaufen"             + "\n\t\t"
                + " if(i == j)"                                         + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// bestimme das Vorzeichen abwaechseld / +"          + "\n\t\t\t"
                    + " position = ((wert % arraylaenge) + (i * i)) % arraylaenge;"   + "\t"                + "// naechste Position / hX"                           + "\n\t\t\t"
                    + " i++;"                                           + "\t\t\t\t\t\t\t\t\t\t\t"          + "// Zaehler um 1 erhoehen"                            + "\n\t\t"
                + " else"                                               + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// oder -"                                           + "\n\t\t\t"
                    + " position = ((wert % arraylaenge) - (j * j)) % arraylaenge"  + "\t"                  + "// naechste Position / hX"                           + "\n\t\t\t"
                    + " j++;"                                           + "\t\t\t\t\t\t\t\t\t\t\t"          + "// Zaehler um 1 erhoehen"                            + "\n\t"
            + " array[position] = wert;"                                + "\t\t\t\t\t\t\t\t\t"              + "// fuege den Wert ein"                               + "\n";
             
    // Pseudo-Code für das Doppel-Hashing mit Kommentaren
    private String codeDH = ""
        + " Suchen / L\u00f6schen:"                                     + "\n"
        + " int index = -1;"                                            + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// markiere als nicht gefunden"                      + "\n"
        + " int i = 1;"                                                 + "\t\t\t\t\t\t\t\t\t\t\t\t\t"      + "// Wert um den verschoben wird"                      + "\n"
        + " int position = wert % arraylaenge;"                         + "\t\t\t\t\t\t\t"                  + "// Anfangsposition / h0"                             + "\n"
        + " while(array[position] != 0 && index == -1"                  + "\t\t\t\t\t\t"                    + "// suche bis leere Zelle oder Wert gefunden"         + "\n"
        + "     && i <= arraylaenge)"                                   + "\t\t\t\t\t\t\t\t\t\t"            + "// oder bis einmal durch Array gelaufen"             + "\n\t"
            + " if(array[position] == wert)"                            + "\t\t\t\t\t\t\t\t"                + "// ist der Wert gefunden"                            + "\n\t\t"
                + " index= position;"                                   + "\t\t\t\t\t\t\t\t\t"              + "// setze die Position auf den Index"                 + "\n\t\t"
                + " if(loeschen)"                                       + "\t\t\t\t\t\t\t\t\t\t"            + "// wenn der Wert geloescht werden soll"              + "\n\t\t\t"
                    + " array[position] = -1;"                          + "\t\t\t\t\t\t\t\t"                + "// markiere als geloescht"                           + "\n\t"
            + " position = (((wert % arraylaenge) "                     + "\t\t\t\t\t\t"                    + "// naechste Position / hX"                           + "\n\t\t"
            + "     - i * (1 + wert % (arraylaenge - 2))) % arraylaenge)"   + "\t"                          + "// "                                                 + "\n\t"
            + " i++;"                                                   + "\t\t\t\t\t\t\t\t\t\t\t\t\t"      + "// Zaehler um 1 erhoehen"                            + "\n"
        + " return index;"                                              + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// Rueckgabe: Wert gefunden oder nicht gefunden"     + "\n"
        + cutS 
        + " Einf\u00fcgen:"                                             + "\n"
        + " if(!arrayVoll && suche(wert)==-1)"                          + "\t\t\t\t\t\t\t"                  + "// Array nicht voll oder Wert nicht gefunden"        + "\n\t"
            + " int position =  wert % arraylaenge;"                    + "\t\t\t\t\t\t"                    + "// Anfangsposition / h0"                             + "\n\t"
            + " int i= 1;"                                              + "\t\t\t\t\t\t\t\t\t\t\t\t\t"      + "// Wert um den verschoben wird"                      + "\n\t"
            + " while(array[position] != 0 && array[position] != -1"    + "\t\t\t"                          + "// suche bis leere oder als geloescht markierte Zelle"   + "\n\t\t"
            + "     && i <= arraylaenge)"                               + "\t\t\t\t\t\t\t\t"                + "// oder bis einmal durch Array gelaufen"             + "\n\t\t"
                        + " position = (((wert % arraylaenge) "         + "\t\t\t\t\t"                      + "// naechste Position / hX"                           + "\n\t\t"
                        + "     - i * (1 + wert % (arraylaenge - 2))) % arraylaenge) "  + ""                + "// "                                                 + "\n\t\t"
                        + " i++;"                                       + "\t\t\t\t\t\t\t\t\t\t\t\t"        + "// Zaehler um 1 erhoehen"                            + "\n\t"
            + " array[position] = wert;"                                + "\t\t\t\t\t\t\t\t\t"              + "// fuege den Wert ein"                               + "\n";
     
    public PseudoCodeView(JComboBox<String> cbVerfahren)
    {
        this.cbVerfahren = cbVerfahren;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setSize(650, 630);
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
