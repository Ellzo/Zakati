package panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import zakati.Projet;
import utils.Calculations;
import utils.Consts;

public class ZakatTransComPanel extends ScreenPanel implements ActionListener{
	private Projet p;
	
	private TextField montantField;
	private TextField epargneField;
	private TextField escompteField;
	private TextField nonLiquideField;
	
	private int montantZakat;
	
	public ZakatTransComPanel(Projet p) {
		this.p = p;
		titleLabel.setText(Consts.ZAKAT_TRANS_COM);
		
		JPanel valMarchPanel = new JPanel();
		valMarchPanel.setLayout(new FlowLayout());
		valMarchPanel.add(new JLabel(Consts.VAL_MARCH));
		montantField = new TextField();
		montantField.setPreferredSize(Consts.FIELD_DIMEN);
		valMarchPanel.add(montantField);
		
		JPanel epargnePanel = new JPanel();
		epargnePanel.setLayout(new FlowLayout());
		epargnePanel.add(new JLabel(Consts.MON_EPARGNE));
		epargneField = new TextField();
		epargneField.setPreferredSize(Consts.FIELD_DIMEN);
		epargnePanel.add(epargneField);
		
		JPanel escomptePanel = new JPanel();
		escomptePanel.setLayout(new FlowLayout());
		escomptePanel.add(new JLabel(Consts.DET_ESCOMPTE));
		escompteField = new TextField();
		escompteField.setPreferredSize(Consts.FIELD_DIMEN);
		escomptePanel.add(escompteField);
		
		JPanel nonLiquidePanel = new JPanel();
		nonLiquidePanel.setLayout(new FlowLayout());
		nonLiquidePanel.add(new JLabel(Consts.DET_NON_LIQUIDE));
		nonLiquideField = new TextField();
		nonLiquideField.setPreferredSize(Consts.FIELD_DIMEN);
		nonLiquidePanel.add(nonLiquideField);
		
		
		JPanel calcPanel = new JPanel();
		calcBtn.setPreferredSize(new Dimension(160, 36));
		calcPanel.add(calcBtn);
		
		midPanel.setLayout(new GridLayout(5, 1));
		midPanel.add(valMarchPanel);
		midPanel.add(epargnePanel);
		midPanel.add(escomptePanel);
		midPanel.add(nonLiquidePanel);
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
			montantZakat = (int) Math.round(Calculations.calcZakatTransCom(
					Integer.parseInt(montantField.getText()),
					Integer.parseInt(epargneField.getText()),
					Integer.parseInt(escompteField.getText()),
					Integer.parseInt(nonLiquideField.getText())));
			resPanel.show(montantZakat);
		}else if(e.getSource() == resPanel.nextBtn) {
			resPanel.nextBtn.setEnabled(false);
			p.addToZakat(montantZakat);
			p.moveToNextPanel();
		}
		
	}

}
