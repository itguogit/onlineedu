package com.model.sys;

import javax.persistence.Column;
import javax.persistence.Id;
import com.model.page.PageDto;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @功能说明：课程信息表
 * @作者： 鑫
 * @创建日期：2021-05-15
 */
public class Course extends PageDto implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	//字段
	private int id;//主键
	private String cName;//课程名称
	private int cType;//课程类别主键
	private int addUser;//添加人员主键
	private Date addTime;//添加时间
	private String cNum;//课程编号，第几集
	private String cDesc;//课程描述
	private int cState;//状态  1 正常 2删除
	private String tUrl;//视频的访问链接

	private String addUserName;

	private String categoryName;

	public String getAddUserName() {
		return addUserName;
	}

	public void setAddUserName(String addUserName) {
		this.addUserName = addUserName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	//构造方法
	public Course() {
	}
	
	//get和set方法
	
	@Id @Column( name = "id"  ,nullable = false  , length = 10  )
	public int getId() {
		return  id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	@Column( name = "c_name"  , length = 150  )
	public String getcName() {
		return  cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	
	@Column( name = "c_type"  , length = 10  )
	public int getcType() {
		return  cType;
	}

	public void setcType(int cType) {
		this.cType = cType;
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

	
	@Column( name = "c_num"  , length = 10  )
	public String getcNum() {
		return  cNum;
	}

	public void setcNum(String cNum) {
		this.cNum = cNum;
	}

	
	@Column( name = "c_desc"  , length = 200  )
	public String getcDesc() {
		return  cDesc;
	}

	public void setcDesc(String cDesc) {
		this.cDesc = cDesc;
	}

	
	@Column( name = "c_state"  , length = 10  )
	public int getcState() {
		return  cState;
	}

	public void setcState(int cState) {
		this.cState = cState;
	}

	
	@Column( name = "t_url"  , length = 200  )
	public String gettUrl() {
		return  tUrl;
	}

	public void settUrl(String tUrl) {
		this.tUrl = tUrl;
	}

	
}
