package cn.gyw.zyn;

public class T2 {
	public static void main(String[] args) {
		//实例化Plane类
		Plane plane = new Plane();
		//实例化Bird类
		Bird bird = new Bird();
		
		makeFly(plane, bird);
	}
	static void makeFly(Plane p,Bird b){
		p.fly();
		b.fly();
	}
}
