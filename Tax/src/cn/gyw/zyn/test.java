package cn.gyw.zyn;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Random;

public class test {
	public static void main(String args[]) throws IOException{
/*		取100个随机数，写出到本地文件中，加序号，每写一个换行一次。
		第1-50次:随机产生[0.0-1.0)double数，
		第51-100次：产生[15-50]的整数*/
		FileOutputStream fos=null;
		PrintStream ps=null;
		
		for(int i=0;i<100;i++){
			if(i>50){
				int random = (int) (35*Math.random()+15);
				fos=new FileOutputStream("D://a.txt",true); 
				ps=new PrintStream(fos); 
				ps.print(i);
				ps.print(':');
				ps.println(random);
				fos.close();
				ps.close();
				System.out.println(random);
			}else{
				double random = Math.random();
				fos=new FileOutputStream("D://a.txt",true); 
				ps=new PrintStream(fos); 
				ps.print(i);
				ps.print(':');
				ps.println(random);
				fos.close();
				ps.close();
				System.out.println(random);
			}
		}
	}
	static void write(int a,int b) throws IOException{


	}
}
