package com.entity.view;

import com.entity.KetangqiandaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 课堂签到
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-11 12:53:13
 */
@TableName("ketangqiandao")
public class KetangqiandaoView  extends KetangqiandaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KetangqiandaoView(){
	}
 
 	public KetangqiandaoView(KetangqiandaoEntity ketangqiandaoEntity){
 	try {
			BeanUtils.copyProperties(this, ketangqiandaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
