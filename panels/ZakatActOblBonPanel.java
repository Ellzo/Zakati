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

public class ZakatActOblBonPanel extends ScreenPanel implements ActionListener{
	private Projet p;
	
	private TextField valField;
	private TextField numField;
	
	private int montantZakat;
	
	public ZakatActOblBonPanel(Projet p ,int panelType) {
		this.p = p;
		
		String title = "";
		String val = "";
		String num = "";
		switch(panelType) {
		case Consts.ACT_PANEL:
			title = Consts.ZAKAT_ACT;
			val = Consts.VAL_ACT;
			num = Consts.NUM_ACT;
			break;
		case Consts.OBL_PANEL:
			title = Consts.ZAKAT_OBL;
			val = Consts.VAL_OBL;
			num = Consts.NUM_OBL;
			break;
		case Consts.BON_PANEL:
			title = Consts.ZAKAT_BON;
			val = Consts.VAL_BON;
			num = Consts.NUM_BON;
			break;
		}
		
		titleLabel.setText(title);
		
		JPanel valPanel = new JPanel();
		valPanel.setLayout(new FlowLayout());
		valPanel.add(new JLabel(val));
		valField = new TextField();
		valField.setPreferredSize(Consts.FIELD_DIMEN);
		valPanel.add(valField);
		
		JPanel numPanel = new JPanel();
		numPanel.setLayout(new FlowLayout());
		numPanel.add(new JLabel(num));
		numField = new TextField();
		numField.setPreferredSize(Consts.FIELD_DIMEN);
		numPanel.add(numField);
		
		
		JPanel calcPanel = new JPanel();
		calcPanel.add(calcBtn);
		
		midPanel.setLayout(new GridLayout(3, 1));
		midPanel.add(valPanel);
		midPanel.add(numPanel);
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
			montantZakat = (int) Math.round(Calculations.calcZakatActOblBon(
					Integer.parseInt(valField.getText()),
					Integer.parseInt(numField.getText())));
			resPanel.show(montantZakat);
		}else if(e.getSource() == resPanel.nextBtn) {
			resPanel.nextBtn.setEnabled(false);
			p.addToZakat(montantZakat);
			p.moveToNextPanel();
		}
	}
}
