package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setTitle("Upravljanje stanovima");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Unos vlasnika");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnosVlasnika uv = new UnosVlasnika();
				uv.setVisible(true);
			}
		});
		btnNewButton.setBounds(104, 25, 222, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Unos stana");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnosStana us = new UnosStana();
				us.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(104, 81, 222, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Prikaz stanova po vlasniku");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StanoviVlasnika sv = new StanoviVlasnika();
				sv.setVisible(true);
			}
		});
		btnNewButton_1_1.setBounds(104, 193, 222, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnBrisanjeZgrade = new JButton("Brisanje zgrade");
		btnBrisanjeZgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrisanjeZgrade bz = new BrisanjeZgrade();
				bz.setVisible(true);
			}
		});
		btnBrisanjeZgrade.setBounds(104, 137, 222, 23);
		contentPane.add(btnBrisanjeZgrade);
	}
}
