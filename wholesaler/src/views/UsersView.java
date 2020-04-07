package views;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class UsersView extends JFrame {

	JFrame maFrame;
	JLabel monLabel;
	JTextField monTextField;
	JButton monButton;

	public void init() {
		maFrame = new JFrame("ma frame de test");
		maFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		monTextField = new JTextField("encore du text test");
		monTextField.setColumns(20);
		monButton = new JButton("cliaue ici");
		monLabel = new JLabel("encore du texte");
		maFrame.getContentPane().setLayout(new FlowLayout());
		maFrame.getContentPane().add(monLabel);
		maFrame.getContentPane().add(monTextField);
		maFrame.getContentPane().add(monButton);
		maFrame.pack();
		maFrame.setVisible(true);
	}
	
	
	
	public JTextField gettextField() {
		return this.monTextField;
	}
	
	public JButton getButton() {
		return monButton;
	}
}
