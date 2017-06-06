package GUI_MVC_REFACTOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import Backend.Logic;
import Backend.OrmLogic;
import Backend.Person;
import Backend.PersonDAOInterface;

public class Controller {
	
	private Model model;
	private MasterView view;
	
	//private Logic logic;
	private OrmLogic logic;
	
	public Controller(PersonDAOInterface dao, MasterView view, Model model) {
		//this.logic = new Logic(dao);
		this.logic = new OrmLogic();
		this.model = model;
		this.view = view;
		
		this.addListenersTab1();
		this.addListenersTab2();
		this.manipulateTableListeners();
		this.addListenersTab3();
		
		model.setPeople(logic.getPersonList());
		view.getTab2().getTblOverview().setModel(model.generateOverviewTable());
		
	}
	
	public void addListenersTab1() {
		view.getTab1().getBtnSaveNotes().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				logic.addNoteToPerson(view.getTab1().getLblId().getText(), view.getTab1().getTxtrNotes().getText());
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,"No ID given - open an existing person first");
			}
		}
	});
	}
	
	public void addListenersTab2() {
		view.getTab2().getRdbtnDontCare().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setPeople(logic.getPersonList());
				view.getTab2().getTblOverview().setModel(model.generateOverviewTable());
			}
		});
		
		view.getTab2().getRdbtnWomen().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setPeople(logic.getPeopleByGender("woman"));
				view.getTab2().getTblOverview().setModel(model.generateOverviewTable());
			}
		});
		
		view.getTab2().getRdbtnMen().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setPeople(logic.getPeopleByGender("man"));
				view.getTab2().getTblOverview().setModel(model.generateOverviewTable());
			}
		});
		
		view.getTab2().getBtnSearch().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setPeople(logic.getPersonBySearch(view.getTab2().getTxtSearchInput().getText()));
				view.getTab2().getTblOverview().setModel(model.generateOverviewTable());
			}
		});
	}
	
	public void manipulateTableListeners() {
		MouseListener[] listeners = view.getTab2().getTblOverview().getMouseListeners();
		for (MouseListener l : listeners)
		{
			view.getTab2().getTblOverview().removeMouseListener(l);
		}
		
		view.getTab2().getTblOverview().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					view.getJTab().setSelectedIndex(0);
			        int row = view.getTab2().getTblOverview().rowAtPoint( e.getPoint() );
			        int p = (int)view.getTab2().getTblOverview().getValueAt(row,0);
					Person peep = logic.getPersonById(p);
					view.getTab1().getLblId().setText(Integer.toString(peep.getPerson_Id()));
					view.getTab1().getLblName().setText(peep.getName() + " " + peep.getLastname());
					view.getTab1().getLblAge().setText(Integer.toString(peep.getAge()));
					view.getTab1().getLblGender().setText(peep.getGender());
					view.getTab1().getLblAddress().setText(peep.getStreet() + ", " + peep.getZip() + " " + peep.getCity());
					view.getTab1().getLblMail().setText(peep.getMail());
					view.getTab1().getTxtrNotes().setText(peep.getNote());
					view.getTab1().getTxtrDetail().setText(peep.getInfo());
				}
			}
		});

		ListSelectionModel listMod =  view.getTab2().getTblOverview().getSelectionModel();
		listMod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMod.addListSelectionListener(view.getTab2().getTblOverview());
	}
	
	public void addListenersTab3() {
		view.getTab3().getBtnCreateNew().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				boolean bool = logic.saveNewPerson(view.getTab3().getTxtName().getText(), view.getTab3().getTxtLastname().getText(), view.getTab3().getComboGender().getSelectedItem().toString(), view.getTab3().getTxtAge().getText(), view.getTab3().getTxtStreet().getText(), view.getTab3().getTxtZip().getText(), view.getTab3().getTxtCity().getText(), view.getTab3().getTxtPhone().getText(), view.getTab3().getTxtMail().getText(), "imagePath", view.getTab3().getTextArea().getText()); //imagePath is not yet implemented
				model.setPeople(logic.getPersonList());
				view.getTab2().getTblOverview().setModel(model.generateOverviewTable());
				view.getJTab().setSelectedIndex(1);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"please fill out all fields");
				}
			}
		});
	}
	
	
	

}
