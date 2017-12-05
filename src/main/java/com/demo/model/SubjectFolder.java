package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity(name="subject_folder")

/**
 * 附件归属表
 * @author thinkpad
 *
 */
public class SubjectFolder {
	private Integer subjectFolderId;
	/**
	 * 创建时间
	 */
	private Date  createDate;
	/**
	 * 修改时间
	 */
	private Date updateDate ;
	@Id
	@SequenceGenerator(name="subject_folder",sequenceName="sql_subject_folder",allocationSize=1)
	@GeneratedValue(generator="subject_folder",strategy=GenerationType.SEQUENCE)
	public Integer getSubjectFolderId() {
		return subjectFolderId;
	}
	public void setSubjectFolderId(Integer subjectFolderId) {
		this.subjectFolderId = subjectFolderId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	
}
