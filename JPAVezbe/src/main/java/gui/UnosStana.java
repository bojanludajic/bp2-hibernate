package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.StanCrud;
import crud.VlasnikCrud;
import crud.ZgradaCrud;
import model.AstanPK;
import model.Avlasnik;
import model.Azgrada;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class UnosStana extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	StanCrud sc = new StanCrud();
	VlasnikCrud vc = new VlasnikCrud();
	ZgradaCrud zc = new ZgradaCrud();
	private JTextField brojCB;
	private JTextField kvCB;
	private JTextField spratCB;
	private JComboBox<Avlasnik> vlasnikCB;
	private JComboBox<Azgrada> zgradaCB;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UnosStana dialog = new UnosStana();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UnosStana() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		vlasnikCB = new JComboBox();
		List<Avlasnik> vlasnici = vc.listVlasnici();
		vlasnici.forEach(it -> vlasnikCB.addItem(it));
		vlasnikCB.setBounds(120, 11, 182, 22);
		contentPanel.add(vlasnikCB);
		
		
		zgradaCB = new JComboBox();
		List<Azgrada> zgrade = zc.listZgrade(); 
		zgrade.forEach(it -> zgradaCB.addItem(it));
		zgradaCB.setBounds(120, 52, 182, 22);
		contentPanel.add(zgradaCB);
	
		{
			brojCB = new JTextField();
			brojCB.setBounds(120, 85, 182, 20);
			contentPanel.add(brojCB);
			brojCB.setColumns(10);
		}
		{
			kvCB = new JTextField();
			kvCB.setBounds(120, 116, 182, 20);
			contentPanel.add(kvCB);
			kvCB.setColumns(10);
		}
		{
			spratCB = new JTextField();
			spratCB.setBounds(120, 147, 182, 20);
			contentPanel.add(spratCB);
			spratCB.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Vlasnik:");
			lblNewLabel.setBounds(32, 15, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblZgrada = new JLabel("Zgrada:");
			lblZgrada.setBounds(32, 56, 46, 14);
			contentPanel.add(lblZgrada);
		}
		{
			JLabel lblBroj = new JLabel("Broj: ");
			lblBroj.setBounds(32, 88, 46, 14);
			contentPanel.add(lblBroj);
		}
		{
			JLabel lblKvadratura = new JLabel("Kvadratura:");
			lblKvadratura.setBounds(32, 119, 58, 14);
			contentPanel.add(lblKvadratura);
		}
		{
			JLabel lblSprat = new JLabel("Sprat:");
			lblSprat.setBounds(32, 150, 46, 14);
			contentPanel.add(lblSprat);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton unesiB = new JButton("Unesi");
				unesiB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Avlasnik v = (Avlasnik) vlasnikCB.getSelectedItem();
						Azgrada z = (Azgrada) zgradaCB.getSelectedItem();
						BigDecimal broj = BigDecimal.valueOf(Long.parseLong(brojCB.getText()));
						BigDecimal sprat = BigDecimal.valueOf(Long.parseLong(spratCB.getText()));
						BigDecimal kvadratura = BigDecimal.valueOf(Long.parseLong(kvCB.getText()));
						AstanPK id = new AstanPK();
						Random r = new Random();
						long l = r.nextLong(1, 100000);
						id.setIds(l);
						id.setZgradaIdz(z.getIdz());
						sc.insertStan(id, v, z, broj, kvadratura, sprat);
					}
				});
				unesiB.setActionCommand("OK");
				buttonPane.add(unesiB);
				getRootPane().setDefaultButton(unesiB);
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
