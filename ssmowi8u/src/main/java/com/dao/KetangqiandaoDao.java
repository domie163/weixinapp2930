package com.dao;

import com.entity.KetangqiandaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KetangqiandaoVO;
import com.entity.view.KetangqiandaoView;


/**
 * 课堂签到
 * 
 * @author 
 * @email 
 * @date 2021-05-11 12:53:13
 */
public interface KetangqiandaoDao extends BaseMapper<KetangqiandaoEntity> {
	
	List<KetangqiandaoVO> selectListVO(@Param("ew") Wrapper<KetangqiandaoEntity> wrapper);
	
	KetangqiandaoVO selectVO(@Param("ew") Wrapper<KetangqiandaoEntity> wrapper);
	
	List<KetangqiandaoView> selectListView(@Param("ew") Wrapper<KetangqiandaoEntity> wrapper);

	List<KetangqiandaoView> selectListView(Pagination page,@Param("ew") Wrapper<KetangqiandaoEntity> wrapper);
	
	KetangqiandaoView selectView(@Param("ew") Wrapper<KetangqiandaoEntity> wrapper);
	
}
