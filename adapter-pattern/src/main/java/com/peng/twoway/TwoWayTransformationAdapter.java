package com.peng.twoway;

//双向转换适配器
public class TwoWayTransformationAdapter implements TwoWayTarget,TwoWayAdapter{

	 private TwoWayTarget target;
	    private TwoWayAdapter adapter;
	    public TwoWayTransformationAdapter(TwoWayTarget target)
	    {
	        this.target=target;
	    }
	    public TwoWayTransformationAdapter(TwoWayAdapter adapter)
	    {
	        this.adapter=adapter;
	    }
	    
	@Override
	public void specificRequest() {
		target.request();
	}

	@Override
	public void request() {
		adapter.specificRequest();
	}

}
