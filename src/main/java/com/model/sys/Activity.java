package com.model.sys;

import javax.lang.model.element.NestingKind;
import javax.persistence.Column;
import javax.persistence.Id;
import com.model.page.PageDto;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @功能说明：活动表
 * @作者： 鑫
 * @创建日期：2021-05-15
 */
public class Activity extends PageDto implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	//字段
	private int id;//主键
	private String aName;//活动的名称
	private int addUser;//添加人主键
	private Date addTime;//添加时间
	private int courseId;//课程主键
	private Date startTime;//开始时间
	private Date endTime;//结束时间
	private String carefulInfo;//注意事项
	private int state;//课程状态  1 正常  2 删除
	private String startDate;
	private String endDate;

	private String cName;
	private String name;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	//构造方法
	public Activity() {
	}
	
	//get和set方法
	
	@Id @Column( name = "id"  ,nullable = false  , length = 10  )
	public int getId() {
		return  id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	@Column( name = "a_name"  , length = 100  )
	public String getaName() {
		return  aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
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

	
	@Column( name = "course_id"  , length = 10  )
	public int getCourseId() {
		return  courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	
	 @Temporal(TemporalType.TIMESTAMP) @Column( name = "start_time"  , length = 10  )
	public Date getStartTime() {
		return  startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	
	 @Temporal(TemporalType.TIMESTAMP) @Column( name = "end_time"  , length = 10  )
	public Date getEndTime() {
		return  endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	
	@Column( name = "careful_info"  , length = 500  )
	public String getCarefulInfo() {
		return  carefulInfo;
	}

	public void setCarefulInfo(String carefulInfo) {
		this.carefulInfo = carefulInfo;
	}

	
	@Column( name = "state"  , length = 10  )
	public int getState() {
		return  state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
