package com.coding404.myweb.practice1;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding404.myweb.command.Practice1VO;
import com.coding404.myweb.util.Criteria;
import com.coding404.myweb.util.Criteria1;

@Service("practice1Service")
public class Practice1ServiceImpl implements Practice1Service {

	@Autowired
	private Practice1Mapper practice1Mapper;

	@Override
	public int regist(Practice1VO vo) {
		return practice1Mapper.regist(vo);
	}

	@Override
	public ArrayList<Practice1VO> getListMe(Criteria1 cri1) {
		return practice1Mapper.getListMe(cri1);
	}

	@Override
	public ArrayList<Practice1VO> getListAll(Criteria1 cri1) {
		return practice1Mapper.getListAll(cri1);
	}

	@Override
	public int getTotal(Criteria1 cri1) {
		return practice1Mapper.getTotal(cri1);
	}

	@Override
	public Practice1VO getDetail(int topic_id) {
		return practice1Mapper.getDetail(topic_id);
	}

	@Override
	public int update(Practice1VO vo) {
		return practice1Mapper.update(vo);
	}

	@Override
	public int delete(int topic_id) {
		return practice1Mapper.delete(topic_id);
	}
	
	
}
