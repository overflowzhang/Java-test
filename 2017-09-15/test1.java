public class Demo {

	public static void main(String[] args) {
		int Num = (int)(Math.random()*100+1);//生成100以内的随机数
		System.out.println("随机数Num已生成！");
		System.out.println("请输入你的猜想N：");
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		while(N!=Num) {//循环输入直到猜对为止
			if(N>Num)
				System.out.println("你猜的大了！");
			else
				System.out.println("你猜的小了！");
			in = new Scanner(System.in);
			N = in.nextInt();
		}
		System.out.println("恭喜你！终于猜对了！");
		
	}
}
