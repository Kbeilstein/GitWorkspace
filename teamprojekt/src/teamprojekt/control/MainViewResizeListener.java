package teamprojekt.control;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JLabel;

import teamprojekt.view.AddDeleteButtonView;
import teamprojekt.view.AnimationSpeedSliderView;
import teamprojekt.view.ControlButtonsView;
import teamprojekt.view.InsertValueTextBoxView;
import teamprojekt.view.MainView;

public class MainViewResizeListener implements ComponentListener
{
    private AnimationSpeedSliderView slider;

    private ControlButtonsView cbView;

    private MainView mainViewcbView;

    private JLabel textBoxLabel;

    private InsertValueTextBoxView textBox;

    private AddDeleteButtonView adbView;

    public MainViewResizeListener(ControlButtonsView cbView, AnimationSpeedSliderView slider, MainView mainViewcbView, JLabel textBoxLabel, InsertValueTextBoxView textBox, AddDeleteButtonView adbView)
    {
        this.cbView = cbView;
        this.slider = slider;
        this.mainViewcbView = mainViewcbView;
        this.textBoxLabel =textBoxLabel;
        this.textBox = textBox;
        this.adbView =adbView;
    }
    
    @Override
    public void componentResized(ComponentEvent e)
    {
        cbView.setBounds((mainViewcbView.getWidth() / 2 - 10 - 175), 2, 150, 50);
        slider.setBounds((mainViewcbView.getWidth() / 2 - 10 - 15), 2, 200, 50);
        textBoxLabel.setBounds((mainViewcbView.getWidth() / 2 - 10 - 240), 2, 70, 20);
        textBox.setBounds((mainViewcbView.getWidth() / 2 - 10 - 170), 1, 50, 24);
        adbView.setBounds((mainViewcbView.getWidth() / 2 - 10 - 100), 1, 360, 30);
    }

    @Override
    public void componentMoved(ComponentEvent e)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void componentShown(ComponentEvent e)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void componentHidden(ComponentEvent e)
    {
        // TODO Auto-generated method stub

    }

}
