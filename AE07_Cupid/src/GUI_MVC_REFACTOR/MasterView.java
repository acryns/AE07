package GUI_MVC_REFACTOR;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class MasterView {
	
	//private JPanel contentPane;
	
	private Tab1View tab1;
	private Tab2View tab2;
	private Tab3View tab3;
	
	private JTabbedPane jTab;
	private JPanel contentPane;
	
	public MasterView(JPanel contentPane)  {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1024, 768);
//		contentPane = new JPanel();
//		contentPane.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
//		
//		this.jTab = new JTabbedPane(JTabbedPane.TOP);
//		contentPane.add(jTab);
		
		
		this.jTab = new JTabbedPane(JTabbedPane.TOP);
		this.contentPane = contentPane;
		contentPane.add(jTab);
		
		this.tab1 = new Tab1View();
		jTab.addTab("details", null, tab1.getTabDetail(), null);
		
		this.tab2 = new Tab2View();
		jTab.addTab("overview", null, tab2.getTabOverview(), null);
		this.tab3 = new Tab3View();
		jTab.addTab("create", null, tab3.getTabCreate(), null);

		
		

	}

	public JTabbedPane getJTab() {
		return jTab;
	}

	public Tab1View getTab1() {
		return tab1;
	}

	public void setTab1(Tab1View tab1) {
		this.tab1 = tab1;
	}

	public Tab2View getTab2() {
		return tab2;
	}

	public void setTab2(Tab2View tab2) {
		this.tab2 = tab2;
	}

	public Tab3View getTab3() {
		return tab3;
	}

	public void setTab3(Tab3View tab3) {
		this.tab3 = tab3;
	}

	public void setjTab(JTabbedPane jTab) {
		this.jTab = jTab;
	}
	
}
