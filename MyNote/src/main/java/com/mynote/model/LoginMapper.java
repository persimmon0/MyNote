package com.mynote.model;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
	LoginModel findByAccount(String account);
}