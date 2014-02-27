package teamprojekt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import teamprojekt.view.NextButtonView;

public class NextButtonHandler implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // TODO Auto-generated method stub
        NextButtonView.next();
    }

}
