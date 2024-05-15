package Music;

import javax.sound.sampled.*;
import java.io.*;

public class ShootMusic{
    private Clip clip;
    private boolean gameRunning; // Biến để theo dõi trạng thái của trò chơi

    public ShootMusic() {
        try {
            // Tải tệp nhạc
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("nhacgame\\\\soundShoot.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            gameRunning = true; // Ban đầu đặt trò chơi đang chạy
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playSound() {
    	clip.setFramePosition(0); // Start from the beginning of the sound
        clip.start();

        // Sleep for approximately 1 second (adjust as needed)
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop the audio
        clip.stop();
    }
}
