package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import javax.swing.JRadioButton;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Application extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearchInput;
	private JTextField txtName;
	private JTextField txtLastname;
	private JTextField txtAge;
	private JTextField txtZip;
	private JTextField txtStreet;
	private JTextField txtCity;
	private JTextField txtPhone;
	private JTextField txtMail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
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
	public Application() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel tabDetail = new JPanel();
		tabbedPane.addTab("details", null, tabDetail, null);
		tabDetail.setLayout(null);
		
		JPanel panelPicture = new JPanel();
		panelPicture.setBackground(Color.MAGENTA);
		panelPicture.setBounds(56, 101, 179, 232);
		tabDetail.add(panelPicture);
		
		JLabel lblName = new JLabel("Vorname Nachname");
		lblName.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblName.setBounds(265, 93, 286, 38);
		tabDetail.add(lblName);
		
		JLabel lblAge = new JLabel("12");
		lblAge.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblAge.setBounds(265, 131, 34, 16);
		tabDetail.add(lblAge);
		
		JTextArea txtrDetail = new JTextArea();
		txtrDetail.setText("Dummy text");
		txtrDetail.setBounds(265, 256, 466, 77);
		tabDetail.add(txtrDetail);
		
		JLabel lblCity = new JLabel("city");
		lblCity.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblCity.setBounds(265, 159, 61, 16);
		tabDetail.add(lblCity);
		
		JLabel lblPhone = new JLabel("phone");
		lblPhone.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblPhone.setBounds(265, 187, 61, 16);
		tabDetail.add(lblPhone);
		
		JLabel lblMail = new JLabel("mail");
		lblMail.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblMail.setBounds(265, 215, 61, 16);
		tabDetail.add(lblMail);
		
		JLabel lblGender = new JLabel("gender");
		lblGender.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblGender.setBounds(311, 132, 103, 15);
		tabDetail.add(lblGender);
		
		JTextArea txtrNootes = new JTextArea();
		txtrNootes.setText("Notes");
		txtrNootes.setBounds(265, 364, 466, 77);
		tabDetail.add(txtrNootes);
		
		JButton btnSave = new JButton("save");
		btnSave.setBounds(760, 412, 117, 29);
		tabDetail.add(btnSave);
		
		JPanel tabOverview = new JPanel();
		tabbedPane.addTab("overview", null, tabOverview, null);
		tabOverview.setLayout(null);
		
		JRadioButton rdbtnDontCare = new JRadioButton("don't care");
		rdbtnDontCare.setBounds(0, 26, 94, 23);
		tabOverview.add(rdbtnDontCare);
		
		JRadioButton rdbtnWomen = new JRadioButton("women");
		rdbtnWomen.setBounds(100, 26, 77, 23);
		tabOverview.add(rdbtnWomen);
		
		JRadioButton rdbtnMen = new JRadioButton("men");
		rdbtnMen.setBounds(189, 26, 59, 23);
		tabOverview.add(rdbtnMen);
		
		JLabel lblSearch = new JLabel("search");
		lblSearch.setBounds(292, 33, 41, 16);
		tabOverview.add(lblSearch);
		
		txtSearchInput = new JTextField();
		txtSearchInput.setBounds(347, 28, 389, 26);
		tabOverview.add(txtSearchInput);
		txtSearchInput.setColumns(8);
		
		JList liOverview = new JList();
		liOverview.setBounds(0, 61, 993, 629);
		tabOverview.add(liOverview);
		
		JPanel tabCreate = new JPanel();
		tabbedPane.addTab("create", null, tabCreate, null);
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
		
		JTextArea textArea = new JTextArea();
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
		
		JButton btnSaveNew = new JButton("save");
		btnSaveNew.setBounds(807, 593, 117, 29);
		panel.add(btnSaveNew);
		
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
		
		JComboBox comboGender = new JComboBox();
		comboGender.setBounds(157, 239, 130, 27);
		panel.add(comboGender);
	}
}
