package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class HomeView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeView window = new HomeView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0 , 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton btnLogOut = new JButton("Log out");
		GridBagConstraints gbc_btnLogOut = new GridBagConstraints();
		gbc_btnLogOut.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogOut.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogOut.gridx = 10;
		gbc_btnLogOut.gridy = 1;
		frame.getContentPane().add(btnLogOut, gbc_btnLogOut);
		
		JButton btnUtilisateurs = new JButton("Users");
		GridBagConstraints gbc_btnUtilisateurs = new GridBagConstraints();
		gbc_btnUtilisateurs.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUtilisateurs.insets = new Insets(0, 0, 5, 5);
		gbc_btnUtilisateurs.gridx = 6;
		gbc_btnUtilisateurs.gridy = 3;
		frame.getContentPane().add(btnUtilisateurs, gbc_btnUtilisateurs);
		
		JButton button = new JButton("Articles");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 6;
		gbc_button.gridy = 4;
		frame.getContentPane().add(button, gbc_button);
		
		JButton btnClients = new JButton("Clients");
		GridBagConstraints gbc_btnClients = new GridBagConstraints();
		gbc_btnClients.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnClients.insets = new Insets(0, 0, 5, 5);
		gbc_btnClients.gridx = 6;
		gbc_btnClients.gridy = 5;
		frame.getContentPane().add(btnClients, gbc_btnClients);
		
		JButton btnInvoices = new JButton("Invoices");
		GridBagConstraints gbc_btnInvoices = new GridBagConstraints();
		gbc_btnInvoices.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInvoices.insets = new Insets(0, 0, 0, 5);
		gbc_btnInvoices.gridx = 6;
		gbc_btnInvoices.gridy = 6;
		frame.getContentPane().add(btnInvoices, gbc_btnInvoices);
	}

}
