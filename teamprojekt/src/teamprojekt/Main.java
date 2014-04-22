package teamprojekt;

import java.awt.Color;

import javax.swing.UIManager;

import teamprojekt.view.LayoutConfigView;

public class Main
{
    public static void main(String[] args)
    {
        UIManager.put("ToolTip.background", Color.LIGHT_GRAY);
        new LayoutConfigView();
    }
}
