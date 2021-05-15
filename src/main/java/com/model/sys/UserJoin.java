package com.model.sys;

import javax.persistence.Column;
import javax.persistence.Id;
import com.model.page.PageDto;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @功能说明：课程的加入人
 * @作者： 鑫
 * @创建日期：2021-05-15
 */
public class UserJoin extends PageDto implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	//字段
	private int id;//主键
	private int activityId;//活动的主键
	private int userId;//用户的主键
	private int state;//状态
	
	//构造方法
	public UserJoin() {
	}
	
	//get和set方法
	
	@Id @Column( name = "id"  ,nullable = false  , length = 10  )
	public int getId() {
		return  id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	@Column( name = "activity_id"  , length = 10  )
	public int getActivityId() {
		return  activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	
	@Column( name = "user_id"  , length = 10  )
	public int getUserId() {
		return  userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	@Column( name = "state"  , length = 10  )
	public int getState() {
		return  state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
}
