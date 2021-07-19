package finalProject;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class DepartArrivePanel extends JPanel {
	protected JComboBox depart;
	protected JComboBox arrive;
	protected String[] departCity = { "김포", "인천", "부산", "서울" };
	protected String[] arriveCity = { "제주", "미국", "독일", "영국" };
	int distancePrice = 0;

	public DepartArrivePanel() {
		distancePrice = 50000;
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
		
		depart = new JComboBox(departCity);
		arrive = new JComboBox(arriveCity);

		depart.setSelectedIndex(0);
		arrive.setSelectedIndex(0);

		setBorder(BorderFactory.createTitledBorder("출발지 - 도착지"));

		add(depart);
		add(arrive);
	}
}