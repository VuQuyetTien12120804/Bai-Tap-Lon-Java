package Game;

import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

import javax.swing.Timer;

import Model.Brick;
import Model.Player1Listener;
import Model.Player2Listener;
import Music.BackgroundMusic;
import Music.ShootMusic;
import Name.NamePlayer;

public class Gameplay  extends JPanel implements ActionListener, KeyListener 
{
	private Brick br;
	private ShootMusic shootmusic;
	private BackgroundMusic backgroundMusic; 
	private NamePlayer name1;
	private NamePlayer name2;
	
	private Timer timer;
	private int delay;
	
	private Player1Listener player1Listener;
	private Player2Listener player2Listener;
	
	private boolean play;
	
	JFrame obj=new JFrame();
	
	private boolean blink = true; // Biến để kiểm soát việc nhấp nháy
	
	public Gameplay(String s1, String s2, boolean a, boolean b)
	{	
		name1 = new NamePlayer(s1,200,540);
		name2 = new NamePlayer(s2,400,540);
		if (a==true) {
			backgroundMusic = new BackgroundMusic();
			backgroundMusic.start();
		}
		if (b==true) {
			shootmusic = new ShootMusic();
		}
		br = new Brick(); 
		player2Listener = new Player2Listener(this,name2);
		player1Listener = new Player1Listener(this,name1);
		setFocusable(true);  // nhận các sự kiện phím
		addKeyListener(player1Listener);
		addKeyListener(player2Listener);
		addKeyListener(this);
		setFocusTraversalKeysEnabled(false);
		delay=8;
		play=true;
        timer=new Timer(delay,this);
		timer.start();
		
		// Tạo một Timer để thay đổi giá trị của biến blink sau mỗi khoảng thời gian
        Timer blinkTimer = new Timer(500, new ActionListener() { // 500 milliseconds
            @Override
            public void actionPerformed(ActionEvent e) {
                blink = !blink; // Chuyển đổi giá trị của blink
                repaint(); // Vẽ lại JPanel để cập nhật hiển thị
            }
        });
        blinkTimer.start(); // Bắt đầu timer
	}
	
	public ShootMusic getShootmusic() {
		return shootmusic;
	}

	public void setShootmusic(ShootMusic shootmusic) {
		this.shootmusic = shootmusic;
	}

	public NamePlayer getName1() {
		return name1;
	}

	public void setName1(NamePlayer name1) {
		this.name1 = name1;
	}

	public NamePlayer getName2() {
		return name2;
	}

	public void setName2(NamePlayer name2) {
		this.name2 = name2;
	}

	public boolean isPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}

	public Brick getBr() {
		return br;
	}

	public void setBr(Brick br) {
		this.br = br;
	}

	public void paint(Graphics g)
	{    		
		// play background
		g.setColor(Color.black);
		g.fillRect(0, 0, 650, 600);
		
		// right side background
		g.setColor(Color.DARK_GRAY);
		g.fillRect(660, 0, 140, 600);
		
		br.drawSolids(this, g);
			
		br.draw(this, g);
		
		if(play)
		{
			// draw player 1
			if(player1Listener.isPlayerup()) {
				player1Listener.setPlayer(new ImageIcon("image\\player1_tank_up.png"));
				name1.drawTank(g);
			}
			else if(player1Listener.isPlayerdown()) {
				player1Listener.setPlayer(new ImageIcon("image\\player1_tank_down.png"));
				name1.drawTank(g);
			}
			else if(player1Listener.isPlayerright()) {
				player1Listener.setPlayer(new ImageIcon("image\\player1_tank_right.png"));
				name1.drawTank(g);
			}
			else if(player1Listener.isPlayerleft()) {
				player1Listener.setPlayer(new ImageIcon("image\\player1_tank_left.png"));
				name1.drawTank(g);
			}
			player1Listener.getPlayer().paintIcon(this, g, player1Listener.getPlayerX(), player1Listener.getPlayerY());
			
			// draw player 2
			if(player2Listener.isPlayerup()) {
				player2Listener.setPlayer(new ImageIcon("image\\player2_tank_up.png"));
				name2.drawTank(g);
			}
			else if(player2Listener.isPlayerdown()) {
				player2Listener.setPlayer(new ImageIcon("image\\player2_tank_down.png"));
				name2.drawTank(g);
			}
			else if(player2Listener.isPlayerright()) {
				player2Listener.setPlayer(new ImageIcon("image\\player2_tank_right.png"));
				name2.drawTank(g);
			}
			else if(player2Listener.isPlayerleft()) {
				player2Listener.setPlayer(new ImageIcon("image\\player2_tank_left.png"));
				name2.drawTank(g);
			}
						
			player2Listener.getPlayer().paintIcon(this, g, player2Listener.getPlayerX(), player2Listener.getPlayerY());
			
			player1Listener.CheckBullet(player2Listener, g, Color.yellow);
			player2Listener.CheckBullet(player1Listener, g, Color.green);	
		}
	
		
		// the scores 		
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD, 20));
		g.drawString("Scores", 700,30);
		g.drawString("Player 1:  "+player1Listener.getPlayerscore(), 670,60);
		g.drawString("Player 2:  "+player1Listener.getPlayerscore(), 670,90);
		
		g.drawString("Lives", 700,150);
		g.drawString("Player 1:  "+player1Listener.getPlayerlives(), 670,180);
		g.drawString("Player 2:  "+player2Listener.getPlayerlives(), 670,210);
		
		if(player1Listener.getPlayerlives() == 0)
		{
			// Chỉ vẽ "Game Over" nếu biến blink là true
            if (blink) {
                g.setColor(Color.RED);
                g.setFont(new Font("serif", Font.BOLD, 90));
                g.drawString("End Game", 100, 300);
                g.drawString(name2.getS() + " Won", 150, 400);
            }
			play = false;
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD, 30));
			g.drawString("(Space to Restart)", 180,500);
		}
		else if(player2Listener.getPlayerlives() == 0)
		{
			if (blink) {
                g.setColor(Color.RED);
                g.setFont(new Font("serif", Font.BOLD, 90));
                g.drawString("Game Over", 100, 300);
                g.drawString(name1.getS() + " Won", 150, 400);
            }
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD, 30));
			g.drawString("(Space to Restart)", 180,500);
			play = false;
		}
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		repaint();
	}

	public void keyTyped(KeyEvent e) {	}
	public void keyReleased(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_SPACE && (player1Listener.getPlayerlives() == 0 || player2Listener.getPlayerlives() == 0))
		{
			br = new Brick();
			name1 = new NamePlayer(name1.getS(),200,540);
			name2 = new NamePlayer(name2.getS(),400,540);
			player2Listener = new Player2Listener(this,name2);
			player1Listener = new Player1Listener(this,name1);
			
			setFocusable(true); 
			addKeyListener(player1Listener);
			addKeyListener(player2Listener);
			addKeyListener(this);
			setFocusTraversalKeysEnabled(false);
			delay=8;
			play=true;
	        timer=new Timer(delay,this);
			timer.start();
			
			setPlay(true);
			repaint();
		}
	}
}