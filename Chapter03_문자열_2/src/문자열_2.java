// contains 
/*
 *   JDBC => DBCP => MyBatis => (JPA)
 *   Ajax => Vue => React => Redux => React-Query => Next
 *   MSA
 *   리액트 쿼리...
 *   //https://www.genie.co.kr/chart/top200?ditc=D&ymd=20240423&hh=15&rtm=Y&pg=2
 *   
 */
import java.util.Scanner;


import javax.swing.*;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class 문자열_2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("1. 노래명 검색 2. 가수명 검색");
		int menu=scan.nextInt();
		int k=1;
		
		if(menu==1) {
			System.out.println("노래명 입력:");
			String fd=scan.next();
			for(int i=1;i<=4;i++) {
				Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20240423&hh=15&rtm=Y&pg="+i).get();
				Elements title=doc.select("table.list-wrap a.title");
				Elements singer=doc.select("table.list-wrap a.title");
				for(int j=0;j<title.size();j++) {
					// 포함여부 확인
					if(title.get(j).text().contains(fd)) {
					     System.out.println(k+"."+title.get(j).text()
					     +"("+singer.get(j).text()+")");
					}
					k++;
				}
			}
		}
		else if(menu==2) {
			System.out.println("가수명 입력:");
			String fd=scan.next();
			for(int i=1;i<=4;i++) {
				Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20240423&hh=15&rtm=Y&pg="+i).get();
				Elements title=doc.select("table.list-wrap a.title");
				Elements singer=doc.select("table.list-wrap a.title");
				for(int j=0;j<singer.size();j++) {
					// 포함여부 확인
					if(singer.get(j).text().contains(fd)) {
					     System.out.println(k+"."+title.get(j).text()
					     +"("+singer.get(j).text()+")");
					}
					k++;
				}
			}
		}
		
	}

}
