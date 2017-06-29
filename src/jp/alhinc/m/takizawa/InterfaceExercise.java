package jp.alhinc.m.takizawa;


//インターフェースで宣言したメソッドは、暗黙的にpublic abstract修飾子。
interface HasGetAreaMethod {
	double getArea(); //面積をかえす
}

//親クラス（インスタンスつくらないと思うから、逆に使えなくするabstract）
abstract class Shape {
	abstract void draw();
}

//子クラス１ interfaceを実装
class Rectangle extends Shape implements HasGetAreaMethod {
	void draw() {
		System.out.println("□");
	}
	//暗黙的にpublic abstractなので、
	public double getArea() {
		System.out.println("CircleクラスのgetAreaメソッドが呼び出されました");
		return 1.0;
	}
}

//子クラス２ interfaceを実装
class Circle extends Shape implements HasGetAreaMethod {
	void draw() {
		System.out.println("○");
	}
	public double getArea() {
		System.out.println("CircleクラスのgetAreaメソッドが呼び出されました");
		return 1.0;
	}
}

//子クラス３
class Polyline extends Shape {
	//インターフェースを実装していないので、面積は返せない
	void draw() {
		System.out.println("N");
	}
}

//子クラス３の子（孫クラス） interfaceを実装
class Polygon extends Polyline implements HasGetAreaMethod {
	void draw() {
		System.out.println("凸");
	}
	//poly
	public double getArea() {
		System.out.println("PolygonクラスのgetAreaメソッドが呼び出されました");
		return 1.0;
	}
}

public class InterfaceExercise {
	public static void main(String[] args) {
		HasGetAreaMethod[] closedShapes = new HasGetAreaMethod[3];
		closedShapes[0] = new Polygon();
		closedShapes[1] = new Rectangle();
		closedShapes[2] = new Circle();

		for(int i = 0; i < 3; i++ ) {
			closedShapes[i].getArea();
		}

	}

}



//インターフェースで変数を宣言した場合、
//その修飾子は、public static final（つまり、定数）がつく
//interface MoveDirection {
//	int UP = 0;
//	int DOWN = 1;
//	int LEFT = 2;
//	int RIGHT = 3;
//}
//
//System.out.println(MoveDirection.UP);
//
//void move(int direction) {
//	switch(direction) {
//	case MoveDirection.UP;
//	//上に移動する処理
//	break;
//	case MoveDirection.DOWN;
//	//下に移動する処理
//	break;
//	case MoveDirection.LEFT;
//	//左に移動する処理
//	break;
//	case MoveDirection.RIGHT;
//	//右に移動する処理
//	break;
//	}
//}
