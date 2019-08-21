package com.peng.abstarctfactoryinsurance.factory;

import com.peng.abstarctfactoryinsurance.common.Result;
import com.peng.abstarctfactoryinsurance.dto.IssueDTO;
import com.peng.abstarctfactoryinsurance.dto.SurrenderDTO;

public interface InsuranceFactoryService {
	
	final static String CHARSET = "UTF-8";
	//出单
	public Result issueOrder(IssueDTO issueDTO);
	
	//退保
	public Result surrenderOrder(SurrenderDTO surrenderDTO);
}
