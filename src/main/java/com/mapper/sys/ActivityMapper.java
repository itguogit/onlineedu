package com.mapper.sys;

import com.mapper.base.BaseDao;
import com.model.sys.Activity;

import java.util.List;

/**
 * @功能说明：活动表
 * @作者： 鑫
 * @创建日期：2021-05-15
 */
public interface ActivityMapper extends BaseDao<Activity>{
    List<Activity> myActivityData(Activity activity);
}
