package com.sist.dao;
import java.util.*;

import lombok.Data;
@Data
public class MemberVO {
	private String id,pwd,name,sex,birthday,post,addr1,addr2,phone,email,content,admin;
	private Date regdate;
}
