package GUI_MVC_REFACTOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import Backend.Person;


public class Tab2View {

	private JPanel tabOverview = new JPanel();

	private JTable tblOverview =  new JTable();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnDontCare = new JRadioButton("don't care");
	private JRadioButton rdbtnWomen = new JRadioButton("women");
	private JRadioButton rdbtnMen = new JRadioButton("men");
	private JTextField txtSearchInput = new JTextField();
	private JButton btnSearch = new JButton("search");
	
	
	public Tab2View() {

		tabOverview.setLayout(null);
		
		buttonGroup.add(rdbtnDontCare);
		rdbtnDontCare.setBounds(0, 26, 94, 23);
		tabOverview.add(rdbtnDontCare);
		

		buttonGroup.add(rdbtnWomen);
		rdbtnWomen.setBounds(100, 26, 77, 23);
		tabOverview.add(rdbtnWomen);
		

		buttonGroup.add(rdbtnMen);
		rdbtnMen.setBounds(189, 26, 59, 23);
		tabOverview.add(rdbtnMen);
		
		
		txtSearchInput.setBounds(347, 28, 389, 26);
		tabOverview.add(txtSearchInput);
		txtSearchInput.setColumns(8);

		btnSearch.setBounds(736, 25, 117, 29);
		tabOverview.add(btnSearch);
		
		
		
		tblOverview.setBounds(0, 61, 993, 629);
		tabOverview.add(tblOverview);
	}
	
	public JPanel getTabOverview() {
		return tabOverview;
	}
	
	public JTable getTblOverview() {
		return tblOverview;
	}

	public JRadioButton getRdbtnDontCare() {
		return rdbtnDontCare;
	}

	public void setRdbtnDontCare(JRadioButton rdbtnDontCare) {
		this.rdbtnDontCare = rdbtnDontCare;
	}

	public JRadioButton getRdbtnWomen() {
		return rdbtnWomen;
	}

	public void setRdbtnWomen(JRadioButton rdbtnWomen) {
		this.rdbtnWomen = rdbtnWomen;
	}

	public JRadioButton getRdbtnMen() {
		return rdbtnMen;
	}

	public void setRdbtnMen(JRadioButton rdbtnMen) {
		this.rdbtnMen = rdbtnMen;
	}

	public JTextField getTxtSearchInput() {
		return txtSearchInput;
	}

	public void setTxtSearchInput(JTextField txtSearchInput) {
		this.txtSearchInput = txtSearchInput;
	}
	
	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}
	
	public JButton getBtnSearch() {
		return btnSearch;
	}
}
