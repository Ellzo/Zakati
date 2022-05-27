package panels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import zakati.*;
import utils.*;

public class MainPanel extends ScreenPanel implements ActionListener{
	private Projet p;
	
	private TextField orField;
	private TextField argField;
	
	public MainPanel(Projet p){
		this.p = p;
		
		titleLabel.setText(Consts.TITLE);
		titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD | Font.ITALIC , 44));
		
		calcBtn.setText(Consts.START);
		calcBtn.addActionListener(this);
		midPanel.add(calcBtn);
		
		JLabel note = new JLabel(Consts.NOTE);
		note.setFont(new Font(note.getFont().getName(), Font.ITALIC , 24));
		
		JPanel orPanel = new JPanel();
		orPanel.setLayout(new FlowLayout(FlowLayout.LEFT, Consts.MARGIN, 0));
		orPanel.add(new JLabel(Consts.PRIX_OR));
		orField = new TextField();
		orField.setText(Integer.toString(Consts.PRIX_OR_INIT));
		orField.setPreferredSize(Consts.FIELD_DIMEN);
		orPanel.add(orField);
		orPanel.add(new JLabel(Consts.UNIT));
		
		JPanel argentPanel = new JPanel();
		argentPanel.setLayout(new FlowLayout(FlowLayout.LEFT, Consts.MARGIN, 0));
		argentPanel.add(new JLabel(Consts.PRIX_ARG));
		argField = new TextField();
		argField.setText(Integer.toString(Consts.PRIX_ARG_INIT));
		argField.setPreferredSize(Consts.FIELD_DIMEN);
		argentPanel.add(argField);
		argentPanel.add(new JLabel(Consts.UNIT));
		
		
		JLabel temps = new JLabel(Consts.TEMPS_VERS);
		temps.setForeground(Color.RED);
		
		JPanel notePanel = new JPanel();
		notePanel.setLayout(new GridLayout(4, 1, Consts.MARGIN/2, Consts.MARGIN/2));
		notePanel.add(note);
		notePanel.add(orPanel);
		notePanel.add(argentPanel);
		notePanel.add(temps);
		
		this.add(titleLabel);
		this.add(midPanel);
		this.add(notePanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == calcBtn) {
			calcBtn.setEnabled(false);
			Calculations.setPrixOr(Integer.parseInt(orField.getText()));
			Calculations.setPrixArgent(Integer.parseInt(argField.getText()));
			p.moveToNextPanel();
		}
	}
}
