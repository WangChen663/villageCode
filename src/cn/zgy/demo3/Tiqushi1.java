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

public class Tiqushi1 {
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
		    fis = new FileInputStream("E:\\City30.txt");
		    isr = new InputStreamReader(fis,"utf-8");
		    br = new BufferedReader(isr);    
		    
		    //����ȡ������д�뵽·����
		    fos = new FileOutputStream("E:\\��.txt");
		    osw = new OutputStreamWriter(fos);
		    bw = new BufferedWriter(osw);    
		    
		    while ((str = br.readLine()) != null) {

		        	String[] split = str.split(",");
		        	int i = split.length;
		        	if(i==4){
		        		bw.write(str+"\r\n");
		        	}
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
