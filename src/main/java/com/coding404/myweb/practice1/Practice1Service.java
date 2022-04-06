package com.coding404.myweb.practice1;

import java.util.ArrayList;

import com.coding404.myweb.command.Practice1VO;
import com.coding404.myweb.util.Criteria;
import com.coding404.myweb.util.Criteria1;

public interface Practice1Service {
	
	public int regist(Practice1VO vo); //등록
	public ArrayList<Practice1VO> getListMe(Criteria1 cri1); //목록 자신
	public ArrayList<Practice1VO> getListAll(Criteria1 cri1); //목록 전체
	public int getTotal(Criteria1 cri1); //전체게시글 수
	
	public Practice1VO getDetail(int topic_id); //상세
	public int update(Practice1VO vo); //수정
	public int delete(int topic_id); //삭제
}
