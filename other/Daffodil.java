
public class Daffodil {
	public static void main(String[] args) {
		int a1,a2,a3;
		for (int i = 100; i < 999; i++) {
			a1 = i/100;
			a2 = i/10%10;
			a3 = i%10;
			if (Math.pow(a1, 3) + Math.pow(a2, 3) + Math.pow(a3, 3) == i) {
				System.out.println("水仙花数为= " + i);
			}
		}
	}
}
