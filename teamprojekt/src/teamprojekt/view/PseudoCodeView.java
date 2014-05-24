package teamprojekt.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

    private JPanel panelSearchDelete, panelInsert, panelInfo;

    public PseudoCodeView(JComboBox<String> cbVerfahren)
    {
        this.cbVerfahren = cbVerfahren;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(650, 630);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (screenSize.getWidth() / 2 - getSize().getWidth() / 2), (int) (screenSize.getHeight() / 2 - getSize().getHeight() / 2));

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        panelSearchDelete = new JPanel(new BorderLayout());
        labelSearchDelete = new JLabel("Suchen / L\u00f6schen:");
        textCodeSearchDelete = new JTextArea();
        textCommentSearchDelete = new JTextArea();

        panelInsert = new JPanel(new BorderLayout());
        labelInsert = new JLabel("Einf\u00fcgen:");
        textCodeInsert = new JTextArea();
        textCommentInsert = new JTextArea();

        panelInfo = new JPanel(new BorderLayout());
        labelInfo = new JLabel("Info:");
        textInfo = new JTextArea("info");

        textCodeSearchDelete.setTabSize(2);
        textCodeInsert.setTabSize(2);

        fillText();

        panelSearchDelete.add(labelSearchDelete, BorderLayout.PAGE_START);
        panelSearchDelete.add(textCodeSearchDelete, BorderLayout.LINE_START);
        panelSearchDelete.add(textCommentSearchDelete, BorderLayout.CENTER);

        panelInsert.add(labelInsert, BorderLayout.PAGE_START);
        panelInsert.add(textCodeInsert, BorderLayout.LINE_START);
        panelInsert.add(textCommentInsert, BorderLayout.CENTER);

        panelInfo.add(labelInfo, BorderLayout.PAGE_START);
        panelInfo.add(textInfo, BorderLayout.CENTER);

        add(panelSearchDelete);
        add(panelInsert);
        add(panelInfo);

        textCodeSearchDelete.setEditable(false);
        textCommentSearchDelete.setEditable(false);
        textCodeInsert.setEditable(false);
        textCommentInsert.setEditable(false);
        textInfo.setEditable(false);

        textCodeSearchDelete.setFont(new Font("Courier New", Font.BOLD, 14));
        textCommentSearchDelete.setFont(new Font("Courier New", Font.ITALIC, 14));
        textCodeInsert.setFont(new Font("Courier New", Font.BOLD, 14));
        textCommentInsert.setFont(new Font("Courier New", Font.ITALIC, 14));

        textCommentSearchDelete.setForeground(Color.getHSBColor(0.283F, 1.0F, 0.5F));
        textCommentInsert.setForeground(Color.getHSBColor(0.283F, 1.0F, 0.5F));

        labelSearchDelete.setFont(new Font("", Font.BOLD, 16));
        labelInsert.setFont(new Font("", Font.BOLD, 16));
        labelInfo.setFont(new Font("", Font.BOLD, 16));

        textCodeSearchDelete.setMargin(new Insets(10, 10, 10, 10));
        textCommentSearchDelete.setMargin(new Insets(10, 10, 10, 10));
        textCodeInsert.setMargin(new Insets(10, 10, 10, 10));
        textCommentInsert.setMargin(new Insets(10, 10, 10, 10));
        textInfo.setMargin(new Insets(10, 10, 10, 10));

        panelSearchDelete.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelInsert.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        pack();
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
