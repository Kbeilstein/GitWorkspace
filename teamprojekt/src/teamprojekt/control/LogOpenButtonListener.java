package teamprojekt.control;

import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.MouseInputListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import teamprojekt.model.Pair;
import teamprojekt.view.LogOpenButtonView;

public class LogOpenButtonListener implements MouseInputListener
{
    private LogOpenButtonView logsaveButton;

    private boolean logsaveClicked;

    private StartButtonListener sbListener;

    public LogOpenButtonListener(LogOpenButtonView b, StartButtonListener sbListener)
    {
        this.logsaveButton = b;
        this.sbListener = sbListener;
        JComponent.setDefaultLocale(Locale.GERMAN);
    }

    public ArrayList<Pair> startOpen()
    {
        ArrayList<Pair> sequence = new ArrayList<>();
        JFileChooser fileChooser = null;
        LookAndFeel previousLF = UIManager.getLookAndFeel();
        // Optik des Auswahlfensters wird dem aktuellen Design angepaﬂt
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            fileChooser = new JFileChooser();
            UIManager.setLookAndFeel(previousLF);
        }
        catch (ClassNotFoundException | InstantiationException
        | IllegalAccessException | UnsupportedLookAndFeelException e)
        {
        }

        // Filterung verschiedener Dateitypen
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".txt", "txt"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".log", "log"));

        // Einlesen der Log Datei in eine ArrayList anhand von "Markern"
        if (fileChooser != null && fileChooser.showOpenDialog(fileChooser) == JFileChooser.APPROVE_OPTION)
        {
            String fileName = fileChooser.getSelectedFile().getAbsolutePath();

            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8")))
            {
                String line;
                while ((line = br.readLine()) != null)
                {
                    if (line.contains("Einf\u00fcgen des Wertes: "))
                    {
                        int value = Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1));
                        sequence.add(new Pair(value, "insert"));
                    }
                    else if (line.contains("Suchen des Wertes: "))
                    {
                        int value = Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1));
                        sequence.add(new Pair(value, "insert"));
                    }
                    else if (line.contains("L\u00f6schen des Wertes: "))
                    {
                        int value = Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1));
                        sequence.add(new Pair(value, "insert"));
                    }
                }
            }
            catch (IOException e)
            {
                sequence = new ArrayList<>();
            }
        }
        else
        {
            // Falls abgebrochen wird soll keine neues Verfahren gestartet
            // werden
            sequence = null;
        }
        return sequence;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (isLogButton(e))
        {
            sbListener.action(startOpen());
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (isLogButton(e))
        {
            logsaveClicked = true;
            logsaveButton.setPseudoButtonClicked();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        logsaveClicked = false;
        mouseMoved(e);
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        logsaveButton.setPseudoButtonOff();
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        if (isLogButton(e) && logsaveClicked)
        {
            logsaveButton.setPseudoButtonClicked();
        }
        else if (isLogButton(e))
        {
            logsaveButton.setPseudoButtonOn();
        }
        else
        {
            logsaveButton.setPseudoButtonOff();
        }
    }

    private boolean isLogButton(MouseEvent e)
    {
        return e.getX() > 1 && e.getY() > 1 && e.getX() < 126 && e.getY() < 21;
    }
}
