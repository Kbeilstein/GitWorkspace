package teamprojekt.view;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

@SuppressWarnings("serial")
public class LogView extends JTextArea
{
    public LogView()
    {
        super();
        setEditable(false);
        setAutoscrolls(true);
        setRows(10);
    }

    // die eigentliche schreib-Methode
    public void write(String text)
    {
        // um bei dem ersten Eintrag eine leer Zeile zu verhindern
        if (this.getDocument().getLength() == 0)
        {
            append(text);
        }
        else
        {
            append("\n" + text);
        }

        // damit bei einem neuen Eintrag in der Textarea automatisch weiter
        // gescrollt wird
        this.setCaretPosition(this.getDocument().getLength());
    }

    public void added(int value, int arrayPosition)
    {
        write(value + " an Stelle " + arrayPosition + " vom Feld geschrieben\n");
    }

    public void deleted(int index, int value)
    {
        write(value + " an Stelle " + index + " vom Feld gel\u00f6scht\n");
    }

    public void exists(int wert)
    {
        write(wert + " schon im Array vorhanden\n");
    }

    public void unAvailable(int value)
    {
        write(value + " im Array nicht vorhanden\n");
    }

    public void full()
    {
        write("Array voll\n");
    }

    public void error()
    {
        write("FEHLER - Wert kann nicht eingef\u00fcgt werden\n");
    }

    public void choosenC(int c)
    {
        write("Fuer c wird " + c + " gew\u00e4hlt\n");
    }

    private String insertSearchDeleteText(int arrayPosition, String isd)
    {
        String text = "";
        if (isd.equals("insert"))
        {
            text += " soll auf Arrayposition " + arrayPosition + " eingef\u00fcgt werden";
        }
        else if (isd.equals("search"))
        {
            text += " wird auf Arrayposition " + arrayPosition + " gesucht";
        }
        else
        {
            text += " soll auf Arrayposition " + arrayPosition + " gel\u00f6scht werden";
        }

        return text;
    }

    public void collisionLinearesSondieren(int value, int arrayPosition, int arrayLength, int i, String isd)
    {
        write("Kollision \u2192 Lineares Sondieren: " + value + " + " + i + " mod " + arrayLength + " = " + arrayPosition + " \u2192 " + value + insertSearchDeleteText(arrayPosition, isd));
    }

    public void collisionVerallgLinearesSondieren(int value, int arrayPosition, int arrayLength, int c, int i, String isd)
    {
        write("Kollision \u2192 Verallgemeintertes Lineares Sondieren: " + value + " + " + c + " * " + i + " mod " + arrayLength + " = " + arrayPosition + " \u2192 " + value + insertSearchDeleteText(arrayPosition, isd));
    }

    public void collisionQuadratischesSondieren(int value, int arrayPosition, int arrayLength, int i, String isd)
    {
        write("Kollision \u2192 Quadratisches Sondieren: " + value + " + " + i * i + " mod " + arrayLength + " = " + arrayPosition + " \u2192 " + value + insertSearchDeleteText(arrayPosition, isd));
    }

    public void collisionAlternierendesQuadrSondierenPlus(int value, int arrayPosition, int arrayLength, int i, String isd)
    {
        write("Kollision \u2192 Alternierendes Quadratisches Sondieren: " + value + " + " + i * i + " mod " + arrayLength + " = " + arrayPosition + " \u2192 " + value + insertSearchDeleteText(arrayPosition, isd));
    }

    public void collisionAlternierendesQuadrSondierenMinus(int value, int arrayPosition, int arrayLength, int i, String isd)
    {
        write("Kollision \u2192 Alternierendes Quadratisches Sondieren: " + value + " - " + i * i + " mod " + arrayLength + " = " + arrayPosition + " \u2192 " + value + insertSearchDeleteText(arrayPosition, isd));
    }

    public void collisionDoppelHashing(int value, int arrayPosition, int arrayLength, int i, String isd)
    {
        // h(x) - i * ( 1 + x mod (m-2))
        write("Kollision \u2192 Doppel-Hashing: (" + value + " mod " + arrayLength + ") - " + i + " * (1 + " + value + " mod (" + (arrayLength - 2) + ")) mod " + arrayLength + " = " + arrayPosition + " \u2192 " + value + insertSearchDeleteText(arrayPosition, isd));
    }

    public void writeFirstInsert(int value, int arrayPosition)
    {
        write(value + " soll auf Arrayposition " + arrayPosition + " eingef\u00fcgt werden");
    }

    public void writeFirstSearch(int value, int arrayPosition)
    {
        write(value + " wird an Arrayposition " + arrayPosition + " gesucht");
    }

    public void writeFirstDelete(int value, int arrayPosition)
    {
        write(value + " soll auf Arrayposition " + arrayPosition + " gel\u00f6scht werden");
    }

    public void writeInsert(int value)
    {
        write("Einf\u00fcgen des Wertes: " + value);
    }

    public void writeSearch(int value)
    {
        write("Suchen des Wertes: " + value);
    }

    public void writeDelete(int value)
    {
        write("L\u00f6schen des Wertes: " + value);
    }

    public void deleteLast()
    {
        // damit bei einem neuen Eintrag in der Textarea automatisch weiter
        // gescrollt wird
        int end;
        try
        {
            end = getLineEndOffset(getLineCount() - 2);
            setText(getText(0, end - 1));
        }
        catch (BadLocationException e)
        {
        }
        this.setCaretPosition(this.getDocument().getLength());
    }
}
