package Name;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class NamePlayer {
	private int x;
	private int y;
	private String s;
	
	public NamePlayer(String s, int x, int y) {
		this.s = s;
		this.x=x;
		this.y=y;
	}
	
	public NamePlayer(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
	public void drawTank(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD, 20));
		g.drawString(getS(), getX(), getY());
	}
}
