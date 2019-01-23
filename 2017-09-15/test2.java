import java.util.Scanner;
public class Demo {

	static String a[] = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖","拾"};
	static String b[] = {"元","拾","佰","仟","万","拾","佰","仟","亿","拾","佰","仟"};
	static String c[] = new String[20];
	static String d[] = new String[20];
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("请输入一个数：");
			Scanner in  = new Scanner(System.in);
			double inNum = in.nextDouble();
		    int small_num = (int)(inNum*100%100);//取扩大100倍后的小数部分
			
			if(isInteger(inNum)) {//输入的数为整数的情况
				Transform(inNum);
				
				Show();
				
				if(inNum%10==0)
					System.out.println("元整");	
					else
						System.out.println("整");
				c = null;
				c = new String[20];
			}

			if(!isInteger(inNum)) {//输入的数为小数的情况
				Transform(inNum);
				
				Show();
				
				System.out.print(a[small_num/10]+"毛"+a[small_num%10]+"分");
			}		
		}
	}

	
public static boolean isInteger(double num) {//判断所输入的数是否为整数
	double a = (int)num;
	if((num-a)!=0) 
		return false;
	else 
		return true;
}
	
public static void Transform(double num) {//转化为中文模式

	int acount=0;
	int m=0;
	int ma=0;//数组a的元素角标
	int mb=0;//数组b的元素角标
	int mc=0;//数组c的元素角标
	
	while(num>10) {
		m = (int)num%10;
		if(m==0&&acount==0) {
			//c[mc++] = a[m];
			mb++;
		}

		if(m!=0) {
			acount++;
			c[mc] = b[mb];
			mc++;mb++;
			c[mc++] = a[m];
		}
		num = num/10;
	}//跳出循环存入第一个数字
	m = (int)num%10;
	c[mc++] = b[mb++];
	c[mc] = a[m];
	
}


public static void Show() {//输出函数
	int s = 0;
	while(c[s]!=null) {
		s++;
	}
	s--;
	while(s>=0) {//倒序输出String c[]中的内容
		System.out.print(c[s]);
		s--;
	}
}

}
