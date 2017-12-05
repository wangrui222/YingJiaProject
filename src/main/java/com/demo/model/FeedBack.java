package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
/**
 * --�������
 * @author admin
 *
 */

@Entity(name="feedback")
public class FeedBack {

	private Integer   feedbackId ;//����
	private Integer    memberId ;//��Աid
	private String feedbackContent ;//�����������
	private Date createDate ;//���ʱ��
	
	
	@Id
	@SequenceGenerator(name="seq_FeedBack",sequenceName="seq_feedback",allocationSize=1)
	@GeneratedValue(generator="seq_FeedBack",strategy=GenerationType.SEQUENCE)
	
	
	public Integer getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getFeedbackContent() {
		return feedbackContent;
	}
	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
