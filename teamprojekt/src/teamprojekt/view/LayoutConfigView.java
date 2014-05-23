package teamprojekt.view;

import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class LayoutConfigView extends JFrame
{
    private HelpFrameView hframe;

    public LayoutConfigView()
    {
        super("Hashing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher()
        {
            public boolean dispatchKeyEvent(KeyEvent e)
            {
                if (KeyEvent.VK_F1 == e.getKeyCode() && e.toString().contains("KEY_PRESSED"))
                {
                    if (hframe == null)
                    {
                        hframe = new HelpFrameView();
                    }
                    hframe.setVisible(true);
                }
                return false;
            }
        });

        // Variable um die Bildschirmbreite abzuspeichern
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setMinimumSize(new Dimension(1280, 720));
        setLocation((int) (screenSize.getWidth() / 2 - getSize().getWidth() / 2), (int) (screenSize.getHeight() / 2 - getSize().getHeight() / 2));

        MainView obenrechts = new MainView();

        ComboView obenlinks = new ComboView(obenrechts);

        JPanel untenlinks = new JPanel();

        LegendView untenrechts = new LegendView();

        // Layout erstellt durch WindowBuilder-Plugin
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(5).addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false).addComponent(untenlinks, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE).addComponent(obenlinks, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(untenrechts, GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE).addComponent(obenrechts, GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)).addGap(5)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addComponent(obenlinks, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(untenlinks, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE).addPreferredGap(ComponentPlacement.RELATED)).addGroup(groupLayout.createSequentialGroup().addComponent(obenrechts, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE).addPreferredGap(ComponentPlacement.RELATED).addComponent(untenrechts, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))).addGap(5)));
        setLayout(groupLayout);

        setVisible(true);
    }
}
