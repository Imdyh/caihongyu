package com.dyh.rain;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

public class Rain extends Frame{
	private static final long serialVersionUID = 1L;
	public static final int WIDTH=1920;
	public static final int HEIGHT=1080;
	
	public static ArrayList<RainInfo> rainInfos = new ArrayList<RainInfo>();
	
	public Rain(){
		this.setSize(WIDTH,HEIGHT);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.BLACK);
		this.addWindowListener(new CloseWindow());
		this.setTitle("彩虹雨.DYh-11.03.19");
		new MyThread().start();
	}
	
	class MyThread extends Thread{
		@Override
		public void run() {
			while (true) {
				try {
					repaint();
					sleep(41);
				} catch (Exception e) {
					
				}
			}
		}
	}
	
	//双重缓冲消除闪烁
	Image bufferImage=null; 
	Graphics GraImage = null;
	@Override
	public void update(Graphics g) {
		//如果有背景图片就需要判断bufferImage是否为空
		//if(bufferImage==null)
	    bufferImage = createImage(this.getWidth(), this.getHeight());   //创建图形缓冲区  
	    GraImage = bufferImage.getGraphics();       //获取图形缓冲区的图形上下文  
	    paint(GraImage);        //用paint方法中编写的绘图过程对图形缓冲区绘图  
	    GraImage.dispose();     //释放图形上下文资源  
	    g.drawImage(bufferImage, 0, 0, this);   //将图形缓冲区绘制到屏幕上 
	}
	
	@Override
	public void paint(Graphics g) {
		run(g);
	}
	
	RainInfo tempInfo;
	Random random=new Random();
	public void run(Graphics g){
		if(rainInfos.size()<WIDTH/50){
			tempInfo=new RainInfo(random.nextInt(WIDTH), 0, random.nextInt(5)+5,Color.GREEN, random.nextInt(20)+10, random.nextInt(30)+10);
			rainInfos.add(tempInfo);
		}
		for (int i = 0; i < rainInfos.size(); i++) {
			tempInfo=rainInfos.get(i);
			tempInfo.drawRain(g);
			if(tempInfo.isAlive==false){
				rainInfos.remove(tempInfo);
			}
		}
	}
	
	
}
