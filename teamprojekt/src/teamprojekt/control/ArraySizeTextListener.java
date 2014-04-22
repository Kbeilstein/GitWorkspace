package teamprojekt.control;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import teamprojekt.view.AlgorithmPickListener;
import teamprojekt.view.SpinnerTextView;

public class ArraySizeTextListener implements DocumentListener
{
    private SpinnerTextView spinnerTextView;

    private JButton startButton;

    private JLabel startButtonLabel;

    private AlgorithmPickListener algoPickListener;

    public ArraySizeTextListener(SpinnerTextView spinnerTextView, JLabel startButtonLabel, AlgorithmPickListener algoPickListener)
    {
        this.spinnerTextView = spinnerTextView;
        this.startButton = new JButton();
        this.startButtonLabel = startButtonLabel;
        this.algoPickListener = algoPickListener;
        insertUpdate(null);
    }

    @Override
    public void insertUpdate(DocumentEvent e)
    {
        if (spinnerTextView.getText().isEmpty() || Integer.parseInt(spinnerTextView.getText()) > 19 || Integer.parseInt(spinnerTextView.getText()) < 5)
        {
            startButton.setEnabled(false);
            startButtonLabel.setForeground(Color.RED);
        }
        else
        {
            startButton.setEnabled(true);
            // Text wird lediglich mit Alpha 0 gezeichnet, somit "unsichtbar",
            // da sonst das Label nicht gezeichnet wird und die buttons im
            // Layout "springen"
            startButtonLabel.setForeground(new Color(10, 10, 10, 0));
        }
        algoPickListener.update();
    }

    @Override
    public void removeUpdate(DocumentEvent e)
    {
        insertUpdate(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e)
    {
        insertUpdate(e);
    }

}
