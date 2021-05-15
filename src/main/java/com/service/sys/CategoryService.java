package com.service.sys;

import org.springframework.stereotype.Service;

import com.mapper.sys.CategoryMapper;
import com.model.sys.Category;
import com.service.base.CrudService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @功能说明：类别表
 * @作者： 鑫
 * @创建日期：2021-05-15
 */
@Service
@Transactional
public class CategoryService extends CrudService<CategoryMapper, Category> {
	
}