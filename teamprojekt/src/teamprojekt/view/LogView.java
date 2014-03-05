package teamprojekt.view;

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

    public void added(int value, int arrayPosition)
    {
        write(value + " an Stelle " + arrayPosition + " vom Feld geschrieben");
    }

    public void deleted(int index, int value)
    {
        write(value + " an Stelle " + index + " vom Feld gelöscht");
    }

    public void unAvailable(int value)
    {
        write(value + " im Array nicht vorhanden");
    }

    public void full()
    {
        write("Array voll");
    }

    public void error()
    {
        write("FEHLER - Wert kann nicht eingefügt werden");
    }

    public void available(int wert)
    {
        write(wert + " schon im Array vorhanden");
    }

    public void choosenC(int c)
    {
        write("Fuer c wird " + c + " gewaehlt");
    }

    public void colLS(int wert, int arrayPosition, int arrayLaenge, int i)
    {
        write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> Lineares Sondieren " + (wert % arrayLaenge) + " + " + i);
    }

    public void colErwLS(int wert, int arrayPosition, int arrayLaenge, int c, int i)
    {
        write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> erw. Lineares Sondieren " + (wert % arrayLaenge) + " + " + c + " * " + i);
    }

    public void colQSi(int wert, int arrayPosition, int arrayLaenge, int i)
    {
        write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> Quadratisches Sondieren " + (wert % arrayLaenge) + " + " + i + "^2");
    }

    public void colQSj(int wert, int arrayPosition, int arrayLaenge, int j)
    {
        write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> Quadratisches Sondieren " + (wert % arrayLaenge) + " - " + j + "^2");
    }

    public void colDH(int wert, int arrayPosition, int i, int arrayLaenge)
    {
        write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> Doppel-Hashing " + arrayPosition + " - " + i + " * (1 + " + wert + " mod " + (arrayLaenge - 2) + ")");
    }

}
