package teamprojekt.view;

import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ComboView extends JPanel 

{
    private String[] verFahren = {"Lineares Sondieren",
                    "Verallg. Lineares Sondieren", 
                    "Quadratisches Sondieren", 
                    "altanierendes Quad. Sondieren",
                    "Doppelthashing"};

    private int[] arryGroesse = {5,7,11,13,17,19};
    
    

    public ComboView()
    {
        setLayout(new GridLayout(0,1));
        
        
        JComboBox<?> versVerf = new JComboBox(verFahren);
        versVerf.setEditable(false);
        add(versVerf);
        
        
        JComboBox<?> versArryLaenge = new JComboBox(Arrays.toString(arryGroesse).split("[\\[\\]]")[1].split(", "));
        versArryLaenge.setEditable(false);
        add(versArryLaenge);
        
        JButton start = new JButton("Start");
        add(start);
        
        
        
    }


    
    
    
    
}
