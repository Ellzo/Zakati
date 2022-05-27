package panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import zakati.Projet;
import utils.Consts;

public class ZakatTotalePanel extends ScreenPanel implements ActionListener{
	
	private Projet p;
	
	public ZakatTotalePanel(Projet p, int zakatTotale) {
		this.p = p;
		
		titleLabel.setText(Consts.ZAKAT_TOTALE);
		
		JLabel montantLabel = new JLabel();
		montantLabel.setText(Consts.ZAKAT_TOTALE_MONTANT + zakatTotale + Consts.UNIT);
		montantLabel.setFont(new Font(montantLabel.getFont().getName(), Font.ITALIC , 24));
		midPanel.add(montantLabel);
		
		resPanel.resLabel.setVisible(false);
		
		resPanel.nextBtn.setText(Consts.GO_HOME);
		resPanel.nextBtn.addActionListener(this);
		
		resPanel.setVisible(true);
		
		this.add(titleLabel);
		this.add(midPanel);
		this.add(resPanel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == resPanel.nextBtn) {
			resPanel.nextBtn.setEnabled(false);
			p.moveToNextPanel();
		}
	}
}
