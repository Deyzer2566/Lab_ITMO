/*
	Лабораторная работа №1
	Вариант 367298

	Группа P3116 Козодой Андрей
*/
import java.lang.Math;
import java.util.Random;
public class Lab1{
	public static double func1(double x){
		return Math.pow(Math.pow((x+2.0/3.0)/2.0*(Math.pow(x/2.0,3.0)-1.0),3.0),1.0/3.0);
	}
	public static double func2(double x){
		return Math.asin(Math.pow((x+4.5)/15.0,2.0));
	}
	public static double func3(double x){
		return Math.tan(Math.tan(Math.pow(0.25/(1-x/0.5),Math.pow(x,x)) ));
	}
	private static int c[] = new int[7];
	private static double x[] = new double[13];
	private static double d[][] = new double[7][13];
	
	//заполнение массивов случайными числами
	private static void gen(){
		Random randomGen = new Random();
		for(int i=16;i>=4;i-=2)
			c[(i-4)/2]=i;
		for(int i = 0;i<13;i++)
			x[i]=Math.sin(randomGen.nextInt())*7.5+4.5;
	}
	
	//расчет значений d
	private static void compute(){
		for(int i = 0;i<7;i++){
			for(int j = 0;j<13;j++){
				if(c[i]==16)
					d[i][j]=func1(x[j]);
				else if(c[i]==4 || c[i]==8 || c[i]==14 )
					d[i][j]=func2(x[j]);
				else
					d[i][j]=func3(x[j]);
			}
		}
	}
	
	//вывод на экран значений матрицы
	private static void print(){
		for(int i = 0;i<7;i++){
			for(int j = 0;j<13;j++)
				System.out.format("%.5f ",d[i][j]);
			System.out.printf("\n");
		}
	}
	
	public static void main(String [] args){
		gen();
		compute();
		print();
	}
}