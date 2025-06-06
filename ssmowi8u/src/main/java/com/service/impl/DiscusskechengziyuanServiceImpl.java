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


import com.dao.DiscusskechengziyuanDao;
import com.entity.DiscusskechengziyuanEntity;
import com.service.DiscusskechengziyuanService;
import com.entity.vo.DiscusskechengziyuanVO;
import com.entity.view.DiscusskechengziyuanView;

@Service("discusskechengziyuanService")
public class DiscusskechengziyuanServiceImpl extends ServiceImpl<DiscusskechengziyuanDao, DiscusskechengziyuanEntity> implements DiscusskechengziyuanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusskechengziyuanEntity> page = this.selectPage(
                new Query<DiscusskechengziyuanEntity>(params).getPage(),
                new EntityWrapper<DiscusskechengziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusskechengziyuanEntity> wrapper) {
		  Page<DiscusskechengziyuanView> page =new Query<DiscusskechengziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusskechengziyuanVO> selectListVO(Wrapper<DiscusskechengziyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusskechengziyuanVO selectVO(Wrapper<DiscusskechengziyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusskechengziyuanView> selectListView(Wrapper<DiscusskechengziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusskechengziyuanView selectView(Wrapper<DiscusskechengziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
