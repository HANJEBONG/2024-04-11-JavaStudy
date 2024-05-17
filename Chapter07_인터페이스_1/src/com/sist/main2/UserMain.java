package com.sist.main2;
import java.util.*;
public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("게시판(1),맛집(2),레시피(3),여행(4),공지사항(5):");
		int menu=scan.nextInt();
		Container c=new Container();
		Model model=c.getModel(menu);
		model.execute();
//		if (menu==1) {
//			BoardModel model=new BoardModel();
//			model.execute();
//		}else if(menu==2) {
//			FoodModel model=new FoodModel();
//			model.execute();
//		}else if(menu==3) {
//			RecipeModel model=new RecipeModel();
//			model.execute();
//		}else if(menu==4) {
//			SeoulModel model=new SeoulModel();
//			model.execute();
//		}else if(menu==5) {
//			NoticeModel model=new NoticeModel();
//			model.execute();
//		}

	}

}
