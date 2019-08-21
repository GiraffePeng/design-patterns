package com.peng.abstarctfactoryinsurance.factory;

import com.peng.abstarctfactoryinsurance.common.HttpClientUtil;
import com.peng.abstarctfactoryinsurance.common.Result;
import com.peng.abstarctfactoryinsurance.dto.IssueDTO;
import com.peng.abstarctfactoryinsurance.dto.SurrenderDTO;
import com.peng.abstarctfactoryinsurance.product.IIssue;
import com.peng.abstarctfactoryinsurance.product.ISurrender;
import com.peng.abstarctfactoryinsurance.product.TaikangIssue;
import com.peng.abstarctfactoryinsurance.product.TaikangSurrender;

public class TaiKangFactoryService implements InsuranceFactoryService{

	@Override
	public Result issueOrder(IssueDTO issueDTO) {
		IIssue taikangIssue = new TaikangIssue();
		//组装报文
		String buildIssueContent = taikangIssue.buildIssueContent(issueDTO.getOrderNo());
		//组装成功 使用http协议调用保险公司接口
		String result = HttpClientUtil.doPost("http://taikang.com", buildIssueContent, CHARSET);
		return new Result<String>(result);
	}

	@Override
	public Result surrenderOrder(SurrenderDTO surrenderDTO) {
		ISurrender taikangSurrender = new TaikangSurrender();
		//组装报文
		String buildSurrenderContent = taikangSurrender.buildSurrenderContent(surrenderDTO.getOrderNo());
		//组装成功 使用http协议调用保险公司接口
		String result = HttpClientUtil.doPost("http://taikang.com", buildSurrenderContent, CHARSET);
		return new Result<String>(result);
	}
	

}
