package GUI_MVC_REFACTOR;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tab1View {

	private JPanel tabDetail;
	private JButton btnSaveNotes = new JButton("save");
	private JLabel lblName = new JLabel();
	private JLabel txtrDetail= new JLabel();
	private JLabel lblAge= new JLabel();
	private JLabel lblAddress= new JLabel();
	private JLabel lblPhone= new JLabel();
	private JLabel lblMail= new JLabel();
	private JLabel lblGender= new JLabel();
	private JLabel lblId= new JLabel();
	private JTextArea txtrNotes= new JTextArea();
	
	
	
	public Tab1View() {
		
		
		
		this.tabDetail = new JPanel();
		tabDetail.setLayout(null);
		
		JPanel panelPicture = new JPanel();
		panelPicture.setBackground(Color.MAGENTA);
		panelPicture.setBounds(56, 101, 179, 232);
		tabDetail.add(panelPicture);
		
		lblName.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblName.setBounds(265, 93, 286, 38);
		tabDetail.add(lblName);
		
		lblAge.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblAge.setBounds(265, 131, 117, 16);
		tabDetail.add(lblAge);
		
		txtrDetail.setText("Dummy text");
		txtrDetail.setBounds(265, 256, 466, 77);
		tabDetail.add(txtrDetail);
		
		
		lblAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblAddress.setBounds(265, 159, 230, 16);
		tabDetail.add(lblAddress);
		
		
		lblPhone.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblPhone.setBounds(265, 187, 61, 16);
		tabDetail.add(lblPhone);
		
		
		lblMail.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblMail.setBounds(265, 215, 61, 16);
		tabDetail.add(lblMail);
		
		
		lblGender.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblGender.setBounds(392, 132, 103, 15);
		tabDetail.add(lblGender);
		
		
		txtrNotes.setText("Notes");
		txtrNotes.setBounds(265, 364, 466, 77);
		tabDetail.add(txtrNotes);

		
		lblId.setBounds(842, 107, 61, 16);
		lblId.setVisible(false);
		tabDetail.add(lblId);
		
		btnSaveNotes.setBounds(760, 412, 117, 29);
		tabDetail.add(btnSaveNotes);
	}
	
	public JPanel getTabDetail() {
		return tabDetail;
	}

	public JLabel getLblName() {
		return lblName;
	}

	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
	}

	public JLabel getTxtrDetail() {
		return txtrDetail;
	}

	public void setTxtrDetail(JLabel txtrDetail) {
		this.txtrDetail = txtrDetail;
	}

	public JLabel getLblAge() {
		return lblAge;
	}

	public void setLblAge(JLabel lblAge) {
		this.lblAge = lblAge;
	}

	public JLabel getLblAddress() {
		return lblAddress;
	}

	public void setLblAddress(JLabel lblAddress) {
		this.lblAddress = lblAddress;
	}

	public JLabel getLblPhone() {
		return lblPhone;
	}

	public void setLblPhone(JLabel lblPhone) {
		this.lblPhone = lblPhone;
	}

	public JLabel getLblMail() {
		return lblMail;
	}

	public void setLblMail(JLabel lblMail) {
		this.lblMail = lblMail;
	}

	public JLabel getLblGender() {
		return lblGender;
	}

	public void setLblGender(JLabel lblGender) {
		this.lblGender = lblGender;
	}

	public JLabel getLblId() {
		return lblId;
	}

	public void setLblId(JLabel lblId) {
		this.lblId = lblId;
	}

	public JTextArea getTxtrNotes() {
		return txtrNotes;
	}

	public void setTxtrNotes(JTextArea txtrNotes) {
		this.txtrNotes = txtrNotes;
	}

	public void setTabDetail(JPanel tabDetail) {
		this.tabDetail = tabDetail;
	}
	
	public JButton getBtnSaveNotes() {
		return btnSaveNotes;
	}
}
