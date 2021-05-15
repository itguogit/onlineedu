package com.model.sys;

import javax.persistence.Column;
import javax.persistence.Id;
import com.model.page.PageDto;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @功能说明：评论表
 * @作者： 鑫
 * @创建日期：2021-05-15
 */
public class Comment extends PageDto implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	//字段
	private int id;//主键
	private int courseId;//课程的名称
	private String addUser;//添加人的主键
	private String tContent;//评论的内容
	private Date addTime;//添加时间
	private int state;//状态
	
	//构造方法
	public Comment() {
	}
	
	//get和set方法
	
	@Id @Column( name = "id"  ,nullable = false  , length = 10  )
	public int getId() {
		return  id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	@Column( name = "course_id"  , length = 10  )
	public int getCourseId() {
		return  courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	
	@Column( name = "add_user"  , length = 100  )
	public String getAddUser() {
		return  addUser;
	}

	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}

	
	@Column( name = "t_content"  , length = 100  )
	public String gettContent() {
		return  tContent;
	}

	public void settContent(String tContent) {
		this.tContent = tContent;
	}

	
	 @Temporal(TemporalType.TIMESTAMP) @Column( name = "add_time"  , length = 10  )
	public Date getAddTime() {
		return  addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	
	@Column( name = "state"  , length = 10  )
	public int getState() {
		return  state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
}
