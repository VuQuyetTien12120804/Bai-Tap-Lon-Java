package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Game.Gameplay;
import Name.NamePlayer;

public class Player {
	private PlayerBullet playerBullet;
	private ImageIcon player;	
	private int playerX;
	private int playerY;	
	private boolean playerright;
	private boolean playerleft;
	private boolean playerdown;
	private boolean playerup;	
	private int playerscore; 
	private int playerlives;
	private boolean playerShoot;
	private String bulletShootDir;
	private Gameplay gamePlay;
	private NamePlayer name;
	
	public NamePlayer getName() {
		return name;
	}
	public void setName(NamePlayer name) {
		this.name = name;
	}
	public Gameplay getGamePlay() {
		return gamePlay;
	}
	public void setGamePlay(Gameplay gamePlay) {
		this.gamePlay = gamePlay;
	}
	public PlayerBullet getPlayerBullet() {
		return playerBullet;
	}
	public void setPlayerBullet(PlayerBullet bullet) {
		this.playerBullet = bullet;
	}
	public ImageIcon getPlayer() {
		return player;
	}
	public void setPlayer(ImageIcon player) {
		this.player = player;
	}
	public int getPlayerX() {
		return playerX;
	}
	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}
	public int getPlayerY() {
		return playerY;
	}
	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}
	public boolean isPlayerright() {
		return playerright;
	}
	public void setPlayerright(boolean playerright) {
		this.playerright = playerright;
	}
	public boolean isPlayerleft() {
		return playerleft;
	}
	public void setPlayerleft(boolean playerleft) {
		this.playerleft = playerleft;
	}
	public boolean isPlayerdown() {
		return playerdown;
	}
	public void setPlayerdown(boolean playerdown) {
		this.playerdown = playerdown;
	}
	public boolean isPlayerup() {
		return playerup;
	}
	public void setPlayerup(boolean playerup) {
		this.playerup = playerup;
	}
	public int getPlayerscore() {
		return playerscore;
	}
	public void setPlayerscore(int playerscore) {
		this.playerscore = playerscore;
	}
	public int getPlayerlives() {
		return playerlives;
	}
	public void setPlayerlives(int playerlives) {
		this.playerlives = playerlives;
	}
	public boolean isPlayerShoot() {
		return playerShoot;
	}
	public void setPlayerShoot(boolean playerShoot) {
		this.playerShoot = playerShoot;
	}
	public String getBulletShootDir() {
		return bulletShootDir;
	}
	public void setBulletShootDir(String bulletShootDir) {
		this.bulletShootDir = bulletShootDir;
	}
	
	public void TankShoot() {
		if(!isPlayerShoot())
		{
			if(isPlayerup())
			{					
				setPlayerBullet(new PlayerBullet(getPlayerX() + 20, getPlayerY()));
			}
			else if(isPlayerdown())
			{					
				setPlayerBullet(new PlayerBullet(getPlayerX() + 20, getPlayerY() + 40));
			}
			else if(isPlayerright())
			{				
				setPlayerBullet(new PlayerBullet(getPlayerX() + 40, getPlayerY() + 20));
			}
			else if(isPlayerleft())
			{			
				setPlayerBullet(new PlayerBullet(getPlayerX(), getPlayerY() + 20));
			}
			
			setPlayerShoot(true);
			gamePlay.getShootmusic().playSound();	
		}
	}
	
	public void TankUp() {
		setPlayerright(false);
		setPlayerleft(false);
		setPlayerdown(false);
		setPlayerup(true);		
		
		if (!(gamePlay.getBr().checkTankCollision(getPlayerX(), getPlayerY() - 10) || gamePlay.getBr().checkTankSolidCollision(getPlayerX(), getPlayerY() - 10)) && !(getPlayerY() < 10)){
			setPlayerY(getPlayerY()-10);
            name.setY(name.getY()-10);
        }
	}
	
	public void TankLeft() {
		setPlayerright(false);
		setPlayerleft(true);
		setPlayerdown(false);
		setPlayerup(false);
		
		if (!(gamePlay.getBr().checkTankCollision(getPlayerX()-10, getPlayerY()) || gamePlay.getBr().checkTankSolidCollision(getPlayerX()-10, getPlayerY())) && !(getPlayerX() < 10)) {
            setPlayerX(getPlayerX()-10);
            name.setX(name.getX()-10);
        }
	}
	
	public void TankDown() {
		setPlayerright(false);
		setPlayerleft(false);
		setPlayerdown(true);
		setPlayerup(false);
		
		if (!(gamePlay.getBr().checkTankCollision(getPlayerX(), getPlayerY() + 10) || gamePlay.getBr().checkTankSolidCollision(getPlayerX(), getPlayerY() + 10)) && !(getPlayerY() > 540)) {
			setPlayerY(getPlayerY()+10);
			name.setY(name.getY()+10);
        }
	}
	
	public void TankRight() {
		setPlayerright(true);
		setPlayerleft(false);
		setPlayerdown(false);
		setPlayerup(false);
		
		if (!(gamePlay.getBr().checkTankCollision(getPlayerX()+10, getPlayerY()) || gamePlay.getBr().checkTankSolidCollision(getPlayerX()+10, getPlayerY())) && !(getPlayerX() > 590)){
			setPlayerX(getPlayerX()+10);
			name.setX(name.getX()+10);
        }
	}
	
	public void CheckBullet(Player other, Graphics g, Color a) {
		if(getPlayerBullet() != null && isPlayerShoot())
		{
			if(getBulletShootDir().equals(""))
			{
				if(isPlayerup())
				{					
					setBulletShootDir("up");
				}
				else if(isPlayerdown())
				{					
					setBulletShootDir("down");
				}
				else if(isPlayerright())
				{				
					setBulletShootDir("right");
				}
				else if(isPlayerleft())
				{			
					setBulletShootDir("left");
				}
			}
			else
			{
				getPlayerBullet().move(getBulletShootDir());
				getPlayerBullet().draw(g, a);
			}
			
			
			if(new Rectangle(getPlayerBullet().getX(), getPlayerBullet().getY(), 10, 10)
			.intersects(new Rectangle(other.getPlayerX(), other.getPlayerY(), 50, 50)))
			{
				setPlayerscore(getPlayerscore()+10);
				other.setPlayerlives(other.getPlayerlives()-1);
				setPlayerBullet(null);
				setPlayerShoot(false);
				setBulletShootDir("");
			}
			
			if(gamePlay.getBr().checkCollision(getPlayerBullet().getX(), getPlayerBullet().getY())
					|| gamePlay.getBr().checkSolidCollision(getPlayerBullet().getX(), getPlayerBullet().getY()))
			{
				setPlayerBullet(null);
				setPlayerShoot(false);
				setBulletShootDir("");				
			}

			if(getPlayerBullet().getY() < 1 
					|| getPlayerBullet().getY() > 580
					|| getPlayerBullet().getX() < 1
					|| getPlayerBullet().getX() > 630)
			{
				setPlayerBullet(null);
				setPlayerShoot(false);
				setBulletShootDir("");
			}
		}
	}
	
}
