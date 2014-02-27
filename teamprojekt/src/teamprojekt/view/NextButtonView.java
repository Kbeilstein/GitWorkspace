package teamprojekt.view;

import javax.swing.JButton;

import teamprojekt.model.Sondieren;

@SuppressWarnings("serial")
public class NextButtonView extends JButton
{
    private static Sondieren sond;

    @SuppressWarnings("static-access")
    public NextButtonView(Sondieren sond)
    {
        super("next");
        this.sond = sond;
    }

    public static void next()
    {
        // sond.verallgLinearesSondieren((int) (Math.random() * 100));
        // sond.linearesSondieren(7);
        // sond.verallgLinearesSondieren(7);
        sond.quadratischesSondieren((int) (Math.random() * 100));
    }
}