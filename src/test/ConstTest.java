package test;

import util.Const;

public class ConstTest {

	public static void main(String[] args) {
		Const.state[46][1] = "糠山県";
		printAll();
	}
	
	public static void printAll() {
		for (int i = 0; i < Const.state.length; i++) {
			for (int j = 0; j < Const.state[i].length; j++) {
				System.out.print(Const.state[i][j]);
				if (j != Const.state[i].length - 1) {
					System.out.print(":");
				}
				if (j == Const.state[i].length - 1) {
					System.out.println("");
				}
			}
		}
	}

}
