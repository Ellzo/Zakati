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

public class ZakatOrPanel extends ScreenPanel implements ActionListener{
	private Projet p;
	
	private TextField carat24Field;
	private TextField carat21Field;
	private TextField carat18Field;
	
	private int montantZakat;
	
	public ZakatOrPanel(Projet p) {
		this.p = p;
		
		titleLabel.setText(Consts.ZAKAT_OR);
		
		JPanel carat24Panel = new JPanel();
		carat24Panel.setLayout(new FlowLayout());
		carat24Panel.add(new JLabel(Consts.OR_24));
		carat24Field = new TextField();
		carat24Field.setPreferredSize(Consts.FIELD_DIMEN);
		carat24Panel.add(carat24Field);
		
		JPanel carat21Panel = new JPanel();
		carat21Panel.setLayout(new FlowLayout());
		carat21Panel.add(new JLabel(Consts.OR_21));
		carat21Field = new TextField();
		carat21Field.setPreferredSize(Consts.FIELD_DIMEN);
		carat21Panel.add(carat21Field);
		
		JPanel carat18Panel = new JPanel();
		carat18Panel.setLayout(new FlowLayout());
		carat18Panel.add(new JLabel(Consts.OR_18));
		carat18Field = new TextField();
		carat18Field.setPreferredSize(Consts.FIELD_DIMEN);
		carat18Panel.add(carat18Field);
		
		
		JPanel calcPanel = new JPanel();
		calcBtn.setPreferredSize(new Dimension(160, 36));
		calcPanel.add(calcBtn);
		
		midPanel.setLayout(new GridLayout(4, 1));
		midPanel.add(carat24Panel);
		midPanel.add(carat21Panel);
		midPanel.add(carat18Panel);
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
			montantZakat = (int) Math.round(Calculations.calcZakatOr(
					Integer.parseInt(carat24Field.getText()),
					Integer.parseInt(carat21Field.getText()),
					Integer.parseInt(carat18Field.getText())));
			resPanel.show(montantZakat);
		}else if(e.getSource() == resPanel.nextBtn) {
			resPanel.nextBtn.setEnabled(false);
			p.addToZakat(montantZakat);
			p.moveToNextPanel();
		}
	}
}
