package com.model.sys;

import javax.persistence.Column;
import javax.persistence.Id;
import com.model.page.PageDto;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @功能说明：类别表
 * @作者： 鑫
 * @创建日期：2021-05-15
 */
public class Category extends PageDto implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	//字段
	private int id;//主键
	private String tName;//种类名称
	private int addUser;//添加人主键
	private Date addTime;//添加时间
	private int state;//状态 1 正常  2 删除
	
	//构造方法
	public Category() {
	}
	
	//get和set方法
	
	@Id @Column( name = "id"  ,nullable = false  , length = 10  )
	public int getId() {
		return  id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	@Column( name = "t_name"  , length = 100  )
	public String gettName() {
		return  tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	
	@Column( name = "add_user"  , length = 10  )
	public int getAddUser() {
		return  addUser;
	}

	public void setAddUser(int addUser) {
		this.addUser = addUser;
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
