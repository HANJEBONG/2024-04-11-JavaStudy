/*
 *     Jsoup => 라이브러리 (웹 크롤링) => HTML데이터 읽기
 *     HTML
 *      <div class="name">데이터</div>
 *      ----        ---- => div.name
 *      <div id="name>데이터</div>
 *                       => div#name
 *      1. 태그
 *      => 구분자(class/id)
 *      2. 바로 위에 있는 태그
 *         <div>
 *          <div></div>
 *         </div>
 *   https://www.genie.co.kr/chart/top200?ditc=D&ymd=20240503&hh=11&rtm=Y&pg=2
 *   <td class="info">
                                    
                                    
                                    <a href="#" class="title ellipsis"
                                    https://www.youtube.com/results?search_query=
 */
// 지니뮤직 ==> 멜론
// 사용자 정의 데이터형

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Music{
	String rank;
	String title;
	String singer;
	String album;
	String poster;
	String key;
}
class GenieMusic{
	static Music[] musics=new Music[200]; // 클래스 블록은 선언하는 위치
	
	{
		try {
//			int k=1;
//			for(int i=1;i<=4;i++) {
//			    Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20240503&hh=11&rtm=Y&pg="+i).get(); // HTML을 모두 긁어온다
//			    Elements title=doc.select("table.list-wrap td.info a.title");
//			    Elements singer=doc.select("table.list-wrap td.info a.artist");
//			    Elements album=doc.select("table.list-wrap td.info a.albumtitle");
//			    Elements poster=doc.select("table.list-wrap a.cover img");
//			    for(int j=0;j<title.size();j++) {
//			    	System.out.println("순위:"+k);
//			    	System.out.println("노래명:"+title.get(j).text());
//			    	System.out.println("가수명:"+singer.get(j).text());
//			    	System.out.println("앨범:"+album.get(j).text());
//			    	System.out.println("이미지:"+poster.get(j).attr("src"));
//			    	//System.out.println("동영상 키:"+youtubeData(title.get(j).text()));
//			    	System.out.println("============================================");
//			    	FileWriter fw=new FileWriter("c:\\javaDev\\genie.txt",true); //append
//			    	String data=k+"|"
//			    			+title.get(j).text()+"|"
//			    			+singer.get(j).text()+"|"
//			    			+album.get(j).text()+"|"
//			    			+poster.get(j).attr("src")+"|"
//			    	        +youtubeData(title.get(j).text())+"\r\n";
//			    	fw.write(data);
//			    	fw.close();
//			    	k++;
//			    }
//			}
			FileReader fr=new FileReader("c:\\javaDev\\genie.txt");
			int i=0;
			StringBuffer sb=new StringBuffer();
			while((i=fr.read())!=-1) {
				sb.append((char)i);
			}
			fr.close();
			
			String data=sb.toString();
			String[] temp=data.split("\n");
			i=0;
			for(String s:temp) {
				String[] ss=s.split("\\|");
				musics[i]=new Music();
				musics[i].rank=ss[0];
				musics[i].title=ss[1];
				musics[i].singer=ss[2];
				musics[i].album=ss[3];
				musics[i].poster=ss[4];
				musics[i].key=ss[5];
				i++;
			}
		}catch (Exception ex) {}
	}
	static void musicDetail(int rank) {
		try {
			Music m=musics[rank-1];
			String url="http://youtube.com/embed/"+m.key;
			Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe "+url);
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	static void musicTitleFind(String title)
	{
		int count=0;
		for(Music m:musics)
		{
			if(m.title.contains(title))
			{
				System.out.println(m.title);
				count++;
			}
		}
		System.out.println("검색 결과 총 "+count+"건");
	}
	static void musicSingerFind(String singer)
	{
		int count=0;
		for(Music m:musics)
		{
			if(m.singer.contains(singer))
			{
				System.out.println(m.title);
				count++;
			}
		}
		System.out.println(singer+" 검색 결과 총 "+count+"건");
	}
	static void musicList() {
		System.out.println("====================== Music List=====================");
		int i=1;
		for (Music s:musics) {
			System.out.println(i+"."+s.title);
			i++;
		}
	}
	static String youtubeData(String title) throws Exception{
		String result="";
		String url="https://www.youtube.com/results?search_query="+
		            URLEncoder.encode(title,"UTF-8");
		Pattern p=Pattern.compile("/watch\\?v=[^가-힁]+");
		Document doc=Jsoup.connect(url).get();
		Matcher m=p.matcher(doc.toString());
		while(m.find()) {
			String temp=m.group();
			temp=temp.substring(temp.indexOf("=")+1,temp.indexOf("\""));
			result=temp;
			break;
		}
		return result;
	}
}
/*
 *   프로그램
 *    => 데이터 수집
 *    => 데이터를 메모리 저장 => 프로그램 종료후 사라진다
 */
public class MusicMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        GenieMusic gm=new GenieMusic();
        gm.musicList();
        System.out.println("=========================================");
        Scanner scan=new Scanner(System.in);
        System.out.print("검색어 입력:");
        String title=scan.next();
        gm.musicTitleFind(title);
        System.out.print("검색어 입력:");
        String singer=scan.next();
        gm.musicSingerFind(singer);
//        try {
//        	String url="http://youtube.com/embed/xfqBQ2XhBCg\u0026pp=ygUUU1BPVCEgKEZlYXQuIEpFTk5JRSk%3D";
//        	Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe "+url);
//        }catch (Exception ex) {} //   
	}

}
