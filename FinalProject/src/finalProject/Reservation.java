package finalProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Reservation extends JFrame implements ActionListener {
	protected String type1 = "", type2 = "", type3 = "", type4 = "", type5 = "", type6 = ""; // Ƽ�� �гο� �ҷ��� �������� �����ϱ� ���� String type�� ��� ���� 6��
	int finalTotal = 0, wayPrice = 0, seatNumber = 0, numberOfPeople = 0; // �� �ݾװ� �� - �պ� ���, �¼� ��ȣ, �� �ο� ���� �����ϱ� ���� int type�� ��� ���� 4��
	private JButton ok, cancel, refresh; 

	final int total = 50000; // �⺻ ���
	private SeatPanel sp;
	private AgePanel ap;
	private HowPanel hp;
	private GradePanel gp;
	private TicketPanel tp;
	private DepartArrivePanel dap;
	private NumberPanel np;
	private Date time;

	private static int[] seats = new int[12];

	class TicketPanel extends JPanel {
		Border border = BorderFactory.createTitledBorder("Ticket");
		JTextArea info = new JTextArea(10, 35);

		public TicketPanel() {
			this.setBorder(border);
			this.setBackground(Color.WHITE);
			time = new Date();
			info.setText("�Ϸ�� ���� ������ �������� �ʽ��ϴ�." + "\n" + "��� �׸� ���� ������ ���ּ���.");
			this.add(info);
			info.setEditable(false);
		}
	}

	public Reservation() {
		this.setTitle("���� ȭ��");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(550, 500);

		sp = new SeatPanel();
		ap = new AgePanel();
		gp = new GradePanel();
		hp = new HowPanel();
		dap = new DepartArrivePanel();
		tp = new TicketPanel();
		np = new NumberPanel();

		JPanel bp = new JPanel(); // buttomPanel
		JPanel bp2 = new JPanel(); // buttomPanel
		JPanel bp3 = new JPanel(); // buttomPanel
		JPanel bsp = new JPanel(); // basePanel
		JPanel bsp2 = new JPanel(); // basePanel

		for (int i = 0; i < 12; i++) {
			seats[i] = 0;
		}

		if(gp.economyS.isSelected() == true) {
			type3 = gp.economyS.getActionCommand();
			gp.gradePrice = 80000;
		}
		if(sp.window.isSelected() == true) {
			type1 = sp.window.getActionCommand();
		}
		if(hp.oneWay.isSelected() == true) {
			type4 = hp.oneWay.getActionCommand();
		}
		if(dap.departCity[dap.depart.getSelectedIndex()].equals(dap.departCity[0])) {
			type5 = dap.departCity[0];
		}
		if(dap.arriveCity[dap.arrive.getSelectedIndex()].equals(dap.arriveCity[0])) {
			type6 = dap.arriveCity[0];
		}
		
		sp.window.addActionListener(this);
		sp.aisle.addActionListener(this);
		np.aplus.addActionListener(this);
		np.aminus.addActionListener(this);
		np.kplus.addActionListener(this);
		np.kminus.addActionListener(this);
		np.bplus.addActionListener(this);
		np.bminus.addActionListener(this);
		ap.buttons[0].addActionListener(this);
		ap.buttons[1].addActionListener(this);
		ap.buttons[2].addActionListener(this);
		gp.economyS.addActionListener(this);
		gp.economyR.addActionListener(this);
		gp.business.addActionListener(this);
		gp.first.addActionListener(this);
		dap.depart.addActionListener(this);
		dap.arrive.addActionListener(this);
		hp.oneWay.addActionListener(this);
		hp.round.addActionListener(this);

		JLabel info = new JLabel("���� ȭ�鿡 ���� ���� ȯ���մϴ�! �Ʒ����� �ش� �׸��� �������ּ���.");
		bp3.add(info, BorderLayout.NORTH);
		bp3.setBackground(Color.WHITE);

		bsp.setLayout(new GridLayout(2, 3, 20, 20));
		bsp.add(ap);
		bsp.add(np);
		bsp.add(sp);
		bsp.add(gp);
		bsp.add(dap);
		bsp.add(hp);

		bp.setLayout(new BorderLayout(20, 20));
		bp.add(bsp, BorderLayout.NORTH);

		this.refresh = new JButton("���ΰ�ħ");
		this.ok = new JButton("Ȯ��");
		this.cancel = new JButton("���");

		ok.addActionListener(e -> {
			if (type4 == hp.oneWay.getActionCommand()) {
				finalTotal = wayPrice * 1;
			} else if (type4 == hp.round.getActionCommand()) {
				finalTotal = wayPrice * 2;
			}
			if (type1 != "" && type2 != "" && type3 != "" && type4 != "" && type5 != "" && type6 != "") {
				tp.info.setText("�� Ƽ���� ȯ�� �� �뼱 ������ �Ұ����մϴ�." + "\n" + "�����Ͻ� : " + time.toString() + "\n");

				if (ap.buttons[0].isSelected() == true) {
					this.tp.info.append("�� �ο� : " + "����  " + np.aValue);
					ap.agePrice = ap.adultCost * np.aValue + ap.kidCost * np.kValue + ap.babyCost * np.bValue;
				}
				if (ap.buttons[1].isSelected() == true) {
					if (ap.buttons[0].isSelected() == false && ap.buttons[2].isSelected() == false)
						this.tp.info.append("�� �ο� : " + "�Ҿ� (��2��~12�� �̸�) " + np.kValue);
					else
						this.tp.info.append(" �Ҿ� (��2��~12�� �̸�) " + np.kValue);
					ap.agePrice = ap.adultCost * np.aValue + ap.kidCost * np.kValue + ap.babyCost * np.bValue;
				}
				if (ap.buttons[2].isSelected() == true) {
					if (ap.buttons[0].isSelected() == false && ap.buttons[1].isSelected() == false)
						this.tp.info.append("�� �ο� : " + "���� (�� 2�� �̸�) " + np.bValue);
					else
						this.tp.info.append("���� (�� 2�� �̸�) " + np.bValue);
					ap.agePrice = ap.adultCost * np.aValue + ap.kidCost * np.kValue + ap.babyCost * np.bValue;
				}

				this.tp.info.append(
						"\n" + "�¼� : " + type1 + "���� " + numberOfPeople + " �¼�" + "     " + "�¼��� ��� : " + type3 + "\n");
				this.tp.info.append("ž�� ������ : " + type2 + "\n");
				this.tp.info.append("���� : " + type4 + "\n");
				this.tp.info.append("����� : " + type5 + "    ������ : " + type6 + "\n");
				this.tp.info.append("���� �ݾ� : " + finalTotal + "��");

				bp2.add(tp, BorderLayout.NORTH);
				if (this.tp.isVisible() == false) {
					this.tp.setVisible(true);
					this.ok.setEnabled(false);
				}
				this.setSize(550, 650);
				info.setText("���࿡ �����߽��ϴ�! ������ ������ �ִٸ� �����ϰ� ���ΰ�ħ�� �����ּ���.");
				bp3.setBackground(Color.BLUE);
				info.setForeground(Color.WHITE);
			} else {
				info.setText("���� ���� �� ������ �߻��߽��ϴ�. ��� ��ư�� ���� �� �ٽ� �õ����ּ���.");
				bp3.setBackground(Color.RED);
				info.setForeground(Color.WHITE);
				this.tp.setVisible(true);
				this.ok.setEnabled(false);
			}
		});

		cancel.addActionListener(e -> {
			if (this.tp.isVisible() == true) {
				this.tp.setVisible(false);
			}
			finalTotal = total;
			this.setSize(550, 500);
			this.ok.setEnabled(true);
		});

		refresh.addActionListener(e -> {

			if (type4 == hp.oneWay.getActionCommand()) {
				finalTotal = wayPrice * 1;
			} else if (type4 == hp.round.getActionCommand()) {
				finalTotal = wayPrice * 2;
			}
			if (type1 != "" && type2 != "" && type3 != "" && type4 != "" && type5 != "" && type6 != "") {
				tp.info.setText("�� Ƽ���� ȯ�� �� �뼱 ������ �Ұ����մϴ�." + "\n" + "�����Ͻ� : " + time.toString() + "\n");

				if (ap.buttons[0].isSelected() == true) {
					this.tp.info.append("�� �ο� : " + "����  " + np.aValue);
					ap.agePrice = ap.adultCost * np.aValue + ap.kidCost * np.kValue + ap.babyCost * np.bValue;
				}
				if (ap.buttons[1].isSelected() == true) {
					if (ap.buttons[0].isSelected() == false && ap.buttons[2].isSelected() == false)
						this.tp.info.append("�� �ο� : " + "�Ҿ� (��2��~12�� �̸�) " + np.kValue);
					else
						this.tp.info.append(" �Ҿ� (��2��~12�� �̸�) " + np.kValue);
					ap.agePrice = ap.adultCost * np.aValue + ap.kidCost * np.kValue + ap.babyCost * np.bValue;
				}
				if (ap.buttons[2].isSelected() == true) {
					if (ap.buttons[0].isSelected() == false && ap.buttons[1].isSelected() == false)
						this.tp.info.append("�� �ο� : " + "���� (�� 2�� �̸�) " + np.bValue);
					else
						this.tp.info.append("���� (�� 2�� �̸�) " + np.bValue);
					ap.agePrice = ap.adultCost * np.aValue + ap.kidCost * np.kValue + ap.babyCost * np.bValue;
				}

				this.tp.info.append(
						"\n" + "�¼� : " + type1 + "���� " + numberOfPeople + " �¼�" + "     " + "�¼��� ��� : " + type3 + "\n");
				this.tp.info.append("ž�� ������ : " + type2 + "\n");
				this.tp.info.append("���� : " + type4 + "\n");
				this.tp.info.append("����� : " + type5 + "    ������ : " + type6 + "\n");
				this.tp.info.append("���� �ݾ� : " + finalTotal + "��");

				bp2.add(tp, BorderLayout.NORTH);
				if (this.tp.isVisible() == false) {
					this.tp.setVisible(true);
				}
				this.setSize(550, 650);
				info.setText("���࿡ �����߽��ϴ�! ������ ������ �ִٸ� �����ϰ� ���ΰ�ħ�� �����ּ���.");
				bp3.setBackground(Color.BLUE);
				info.setForeground(Color.WHITE);
			} else {
				info.setText("���� ���� �� ������ �߻��߽��ϴ�. ��� ��ư�� ���� �� �ٽ� �õ����ּ���.");
				bp3.setBackground(Color.RED);
				info.setForeground(Color.WHITE);
				this.tp.info.setText("�Ϸ�� ���� ������ �������� �ʽ��ϴ�." + "\n" + "��� �׸� ���� ������ ���ּ���.");
				this.tp.setVisible(true);
			}
		});

		tp.add(refresh);
		bsp2.add(ok, BorderLayout.WEST);
		bsp2.add(cancel, BorderLayout.EAST);

		bp2.add(bsp2, BorderLayout.SOUTH);
		bp2.add(tp, BorderLayout.NORTH);

		tp.setVisible(false);

		this.setLayout(new BorderLayout(20, 20));
		this.add(bp3, BorderLayout.NORTH);
		this.add(bp, BorderLayout.CENTER);
		this.add(bp2, BorderLayout.SOUTH);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.sp.window) {
			type1 = e.getActionCommand();
			if (this.sp.window.isSelected() == true) {
				if (e.getSource() == this.sp.window) {
					seatNumber = bookWindow();
					if (seatNumber == -1) {
						seatNumber = bookAisle();

						if (seatNumber != -1) {
							type1 = e.getActionCommand() + " " + seatNumber;
						}
					} else {
						type1 = e.getActionCommand() + " " + seatNumber;
					}
					if (seatNumber == -1) {
						type1 = "â���� �ڸ� ����";
					}
				}
			}
		}
		if (e.getSource() == this.sp.aisle) {
			type1 = e.getActionCommand();
			if (this.sp.aisle.isSelected() == true) {
				if (e.getSource() == this.sp.aisle) {
					seatNumber = bookAisle();
					if (seatNumber == -1) {
						seatNumber = bookWindow();

						if (seatNumber != -1) {
							type1 = e.getActionCommand() + " " + seatNumber;
						}
					} else {
						type1 = e.getActionCommand() + " " + seatNumber;
					}
					if (seatNumber == -1) {
						type1 = "����� �ڸ� ����";
					}
				}
			}
		}
		if (e.getSource() == this.np.aplus) {
			np.aValue++;
			np.aCount.setText("     " + np.aValue);
		}
		if (e.getSource() == this.np.aminus) {
			np.aValue--;
			np.aCount.setText("     " + np.aValue);
			if (np.aValue <= 0) {
				np.aValue = 0;
				np.aCount.setText("     " + np.aValue);
				if (ap.buttons[0].isSelected() == true) {
					ap.buttons[0].setSelected(false);
					np.aplus.setEnabled(false);
					np.aminus.setEnabled(false);
				}
			}
		}
		if (e.getSource() == this.np.kplus) {
			np.kValue++;
			np.kCount.setText("     " + np.kValue);
		}
		if (e.getSource() == this.np.kminus) {
			np.kValue--;
			np.kCount.setText("     " + np.kValue);
			if (np.kValue <= 0) {
				np.kValue = 0;
				np.kCount.setText("     " + np.kValue);
				if (ap.buttons[1].isSelected() == true) {
					ap.buttons[1].setSelected(false);
					np.kplus.setEnabled(false);
					np.kminus.setEnabled(false);
				}
			}
		}
		if (e.getSource() == this.np.bplus) {
			np.bValue++;
			np.bCount.setText("     " + np.bValue);
		}
		if (e.getSource() == this.np.bminus) {
			np.bValue--;
			np.bCount.setText("     " + np.bValue);
			if (np.bValue <= 0) {
				np.bValue = 0;
				np.bCount.setText("     " + np.bValue);
				if (ap.buttons[2].isSelected() == true) {
					ap.buttons[2].setSelected(false);
					np.bplus.setEnabled(false);
					np.bminus.setEnabled(false);
				}
			}
		}
		if (e.getSource() == this.ap.buttons[0]) {
			np.aplus.setEnabled(true);
			np.aminus.setEnabled(true);
			np.aValue = 1;
			np.aCount.setText("     " + np.aValue);
			if (type2 == "")
				type2 = e.getActionCommand();
			else if (type2 != "")
				type2 = type2 + "     " + e.getActionCommand();
			if (ap.buttons[0].isSelected() == false) {
				np.aValue = 0;
				np.aCount.setText("     " + np.aValue);
				np.aplus.setEnabled(false);
				np.aminus.setEnabled(false);
			} else {
				np.aValue = 1;
			}
			if (np.aValue == 0)
				type2 = type2.replace(e.getActionCommand(), "");
			ap.aChosenCount++;
			if (ap.aChosenCount % 2 == 0 && ap.aChosenCount >= 2) {
				ap.agePrice -= ap.adultCost;
				ap.adultCost = 0;
			}
			if (ap.aChosenCount % 2 != 0 && ap.aChosenCount > 1) {
				ap.adultCost = 100000;
				ap.agePrice += ap.adultCost;
			}
			if (ap.aChosenCount == 1) {
				ap.adultCost = 100000;
			}
			if (ap.aChosenCount == 0) {
				ap.adultCost = 0;
			}
		}

		if (e.getSource() == this.ap.buttons[1]) {
			np.kplus.setEnabled(true);
			np.kminus.setEnabled(true);
			np.kValue = 1;
			np.kCount.setText("     " + np.kValue);
			if (type2 == "")
				type2 = e.getActionCommand();
			else if (type2 != "")
				type2 = type2 + "     " + e.getActionCommand();
			if (ap.buttons[1].isSelected() == false) {
				np.kValue = 0;
				np.kCount.setText("     " + np.kValue);
				np.kplus.setEnabled(false);
				np.kminus.setEnabled(false);
			} else {
				np.kValue = 1;
				ap.agePrice += ap.kidCost;
			}
			if (np.kValue == 0)
				type2 = type2.replace(e.getActionCommand(), "");
			ap.kChosenCount++;
			if (ap.kChosenCount % 2 == 0 && ap.kChosenCount >= 2) {
				ap.agePrice -= ap.kidCost;
				ap.kidCost = 0;
			}
			if (ap.kChosenCount % 2 != 0 && ap.kChosenCount >= 1) {
				ap.kidCost = 50000;
				ap.agePrice += ap.kidCost;
			}
			if (ap.kChosenCount == 1) {
				ap.kidCost = 50000;
			}
			if (ap.kChosenCount == 0) {
				ap.kidCost = 0;
			}
		}
		if (e.getSource() == this.ap.buttons[2]) {
			np.bplus.setEnabled(true);
			np.bminus.setEnabled(true);
			np.bValue = 1;
			np.bCount.setText("     " + np.bValue);
			if (type2 == "")
				type2 = e.getActionCommand();
			else if (type2 != "")
				type2 = type2 + "     " + e.getActionCommand();
			if (ap.buttons[2].isSelected() == false) {
				np.bValue = 0;
				np.bCount.setText("     " + np.bValue);
				np.bplus.setEnabled(false);
				np.bminus.setEnabled(false);
			} else {
				np.bValue = 1;
			}
			if (np.bValue == 0)
				type2 = type2.replace(e.getActionCommand(), "");
			ap.bChosenCount++;
			if (ap.bChosenCount % 2 == 0 && ap.bChosenCount >= 2) {
				ap.agePrice -= ap.babyCost;
				ap.babyCost = 0;
			}
			if (ap.bChosenCount % 2 != 0 && ap.bChosenCount >= 1) {
				ap.babyCost = 20000;
				ap.agePrice += ap.babyCost;
			}
			if (ap.bChosenCount == 1) {
				ap.babyCost = 20000;
			}
			if (ap.bChosenCount == 0) {
				ap.babyCost = 0;
			}
		}
		if (e.getSource() == this.gp.economyS) {
			type3 = e.getActionCommand();
			gp.gradePrice = 80000;
		}
		if (e.getSource() == this.gp.economyR) {
			type3 = e.getActionCommand();
			gp.gradePrice = 100000;
		}
		if (e.getSource() == this.gp.business) {
			type3 = e.getActionCommand();
			gp.gradePrice = 180000;
		}
		if (e.getSource() == this.gp.first) {
			type3 = e.getActionCommand();
			gp.gradePrice = 200000;
		}
		if (this.dap.departCity[dap.depart.getSelectedIndex()].equals(this.dap.departCity[0])) {
			type5 = this.dap.departCity[0];
		}
		if (this.dap.departCity[dap.depart.getSelectedIndex()].equals(this.dap.departCity[1])) {
			type5 = this.dap.departCity[1];
		}
		if (this.dap.departCity[dap.depart.getSelectedIndex()].equals(this.dap.departCity[2])) {
			type5 = this.dap.departCity[2];
		}
		if (this.dap.departCity[dap.depart.getSelectedIndex()].equals(this.dap.departCity[3])) {
			type5 = this.dap.departCity[3];
		}
		if (this.dap.arriveCity[dap.arrive.getSelectedIndex()].equals(this.dap.arriveCity[0])) {
			dap.distancePrice = 50000;
			type6 = this.dap.arriveCity[0];
		}
		if (this.dap.arriveCity[dap.arrive.getSelectedIndex()].equals(this.dap.arriveCity[1])) {
			dap.distancePrice = 200000;
			type6 = this.dap.arriveCity[1];
		}
		if (this.dap.arriveCity[dap.arrive.getSelectedIndex()].equals(this.dap.arriveCity[2])) {
			dap.distancePrice = 150000;
			type6 = this.dap.arriveCity[2];
		}
		if (this.dap.arriveCity[dap.arrive.getSelectedIndex()].equals(this.dap.arriveCity[3])) {
			dap.distancePrice = 140000;
			type6 = this.dap.arriveCity[3];
		}
		if (e.getSource() == this.hp.oneWay) {
			type4 = e.getActionCommand();
			finalTotal = wayPrice * 1; // �� �ݾ�
		}
		if (e.getSource() == this.hp.round) {
			type4 = e.getActionCommand();
			finalTotal = wayPrice * 2; // �պ� �ݾ��� 2��
		}
		if (ap.buttons[0].isSelected() == false && ap.buttons[1].isSelected() == false
				&& ap.buttons[2].isSelected() == false) {
			type2 = "";
		}
		ap.agePrice = ap.adultCost * np.aValue + ap.kidCost * np.kValue + ap.babyCost * np.bValue;
		numberOfPeople = np.aValue + np.kValue + np.bValue;
		wayPrice = ap.agePrice + gp.gradePrice + dap.distancePrice + total;
	}

	private static int bookWindow() {
		for (int i = 0; i < 6; i++) {
			if (seats[i] == 0) {
				seats[i] = 1;
				return i + 1;
			}
		}
		return -1;
	}

	private static int bookAisle() {
		for (int i = 6; i < 12; i++) {
			if (seats[i] == 0) {
				seats[i] = 1;
				return i + 1;
			}
		}
		return -1;

	}
}
