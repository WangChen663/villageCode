package cn.zgy.demo3;


import java.io.BufferedWriter;         
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class NewJousp1 {
	
	 	private static Map<Integer, String> cssMap = new HashMap<Integer, String>();
	    private static BufferedWriter bufferedWriter = null;
	 
	     static
	     {
	         cssMap.put(1, "provincetr");
	         cssMap.put(2, "citytr");
	         cssMap.put(3, "countytr");
	         cssMap.put(4, "towntr");
	         cssMap.put(5, "villagetr");
	     }
	 
	     public static void main(String[] args) throws IOException{
	          int level = 1;
	 
	          initFile();
	          Document connect = connect("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2016/index.html");
	          Elements rowProvince = connect.select("tr." + cssMap.get(level));
	          Element element2 = rowProvince.get(2);
	          //for (Element provinceElement : rowProvince){
	             //Elements select = provinceElement.select("a");
	          Elements select = element2.select("a");
	             Element province = select.get(2);
	             //for (Element province : select){
	                 parseNextLevel(province, level);
	             //}
	          //}
	          closeStream();
	      }
	  
	    
	      //省
	      private static void parseNextLevel(Element parentElement, int level) throws IOException{
	    	  try{
	             Thread.sleep(1);
	    	  } catch (InterruptedException e){
	              e.printStackTrace();
	    	  }
		               printInfo(parentElement, level);
		               parseNextLevel(parentElement,parentElement, level+1);
	      }
	      private static void parseNextLevel(Element epr,Element parentElement, int level) throws IOException{
	    	  try{
	    		  Thread.sleep(1);
	    	  } catch (InterruptedException e){
	    		  e.printStackTrace();
	    	  }
	    	  
	    	  Document doc = connect(parentElement.attr("abs:href"));
	    	  if (doc != null){
	    		  Elements newsHeadlines = doc.select("tr." + cssMap.get(level));//
	    		 // for (Element element : newsHeadlines){
	    		  Element element = newsHeadlines.get(17);
	    			  printInfo(epr,element, level + 1);
	    			  Elements select = element.select("a");
	    			  if (select.size() != 0){
	    				  parseNextLevel(epr,element,select.last(), level + 1);
	    			  }
	    		 // }
	    	  }
	      }
	      private static void parseNextLevel(Element epr,Element eci,Element parentElement, int level) throws IOException{
	    	  try{
	    		  Thread.sleep(1);//閻繝鏁撻弬銈嗗
	    	  } catch (InterruptedException e){
	    		  e.printStackTrace();
	    	  }
	    	  
	    	  Document doc = connect(parentElement.attr("abs:href"));
	    	  if (doc != null){
	    		  //Elements newsHeadlines = doc.select("tr." + cssMap.get(++level));
	    		  Elements newsHeadlines = doc.select("tr." + cssMap.get(level));
	    		  // 闁跨喐鏋婚幏宄板絿闁跨喐鏋婚幏鐑芥晸閺傘倖瀚规稉锟芥晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻敓锟�	    		  
	    		  for (Element element : newsHeadlines){
	    			  printInfo(epr,eci,element, level + 1);
	    			  Elements select = element.select("a");// 闁跨喕濡柅鎺旀閹风兘鏁撻弬銈嗗閻滎偊鏁撶紒鐐村敾閹风兘鏁撻敓浠嬫晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻弬銈嗗闁跨喎褰ㄧ拋瑙勫闁跨喕顫楅崙銈嗗闁跨喕顫楁潏鐐娑擄拷鏁撻弬銈嗗闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐕傛嫹闁跨喐鏋婚幏铚傜闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻惌顐＄串閹风兘鏁撶徊姗�鏁撻弬銈嗗缁涳拷
	    			  if (select.size() != 0){
	    				  parseNextLevel(epr,eci,element,select.last(), level + 1);
	    			  }
	    		  }
	    	  }
	      }
	      //闁跨喐鏋婚幏宄板祪闁跨喐鏋婚幏鐑芥晸閺傘倖瀚�
	      private static void parseNextLevel(Element epr,Element eci,Element eco,Element parentElement, int level) throws IOException{
	    	  try{
	    		  Thread.sleep(1);//閻繝鏁撻弬銈嗗
	    	  } catch (InterruptedException e){
	    		  e.printStackTrace();
	    	  }
	    	  
	    	  Document doc = connect(parentElement.attr("abs:href"));
	    	  if (doc != null){
	    		  Elements newsHeadlines = doc.select("tr." + cssMap.get(level));//
	    		  // 闁跨喐鏋婚幏宄板絿闁跨喐鏋婚幏鐑芥晸閺傘倖瀚规稉锟芥晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻敓锟�	    		  
	    		  for (Element element : newsHeadlines){
	    			  printInfo(epr,eci,eco,element, level + 1);
	    			  Elements select = element.select("a");// 闁跨喕濡柅鎺旀閹风兘鏁撻弬銈嗗閻滎偊鏁撶紒鐐村敾閹风兘鏁撻敓浠嬫晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻弬銈嗗闁跨喎褰ㄧ拋瑙勫闁跨喕顫楅崙銈嗗闁跨喕顫楁潏鐐娑擄拷鏁撻弬銈嗗闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐕傛嫹闁跨喐鏋婚幏铚傜闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻惌顐＄串閹风兘鏁撶徊姗�鏁撻弬銈嗗缁涳拷
	    			  if (select.size() != 0){
	    				  parseNextLevel(epr,eci,eco,element,select.last(), level + 1);
	    			  }
	    		  }
	    	  }
	      }
	      //闁跨喐鏋婚幏宄板祪闁跨喐鏋婚幏鐑芥晸閺傘倖瀚�
	      private static void parseNextLevel(Element epr,Element eci,Element eco,Element eto,Element parentElement, int level) throws IOException{
	    	  try{
	    		  Thread.sleep(1);//閻繝鏁撻弬銈嗗
	    	  } catch (InterruptedException e){
	    		  e.printStackTrace();
	    	  }
	    	  
	    	  Document doc = connect(parentElement.attr("abs:href"));
	    	  if (doc != null){
	    		  Elements newsHeadlines = doc.select("tr." + cssMap.get(level));//
	    		  // 闁跨喐鏋婚幏宄板絿闁跨喐鏋婚幏鐑芥晸閺傘倖瀚规稉锟芥晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻敓锟�	    		  
	    		  for (Element element : newsHeadlines){
	    			  printInfo(epr,eci,eco,eto,element, level + 1);
	    			  Elements select = element.select("a");// 闁跨喕濡柅鎺旀閹风兘鏁撻弬銈嗗閻滎偊鏁撶紒鐐村敾閹风兘鏁撻敓浠嬫晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻弬銈嗗闁跨喎褰ㄧ拋瑙勫闁跨喕顫楅崙銈嗗闁跨喕顫楁潏鐐娑擄拷鏁撻弬銈嗗闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐕傛嫹闁跨喐鏋婚幏铚傜闁跨喐鏋婚幏鐑芥晸閺傘倖瀚归柨鐔告灮閹风兘鏁撻惌顐＄串閹风兘鏁撶徊姗�鏁撻弬銈嗗缁涳拷
	    			  if (select.size() != 0){
	    				  parseNextLevel(epr,eci,eco,eto,select.last(), level + 1);
	    			  }
	    		  }
	    	  }
	      }
	     /**
	      * 閸愭瑤绔撮柨鐔告灮閹风兘鏁撻弬銈嗗閼炬悂鏁撻弬銈嗗闁跨喐鏋婚幏鐑芥晸娓氥儳銆嬮幏鐑芥晸閺傘倖瀚归崢锟�
	      * @param element 闁跨喐鏋婚幏鐑芥晸閼恒儱鍩岄柨鐔告灮閹风兘鏁撻弬銈嗗闁跨喓娈曢搴㈠妤濊尙绮堥敓锟�	     * @param level 闁跨喐鏋婚幏鐑芥晸閸欘偆銆嬮幏鐑芥晸閺傘倖瀚�
	     */
	      //閻拷
	     private static void printInfo(Element element, int level){
	         try{
	             bufferedWriter.write(element.select("a").text());
	             bufferedWriter.newLine();
	            bufferedWriter.flush();
	         } catch (IOException e){
	             e.printStackTrace();
	         }
	     }
	     //闁跨喐鏋婚幏锟�
	     private static void printInfo(Element epr,Element element, int level){
	    	 try{
	    		 bufferedWriter.write(epr.select("a").text()+","+
	    				 element.select("td").last().text()+","
	    				 + "{" + level + "}"+","+"["
	    				 +element.select("td").first().text() + "]");
	    		 bufferedWriter.newLine();
	    		 bufferedWriter.flush();
	    	 } catch (IOException e){
	    		 e.printStackTrace();
	    	 }
	     }
	     //闁跨喐鏋婚幏锟�
	     private static void printInfo(Element epr,Element eci,Element element, int level){
	    	 try{
	    		 bufferedWriter.write(epr.select("a").text()+","+
	    				 eci.select("td").last().text()+","
	    				 +element.select("td").last().text()+","
	    				 + "{" + level + "}"+","+"["
	    				 +element.select("td").first().text() + "]");
	    		 bufferedWriter.newLine();
	    		 bufferedWriter.flush();
	    	 } catch (IOException e){
	    		 e.printStackTrace();
	    	 }
	     }
	     //闁跨喐鏋婚幏锟�
	     private static void printInfo(Element epr,Element eci,Element eco,Element element, int level){
	    	 try{
	    		 bufferedWriter.write(epr.select("a").text()+","+
	    				 eci.select("td").last().text()+","
	    				 +eco.select("td").last().text()+","
	    				 +element.select("td").last().text()+","
	    				 + "{" + level + "}"+","+"["
	    				 +element.select("td").first().text() + "]");
	    		 bufferedWriter.newLine();
	    		 bufferedWriter.flush();
	    	 } catch (IOException e){
	    		 e.printStackTrace();
	    	 }
	     }
	     //闁跨喐鏋婚幏锟�
	     private static void printInfo(Element epr,Element eci,Element eco,Element eto,Element element, int level){
	    	 try{
	    		 bufferedWriter.write(epr.select("a").text()+","+
	    				 eci.select("td").last().text()+","
	    				 +eco.select("td").last().text()+","
	    				 +eto.select("td").last().text()+","
	    				 +element.select("td").last().text()+","
	    				 + "{" + level + "}"+","+"["
	    				 +element.select("td").first().text() + "]");
	    		 bufferedWriter.newLine();
	    		 bufferedWriter.flush();
	    	 } catch (IOException e){
	    		 e.printStackTrace();
	    	 }
	     }
	     private static Document connect(String url){
	         if (url == null || url.isEmpty()){
	             throw new IllegalArgumentException("The input url('" + url + "') is invalid!");
	         }
	         try{
	            return Jsoup.connect(url).timeout(100 * 1000).get();
	         } catch (Exception e){
	             e.printStackTrace();
	             return null;
	         }
	     }
	     private static void initFile(){
	         try{
	             bufferedWriter = new BufferedWriter(new FileWriter(new File("e:\\City4.txt"), true));
	         } catch (IOException e){
	             e.printStackTrace();
	         }
	      	}
	  
	      private static void closeStream(){
	          if (bufferedWriter != null){
	              try{
	                  bufferedWriter.close();
	              } catch (IOException e){
	                 e.printStackTrace();
	              	}
	              bufferedWriter = null;
	         }
	     }
}


