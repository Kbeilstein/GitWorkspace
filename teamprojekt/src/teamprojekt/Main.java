package teamprojekt;

import java.awt.Color;

import javax.swing.UIManager;

import teamprojekt.view.LayoutConfigView;

/**
 * 
 * Main-Klasse zum starten des Programms
 * 
 */

public class Main
{
    public static void main(String[] args)
    {
        // setzen der Farbe fuer die ToolTips, muss vor Erstellung des Frames
        // geschehen
        UIManager.put("ToolTip.background", Color.LIGHT_GRAY);
        new LayoutConfigView();
    }
}
