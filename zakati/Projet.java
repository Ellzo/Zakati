package zakati;

import javax.swing.*;

import panels.*;
import utils.Consts;


public class Projet {
	private ScreenPanel currentPanel;
	private JFrame frame;
	
	private int zakatTotale = 0;
	
	private enum SCREEN{
		MainPanel, 
		ZakatMonnaiePanel, 
		ZakatTransComPanel, 
		ZakatActOblBonPanel,
		ZakatOrPanel,
		ZakatArgentPanel,
		ZakatTotalePanel
	}
	
	public Projet() {
		frame = new JFrame();
		currentPanel = new MainPanel(this);
        
        frame.add(currentPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setTitle(Consts.TITLE);
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);
	}
   
    public static void main (String[] args) {

    	new Projet();
    	
    }

    public void moveToNextPanel() {
    	
    	frame.remove(currentPanel);
    	
    	SCREEN s = SCREEN.valueOf(currentPanel.getClass().getSimpleName());
    	switch (s) {
    	case MainPanel:
    		currentPanel = new ZakatMonnaiePanel(this);
    		break;
    	case ZakatMonnaiePanel:
    		currentPanel = new ZakatTransComPanel(this);
    		break;
    	case ZakatTransComPanel:
    		currentPanel = new ZakatActOblBonPanel(this, Consts.ACT_PANEL);
    		break;
    	case ZakatActOblBonPanel:
    		Inner:switch(currentPanel.titleLabel.getText()) {
    		case Consts.ZAKAT_ACT:
    			currentPanel = new ZakatActOblBonPanel(this, Consts.OBL_PANEL);
    			break Inner;
    		case Consts.ZAKAT_OBL:
    			currentPanel = new ZakatActOblBonPanel(this, Consts.BON_PANEL);
    			break Inner;
    		default:
    			currentPanel = new ZakatOrPanel(this);
    			break Inner;
    		}
    		break;
    	case ZakatOrPanel:
    		currentPanel = new ZakatArgentPanel(this);
    		break;
    	case ZakatArgentPanel:
    		currentPanel = new ZakatTotalePanel(this, zakatTotale);
    		break;
    	default:
    		currentPanel = new MainPanel(this);
    		break;
    	}
    	
    	frame.add(currentPanel);
    	frame.validate();
        frame.repaint();
    	
    }
    
    public void addToZakat(int amount) {
    	zakatTotale += amount;
    }
}
    
