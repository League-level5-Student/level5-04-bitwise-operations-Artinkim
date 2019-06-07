package Peter;

public class Runner {
	public static void main(String[] args) {
		a origin = new a(1);
		c sub = new c(origin);
		origin.x +=2;
		sub.run();
		System.out.println(origin.x+" "+sub.top.x);
	}
}
