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

}
class MelonMusic{
	static Music[] musics=new Music[100]; // 클래스 블록은 선언하는 위치
	
	{
		try {
			int k=1;
			    for(int i=1;i<=2;i++) {
			    Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get(); // HTML을 모두 긁어온다
			    Elements title=doc.select("tr.lst"+50*i+" div.wrap div.rank01 a");
			    Elements singer=doc.select("tr.lst"+50*i+" div.wrap div.rank02");
			    Elements album=doc.select("tr.lst"+50*i+" div.wrap div.rank03");
			    Elements poster=doc.select("tr.lst"+50*i+" div.wrap a.image_typeAll img");
			        for(int j=0;j<title.size();j++) {
			    	    System.out.println("순위:"+k);
			    	    System.out.println("노래명:"+title.get(j).text());
			    	    System.out.println("가수명:"+singer.get(j).text());
			    	    System.out.println("앨범:"+album.get(j).text());
			    	    System.out.println("이미지:"+poster.get(j).attr("src"));
			    	    //System.out.println("동영상 키:"+youtubeData(title.get(j).text()));
			    	    System.out.println("============================================");
			    	    FileWriter fw=new FileWriter("c:\\javaDev\\Melon.txt",true); //append
			    	    String data=k+"|"
			    			+title.get(j).text()+"|"
			    			+singer.get(j).text()+"|"
			    			+album.get(j).text()+"|"
			    			+poster.get(j).attr("src")+"\r\n";
			    	        
			    	    fw.write(data);
			    	    fw.close();
			    	    k++;
			        }
			  }
//			FileReader fr=new FileReader("c:\\javaDev\\Melon.txt");
//			int i=0;
//			StringBuffer sb=new StringBuffer();
//			while((i=fr.read())!=-1) {
//				sb.append((char)i);
//			}
//			fr.close();
//			
//			String data=sb.toString();
//			String[] temp=data.split("\n");
//			i=0;
//			for(String s:temp) {
//				String[] ss=s.split("\\|");
//				musics[i]=new Music();
//				musics[i].rank=ss[0];
//				musics[i].title=ss[1];
//				musics[i].singer=ss[2];
//				musics[i].album=ss[3];
//				musics[i].poster=ss[4];
//				i++;
//			}
		}catch (Exception ex) {}
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
}
public class MelonMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MelonMusic kg=new MelonMusic();
//        kg.musicList();

	}

}
