package jp.ghdoremi.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import jp.ghdoremi.game.bean.Point;

public class GameTestMain {

	JFrame frame1;
	BufferStrategy bstrategy;
	int count = 0;
	Point myPoint = new Point(300,400);

	GameTestMain(){

	//フレーム
		frame1 = new JFrame("ゲームテスト");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBackground(Color.WHITE);
		frame1.setResizable(false);

	//画面サイズ
		frame1.setVisible(true);
		Insets insets = frame1.getInsets();
		frame1.setSize(600 + insets.left + insets.right, 400 + insets.top + insets.bottom);
		frame1.setLocationRelativeTo(null);

	//描画用
		frame1.setIgnoreRepaint(true);
		frame1.createBufferStrategy(2);
		bstrategy = frame1.getBufferStrategy();

	//キー利用
		frame1.addKeyListener(new MyKeyAdapter());

	//時間の処理
		Timer t = new Timer();
		t.schedule(new MyTimerTask(), 0, 100);
		//t.schedule(new MyTimerTask(), 10, 1000);

		//GameTestUtil.printInsetsSize(frame1);


	}

	class MyTimerTask extends TimerTask{

		@Override
		public void run() {
			Graphics g = bstrategy.getDrawGraphics();

			//BufferStrategyが利用可能ならfalse
			if(bstrategy.contentsLost() == false){

				//画面のタイトルバーなどの枠の分だけ位置を調整
				Insets insets = frame1.getInsets();
				g.translate(insets.left, insets.right);

				System.out.println(myPoint.getX());

				g.setColor(Color.BLUE);
				g.fillRect(myPoint.getX() -5, myPoint.getY() -5, 10,10);
				//g.drawPolygon(new int[]{0,100,300}, new int[]{300,200,400}, 3);
				bstrategy.show();
				//Graphic機能は使い終わったらすぐOSに返却する必要がある。
				g.dispose();
			}
		}

	}

	class MyKeyAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent ev){
			if(ev.getKeyCode() == KeyEvent.VK_RIGHT){
				myPoint.setX(myPoint.getX()+1);

			}
			if(ev.getKeyCode() == KeyEvent.VK_LEFT){
				myPoint.setX(myPoint.getX()-1);
			}
		}
		public void keyReleased(KeyEvent ev){
			if(ev.getKeyCode() == KeyEvent.VK_SPACE){
				System.out.println("離された");
			}
		}
	}

	public static void main(String[] args){

		GameTestMain gtm = new GameTestMain();

	}

}
