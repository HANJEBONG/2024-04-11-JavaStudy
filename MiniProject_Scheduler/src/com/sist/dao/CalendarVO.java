package com.sist.dao;
import java.util.*;
import lombok.Data;
/*
 * TITLE VARCHAR2(4000)
 PLACE   VARCHAR2(4000)
 DAY     DATE
 CONTENT  VARCHAR2(4000)
 USERID  NOT NULL VARCHAR2(4000)
 */
@Data
public class CalendarVO {
	private String title, place, content, userId;
	private String day;
	private int no;



}