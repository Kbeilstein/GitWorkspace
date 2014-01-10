package teamprojekt;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class LogView extends JTextArea
{    
    public LogView()
    {
        super();

    }

    public void write(String text)
    {
        append(text + "\n");
    }
}
