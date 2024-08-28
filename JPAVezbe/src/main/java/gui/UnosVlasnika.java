package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.VlasnikCrud;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UnosVlasnika extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private VlasnikCrud vc = new VlasnikCrud();
	private JTextField imeTF;
	private JTextField prezimeTF;
	private JTextField brtelTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UnosVlasnika dialog = new UnosVlasnika();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UnosVlasnika() {
		setTitle("Unos vlasnika");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		imeTF = new JTextField();
		imeTF.setBounds(119, 42, 197, 20);
		contentPanel.add(imeTF);
		imeTF.setColumns(10);
		
		prezimeTF = new JTextField();
		prezimeTF.setBounds(119, 104, 197, 20);
		contentPanel.add(prezimeTF);
		prezimeTF.setColumns(10);
		
		brtelTF = new JTextField();
		brtelTF.setBounds(119, 166, 197, 20);
		contentPanel.add(brtelTF);
		brtelTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ime:");
		lblNewLabel.setBounds(49, 45, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setBounds(49, 107, 46, 14);
		contentPanel.add(lblPrezime);
		
		JLabel lblBrTel = new JLabel("Br. tel:");
		lblBrTel.setBounds(49, 169, 53, 14);
		contentPanel.add(lblBrTel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton unesiButton = new JButton("Unesi");
				unesiButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String ime = imeTF.getText();
						String prezim = prezimeTF.getText();
						String brTel = brtelTF.getText();
						vc.insertVlasnik(ime, prezim, brTel);
					}
				});
				unesiButton.setActionCommand("OK");
				buttonPane.add(unesiButton);
				getRootPane().setDefaultButton(unesiButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
