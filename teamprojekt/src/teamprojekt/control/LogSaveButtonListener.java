package teamprojekt.control;

import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.MouseInputListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import teamprojekt.view.LogSaveButtonView;
import teamprojekt.view.LogView;

public class LogSaveButtonListener implements MouseInputListener, PropertyChangeListener
{
    private LogSaveButtonView logsaveButton;

    private JTextArea text;

    private String extension;

    private boolean logsaveClicked;

    public LogSaveButtonListener(LogSaveButtonView b, LogView logField)
    {
        this.logsaveButton = b;
        text = logField;
        extension = ".txt";
        JFileChooser.setDefaultLocale(Locale.GERMAN);
    }

    public void startSave()
    {
        JFileChooser fileChooser = null;
        LookAndFeel previousLF = UIManager.getLookAndFeel();
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

        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".txt", "txt"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".log", "log"));
        fileChooser.addPropertyChangeListener(this);

        if (fileChooser != null && fileChooser.showSaveDialog(fileChooser) == JFileChooser.APPROVE_OPTION)
        {
            String fileName = fileChooser.getSelectedFile().getAbsolutePath();
            // falls eine Datei ausgewählt wird ist der name schon im Pfad
            // vorhanden, ansonsten muss noch der gewählte Name angehangen
            // werden
            if (!fileName.contains(fileChooser.getSelectedFile().getName()))
            {
                fileName += fileChooser.getSelectedFile().getName();
            }
            // wenn der gewählte Name keinen . enthält, für den Dateitypen, wir
            // der gewählte hinzugefügt
            if (fileName.contains("" + File.separatorChar) && !fileName.substring(fileName.lastIndexOf(File.separatorChar)).contains("."))
            {
                fileName += extension;
            }

            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName)), "UTF-8")))
            {
                text.write(bw);
            }
            catch (IOException e)
            {
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        if (evt.toString().contains("fileFilterChanged") && evt.getNewValue().toString().contains(".txt"))
        {
            extension = ".txt";
        }
        else if (evt.toString().contains("fileFilterChanged") && evt.getNewValue().toString().contains(".log"))
        {
            extension = ".log";
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (isPseudoCode(e))
        {
            startSave();
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (isPseudoCode(e))
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
        if (isPseudoCode(e) && logsaveClicked)
        {
            logsaveButton.setPseudoButtonClicked();
        }
        else if (isPseudoCode(e))
        {
            logsaveButton.setPseudoButtonOn();
        }
        else
        {
            logsaveButton.setPseudoButtonOff();
        }
    }

    private boolean isPseudoCode(MouseEvent e)
    {
        return e.getX() > 1 && e.getY() > 1 && e.getX() < 126 && e.getY() < 21;
    }
}
