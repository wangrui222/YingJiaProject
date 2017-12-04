<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h2>
    <span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>特定属性
</h2>
<div class="row bdlist typicalPanel">
    <#list fields as field>
        <div class="form-group col-md-6">
            <label class="col-sm-3 control-label">${field.description}：</label>
            <div class="col-sm-9">
                <input name="subjectFieldRecords[${field_index}].fieldId" value="${field}" type="hidden">
                <input name="subjectFieldRecords[${field_index}].fieldValue" class="form-control" placeholder="请输入文本" type="text">
                <span style="visibility: hidden">验证提示预留位置</span>
            </div>
        </div>
    </#list>
</div>