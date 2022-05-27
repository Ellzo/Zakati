package panels;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import zakati.ProjectButton;
import zakati.Projet;
import utils.Calculations;
import utils.Consts;

public class ZakatArgentPanel extends ScreenPanel implements ActionListener{
	private Projet p;
	
	private TextField montantField;
	
	private int montantZakat;
	
	public ZakatArgentPanel(Projet p) {
		this.p = p;
		
		titleLabel.setText(Consts.ZAKAT_ARG);
		
		JPanel montantPanel = new JPanel();
		montantPanel.setLayout(new FlowLayout());
		montantPanel.add(new JLabel(Consts.POIDS_ARG));
		montantField = new TextField();
		montantField.setPreferredSize(Consts.FIELD_DIMEN);
		montantPanel.add(montantField);
		
		JPanel calcPanel = new JPanel();
		calcPanel.add(calcBtn);
		
		midPanel.setLayout(new GridLayout(2, 1));
		midPanel.add(montantPanel);
		midPanel.add(calcPanel);
		
		calcBtn.addActionListener(this);
		resPanel.nextBtn.addActionListener(this);
		
		this.add(titleLabel);
		this.add(midPanel);
		this.add(resPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == calcBtn) {
			montantZakat = (int) Math.round(Calculations.calcZakatArgent(Integer.parseInt(montantField.getText())));
			resPanel.show(montantZakat);
		}else if(e.getSource() == resPanel.nextBtn) {
			resPanel.nextBtn.setEnabled(false);
			p.addToZakat(montantZakat);
			p.moveToNextPanel();
		}
	}
}
