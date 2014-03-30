package teamprojekt.view;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class InsertValueTextBoxView extends JTextField
{
    public InsertValueTextBoxView()
    {
        /*
         * 
         * Das Textfeld soll nur Zahlen zulassen und als Maximum soll maximal
         * eine fünfstellige Zahl im Textfeld stehen.
         */
        this.setToolTipText("Zahlen von 1-99");
        this.setDocument(new PlainDocument()
        {
            private static final long serialVersionUID = 1L;

            @Override
            public void insertString(int off, String str, AttributeSet as) throws BadLocationException
            {
                // Prüfen, ob bereits 5 Zeichen drin stehen
                if (getLength() >= 2)
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
