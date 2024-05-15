package GameInterface;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("Game Tank 2D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 650);
        setLocationRelativeTo(null);
        setResizable(false);
        //setExtendedState(JFrame.MAXIMIZED_BOTH); // Đặt kích thước cửa sổ để lấp đầy toàn bộ màn hình
        //setUndecorated(true); // Loại bỏ tiêu đề và khung viền của cửa sổ
        // Tạo một GameStartPanel mới và thêm vào frame
        GameStartPanel startPanel = new GameStartPanel();
        add(startPanel);
        ImageIcon image = new ImageIcon("image\\logo.jpg"); //create an image icon
		setIconImage(image.getImage()); // change icon of frame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GameFrame();
            }
        });
    }
    
    
}
