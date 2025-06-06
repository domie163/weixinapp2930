package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusskechengziyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusskechengziyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusskechengziyuanView;


/**
 * 课程资源评论表
 *
 * @author 
 * @email 
 * @date 2021-05-11 12:53:14
 */
public interface DiscusskechengziyuanService extends IService<DiscusskechengziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusskechengziyuanVO> selectListVO(Wrapper<DiscusskechengziyuanEntity> wrapper);
   	
   	DiscusskechengziyuanVO selectVO(@Param("ew") Wrapper<DiscusskechengziyuanEntity> wrapper);
   	
   	List<DiscusskechengziyuanView> selectListView(Wrapper<DiscusskechengziyuanEntity> wrapper);
   	
   	DiscusskechengziyuanView selectView(@Param("ew") Wrapper<DiscusskechengziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusskechengziyuanEntity> wrapper);
   	
}

