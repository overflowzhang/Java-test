public class Reprot2_2 {

	public static void main(String[] args) {
		int[]a = {5,9,8,7,6,3,4,1,2,10};
		System.out.print("数组：");
		Average F = new First();
		Average S = new Second();
		F.Aver(a);
		S.Aver(a);
	}
}

interface Average{
	public void Aver(int a[]);          //若是静态方法 必须要有实现
}

class First implements Average{
	int sum=0;
	int c=0;
	public void Aver(int a[]) {
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
			c++;
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.println("数组的平均值 (一)："+sum/c);
	}
}

class Second implements Average{
	int sum=0;
	int c=0;
	int min;
	int max;
	public void Aver(int a[]) {     //所有元素之和
		for(int i=0;i<a.length;i++) {
			min=a[0];
			max=a[0];
			if(min>a[i])
				min=a[i];             //数组最小值
			if(max<a[i])
				max=a[i];            //数组最大值
			sum+=a[i];
			c++;
		}
		
		System.out.println("数组的平均值（二）："+sum/(c-2));
	}
}
