package com.sist.dao;
import java.util.*;

import lombok.Data;
/*
 * CNO                                       NOT NULL NUMBER
 ID                                                 VARCHAR2(20)
 GNO                                                NUMBER
 ACCOUNT                                            NUMBER
 PRICE                                              NUMBER
 REGDATE                                            DATE
 */
@Data
public class CartVO {
	private int cno,gno,price,account;
	private String id;
	private Date regdate;
	private GoodsVO gvo=new GoodsVO();
}
