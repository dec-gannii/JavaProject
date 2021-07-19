package finalProject;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class DepartArrivePanel extends JPanel {
	protected JComboBox depart;
	protected JComboBox arrive;
	protected String[] departCity = { "����", "��õ", "�λ�", "����" };
	protected String[] arriveCity = { "����", "�̱�", "����", "����" };
	int distancePrice = 0;

	public DepartArrivePanel() {
		distancePrice = 50000;
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
		
		depart = new JComboBox(departCity);
		arrive = new JComboBox(arriveCity);

		depart.setSelectedIndex(0);
		arrive.setSelectedIndex(0);

		setBorder(BorderFactory.createTitledBorder("����� - ������"));

		add(depart);
		add(arrive);
	}
}