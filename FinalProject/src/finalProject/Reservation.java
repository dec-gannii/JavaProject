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
	protected String type1 = "", type2 = "", type3 = "", type4 = "", type5 = "", type6 = ""; // 티켓 패널에 불러올 정보들을 저장하기 위한 String type의 멤버 변수 6개
	int finalTotal = 0, wayPrice = 0, seatNumber = 0, numberOfPeople = 0; // 총 금액과 편도 - 왕복 비용, 좌석 번호, 총 인원 수를 저장하기 위한 int type의 멤버 변수 4개
	private JButton ok, cancel, refresh; 

	final int total = 50000; // 기본 요금
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
			info.setText("완료된 예약 내역이 존재하지 않습니다." + "\n" + "모든 항목에 대한 선택을 해주세요.");
			this.add(info);
			info.setEditable(false);
		}
	}

	public Reservation() {
		this.setTitle("예약 화면");
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

		JLabel info = new JLabel("예약 화면에 오신 것을 환영합니다! 아래에서 해당 항목을 선택해주세요.");
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

		this.refresh = new JButton("새로고침");
		this.ok = new JButton("확인");
		this.cancel = new JButton("취소");

		ok.addActionListener(e -> {
			if (type4 == hp.oneWay.getActionCommand()) {
				finalTotal = wayPrice * 1;
			} else if (type4 == hp.round.getActionCommand()) {
				finalTotal = wayPrice * 2;
			}
			if (type1 != "" && type2 != "" && type3 != "" && type4 != "" && type5 != "" && type6 != "") {
				tp.info.setText("이 티켓은 환불 및 노선 변경이 불가능합니다." + "\n" + "예약일시 : " + time.toString() + "\n");

				if (ap.buttons[0].isSelected() == true) {
					this.tp.info.append("총 인원 : " + "성인  " + np.aValue);
					ap.agePrice = ap.adultCost * np.aValue + ap.kidCost * np.kValue + ap.babyCost * np.bValue;
				}
				if (ap.buttons[1].isSelected() == true) {
					if (ap.buttons[0].isSelected() == false && ap.buttons[2].isSelected() == false)
						this.tp.info.append("총 인원 : " + "소아 (만2세~12세 미만) " + np.kValue);
					else
						this.tp.info.append(" 소아 (만2세~12세 미만) " + np.kValue);
					ap.agePrice = ap.adultCost * np.aValue + ap.kidCost * np.kValue + ap.babyCost * np.bValue;
				}
				if (ap.buttons[2].isSelected() == true) {
					if (ap.buttons[0].isSelected() == false && ap.buttons[1].isSelected() == false)
						this.tp.info.append("총 인원 : " + "유아 (만 2세 미만) " + np.bValue);
					else
						this.tp.info.append("유아 (만 2세 미만) " + np.bValue);
					ap.agePrice = ap.adultCost * np.aValue + ap.kidCost * np.kValue + ap.babyCost * np.bValue;
				}

				this.tp.info.append(
						"\n" + "좌석 : " + type1 + "부터 " + numberOfPeople + " 좌석" + "     " + "좌석의 등급 : " + type3 + "\n");
				this.tp.info.append("탑승 예정자 : " + type2 + "\n");
				this.tp.info.append("일정 : " + type4 + "\n");
				this.tp.info.append("출발지 : " + type5 + "    도착지 : " + type6 + "\n");
				this.tp.info.append("결제 금액 : " + finalTotal + "원");

				bp2.add(tp, BorderLayout.NORTH);
				if (this.tp.isVisible() == false) {
					this.tp.setVisible(true);
					this.ok.setEnabled(false);
				}
				this.setSize(550, 650);
				info.setText("예약에 성공했습니다! 수정할 내용이 있다면 수정하고 새로고침을 눌러주세요.");
				bp3.setBackground(Color.BLUE);
				info.setForeground(Color.WHITE);
			} else {
				info.setText("예약 과정 중 문제가 발생했습니다. 취소 버튼을 누른 후 다시 시도해주세요.");
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
				tp.info.setText("이 티켓은 환불 및 노선 변경이 불가능합니다." + "\n" + "예약일시 : " + time.toString() + "\n");

				if (ap.buttons[0].isSelected() == true) {
					this.tp.info.append("총 인원 : " + "성인  " + np.aValue);
					ap.agePrice = ap.adultCost * np.aValue + ap.kidCost * np.kValue + ap.babyCost * np.bValue;
				}
				if (ap.buttons[1].isSelected() == true) {
					if (ap.buttons[0].isSelected() == false && ap.buttons[2].isSelected() == false)
						this.tp.info.append("총 인원 : " + "소아 (만2세~12세 미만) " + np.kValue);
					else
						this.tp.info.append(" 소아 (만2세~12세 미만) " + np.kValue);
					ap.agePrice = ap.adultCost * np.aValue + ap.kidCost * np.kValue + ap.babyCost * np.bValue;
				}
				if (ap.buttons[2].isSelected() == true) {
					if (ap.buttons[0].isSelected() == false && ap.buttons[1].isSelected() == false)
						this.tp.info.append("총 인원 : " + "유아 (만 2세 미만) " + np.bValue);
					else
						this.tp.info.append("유아 (만 2세 미만) " + np.bValue);
					ap.agePrice = ap.adultCost * np.aValue + ap.kidCost * np.kValue + ap.babyCost * np.bValue;
				}

				this.tp.info.append(
						"\n" + "좌석 : " + type1 + "부터 " + numberOfPeople + " 좌석" + "     " + "좌석의 등급 : " + type3 + "\n");
				this.tp.info.append("탑승 예정자 : " + type2 + "\n");
				this.tp.info.append("일정 : " + type4 + "\n");
				this.tp.info.append("출발지 : " + type5 + "    도착지 : " + type6 + "\n");
				this.tp.info.append("결제 금액 : " + finalTotal + "원");

				bp2.add(tp, BorderLayout.NORTH);
				if (this.tp.isVisible() == false) {
					this.tp.setVisible(true);
				}
				this.setSize(550, 650);
				info.setText("예약에 성공했습니다! 수정할 내용이 있다면 수정하고 새로고침을 눌러주세요.");
				bp3.setBackground(Color.BLUE);
				info.setForeground(Color.WHITE);
			} else {
				info.setText("예약 과정 중 문제가 발생했습니다. 취소 버튼을 누른 후 다시 시도해주세요.");
				bp3.setBackground(Color.RED);
				info.setForeground(Color.WHITE);
				this.tp.info.setText("완료된 예약 내역이 존재하지 않습니다." + "\n" + "모든 항목에 대한 선택을 해주세요.");
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
						type1 = "창가쪽 자리 매진";
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
						type1 = "통로쪽 자리 매진";
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
			finalTotal = wayPrice * 1; // 편도 금액
		}
		if (e.getSource() == this.hp.round) {
			type4 = e.getActionCommand();
			finalTotal = wayPrice * 2; // 왕복 금액은 2배
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
