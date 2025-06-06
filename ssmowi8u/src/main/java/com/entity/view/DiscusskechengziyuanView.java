package com.entity.view;

import com.entity.DiscusskechengziyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 课程资源评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-11 12:53:14
 */
@TableName("discusskechengziyuan")
public class DiscusskechengziyuanView  extends DiscusskechengziyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusskechengziyuanView(){
	}
 
 	public DiscusskechengziyuanView(DiscusskechengziyuanEntity discusskechengziyuanEntity){
 	try {
			BeanUtils.copyProperties(this, discusskechengziyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
