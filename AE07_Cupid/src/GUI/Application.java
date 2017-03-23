package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;


import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JTable;

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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ArrayList<Person> people;
	private JTable tblOverview = new JTable();
	private JTabbedPane jTab;
	
	
	private JLabel lblName = new JLabel("Vorname Nachname");
	private JLabel lblAge = new JLabel("01.01.2005, 12");
	private JTextArea txtrDetail = new JTextArea();
	private JLabel lblAddress = new JLabel("Street 12a, 22222 Hamburg");
	private JLabel lblPhone = new JLabel("phone");
	private JLabel lblMail = new JLabel("mail");
	private JLabel lblId = new JLabel("");
	private JLabel lblGender = new JLabel("gender");
	private JTextArea txtrNotes = new JTextArea();
	

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
					new ExceptionHandler(e).handle();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Application() {
		
		Logic logic = new Logic(new PersonDAO());
		people = logic.getPersonList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		this.jTab = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(jTab);
		
		JPanel tabDetail = new JPanel();
		jTab.addTab("details", null, tabDetail, null);
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
		
		JButton btnSaveNotes = new JButton("save");
		btnSaveNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					logic.addNoteToPerson(lblId.getText(), txtrNotes.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSaveNotes.setBounds(760, 412, 117, 29);
		tabDetail.add(btnSaveNotes);
		
		JPanel tabOverview = new JPanel();
		jTab.addTab("overview", null, tabOverview, null);
		tabOverview.setLayout(null);
		
		JRadioButton rdbtnDontCare = new JRadioButton("don't care");
		rdbtnDontCare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				people = logic.getPersonList();
				tblOverview.setModel(generateOverviewTable(people));
			}
		});
		buttonGroup.add(rdbtnDontCare);
		rdbtnDontCare.setBounds(0, 26, 94, 23);
		tabOverview.add(rdbtnDontCare);
		
		JRadioButton rdbtnWomen = new JRadioButton("women");
		rdbtnWomen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				people = logic.getPeopleByGender("woman");
				tblOverview.setModel(generateOverviewTable(people));
			}
		});
		buttonGroup.add(rdbtnWomen);
		rdbtnWomen.setBounds(100, 26, 77, 23);
		tabOverview.add(rdbtnWomen);
		
		JRadioButton rdbtnMen = new JRadioButton("men");
		rdbtnMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				people = logic.getPeopleByGender("man");
				tblOverview.setModel(generateOverviewTable(people));
			}
		});
		buttonGroup.add(rdbtnMen);
		rdbtnMen.setBounds(189, 26, 59, 23);
		tabOverview.add(rdbtnMen);
		
		txtSearchInput = new JTextField();
		txtSearchInput.setBounds(347, 28, 389, 26);
		tabOverview.add(txtSearchInput);
		txtSearchInput.setColumns(8);
//		for(Person person : people){
//			
//		}
		tblOverview.setModel(generateOverviewTable(people));
		
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				people = logic.getPersonBySearch(txtSearchInput.getText());
				tblOverview.setModel(generateOverviewTable(people));
			}
		});
		btnSearch.setBounds(736, 25, 117, 29);
		tabOverview.add(btnSearch);
		
		
		
		MouseListener[] listeners = tblOverview.getMouseListeners();
		for (MouseListener l : listeners)
		{
		    tblOverview.removeMouseListener(l);
		}
		
		tblOverview.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					getJTab().setSelectedIndex(0);
			        int row = tblOverview.rowAtPoint( e.getPoint() );
			        int p = (int)tblOverview.getValueAt(row,0);
					Person peep = logic.getPersonById(p);
					lblId.setText(Integer.toString(peep.getId()));
					lblName.setText(peep.getName() + " " + peep.getLastname());
					lblAge.setText(Integer.toString(peep.getAge()));
					lblGender.setText(peep.getGender());
					lblAddress.setText(peep.getStreet() + ", " + peep.getZip() + " " + peep.getCity());
					lblMail.setText(peep.getMail());
					txtrNotes.setText(peep.getNote());
					txtrDetail.setText(peep.getAddInfo());
				}
			}
		});

		ListSelectionModel listMod =  tblOverview.getSelectionModel();
		listMod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMod.addListSelectionListener(tblOverview);
		
		
		tblOverview.setBounds(0, 61, 993, 629);
		tabOverview.add(tblOverview);
		
		JPanel tabCreate = new JPanel();
		jTab.addTab("create", null, tabCreate, null);
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
		
		JComboBox<String> comboGender = new JComboBox<String>();
		comboGender.setBounds(157, 239, 130, 27);
		comboGender.addItem("woman");
		comboGender.addItem("man");
		comboGender.addItem("other");
		panel.add(comboGender);
		
		JButton btnCreateNew = new JButton("create");
		btnCreateNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.saveNewPerson(txtName.getText(), txtLastname.getText(), comboGender.getSelectedItem().toString(), txtAge.getText(), txtStreet.getText(), txtZip.getText(), txtCity.getText(), txtPhone.getText(), txtMail.getText(), "imagePath", txtrDetail.getText()); //imagePath is not yet implemented
				people = logic.getPersonList();
				tblOverview.setModel(generateOverviewTable(people));
				getJTab().setSelectedIndex(1);
			}
		});
		btnCreateNew.setBounds(807, 593, 117, 29);
		panel.add(btnCreateNew);
		
	}
	
	public  JTabbedPane getJTab() {
		return jTab;
	}
	
	public DefaultTableModel generateOverviewTable(ArrayList<Person> people) {
		Vector<Vector<Object>> tableContent = new Vector<Vector<Object>>();
		Vector<String> tableheader = new Vector<String>();
		tableheader.add("#");
		tableheader.add("First Name");
		tableheader.add("Last Name");
		tableheader.add("Gender");
		tableheader.add("Age");
		tableheader.add("City");
		
		for(Person peep : people) {
			Vector<Object> row = new Vector<Object>();
			row.addElement(peep.getId());
			row.add(peep.getName());
			row.add(peep.getLastname());
			row.add(peep.getGender());
			row.add(Integer.toString(peep.getAge()));
			row.add(peep.getCity());
			tableContent.add(row);
		}
		DefaultTableModel model = new DefaultTableModel(tableContent, tableheader);
		return model;
	}
}
