package com.service.sys;

import org.springframework.stereotype.Service;

import com.mapper.sys.ActivityMapper;
import com.model.sys.Activity;
import com.service.base.CrudService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @功能说明：活动表
 * @作者： 鑫
 * @创建日期：2021-05-15
 */
@Service
@Transactional
public class ActivityService extends CrudService<ActivityMapper, Activity> {
	
}