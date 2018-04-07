package jp.ghdoremi.game;

import java.awt.Insets;

import javax.swing.JFrame;

public class GameTestUtil {

	private GameTestUtil(){}

	public static void printInsetsSize(JFrame frame){
		Insets insets = frame.getInsets();
		System.out.println("上枠=" + insets.top);
		System.out.println("下枠=" + insets.bottom);
		System.out.println("左枠=" + insets.left);
		System.out.println("右枠=" + insets.right);
	}

}
