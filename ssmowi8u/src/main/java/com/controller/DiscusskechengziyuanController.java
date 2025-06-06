package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscusskechengziyuanEntity;
import com.entity.view.DiscusskechengziyuanView;

import com.service.DiscusskechengziyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 课程资源评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2021-05-11 12:53:14
 */
@RestController
@RequestMapping("/discusskechengziyuan")
public class DiscusskechengziyuanController {
    @Autowired
    private DiscusskechengziyuanService discusskechengziyuanService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusskechengziyuanEntity discusskechengziyuan, 
		HttpServletRequest request){

        EntityWrapper<DiscusskechengziyuanEntity> ew = new EntityWrapper<DiscusskechengziyuanEntity>();
		PageUtils page = discusskechengziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusskechengziyuan), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusskechengziyuanEntity discusskechengziyuan, 
		HttpServletRequest request){
        EntityWrapper<DiscusskechengziyuanEntity> ew = new EntityWrapper<DiscusskechengziyuanEntity>();
		PageUtils page = discusskechengziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusskechengziyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusskechengziyuanEntity discusskechengziyuan){
       	EntityWrapper<DiscusskechengziyuanEntity> ew = new EntityWrapper<DiscusskechengziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusskechengziyuan, "discusskechengziyuan")); 
        return R.ok().put("data", discusskechengziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusskechengziyuanEntity discusskechengziyuan){
        EntityWrapper< DiscusskechengziyuanEntity> ew = new EntityWrapper< DiscusskechengziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusskechengziyuan, "discusskechengziyuan")); 
		DiscusskechengziyuanView discusskechengziyuanView =  discusskechengziyuanService.selectView(ew);
		return R.ok("查询课程资源评论表成功").put("data", discusskechengziyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusskechengziyuanEntity discusskechengziyuan = discusskechengziyuanService.selectById(id);
        return R.ok().put("data", discusskechengziyuan);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusskechengziyuanEntity discusskechengziyuan = discusskechengziyuanService.selectById(id);
        return R.ok().put("data", discusskechengziyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusskechengziyuanEntity discusskechengziyuan, HttpServletRequest request){
    	discusskechengziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusskechengziyuan);

        discusskechengziyuanService.insert(discusskechengziyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusskechengziyuanEntity discusskechengziyuan, HttpServletRequest request){
    	discusskechengziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusskechengziyuan);

        discusskechengziyuanService.insert(discusskechengziyuan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscusskechengziyuanEntity discusskechengziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusskechengziyuan);
        discusskechengziyuanService.updateById(discusskechengziyuan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusskechengziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscusskechengziyuanEntity> wrapper = new EntityWrapper<DiscusskechengziyuanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discusskechengziyuanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
