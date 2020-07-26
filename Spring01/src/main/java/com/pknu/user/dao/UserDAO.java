package com.pknu.user.dao;

import java.util.List;

import com.pknu.user.vo.UserVO;

public interface UserDAO {
	public void addUser(UserVO vo);

	public List<UserVO> getList();

	public UserVO getView(String tel);

	public UserVO delUser(UserVO vo);

	public void updateUser(UserVO vo);
	
}
