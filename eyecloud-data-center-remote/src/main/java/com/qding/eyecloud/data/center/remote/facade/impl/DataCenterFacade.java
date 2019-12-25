package com.qding.eyecloud.data.center.remote.facade.impl;

import com.qding.eyecloud.data.center.remote.facade.IDataCenterFacade;

//@Service
public class DataCenterFacade implements IDataCenterFacade {

	@Override
	public String hello(String text) {
		return "success:hello!" + text;
	}

}
