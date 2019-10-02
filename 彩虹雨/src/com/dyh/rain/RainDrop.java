package com.dyh.rain;

import java.awt.Color;

public class RainDrop {
	public int x;
	public int y;
	public char value;
	public Color color;
	public RainDrop(int x, int y, char value) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
		//color=new Color(new Random().nextInt(255), new Random().nextInt(255),new Random().nextInt(255));	
	}
}
