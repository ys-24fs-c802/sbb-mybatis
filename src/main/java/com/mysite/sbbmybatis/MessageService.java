package com.mysite.sbbmybatis;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
	// 데이터베이스에서 값을 가져오는 것
	public String getMessage(Integer id) {
		//return messageMapper.getMessageById(id);
		return "Hello World";
	}
}
