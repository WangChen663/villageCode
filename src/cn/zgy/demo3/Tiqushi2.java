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
		//����������
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null; 
		//����д������
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			String str = "";//���屻��������
		    String str2 = "";//������Ҫ��ȡ����
		    //��ȡ·���ڵ�����
		    fis = new FileInputStream("E:\\��.txt");
		    isr = new InputStreamReader(fis,"gbk");
		    br = new BufferedReader(isr);    
		    
		    //����ȡ������д�뵽·����
		    fos = new FileOutputStream("E:\\�б���.txt");
		    osw = new OutputStreamWriter(fos,"gbk");
		    bw = new BufferedWriter(osw);    
		    
		    while ((str = br.readLine()) != null) {

		        	String[] split = str.split(",");
		        	String s = split[3].substring(1, 7);
		        	
		        		bw.write(split[0]+","+split[1]+","+s+"\r\n");

		    }
		    //��ӡ��ȡ����Ϣ
		    System.out.println(str2);
		   } catch (FileNotFoundException e) {
		    System.out.println("�Ҳ���ָ���ļ�");
		   } catch (IOException e) {
		    System.out.println("��ȡ�ļ�ʧ��");
		   }finally{
			   try {
			    	//�ر���
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
