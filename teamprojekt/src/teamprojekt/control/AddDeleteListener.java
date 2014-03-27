package teamprojekt.control;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import teamprojekt.view.AddDeleteButtonView;

public class AddDeleteListener implements MouseInputListener
{
    private AddDeleteButtonView button;

    private boolean insertClicked;

    private boolean searchClicked;

    private boolean deleteClicked;

    public AddDeleteListener(AddDeleteButtonView b)
    {
        // TODO Auto-generated constructor stub
        this.button = b;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        // TODO Auto-generated method stub
        if (isInsert(e))
        {
            insertClicked = true;
            button.setInsertButtonClicked();
            ;
        }
        else if (isSearch(e))
        {
            searchClicked = true;
            button.setSearchButtonClicked();
        }
        else if (isDelete(e))
        {
            deleteClicked = true;
            button.setDeleteButtonClicked();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        // TODO Auto-generated method stub
        insertClicked = false;
        searchClicked = false;
        deleteClicked = false;
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        // TODO Auto-generated method stub
        button.setInsertButtonOff();
        button.setSearchButtonOff();
        button.setDeleteButtonOff();
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        // TODO Auto-generated method stub
        mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        // TODO Auto-generated method stub
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
