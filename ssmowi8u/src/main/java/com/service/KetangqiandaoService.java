package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KetangqiandaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KetangqiandaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KetangqiandaoView;


/**
 * 课堂签到
 *
 * @author 
 * @email 
 * @date 2021-05-11 12:53:13
 */
public interface KetangqiandaoService extends IService<KetangqiandaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KetangqiandaoVO> selectListVO(Wrapper<KetangqiandaoEntity> wrapper);
   	
   	KetangqiandaoVO selectVO(@Param("ew") Wrapper<KetangqiandaoEntity> wrapper);
   	
   	List<KetangqiandaoView> selectListView(Wrapper<KetangqiandaoEntity> wrapper);
   	
   	KetangqiandaoView selectView(@Param("ew") Wrapper<KetangqiandaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KetangqiandaoEntity> wrapper);
   	
}

