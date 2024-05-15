package Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

import Game.Gameplay;
import Name.NamePlayer;

public class Player1Listener extends Player implements KeyListener
{	
	public Player1Listener(Gameplay gamePlay, NamePlayer name1) {
		setGamePlay(gamePlay);
		setPlayer(new ImageIcon("image\\player1_tank_up.png"));	
		setPlayerX(200);
		setPlayerY(550);		
		setPlayerright(false);
		setPlayerleft(false);
		setPlayerdown(false);
		setPlayerup(true);
		setPlayerscore(0);
		setPlayerlives(5);
		setPlayerShoot(false);
		setBulletShootDir("");
		setPlayerBullet(null);
		setName(name1);
	}

	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}		
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_U)
		{
			TankShoot();
		}
		if(e.getKeyCode()== KeyEvent.VK_W)
		{
			TankUp();
		}
		if(e.getKeyCode()== KeyEvent.VK_A)
		{
			TankLeft();
		}
		if(e.getKeyCode()== KeyEvent.VK_S)
		{
			TankDown();
		}
		if(e.getKeyCode()== KeyEvent.VK_D)
		{
			TankRight();
		}
	}
}
