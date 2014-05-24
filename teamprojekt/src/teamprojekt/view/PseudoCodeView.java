package teamprojekt.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class PseudoCodeView extends JFrame
{
    private JComboBox<String> cbVerfahren;

    /**@formatter:off**/
    // Pseudo-Code für das lineare Sondieren mit Kommentaren
    private String codeSearchDeleteLS = ""
        + " int index = -1;\n"
        + " int i = 1;\n"
        + " int position = wert % arraylaenge;\n"
        + " while(array[position] != 0 && index == -1)\n\t" 
            + " if(array[position] == wert)\n\t\t"
                + " index= position;\n\t\t"
                + " if(loeschen)\n\t\t\t"
                    + " array[position] = -1;\n\t\t"
            + " position = ((wert % arraylaenge) + i) % arraylaenge;\n\t\t"
            + " i++;\n\t"
        + " return index;";
    
    private String commSearchDeleteLS =""
        + "// markiere als nicht gefunden\n"
        + "// Wert um den verschoben wird\n"
        + "// Wert um den verschoben wird\n"
        + "// suche bis leere Zelle oder Wert gefunden\n"
        + "// ist der Wert gefunden\n"
        + "// setze die Position auf den Index\n"
        + "// wenn der Wert geloescht werden soll\n" 
        + "// markiere als geloescht\n"
        + "// naechste Position / hX\n"
        + "// Zaehler um 1 erhoehen\n"
        + "// Rueckgabe: Wert gefunden oder nicht gefunden";

    private String codeInsertLS = ""
        + " if(!arrayVoll && suche(wert)==-1)\n\t"
            + " int position =  wert % arraylaenge;\n\t"
            + " int i= 1;\n\t"
            + " while(array[position] != 0 && array[position] != -1)\n\t\t"
                    + " position = ((wert % arraylaenge) + i) % arraylaenge;\n\t\t"
                    + " i++;\n\t"
            + " array[position] = wert;";
    
    private String commInsertLS = ""
        + "// Array nicht voll und Wert nicht gefunden\n"     
        + "// Anfangsposition / h0\n"
        + "// Wert um den verschoben wird\n"
        + "// suche bis leere oder als geloescht markierte Zelle\n"
        + "// naechste Position / hX\n"
        + "// Zaehler um 1 erhoehen\n" 
        + "// fuege den Wert ein";
    
    private String infoLS = "LS";
                    
    // Pseudo-Code für das Verallgemeinerte lineare Sondieren mit Kommentaren
    private String codeSearchDeleteErwLS = ""
        + " int index = -1;\n"
        + " int i = 1;\n"
        + " int c = benutzerauswahl;\n"
        + " int position = wert % arraylaenge;\n"
        + " while(array[position] != 0 && index == -1)\n\t"
            + " if(array[position] == wert)\n\t\t"
                + " index = position;\n\t\t"
                + " if(loeschen)\n\t\t\t"
                    + " array[position] = -1;\n\t"
            + " position = ((wert % arraylaenge) + (c * i)) % arraylaenge;\n\t"
            + " i++;\n"
        + " return index;";
    
    private String commSearchDeleteErwLS =""
        + "// markiere als nicht gefunden\n"
        + "// Wert um den verschoben wird\n"
        + "// gewähltes c, teilerfremd mit Arraylaenge\n"
        + "// Anfangsposition / h0\n"
        + "// suche bis leere Zelle oder Wert gefunden\n"
        + "// ist der Wert gefunden\n"
        + "// setze die Position auf den Index\n"
        + "// wenn der Wert geloescht werden soll\n"
        + "// markiere als geloescht\n"
        + "// naechste Position / hX\n"
        + "// Zaehler um 1 erhoehen\n"
        + "// Rueckgabe: Position wenn Wert gefunden oder -1 wenn nicht gefunden";
    
    private String codeInsertErwLS = ""
        + " if(!arrayVoll && suche(wert) == -1)\n\t"
            + " int position =  wert % arraylaenge;\n\t"
            + " int i = 1;\n\t"
            + " int c = benutzerauswahl;\n\t"
            + " while(array[position] != 0 && array[position] != -1 \n\t\t\t"
                    + " && i < arraylaenge)\n\t\t"
                + " position = ((wert % arraylaenge) + (c * i)) % arraylaenge;\n\t\t"
                + " i++;\n\t"
            + " array[position] = wert;";
    
    private String commInsertErwLS = ""
        + "// Array nicht voll und Wert nicht vorhanden\n"
        + "// Anfangsposition / h0\n"
        + "// Wert um den verschoben wird\n"
        + "// gewähltes c, teilerfremd mit Arraylaenge\n"
        + "// suche bis leere oder als geloescht markierte Zelle\n"
        + "// oder einmal durch das Array gelaufen\n"
        + "// naechste Position / hX\n"
        + "// Zaehler um 1 erhoehen\n"
        + "// fuege den Wert ein";
    
    private String infoErwLS = "ErwLS";
                    
    // Pseudo-Code für das quadratisches Sondieren mit Kommentaren
    private String codeSearchDeleteQS = ""
        + " int index = -1;\n"
        + " int i = 1;\n"
        + " int position = wert % arraylaenge;\n"
        + " while(array[position] != 0 && index == -1\n\t\t"
                + " && i < arraylaenge)\n\t"
            + " if(array[position] == wert)\n\t\t"
                + " index = position;\n\t\t"
                + " if(loeschen)\n\t\t\t"
                    + " array[position] = -1;\n\t\t"
            + " position = ((wert % arraylaenge) + (i * i)) % arraylaenge;\n\t\t"
            + " i++;\n"
        + " return index;";
    
    private String commSearchDeleteQS = ""
        + "// markiere als nicht gefunden\n"
        + "// Wert um den verschoben wird\n"
        + "// Anfangsposition / h0\n"
        + "// suche bis leere Zelle oder Wert gefunden\n"
        + "// oder einmal durch das Array gelaufen\n"
        + "// ist der Wert gefunden\n"
        + "// setze die Position auf den Index\n"
        + "// wenn der Wert geloescht werden soll\n"
        + "// markiere als geloescht\n"
        + "// naechste Position / hX\n"
        + "// Zaehler um 1 erhoehen\n"
        + "// Rueckgabe: Wert gefunden oder nicht gefunden";

    private String codeInsertQS= ""
        + " if(!arrayVoll && suche(wert) == -1)\n"
        + " int position =  wert % arraylaenge;\n"
        + " int i = 1;\n"
        + " while(array[position] != 0 && array[position] != -1\n\t\t"
                + " && i < arraylaenge)\n\t"
            + " position = ((wert % arraylaenge) + (i * i)) % arraylaenge;\n\t"
            + " i++;\n"
        + " array[position] = wert;";
        
    private String commInsertQS= ""
            + "// Array nicht voll oder Wert nicht gefunden\n"
            + "// Anfangsposition / h0\n"
            + "// Wert um den verschoben wird\n" 
            + "// suche bis leere oder als geloescht markierte Zelle\n"
            + "// oder bis einmal durch Array gelaufen\n"
            + "// naechste Position / hX\n"
            + "// Zaehler um 1 erhoehen\n"
            + "// fuege den Wert ein";
    
    private String infoQS = "QS";
             
    // Pseudo-Code für das alternierendes quadratisches Sondieren mit Kommentaren
    private String codeSearchDeleteAltQS = ""
        + " int index = -1;\n"
        + " int i = 1;\n"
        + " int position = wert % arraylaenge;\n"
        + " while(array[position] != 0 && index == -1\n\t\t"
                + " && i < arraylaenge)\n\t"
            + " if(array[position] == wert)\n\t\t"
                + " index = position;\n\t\t"
                + " if(loeschen)\n\t\t\t"
                    + " array[position] = -1;\n\t\t"
                + " if(i % 2 != 0)\n\t\t\t"
                    + " position = ((wert % arraylaenge) + (i * i)) % arraylaenge;\n\t\t"
                + " else\n\t\t\t"
                    + " position = ((wert % arraylaenge) - (i * i)) % arraylaenge;\n\t\t"
                + " i++;\n"
        + " return index;";
    
    private String commSearchDeleteAltQS = ""
        + "// markiere als nicht gefunden\n"
        + "// Wert um den verschoben wird\n"
        + "// Anfangsposition / h0\n"
        + "// suche bis leere Zelle oder Wert gefunden\n"
        + "// oder bis einmal durch Array gelaufen\n"
        + "// ist der Wert gefunden\n"
        + "// setze die Position auf den Index\n"
        + "// wenn der Wert geloescht werden soll\n"
        + "// markiere als geloescht\n"
        + "// wenn i ungerade / + \n"
        + "// naechste Position/ hX \n"
        + "// wenn i gerade / - \n"
        + "// naechste Position / hX\n"
        + "// Zaehler um 1 erhoehen\n"
        + "// Rueckgabe: Wert gefunden oder nicht gefunden";

    private String codeInsertAltQS= ""
        + " if(!arrayVoll && suche(wert)==-1)\n\t"
            + " int position =  wert % arraylaenge;\n\t"
            + " int i = 1;\n\t"
            + " int j = 1;\n\t"
            + " while(array[position] != 0 && array[position] != -1\n\t\t\t"
                    + " && i < arraylaenge)\n\t\t"
                + " if(array[position] == wert)\n\t\t\t"
                    + " index = position;\n\t\t\t"
                    + " if(i % 2 != 0)\n\t\t\t\t"
                        + " position = ((wert % arraylaenge) + (i * i)) % arraylaenge;\n\t\t\t"
                    + " else\n\t\t\t\t"
                        + " position = ((wert % arraylaenge) - (i * i)) % arraylaenge;\n\t\t\t"
                    + " i++;\n\t"
            + " if(array[position] != 0 && array[position] != -1)\n\t\t"
                + " array[position] = wert;";
        
    private String commInsertAltQS= ""
        + "// Array nicht voll oder Wert nicht gefunden\n"
        + "// Anfangsposition / h0\n"
        + "// Wert um den verschoben wird\n"
        + "// Wert um den verschoben wird\n"
        + "// suche bis leere Zelle oder Wert gefunden\n"
        + "// oder bis einmal durch Array gelaufen\n"
        + "// ist der Wert gefunden\n"
        + "// setze die Position auf den Index\n"
        + "// wenn i ungerade / + \n"
        + "// naechste Position/ hX\n"
        + "// wenn i gerade / - \n"
        + "// naechste Position / hX\n"
        + "// Zaehler um 1 erhoehen\n"
        + "// wenn leere oder als gelöscht markierte Zelle gefunden\n"
        + "// fuege den Wert ein";
    
    private String infoAltQS = "AltQS";
        
    // Pseudo-Code für das Doppel-Hashing mit Kommentaren
    private String codeSearchDeleteDH = ""
        + " int index = -1;\n"
        + " int i = 1;\n"
        + " int position = wert % arraylaenge;\n"
        + " while(array[position] != 0 && index == -1\n\t\t"
                + " && i < arraylaenge)\n\t"
            + " if(array[position] == wert)\n\t\t"
                + " index= position;\n\t\t"
                + " if(loeschen)\n\t\t\t"
                    + " array[position] = -1;\n\t"
            + " position = (((wert % arraylaenge)\n\t\t"
                + " - i * (1 + wert % (arraylaenge - 2))) % arraylaenge)\n\t"
            + " i++;\n"
        + " return index;";
    
    private String commSearchDeleteDH = ""
        + "// markiere als nicht gefunden\n"
        + "// Wert um den verschoben wird\n"
        + "// Anfangsposition / h0\n"
        + "// suche bis leere Zelle oder Wert gefunden\n"
        + "// oder bis einmal durch Array gelaufen\n"
        + "// ist der Wert gefunden\n"
        + "// setze die Position auf den Index\n"
        + "// wenn der Wert geloescht werden soll\n"
        + "// markiere als geloescht\n"
        + "// naechste Position / hX\n"
        + "// \n"
        + "// Zaehler um 1 erhoehen\n"
        + "// Rueckgabe: Wert gefunden oder nicht gefunden";

    
    private String codeInsertDH = ""
        + " if(!arrayVoll && suche(wert)==-1)\n\t"
            + " int position =  wert % arraylaenge;\n\t"
            + " int i= 1;\n\t"
            + " while(array[position] != 0 && array[position] != -1\n\t\t\t"
                    + " && i < arraylaenge)\n\t\t"
                + " position = (((wert % arraylaenge)\n\t\t\t"
                    + " - i * (1 + wert % (arraylaenge - 2))) % arraylaenge)\n\t\t"
                + " i++;\n\t" 
            + " array[position] = wert;";
    
    private String commInsertDH = ""
        + "// Array nicht voll oder Wert nicht gefunden\n"
        + "// Anfangsposition / h0\n"
        + "// Wert um den verschoben wird\n"
        + "// suche bis leere oder als geloescht markierte Zelle\n"
        + "// oder bis einmal durch Array gelaufen\n"
        + "// naechste Position / hX\n"
        + "// \n"
        + "// Zaehler um 1 erhoehen\n"
        + "// fuege den Wert ein";
    
    private String infoDH = "DH";

    /**@formatter:on**/

    private JTextArea textCodeSearchDelete, textCommentSearchDelete,
    textCodeInsert, textCommentInsert, textInfo;

    private JLabel labelSearchDelete, labelInsert, labelInfo;

    public PseudoCodeView(JComboBox<String> cbVerfahren)
    {
        this.cbVerfahren = cbVerfahren;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        labelSearchDelete = new JLabel("Suchen / L\u00f6schen:");
        textCodeSearchDelete = new JTextArea();
        textCommentSearchDelete = new JTextArea();

        labelInsert = new JLabel("Einf\u00fcgen:");
        textCodeInsert = new JTextArea();
        textCommentInsert = new JTextArea();

        labelInfo = new JLabel("Info:");
        textInfo = new JTextArea("info");

        textCodeSearchDelete.setTabSize(2);
        textCodeInsert.setTabSize(2);

        // einrichten des GriBagLayouts
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.insets = new Insets(6, 6, 6, 6);
        add(labelSearchDelete, c);
        c.gridwidth = 1;
        c.gridy = 1;
        c.insets = new Insets(0, 6, 6, 0);
        add(textCodeSearchDelete, c);
        c.gridx = 1;
        c.insets = new Insets(0, 0, 6, 6);
        add(textCommentSearchDelete, c);

        c.gridwidth = 2;
        c.gridy = 2;
        c.gridx = 0;
        c.insets = new Insets(6, 6, 6, 6);
        add(labelInsert, c);
        c.gridwidth = 1;
        c.gridy = 3;
        c.insets = new Insets(0, 6, 6, 0);
        add(textCodeInsert, c);
        c.gridx = 1;
        c.insets = new Insets(0, 0, 6, 6);
        add(textCommentInsert, c);

        c.gridwidth = 2;
        c.gridy = 4;
        c.gridx = 0;
        c.insets = new Insets(6, 6, 6, 6);
        add(labelInfo, c);
        c.gridy = 5;
        c.insets = new Insets(0, 6, 6, 6);
        add(textInfo, c);

        textCodeSearchDelete.setEditable(false);
        textCommentSearchDelete.setEditable(false);
        textCodeInsert.setEditable(false);
        textCommentInsert.setEditable(false);
        textInfo.setEditable(false);

        Font font = new Font("Verdana", Font.PLAIN, 12);
        textCodeSearchDelete.setFont(font);
        textCommentSearchDelete.setFont(font);
        textCodeInsert.setFont(font);
        textCommentInsert.setFont(font);

        textCommentSearchDelete.setForeground(Color.getHSBColor(0.283F, 1.0F, 0.5F));
        textCommentInsert.setForeground(Color.getHSBColor(0.283F, 1.0F, 0.5F));

        font = new Font("Verdana", Font.BOLD, 14);
        labelSearchDelete.setFont(font);
        labelSearchDelete.setForeground(Color.DARK_GRAY);
        labelInsert.setFont(font);
        labelInsert.setForeground(Color.DARK_GRAY);
        labelInfo.setFont(font);
        labelInfo.setForeground(Color.DARK_GRAY);

        Insets inset = new Insets(6, 6, 6, 6);
        textCodeSearchDelete.setMargin(inset);
        textCommentSearchDelete.setMargin(inset);
        textCodeInsert.setMargin(inset);
        textCommentInsert.setMargin(inset);
        textInfo.setMargin(inset);

        fillText();
        setLocation((int) (screenSize.getWidth() / 2 - getSize().getWidth() / 2), (int) (screenSize.getHeight() / 2 - getSize().getHeight() / 2));
        setVisible(true);
    }

    public void fillText()
    {
        int index = cbVerfahren.getSelectedIndex();
        switch (index)
        {
            case 0:
                textCodeSearchDelete.setText(codeSearchDeleteLS);
                textCommentSearchDelete.setText(commSearchDeleteLS);
                textCodeInsert.setText(codeInsertLS);
                textCommentInsert.setText(commInsertLS);
                textInfo.setText(infoLS);
                break;
            case 1:
                textCodeSearchDelete.setText(codeSearchDeleteErwLS);
                textCommentSearchDelete.setText(commSearchDeleteErwLS);
                textCodeInsert.setText(codeInsertErwLS);
                textCommentInsert.setText(commInsertErwLS);
                textInfo.setText(infoErwLS);
                break;
            case 2:
                textCodeSearchDelete.setText(codeSearchDeleteQS);
                textCommentSearchDelete.setText(commSearchDeleteQS);
                textCodeInsert.setText(codeInsertQS);
                textCommentInsert.setText(commInsertQS);
                textInfo.setText(infoQS);
                break;
            case 3:
                textCodeSearchDelete.setText(codeSearchDeleteAltQS);
                textCommentSearchDelete.setText(commSearchDeleteAltQS);
                textCodeInsert.setText(codeInsertAltQS);
                textCommentInsert.setText(commInsertAltQS);
                textInfo.setText(infoAltQS);
                break;
            case 4:
                textCodeSearchDelete.setText(codeSearchDeleteDH);
                textCommentSearchDelete.setText(commSearchDeleteDH);
                textCodeInsert.setText(codeInsertDH);
                textCommentInsert.setText(commInsertDH);
                textInfo.setText(infoDH);
                break;

            default:
                break;
        }
        setTitle((String) cbVerfahren.getSelectedItem());
        pack();
    }
}
