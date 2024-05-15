package Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

import Game.Gameplay;
import Name.NamePlayer;

public class Player2Listener extends Player implements KeyListener
{
	public Player2Listener(Gameplay gamePlay, NamePlayer Name2) {
		setPlayer(new ImageIcon("image\\player2_tank_up.png"));
		setGamePlay(gamePlay);	
		setPlayerX(400);
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
		setName(Name2);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_M)
		{
			TankShoot();
			
		}
		if(e.getKeyCode()== KeyEvent.VK_UP)
		{
			TankUp();

		}
		if(e.getKeyCode()== KeyEvent.VK_LEFT)
		{
			TankLeft();
		}
		if(e.getKeyCode()== KeyEvent.VK_DOWN)
		{
			TankDown();
		}
		if(e.getKeyCode()== KeyEvent.VK_RIGHT)
		{
			TankRight();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
