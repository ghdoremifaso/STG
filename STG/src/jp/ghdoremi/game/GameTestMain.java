package jp.ghdoremi.game;

import javax.swing.JFrame;

public class GameTestMain {

	JFrame frame1;

	GameTestMain(){
		frame1 = new JFrame("ゲームテスト");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setSize(600, 400);
		frame1.setVisible(true);

		GameTestUtil.printInsetsSize(frame1);
	}

	public static void main(String[] args){

		GameTestMain gtm = new GameTestMain();

	}

}
