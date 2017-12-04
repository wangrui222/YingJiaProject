package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="subject_file")
/**
 * ������
 * @author thinkpad
 *
 */
public class SubjectFile {
	private Integer subjectFileId;
	/**
	 * ��������id
	 */
	private Integer  folderId;
	/**
	 * �ļ�·��
	 * @return
	 */
	private String subjectFilePath;
	/**
	 * �ļ���
	 * @return
	 */
	private String fileName;
	/**
	 * ԭ�ļ���
	 * @return
	 */
	private String originalName;
	/**
	 * ԭ�ļ���
	 */
	private Date createDate;
	/**
	 * �޸�ʱ��
	 */
	private Date  updateDate;
	@Id
	@SequenceGenerator(name="subject_file",sequenceName="sql_subject_file",allocationSize=1)
	@GeneratedValue(generator="subject_file",strategy=GenerationType.SEQUENCE)
	public Integer getSubjectFileId() {
		return subjectFileId;
	}
	public void setSubjectFileId(Integer subjectFileId) {
		this.subjectFileId = subjectFileId;
	}
	public Integer getFolderId() {
		return folderId;
	}
	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}
	public String getSubjectFilePath() {
		return subjectFilePath;
	}
	public void setSubjectFilePath(String subjectFilePath) {
		this.subjectFilePath = subjectFilePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
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
