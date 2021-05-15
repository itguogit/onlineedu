package com.service.sys;


import org.springframework.stereotype.Service;

import com.mapper.sys.CourseMapper;
import com.model.sys.Course;
import com.service.base.CrudService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @功能说明：课程信息表
 * @作者： 鑫
 * @创建日期：2021-05-15
 */
@Service
@Transactional
public class CourseService extends CrudService<CourseMapper, Course> {
	
}