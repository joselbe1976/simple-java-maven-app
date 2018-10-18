package com.common.tools.interfaces;


import com.common.server.queue.Task;
import com.common.webservices.apiRest.models.TokenInfo;

public interface iTaskMethod {

	public static final int FINISH_SUCCESS = 0;
	public static final int FINISH_ERROR = -1;
	
	public void Dispose();
	public int Execute(String ArgsJson, TokenInfo userConected, Task task);
}
