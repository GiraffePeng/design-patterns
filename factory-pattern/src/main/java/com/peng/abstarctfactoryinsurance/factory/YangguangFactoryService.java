package com.peng.abstarctfactoryinsurance.factory;

import com.peng.abstarctfactoryinsurance.common.HttpClientUtil;
import com.peng.abstarctfactoryinsurance.common.Result;
import com.peng.abstarctfactoryinsurance.dto.IssueDTO;
import com.peng.abstarctfactoryinsurance.dto.SurrenderDTO;
import com.peng.abstarctfactoryinsurance.product.IIssue;
import com.peng.abstarctfactoryinsurance.product.ISurrender;
import com.peng.abstarctfactoryinsurance.product.YangguangIssue;
import com.peng.abstarctfactoryinsurance.product.YangguangSurrender;

public class YangguangFactoryService implements InsuranceFactoryService{

	@Override
	public Result issueOrder(IssueDTO issueDTO) {
		IIssue yangguangIssue = new YangguangIssue();
		//组装报文
		String buildIssueContent = yangguangIssue.buildIssueContent(issueDTO.getOrderNo());
		//组装成功 使用http协议调用保险公司接口
		String result = HttpClientUtil.doPost("http://yangguang.com", buildIssueContent, CHARSET);
		return new Result<String>(result);
	}

	@Override
	public Result surrenderOrder(SurrenderDTO surrenderDTO) {
		ISurrender yangguangSurrender = new YangguangSurrender();
		//组装报文
		String buildSurrenderContent = yangguangSurrender.buildSurrenderContent(surrenderDTO.getOrderNo());
		//组装成功 使用http协议调用保险公司接口
		String result = HttpClientUtil.doPost("http://yangguang.com", buildSurrenderContent, CHARSET);
		return new Result<String>(result);
	}
	

}
