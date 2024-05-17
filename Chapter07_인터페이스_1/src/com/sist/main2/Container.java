package com.sist.main2;
import java.util.*;
public class Container {
    Model[] models= {
    		new BoardModel(), new FoodModel(), new NoticeModel(), new RecipeModel(), new SeoulModel()
    };
	public Model getModel(int no) {
    	return models[no-1];
    }
}
