import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

// 소스를 입력하고 Ctrl+Shift+O를 눌러서 필요한 파일을 포함한다. 

class MyPanel extends JPanel implements MouseListener {
	BufferedImage img = null;
	int img_x = 100, img_y = 100;

	public MyPanel() {
		try {
			img = ImageIO.read(new File("car.gif"));

		} catch (IOException e) {
			System.out.println("no image");
			System.exit(1);
		}
		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				switch (keycode) {
				case KeyEvent.VK_UP:	img_y -= 10;	break;
				case KeyEvent.VK_DOWN:	img_y += 10;	break;
				case KeyEvent.VK_LEFT:	img_x -= 10;	break;
				case KeyEvent.VK_RIGHT:	img_x += 10;	break;
				}
				repaint();
			}
			public void keyReleased(KeyEvent arg0) {		}
			public void keyTyped(KeyEvent arg0) {			}

		});
		addMouseListener(this);
		this.requestFocus();
		setFocusable(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, img_x, img_y, null);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
				
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		img_x = e.getX();
		img_y = e.getY();
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

public class CarGameTestMouseVer extends JFrame {
	public CarGameTestMouseVer() {
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyPanel());
		setVisible(true);
	}

	public static void main(String[] args) {
		CarGameTestMouseVer s = new CarGameTestMouseVer();
	}
}