package com.service.sys;

import org.springframework.stereotype.Service;

import com.mapper.sys.UserJoinMapper;
import com.model.sys.UserJoin;
import com.service.base.CrudService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @功能说明：课程的加入人
 * @作者： 鑫
 * @创建日期：2021-05-15
 */
@Service
@Transactional
public class UserJoinService extends CrudService<UserJoinMapper, UserJoin> {
	
}