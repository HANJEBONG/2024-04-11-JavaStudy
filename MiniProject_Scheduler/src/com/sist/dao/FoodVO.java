package com.sist.dao;

import lombok.Data;

/*
	"FNO" NUMBER, 
	"POSTER" VARCHAR2(1000 BYTE), 
	"NAME" VARCHAR2(300 BYTE), 
	"TYPE" VARCHAR2(100 BYTE), 
	"ADDRESS" VARCHAR2(500 BYTE), 
	"PHONE" VARCHAR2(100 BYTE), 
	"SCORE" NUMBER(2,1), 
	"THEME" VARCHAR2(4000 BYTE), 
	"PRICE" VARCHAR2(100 BYTE), 
	"TIME" VARCHAR2(200 BYTE), 
	"SEAT" VARCHAR2(100 BYTE), 
	"CONTENT" CLOB, 
	"LINK" VARCHAR2(300 BYTE)

	
	 */
@Data
public class FoodVO {
	private int fno,no;
	private double score;
	private String name,address,phone,theme,type,price,time,seat,content,poster,link;
}