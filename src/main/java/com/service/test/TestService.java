package com.service.test;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.test.TestMapper;
import com.model.test.Test;
import com.service.base.CrudService;

/**
 * @功能说明：test
 * @作者： test
 * @创建日期：2018-05-01
 */
@Service
@Transactional
public class TestService extends CrudService<TestMapper, Test> {
	
}