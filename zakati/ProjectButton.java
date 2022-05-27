package zakati;

import java.awt.Dimension;

import javax.swing.JButton;

public class ProjectButton extends JButton{
	
	public ProjectButton(String text){
		this.setText(text);
		this.setPreferredSize(new Dimension(250, 50));
		this.setFocusable(false);
	}

}
