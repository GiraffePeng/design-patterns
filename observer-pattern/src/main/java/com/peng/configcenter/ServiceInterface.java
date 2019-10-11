package com.peng.configcenter;

import java.util.Map;
import java.util.Properties;

//抽象观察者角色
public interface ServiceInterface {

	public void refreshConfig(Properties property);
}
