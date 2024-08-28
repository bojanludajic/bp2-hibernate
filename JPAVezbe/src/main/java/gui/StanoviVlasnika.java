package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.VlasnikCrud;
import model.Avlasnik;

import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StanoviVlasnika extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JComboBox<Avlasnik> vlasnikCB;
	private VlasnikCrud vc = new VlasnikCrud();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StanoviVlasnika dialog = new StanoviVlasnika();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StanoviVlasnika() {
		setTitle("Stanovi vlasnika");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		
		vlasnikCB = new JComboBox<>();
		List<Avlasnik> vlasnici = vc.listVlasnici();
		vlasnici.forEach(it -> vlasnikCB.addItem(it));
		vlasnikCB.setBounds(54, 9, 315, 22);
		contentPanel.add(vlasnikCB);
		
		table = new JTable();
		table.setBounds(54, 42, 315, 162);
		contentPanel.add(table);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Prikazi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Avlasnik v = (Avlasnik) vlasnikCB.getSelectedItem();
						TableModelVlasnik tmv = new TableModelVlasnik(v);
						
						table.setModel(tmv);
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
