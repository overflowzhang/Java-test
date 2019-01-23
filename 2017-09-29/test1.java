import java.util.Scanner;

class Score{
	int Zi;
	int Mu;
	Score(int z,int m) {
		Zi = z;
		Mu = m;
	}
}

public class Report2_1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请分别输入两分数的分子和分母:");
		int A1=sc.nextInt();
		int A2=sc.nextInt();
		
		Score A;
		A = new Score(A1, A2);
		
		int B1=sc.nextInt();
		int B2=sc.nextInt();

		Score B;
		B = new Score(B1,B2);
		System.out.println("请输入运算符:");
		String s=sc.next();
		char ch=s.charAt(0);                              //获取输入的字符
		
		Score C=Operation(A,ch,B);                        //两分数进行四则运算
		int g = gcd(C.Zi, C.Mu);                          //辗转相除求最大公约数
		Simpfy(C,g);                                      //化简并输出
		
	}
	
	
	public static Score Operation(Score A,char ch,Score B) {//将两分数进行四则运算
		Score C;
		C=new Score(0, 0);
		switch(ch) {
		case '+':
			C.Zi=A.Zi*B.Mu+A.Mu*B.Zi;
			C.Mu=A.Mu*B.Mu;
			break;
		case '-':
			C.Zi=A.Zi*B.Mu-B.Zi*A.Mu;
			C.Mu=A.Mu*B.Mu;
			break;
		case '*':
			C.Zi=A.Zi*B.Zi;
			C.Mu=A.Mu*B.Mu;
			break;
		case '/':
			C.Zi=A.Zi*B.Mu;
			C.Mu=A.Mu*B.Zi;
			break;
		}
		return C;
	}
	
	
	public static void Simpfy(Score C,int g) {//化简并输出结果
		int Z = C.Zi/g;
		int M = C.Mu/g;
		System.out.println("结果为: "+Z+'/'+M);
	}
	
	public static int gcd(int a,int b) {//辗转相除求最大公约数
		int g=0;
		while(b!=0) {
			int temp = a%b;
			a=b;
			b=temp;
		}
		return a;
	}
}
