package teamprojekt.view;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class InsertValueTextBoxView extends JTextField
{
    public InsertValueTextBoxView()
    {
        // Zeilen auf 2 setzen, da der Wert maximal 2 Zeichen haben kann
        setColumns(2);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font(Font.DIALOG, Font.PLAIN, 14));

        // um falsche Eingaben zu unterbinden werden fast "alle ungültigen"
        // Eingaben im vorhinein gefiltert
        this.setToolTipText("Zahlen von 1-99");
        this.setDocument(new PlainDocument()
        {
            private static final long serialVersionUID = 1L;

            @Override
            public void insertString(int off, String str, AttributeSet as) throws BadLocationException
            {
                // Prüft, ob bereits 2 Zeichen vorhanden sind oder ob der
                // einzufügende String plus dem bisher vorhanden String länger
                // als 2 Zeichen ist
                if (getLength() >= 2 || (str.length() + getLength()) > 2)
                {
                    return;
                }

                // Prüfen, ob die einzufügenden Zeichen Zahlen sind
                for (int i = 0; i < str.length(); i++)
                {
                    if (!Character.isDigit(str.charAt(i)))
                    {
                        return;
                    }

                    if (str.charAt(0) == '0' && off == 0)
                    {
                        return;
                    }
                }

                // Zahl(en) einfügen
                super.insertString(off, str, as);
            }
        });

    }
}
