package panels;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import zakati.ProjectButton;
import utils.Consts;

public class ScreenPanel extends JPanel{
	public JLabel titleLabel;
	
	JPanel midPanel;
	ResultPanel resPanel;
	
	JButton calcBtn;
	
	ScreenPanel(){
		titleLabel = new JLabel();
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD , 32));
		
		calcBtn = new ProjectButton(Consts.CALC);
		
		midPanel = new JPanel();
		
		resPanel = new ResultPanel();
		
		this.setBorder(BorderFactory.createEmptyBorder(Consts.MARGIN, Consts.MARGIN, Consts.MARGIN, Consts.MARGIN));
		this.setLayout(new GridLayout(3, 1, Consts.MARGIN, Consts.MARGIN));
	}
}
