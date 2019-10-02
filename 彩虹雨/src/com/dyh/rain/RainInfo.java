package com.dyh.rain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class RainInfo {
	public int x;
	public int y;
	public int speed;
	public Color color;
	public int rainDropNum;
	public int fontSize;
	public boolean isAlive;
	public ArrayList<RainDrop> rainDrops=new ArrayList<RainDrop>();
	public RainInfo(int x, int y, int speed, Color color, int rainDropNum,int fontSize) {
		super();
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.color = color;
		this.rainDropNum = rainDropNum;
		this.fontSize=fontSize;
		this.isAlive=true;
		
		createRainDrop();
	}
	
	//画出文字
	public void drawRain(Graphics g){
		g.setFont(new Font("宋体",0,fontSize));
		
		for (int i = 0; i <rainDrops.size(); i++) {
			tempDrop=rainDrops.get(i);
			g.setColor(tempDrop.color);
			g.drawString(tempDrop.value+"", tempDrop.x, tempDrop.y);
		}
		move();
	}
	
	//创建文字
	Random random=new Random();
	public int red=0;
	public int green=255;
	public int blue=0;
	public void createRainDrop(){
		RainDrop rainDrop;
		for (int i = 0; i <rainDropNum; i++) {
			//英文字符
			rainDrop=new RainDrop(x, y-=fontSize+2, (char)(random.nextInt(90)+33));
			rainDrop.color=new Color(red,green,blue);
			green-=8;
			if(i==0){
				rainDrop.color=new Color(0,210,255);
			}
			//中文汉字
			//rainDrop=new RainDrop(x, y-=fontSize+2, (char)(random.nextInt(20901)+19968));
			
			rainDrops.add(rainDrop);
		}
	}
	
	//文字移动
	RainDrop tempDrop;
	public void move(){
		for (int i = 0; i < rainDrops.size(); i++) {
			tempDrop=rainDrops.get(i);
			tempDrop.y+=speed;
			
			if(random.nextInt(10)==0){
				tempDrop.value=(char)(random.nextInt(90)+33);//英文字符
			}
		}
		if(rainDrops.get(rainDrops.size()-1).y>=Rain.HEIGHT){
			isAlive=false;
		}
	}
	
	
	
	/*
	 public void move(){
		for (int i = 0; i < rainDrops.size(); i++) {
			tempDrop=rainDrops.get(i);
			tempDrop.y+=speed;
			if(random.nextInt(10)==0){
				tempDrop.value=(char)(random.nextInt(20901)+19968);//中文汉字
			}
			
			//寻找存在的字
			if((tempDrop.value+"").equals('董'+"")&&tempDrop.y>=200&&tempDrop.y<=400){
				color=Color.RED;
				speed=0;
				System.out.println("找到了");
			}
			
		}
		if(rainDrops.get(rainDrops.size()-1).y>=Rain.HEIGHT){
			isAlive=false;
		}
	}
	*/
	
}
