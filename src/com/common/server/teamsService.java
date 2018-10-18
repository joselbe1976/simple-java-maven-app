package com.common.server;

import com.common.tools.interfaces.iDisposable;

public class teamsService implements iDisposable {

	@Override
	public void Dispose() {
		
	}
	
	// Executed for syncronize all backends. If only 1 backend, desactive this service on StartUp (see parameters)
	public void execute() {
		
		// We should find in Redis Server the chats and the last update. If we have chats no syncronize and there are some 
		// sessions of users of this chats, send to all the messages.
		
		
	}

}
