package teamprojekt.control;

import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;

import teamprojekt.model.Sondieren;
import teamprojekt.view.AddDeleteButtonView;

public class AddDeleteListener implements MouseInputListener
{
    private AddDeleteButtonView button;

    private JTextField textBox;

    private Sondieren sondieren;

    private boolean insertClicked;

    private boolean searchClicked;

    private boolean deleteClicked;

    public AddDeleteListener(AddDeleteButtonView b, JTextField textBox, Sondieren sondieren)
    {
        this.textBox = textBox;
        this.sondieren = sondieren;
        this.button = b;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (sondieren.getArrayPosition() == -1)
        {
            if (isInsert(e))
            {
                insertClicked = true;
                button.setInsertButtonClicked();
                buttonReaction("insert");
            }
            else if (isSearch(e))
            {
                searchClicked = true;
                button.setSearchButtonClicked();
                buttonReaction("search");
            }
            else if (isDelete(e))
            {
                deleteClicked = true;
                button.setDeleteButtonClicked();
                buttonReaction("delete");
            }
            // Label auf "durchsichtig Setzen"
        }
        else if (isInsert(e) || isSearch(e) || isDelete(e))
        {
            // Text in Label setzen
            // System.out.println("Aktion erst nach Ende der Animation möglich");
        }
    }

    private void buttonReaction(String type)
    {
        String textBoxString = textBox.getText();
        boolean possible = false;

        // prüft beim drücken der Buttons zuerst, ob die Eingabe gültig ist
        // muß zusätzlich zur Eingabebeschränkung gemacht werden, da falsche
        // Werte die per Copy-Paste eingefügt werden sonst zu Fehler führen
        for (int i = 0; i < textBoxString.length() && !textBoxString.equals("0"); i++)
        {
            // laenge darf maximal 2 sein und an beiden Stellen muss der Wert
            // eine Zahle sein
            if (textBoxString.charAt(i) >= '0' && textBoxString.charAt(i) <= '9' && i < 2)
            {
                possible = true;
            }
            else
            {
                possible = false;
            }
        }

        if (possible && sondieren.getArrayPosition() == -1)
        {
            int value = Integer.parseInt(textBox.getText());
            sondieren.setInsertSearchDelete(type);
            if (type.equals("insert"))
            {
                sondieren.insert(value);
            }
            else if (type.equals("search"))
            {
                sondieren.search(value);
            }
            else
            {
                sondieren.delete(value);
            }
            textBox.setText("");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        insertClicked = false;
        searchClicked = false;
        deleteClicked = false;
        mouseMoved(e);
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        button.setInsertButtonOff();
        button.setSearchButtonOff();
        button.setDeleteButtonOff();
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        if (isInsert(e) && insertClicked)
        {
            button.setInsertButtonClicked();
            button.setSearchButtonOff();
            button.setDeleteButtonOff();
        }
        else if (isSearch(e) && searchClicked)
        {
            button.setInsertButtonOff();
            button.setSearchButtonClicked();
            button.setDeleteButtonOff();

        }
        else if (isDelete(e) && deleteClicked)
        {
            button.setInsertButtonOff();
            button.setSearchButtonOff();
            button.setDeleteButtonClicked();
        }
        else if (isInsert(e))
        {
            button.setInsertButtonOn();
            button.setSearchButtonOff();
            button.setDeleteButtonOff();
        }
        else if (isSearch(e))
        {
            button.setInsertButtonOff();
            button.setSearchButtonOn();
            button.setDeleteButtonOff();

        }
        else if (isDelete(e))
        {
            button.setInsertButtonOff();
            button.setSearchButtonOff();
            button.setDeleteButtonOn();
        }
        else
        {
            button.setInsertButtonOff();
            button.setSearchButtonOff();
            button.setDeleteButtonOff();
        }
    }

    private boolean isInsert(MouseEvent e)
    {
        return e.getX() > 1 && e.getY() > 1 && e.getX() < 111 && e.getY() < 21;
    }

    private boolean isSearch(MouseEvent e)
    {
        return e.getX() > 126 && e.getY() > 1 && e.getX() < 226 && e.getY() < 21;
    }

    private boolean isDelete(MouseEvent e)
    {
        return e.getX() > 241 && e.getY() > 1 && e.getX() < 341 && e.getY() < 21;
    }

}
