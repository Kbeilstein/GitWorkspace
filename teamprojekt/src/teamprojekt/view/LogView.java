package teamprojekt.view;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class LogView extends JTextArea
{
    public LogView()
    {
        super();
        setRows(10);
    }

    public void write(String text)
    {
        append(text + "\n");
    }

    public void added(int value, int arrayPosition)
    {
        write(value + " an Stelle " + arrayPosition + " vom Feld geschrieben\n");
    }

    public void deleted(int index, int value)
    {
        write(value + " an Stelle " + index + " vom Feld gelöscht\n");
    }

    public void available(int wert)
    {
        write(wert + " schon im Array vorhanden\n");
    }

    public void unAvailable(int value)
    {
        write(value + " im Array nicht vorhanden\n");
    }

    public void full()
    {
        write("Array voll\n");
    }

    public void error()
    {
        write("FEHLER - Wert kann nicht eingefügt werden\n");
    }

    public void choosenC(int c)
    {
        write("Fuer c wird " + c + " gewählt\n");
    }

    public void collisionLinearesSondieren(int wert, int arrayPosition, int arrayLaenge, int i)
    {
        write("Kollision \u2192 Lineares Sondieren (Formel): " + (wert % arrayLaenge) + " + " + i + " mod " + arrayLaenge + " = " + arrayPosition + " \u2192 " + wert + " soll auf Feldposition " + arrayPosition + " eingefügt werden");
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

    public void colDH(int wert, int arrayPosition, int arrayLaenge, int i)
    {
        write(wert + " auf Feldposition " + arrayPosition + ", Kollision -> Doppel-Hashing " + arrayPosition + " - " + i + " * (1 + " + wert + " mod " + (arrayLaenge - 2) + ")");
    }

}
