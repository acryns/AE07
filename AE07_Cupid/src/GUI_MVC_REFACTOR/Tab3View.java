package GUI_MVC_REFACTOR;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tab3View {
	
	private JPanel tabCreate = new JPanel();
	private JComboBox<String> comboGender = new JComboBox<String>();
	


	private JTextField txtName;
	private JTextField txtLastname;
	private JTextField txtAge;
	private JTextField txtZip;
	private JTextField txtStreet;
	private JTextField txtCity;
	private JTextField txtPhone;
	private JTextField txtMail;
	private JTextArea textArea = new JTextArea();
	
	private JButton btnCreateNew = new JButton("create");

	public Tab3View() {
		//JPanel tabCreate = new JPanel();
		
		tabCreate.setLayout(new BoxLayout(tabCreate, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		tabCreate.add(panel);
		
		JPanel panelNewImage = new JPanel();
		panelNewImage.setBackground(Color.MAGENTA);
		panelNewImage.setBounds(745, 84, 179, 232);
		panel.add(panelNewImage);
		
		JLabel lblNewProfile = new JLabel("Create new profile");
		lblNewProfile.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewProfile.setBounds(84, 84, 286, 38);
		panel.add(lblNewProfile);
		
		
		textArea.setText("Dummy text");
		textArea.setBounds(84, 430, 466, 77);
		panel.add(textArea);
		
		JLabel lblName_1 = new JLabel("name");
		lblName_1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblName_1.setBounds(84, 157, 61, 16);
		panel.add(lblName_1);
		
		JLabel label_3 = new JLabel("phone");
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		label_3.setBounds(84, 335, 61, 16);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("mail");
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		label_4.setBounds(84, 364, 61, 16);
		panel.add(label_4);
		
		JLabel lblLastname = new JLabel("lastname");
		lblLastname.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblLastname.setBounds(84, 187, 61, 16);
		panel.add(lblLastname);
		
		JLabel lblAgeInput = new JLabel("age");
		lblAgeInput.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblAgeInput.setBounds(84, 215, 61, 16);
		panel.add(lblAgeInput);
		
		JLabel lblStreet = new JLabel("street");
		lblStreet.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblStreet.setBounds(84, 279, 61, 16);
		panel.add(lblStreet);
		
		JLabel lblGender_1 = new JLabel("gender");
		lblGender_1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblGender_1.setBounds(84, 243, 61, 16);
		panel.add(lblGender_1);
		
		JLabel lblZip = new JLabel("zip");
		lblZip.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblZip.setBounds(84, 307, 61, 16);
		panel.add(lblZip);
		
		JLabel label_1 = new JLabel("city");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		label_1.setBounds(309, 307, 61, 16);
		panel.add(label_1);
		
		JLabel lblInfo = new JLabel("additional information");
		lblInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblInfo.setBounds(84, 406, 138, 16);
		panel.add(lblInfo);
		
		JButton btnUploadImage = new JButton("upload image");
		btnUploadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//open dialog for choosing picture and save in variable
			}
		});
		btnUploadImage.setBounds(807, 334, 117, 29);
		panel.add(btnUploadImage);
		
		txtName = new JTextField();
		txtName.setBounds(157, 152, 130, 26);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtLastname = new JTextField();
		txtLastname.setBounds(157, 182, 130, 26);
		panel.add(txtLastname);
		txtLastname.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(157, 210, 130, 26);
		panel.add(txtAge);
		
		txtZip = new JTextField();
		txtZip.setColumns(10);
		txtZip.setBounds(157, 301, 130, 26);
		panel.add(txtZip);
		
		txtStreet = new JTextField();
		txtStreet.setColumns(10);
		txtStreet.setBounds(157, 273, 306, 26);
		panel.add(txtStreet);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(346, 302, 130, 26);
		panel.add(txtCity);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(157, 329, 130, 26);
		panel.add(txtPhone);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(157, 359, 130, 26);
		panel.add(txtMail);

		comboGender.setBounds(157, 239, 130, 27);
		comboGender.addItem("woman");
		comboGender.addItem("man");
		comboGender.addItem("other");
		panel.add(comboGender);
		
		btnCreateNew.setBounds(807, 593, 117, 29);
		panel.add(btnCreateNew);
	}
	
	public JPanel getTabCreate() {
		return tabCreate;
	}
	
	public JButton getBtnCreateNew() {
		return btnCreateNew;
	}
	
	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public JTextField getTxtLastname() {
		return txtLastname;
	}

	public void setTxtLastname(JTextField txtLastname) {
		this.txtLastname = txtLastname;
	}

	public JTextField getTxtAge() {
		return txtAge;
	}

	public void setTxtAge(JTextField txtAge) {
		this.txtAge = txtAge;
	}

	public JTextField getTxtZip() {
		return txtZip;
	}

	public void setTxtZip(JTextField txtZip) {
		this.txtZip = txtZip;
	}

	public JTextField getTxtStreet() {
		return txtStreet;
	}

	public void setTxtStreet(JTextField txtStreet) {
		this.txtStreet = txtStreet;
	}

	public JTextField getTxtCity() {
		return txtCity;
	}

	public void setTxtCity(JTextField txtCity) {
		this.txtCity = txtCity;
	}

	public JTextField getTxtPhone() {
		return txtPhone;
	}

	public void setTxtPhone(JTextField txtPhone) {
		this.txtPhone = txtPhone;
	}

	public JTextField getTxtMail() {
		return txtMail;
	}

	public void setTxtMail(JTextField txtMail) {
		this.txtMail = txtMail;
	}

	public void setTabCreate(JPanel tabCreate) {
		this.tabCreate = tabCreate;
	}
	
	public JComboBox<String> getComboGender() {
		return comboGender;
	}
	
	public JTextArea getTextArea() {
		return textArea;
	}
}
