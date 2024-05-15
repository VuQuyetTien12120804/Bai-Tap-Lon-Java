package GameInterface;
import javax.swing.*;

import Name.Name;

import java.awt.*;
import java.awt.event.*;

public class GameStartPanel extends JPanel {
    private JButton playButton;
    private JButton settingsButton;
    private Image backgroundImage;
    private JLabel jText;
	private JLabel soundLabel;
	private JLabel vibrateLabel;
	private JCheckBox soundRadioButton;
	private JCheckBox vibrateRadioButton;

    public JLabel getSoundLabel() {
		return soundLabel;
	}

	public void setSoundLabel(JLabel soundLabel) {
		this.soundLabel = soundLabel;
	}

	public JLabel getVibrateLabel() {
		return vibrateLabel;
	}

	public void setVibrateLabel(JLabel vibrateLabel) {
		this.vibrateLabel = vibrateLabel;
	}

	public GameStartPanel() {
        setLayout(null);

        // Load ảnh nền
        backgroundImage = new ImageIcon("image//background.jpg").getImage();

        // Nút play
        playButton = new JButton("PLAY");
        //playButton.setIcon(new ImageIcon("image\\pl1.png")); // Thêm biểu tượng cho nút "PLAY"
        playButton.setBorderPainted(false);
        playButton.setContentAreaFilled(false);
        playButton.setFocusPainted(false);
        playButton.setBounds(300, 400, 200, 60);
        
        JLabel jText = new JLabel("TANK 2D GAME", JLabel.CENTER);
		jText.setFocusable(false);
		jText.setBounds(100, 30, 600, 200);
		jText.setForeground(Color.darkGray);
		jText.setFont(new Font("Algerian", Font.BOLD, 60));
		
		add(jText);
     
     // Thiết lập màu nền và phông chữ mới
        //playButton.setBackground(Color.red);
        playButton.setForeground(Color.red);
        playButton.setFont(new Font("Algerian", Font.BOLD, 60)); // Thiết lập phông chữ Algerian, đậm, kích cỡ 60

        add(playButton);
      
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Gọi phương thức để mở giao diện trò chơi
                openName();
            }
        });
        
    //  nút settings  
        
        settingsButton = new JButton("SETTINGS");
        settingsButton.setBorderPainted(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setFocusPainted(false);
        
        settingsButton.setForeground(Color.black);
        settingsButton.setFont(new Font("Algerian", Font.BOLD, 30)); // Thiết lập phông chữ Algerian, đậm, kích cỡ 60
        
     // Thiết lập menu cho nút settings
        JPopupMenu settingsMenu = new JPopupMenu();
        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new GridLayout(2, 2, 10, 10)); // Sử dụng GridLayout để sắp xếp các thành phần

        soundLabel = new JLabel("Sound");
        vibrateLabel = new JLabel("Vibrate");

        soundRadioButton = new JCheckBox();
        soundRadioButton.setSelected(true); // Mặc định là bật
        
        vibrateRadioButton = new JCheckBox();
        vibrateRadioButton.setSelected(true); // Mặc định là bật

        // Thêm các phần tử vào panel
        settingsPanel.add(soundLabel);
        settingsPanel.add(soundRadioButton);
        settingsPanel.add(vibrateLabel);
        settingsPanel.add(vibrateRadioButton);

        settingsMenu.add(settingsPanel);

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsMenu.show(settingsButton, 0, settingsButton.getHeight());
            }
        });

        settingsButton.setBounds(0, 5, 200, 70);
        
        add(settingsButton);
        add(jText);
    }

    // Phương thức để mở giao diện trò chơi
    private void openName() {
        // Tạo một JFrame mới để hiển thị giao diện trò chơi
        JFrame gameFrame = new JFrame("Name");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(800, 650);
        gameFrame.setLocationRelativeTo(gameFrame);
        //gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon image = new ImageIcon("image\\logo.jpg"); //create an image icon
    	gameFrame.setIconImage(image.getImage()); // change icon of frame

        // Tạo một Name mới và thêm vào frame
    	boolean a,b;
    	if (this.soundRadioButton.isSelected()) a=true;
    	else a=false;
    	if (this.vibrateRadioButton.isSelected()) b=true;
    	else b=false;
        Name name = new Name(a,b);
        gameFrame.add(name);

        // Ẩn frame chính (nếu cần)
        SwingUtilities.getWindowAncestor(this).setVisible(false);

        // Hiển thị frame của giao diện trò chơi
        gameFrame.setVisible(true);
    }

    // Phương thức để vẽ ảnh nền
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
    

}
