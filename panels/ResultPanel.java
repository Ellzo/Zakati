package panels;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import zakati.ProjectButton;
import utils.Consts;

public class ResultPanel extends JPanel{
	JLabel resLabel;
	JButton nextBtn;
	
	ResultPanel(){
		this.setVisible(false);
		
		JPanel nextPanel = new JPanel();
		nextBtn = new ProjectButton(Consts.NEXT);
		nextPanel.add(nextBtn);
		
		resLabel = new JLabel();
		resLabel.setHorizontalAlignment(JLabel.CENTER);
		
		this.setLayout(new GridLayout(2, 1));
		this.add(resLabel);
		this.add(nextPanel);
	}
	
	void show(int amount) {
		resLabel.setText(Consts.ZAKAT_TYPE_MONTANT + amount + Consts.UNIT);
		this.setVisible(true);
	}
}
