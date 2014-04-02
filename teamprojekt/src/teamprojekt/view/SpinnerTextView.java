package teamprojekt.view;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class SpinnerTextView extends JTextField
{

    public SpinnerTextView()
    {
        // Zeilen auf 2 setzen, da der Wert maximal 2 Zeichen haben kann
        setColumns(2);
        setHorizontalAlignment(JTextField.CENTER);

        // um falsche Eingaeben zu unterbinden werden fast alle "ung�ltigen"
        // Eingaben im vorhinein gefiltert, 1 als alleinige Eingabe kann aber
        // vorkommen und muss mit dem dr�cken des Startbutton "abefangen" werden
        setDocument(new PlainDocument()
        {
            private static final long serialVersionUID = 1L;

            @Override
            public void insertString(int off, String str, AttributeSet as) throws BadLocationException
            {
                // Pr�ft, ob bereits 2 Zeichen vorhanden sind oder ob der
                // einzuf�gende String plus dem bisher vorhanden String l�nger
                // als 2 Zeichen ist
                if (getLength() >= 2 || (str.length() + getLength()) > 2)
                {
                    return;
                }

                // Pr�ft, ob die erste Stelle des einzuf�genden Strings mit 1
                // oder 5-9 beginnt
                if ((str.charAt(0) == '0' || str.charAt(0) == '2' || str.charAt(0) == '3' || str.charAt(0) == '4') && off == 0)
                {
                    return;
                }

                // Pr�ft, wenn schon ein einstelliger Wert vorhanden ist, ob
                // davor was anderes als eine 1 eingetragen wird
                if (getLength() == 1 && (getText(0, 1).charAt(0) != '1'))
                {
                    return;
                }

                // Pr�ft, ob die einzuf�genden Zeichen Zahlen sind
                for (int i = 0; i < str.length(); i++)
                {
                    if (!Character.isDigit(str.charAt(i)))
                    {
                        return;
                    }
                }

                // Zahl(en) einf�gen
                super.insertString(off, str, as);
            }
        });

        // Startwert setzen
        setText("11");
    }
}
