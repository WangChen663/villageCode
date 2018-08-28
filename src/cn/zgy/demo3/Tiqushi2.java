package cn.zgy.demo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tiqushi2 {
	public static void main(String[] args) {
		
		
		List<String> list = new ArrayList<>();
		//定义流对象
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null; 
		//定义写流对象
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			String str = "";//定义被读到的行
		    String str2 = "";//定义需要提取的行
		    //读取路径内的内容
		    fis = new FileInputStream("E:\\市.txt");
		    isr = new InputStreamReader(fis,"gbk");
		    br = new BufferedReader(isr);    
		    
		    //把提取的数据写入到路径内
		    fos = new FileOutputStream("E:\\市编码.txt");
		    osw = new OutputStreamWriter(fos,"gbk");
		    bw = new BufferedWriter(osw);    
		    
		    while ((str = br.readLine()) != null) {

		        	String[] split = str.split(",");
		        	String s = split[3].substring(1, 7);
		        	
		        		bw.write(split[0]+","+split[1]+","+s+"\r\n");

		    }
		    //打印提取的信息
		    System.out.println(str2);
		   } catch (FileNotFoundException e) {
		    System.out.println("找不到指定文件");
		   } catch (IOException e) {
		    System.out.println("读取文件失败");
		   }finally{
			   try {
			    	//关闭流
			    	br.close();
			    	isr.close();
			    	fis.close();
			    	bw.close();
			    	osw.close();
			    	fos.close();
			   }catch (IOException e){
				   e.printStackTrace();
			   }
		   }
	}
}
