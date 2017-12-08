package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *@author ���ߣ�
 *@version ����ʱ�䣺2017��12��8��
 *��˵��
 *�����б�
 */
@Entity(name="select_project")
public class SelectProject {
	private Integer id;//����
	private String code;//�����б������
	private String name;
	private Integer value;
	@Id
	@SequenceGenerator(name="select_project",sequenceName="seq_select_project",allocationSize=1)
	@GeneratedValue(generator="select_project",strategy=GenerationType.SEQUENCE)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
}
