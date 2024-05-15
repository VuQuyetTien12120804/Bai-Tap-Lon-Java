package Name;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.KhachHangDAO;
import Game.Gameplay;
import Model.KhachHang;

public class Name extends JPanel{
	private JLabel jLabelP1;
	private JLabel jLabelP2;
	private JLabel jLabelName;
	private JLabel jLabelPasword;
	private JTextField jTextFieldNameP1;
	private JTextField jTextFieldNameP2;
	private JPasswordField jTextFieldPassP1;
	private JPasswordField jTextFieldPassP2;
	private JButton jButton_Play;
	private JButton jButton_ok1,jButton_ok2;
	private JLabel jText;
	private String s1,s2;
	private Image backgroundImage;
	private boolean a,b;	
	public Name(boolean a, boolean b) {
		this.a=a;
		this.b=b;
		this.init();
		this.setVisible(true);
	}
	
	public void init() {
		backgroundImage = new ImageIcon("image//background.jpg").getImage();
		this.setSize(800, 650);
		setLayout(null);
		
		jLabelName = new JLabel("Name");
		jLabelName.setForeground(Color.ORANGE);
		jLabelName.setFont(new Font("Algerian", Font.BOLD, 50));
		jLabelName.setBounds(320, 150, 200, 50);
		
		jLabelPasword = new JLabel("Password");
		jLabelPasword.setForeground(Color.ORANGE);
		jLabelPasword.setFont(new Font("Algerian", Font.BOLD, 50));
		jLabelPasword.setBounds(265, 250, 400, 50);
		
		jTextFieldPassP1 = new JPasswordField(50);
		jTextFieldPassP1.setBounds(30, 250, 200, 40);
		
		jTextFieldPassP2 = new JPasswordField(50);
		jTextFieldPassP2.setBounds(550, 250, 200, 40);
		
		jLabelP1 = new JLabel("Player1");
		jLabelP1.setForeground(Color.green);
		jLabelP1.setFont(new Font("Algerian", Font.BOLD, 30));
		jLabelP1.setBounds(60, 100, 200, 60);
		
		jTextFieldNameP1 = new JTextField(50);
		jTextFieldNameP1.setBounds(30, 150, 200, 40);
		
		jLabelP2 = new JLabel("Player2");
		jLabelP2.setForeground(Color.yellow);
		jLabelP2.setFont(new Font("Algerian", Font.BOLD, 30));
		jLabelP2.setBounds(580, 100, 200, 60);
		
		jTextFieldNameP2 = new JTextField(50);
		jTextFieldNameP2.setBounds(550, 150, 200, 40);
		
		jButton_ok1 = new JButton("Ok");
		jButton_ok1.setBorderPainted(false);
		jButton_ok1.setContentAreaFilled(false);
		jButton_ok1.setFocusPainted(false);
		jButton_ok1.setBounds(30, 300, 200, 30);
		jButton_ok1.setForeground(Color.green);
		jButton_ok1.setFont(new Font("Algerian", Font.BOLD, 30));
		
		jButton_ok2 = new JButton("Ok");
		jButton_ok2.setBorderPainted(false);
		jButton_ok2.setContentAreaFilled(false);
		jButton_ok2.setFocusPainted(false);
		jButton_ok2.setBounds(550, 300, 200, 30);
		jButton_ok2.setForeground(Color.yellow);
		jButton_ok2.setFont(new Font("Algerian", Font.BOLD, 30));
		
		jButton_Play = new JButton("Play");
		jButton_Play.setBorderPainted(false);
		jButton_Play.setContentAreaFilled(false);
		jButton_Play.setFocusPainted(false);
		jButton_Play.setBounds(300, 400, 200, 60);
		jButton_Play.setForeground(Color.red);
		jButton_Play.setFont(new Font("Algerian", Font.BOLD, 60));
		
		JLabel jText = new JLabel("TANK 2D GAME", JLabel.CENTER);
		jText.setFocusable(false);
		jText.setBounds(100, 0, 600, 200);
		jText.setForeground(Color.darkGray);
		jText.setFont(new Font("Algerian", Font.BOLD, 60));
		
		add(jText);

		add(jButton_ok1);
		add(jButton_ok2);
		add(jButton_Play);
		add(jText);
		add(jLabelP1);
		add(jTextFieldNameP1);
		add(jLabelP2);
		add(jTextFieldNameP2);
		add(jLabelName);
		add(jLabelPasword);
		add(jTextFieldPassP1);
		add(jTextFieldPassP2);
		
		jButton_Play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                // Gọi phương thức để mở giao diện trò chơi
                openGamePlay();
            }
        });
		
		jButton_ok1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check1();
            }
        });
		
		jButton_ok2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check2();
            }
        });
	}
	
	public JLabel getjLabelP1() {
		return jLabelP1;
	}

	public void setjLabelP1(JLabel jLabelP1) {
		this.jLabelP1 = jLabelP1;
	}

	public JLabel getjLabelP2() {
		return jLabelP2;
	}

	public void setjLabelP2(JLabel jLabelP2) {
		this.jLabelP2 = jLabelP2;
	}

	public JLabel getjLabelName() {
		return jLabelName;
	}

	public void setjLabelName(JLabel jLabelName) {
		this.jLabelName = jLabelName;
	}

	public JLabel getjLabelPasword() {
		return jLabelPasword;
	}

	public void setjLabelPasword(JLabel jLabelPasword) {
		this.jLabelPasword = jLabelPasword;
	}

	public JTextField getjTextFieldNameP1() {
		return jTextFieldNameP1;
	}

	public void setjTextFieldNameP1(JTextField jTextFieldNameP1) {
		this.jTextFieldNameP1 = jTextFieldNameP1;
	}

	public JTextField getjTextFieldNameP2() {
		return jTextFieldNameP2;
	}

	public void setjTextFieldNameP2(JTextField jTextFieldNameP2) {
		this.jTextFieldNameP2 = jTextFieldNameP2;
	}

	public JTextField getjTextFieldPassP1() {
		return jTextFieldPassP1;
	}

	public void setjTextFieldPassP1(JPasswordField jTextFieldPassP1) {
		this.jTextFieldPassP1 = jTextFieldPassP1;
	}

	public JTextField getjTextFieldPassP2() {
		return jTextFieldPassP2;
	}

	public void setjTextFieldPassP2(JPasswordField jTextFieldPassP2) {
		this.jTextFieldPassP2 = jTextFieldPassP2;
	}

	public JButton getjButton_Play() {
		return jButton_Play;
	}

	public void setjButton_Play(JButton jButton_Play) {
		this.jButton_Play = jButton_Play;
	}

	public JLabel getjText() {
		return jText;
	}

	public void setjText(JLabel jText) {
		this.jText = jText;
	}

	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

	public Image getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	private void openGamePlay() {
		// Tạo một JFrame mới để hiển thị giao diện trò chơi
        JFrame gameFrame = new JFrame("GamePlay");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(800, 650);
        gameFrame.setLocationRelativeTo(gameFrame);
        //gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon image = new ImageIcon("image\\logo.jpg"); //create an image icon
    	gameFrame.setIconImage(image.getImage()); // change icon of frame

        // Tạo một Gameplay mới và thêm vào frame
		s1 = jTextFieldNameP1.getText();
		s2 = jTextFieldNameP2.getText();
        Gameplay gamePlay = new Gameplay(s1,s2,a,b);
        gameFrame.add(gamePlay);

        // Ẩn frame chính (nếu cần)
        SwingUtilities.getWindowAncestor(this).setVisible(false);

        // Hiển thị frame của giao diện trò chơi
        gameFrame.setVisible(true);
    }
	
	private void check1() {
		s1 = jTextFieldNameP1.getText();
		char[] password = jTextFieldPassP1.getPassword();
		String s3 = new String(password);
		KhachHang kh = new KhachHang(s1, s3);
		if (KhachHangDAO.getIntance().check(kh)) {
			jTextFieldNameP1.setText("");
			jTextFieldPassP1.setText("");
		}else KhachHangDAO.getIntance().insert(kh);		
	}
	
	private void check2() {
		s2 = jTextFieldNameP2.getText();
		char[] password = jTextFieldPassP2.getPassword();
		String s4 = new String(password);
		KhachHang kh = new KhachHang(s2, s4);
		if (KhachHangDAO.getIntance().check(kh)) {
			jTextFieldNameP2.setText("");
			jTextFieldPassP2.setText("");
		}else KhachHangDAO.getIntance().insert(kh);
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
