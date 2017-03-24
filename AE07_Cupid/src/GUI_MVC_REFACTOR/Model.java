package GUI_MVC_REFACTOR;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import Backend.Person;

public class Model {
	
	private ArrayList<Person> people;

	public ArrayList<Person> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}
	
	public DefaultTableModel generateOverviewTable() {
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
