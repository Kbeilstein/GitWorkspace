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
    }

    private void buttonReaction(String type)
    {
        if (!textBox.getText().isEmpty() && sondieren.getArrayPosition() == -1)
        {
            int typeToStart = Integer.parseInt(textBox.getText());
            sondieren.setInsertSearchDelete(type);
            if (type.equals("insert"))
            {
                sondieren.add(typeToStart);
            }
            else if (type.equals("search"))
            {
                sondieren.search(typeToStart);
            }
            else
            {
                sondieren.delete(typeToStart);
            }
        }
        textBox.setText("");
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
        return e.getX() > 2 && e.getY() > 2 && e.getX() < 102 && e.getY() < 22;
    }

    private boolean isSearch(MouseEvent e)
    {
        return e.getX() > 122 && e.getY() > 2 && e.getX() < 222 && e.getY() < 22;
    }

    private boolean isDelete(MouseEvent e)
    {
        return e.getX() > 242 && e.getY() > 2 && e.getX() < 342 && e.getY() < 22;
    }

}
