package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.KetangqiandaoDao;
import com.entity.KetangqiandaoEntity;
import com.service.KetangqiandaoService;
import com.entity.vo.KetangqiandaoVO;
import com.entity.view.KetangqiandaoView;

@Service("ketangqiandaoService")
public class KetangqiandaoServiceImpl extends ServiceImpl<KetangqiandaoDao, KetangqiandaoEntity> implements KetangqiandaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KetangqiandaoEntity> page = this.selectPage(
                new Query<KetangqiandaoEntity>(params).getPage(),
                new EntityWrapper<KetangqiandaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KetangqiandaoEntity> wrapper) {
		  Page<KetangqiandaoView> page =new Query<KetangqiandaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KetangqiandaoVO> selectListVO(Wrapper<KetangqiandaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KetangqiandaoVO selectVO(Wrapper<KetangqiandaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KetangqiandaoView> selectListView(Wrapper<KetangqiandaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KetangqiandaoView selectView(Wrapper<KetangqiandaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
