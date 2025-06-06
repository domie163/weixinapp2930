package com.dao;

import com.entity.DiscusskechengziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusskechengziyuanVO;
import com.entity.view.DiscusskechengziyuanView;


/**
 * 课程资源评论表
 * 
 * @author 
 * @email 
 * @date 2021-05-11 12:53:14
 */
public interface DiscusskechengziyuanDao extends BaseMapper<DiscusskechengziyuanEntity> {
	
	List<DiscusskechengziyuanVO> selectListVO(@Param("ew") Wrapper<DiscusskechengziyuanEntity> wrapper);
	
	DiscusskechengziyuanVO selectVO(@Param("ew") Wrapper<DiscusskechengziyuanEntity> wrapper);
	
	List<DiscusskechengziyuanView> selectListView(@Param("ew") Wrapper<DiscusskechengziyuanEntity> wrapper);

	List<DiscusskechengziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusskechengziyuanEntity> wrapper);
	
	DiscusskechengziyuanView selectView(@Param("ew") Wrapper<DiscusskechengziyuanEntity> wrapper);
	
}
