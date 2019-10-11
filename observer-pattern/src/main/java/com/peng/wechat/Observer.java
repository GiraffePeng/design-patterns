package com.peng.wechat;

//抽象观察者，其中声明接到通知时更改的方法
public interface Observer {

	public void response(String content);
}
