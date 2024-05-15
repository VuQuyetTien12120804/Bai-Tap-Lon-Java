package Music;

import javax.sound.sampled.*;
import java.io.*;

public class BackgroundMusic implements Runnable {
    private Thread musicThread;
    private Clip clip;
    private boolean gameRunning; // Biến để theo dõi trạng thái của trò chơi

    public BackgroundMusic() {
        try {
            // Tải tệp nhạc
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("nhacgame\\\\music.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            gameRunning = true; // Ban đầu đặt trò chơi đang chạy
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Phương thức để bắt đầu phát nhạc
    public void start() {
        if (musicThread == null) {
            musicThread = new Thread(this);
            musicThread.start();
        }
    }

    // Phương thức để dừng phát nhạc
    public void stop() {
        if (musicThread != null) {
            clip.stop();
            musicThread.interrupt();
            musicThread = null;
        }
    }

    // Phương thức chạy trong luồng để phát nhạc
    @Override
    public void run() {
        try {
            // Lặp vô hạn để nhạc có thể tiếp tục chạy
            while (gameRunning) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                // Ngủ 100ms và kiểm tra trạng thái trò chơi mỗi lần
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Phương thức để thông báo rằng trò chơi đã kết thúc
    public void gameEnded() {
        gameRunning = false;
    }
}
