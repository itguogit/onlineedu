package com.service.sys;


import org.springframework.stereotype.Service;

import com.mapper.sys.CommentMapper;
import com.model.sys.Comment;
import com.service.base.CrudService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @功能说明：评论表
 * @作者： 鑫
 * @创建日期：2021-05-15
 */
@Service
@Transactional
public class CommentService extends CrudService<CommentMapper, Comment> {
	
}