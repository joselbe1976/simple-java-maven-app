package com.common.tools.Redis;

import java.time.Duration;

import com.common.config.ParamsApp;

// import Redis client
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public final class RedisInterface {

	final  JedisPoolConfig poolConfig = buildPoolConfig();
	static JedisPool jedisPool = null;
	static boolean log = false;
	static boolean redisServerActivate = false;
	static long redisExpireKeyCache;
	
	
	
	//constructor
	public RedisInterface(){
		
		
		if (jedisPool == null) {
		
			new ParamsApp();
			
			if (ParamsApp.SYSTEM_DEBUG == 1) {
				this.log = true;
			}
			
			String host = ParamsApp.SYSTEM_REDIS_HOST;
			int port    = ParamsApp.SYSTEM_REDIS_PORT;
			addLog("Redis Server Configuration. Host : " + host +  "  | Port : " + port, ParamsApp.LOG_TYPE_INFO);
			
			//is avtive the server redis
			if (ParamsApp.SYSTEM_REDIS==1) {
				this.redisServerActivate = true;
			}
			
			
			//create the pool
			jedisPool = new JedisPool(poolConfig, host, port);
			
			RedisInterface.redisExpireKeyCache = ParamsApp.SYSTEM_REDIS_KEY_EXPIRE_SECONDS;
			
		}
		
	}
	


	//pooling config
	private JedisPoolConfig buildPoolConfig() {
	    final JedisPoolConfig poolConfig = new JedisPoolConfig();
	    poolConfig.setMaxTotal(128);
	    poolConfig.setMaxIdle(128);
	    poolConfig.setMinIdle(16);
	    poolConfig.setTestOnBorrow(true);
	    poolConfig.setTestOnReturn(true);
	    poolConfig.setTestWhileIdle(true);
	    poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
	    poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
	    poolConfig.setNumTestsPerEvictionRun(3);
	    poolConfig.setBlockWhenExhausted(true);
	    return poolConfig;
	}
	
	
	
	public boolean isActivateRedisServer() {
		return this.redisServerActivate;
	}
	
	
	
	// Set Value to Redis Server
	public boolean setValueCache(String key, String value) {
		
		try (Jedis jedis = jedisPool.getResource()) {
			try {
				
				// If Cache Key == 0 No Expires
				if (RedisInterface.redisExpireKeyCache == 0) {
					//set value NO expire
					jedis.set(key, value); // cache NO expire
					if (log) {
						addLog("setValueCache key: " + key, ParamsApp.LOG_TYPE_INFO);
					}
				}
				else {
					
					//Calc Seconds to Miliseconds
					long miliseconds = RedisInterface.redisExpireKeyCache * 1000;

					//Set value with expire time
					jedis.psetex(key, miliseconds, value);  //cache expire
					
					if (log) {
						addLog("INFO: Redis Server. psetex : " + key + "  : Expires (milisegundos):" + miliseconds, ParamsApp.LOG_TYPE_INFO);
					}
				}
				
				
				return true;
			}
			catch(Exception e) {
				addLog("setValueCache" + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
				return false;
			}
		}

	}
	
	
	public boolean delKeyCache(String key) {
		try (Jedis jedis = jedisPool.getResource()) {
			try {
			
				jedis.del(key); //delete
				if (log) {
					addLog("delKeyCache Delete: " + key, ParamsApp.LOG_TYPE_INFO);
				}
				return true;
			}
			catch(Exception e) {
				addLog("delKeyCache" + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
				return false;
			}
		}
	}
	
	
	//Get Value of Redis Server
	public String getValueCache(String key){
		try (Jedis jedis = jedisPool.getResource()) {
			try {
				
				String value = jedis.get(key); //read
				
				if (log) {
					addLog("getValueCache GET: " + key, ParamsApp.LOG_TYPE_INFO);
				}
				return value;
			}
			catch(Exception e) {
				addLog("getValueCache" + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
				return null;
			}
		}
		
	}
	
	//Get Value of Redis Server
	public void cleanAllCaches(){
		try (Jedis jedis = jedisPool.getResource()) {
			try {
				
				jedis.flushAll();
				
				if (log) {
					addLog("cleanAllCaches OK", ParamsApp.LOG_TYPE_INFO);
				}
			}
			catch(Exception e) {
				addLog("cleanAllCaches" + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
			}
		}
		
	}
	
	
	//return if exist the key
	public boolean existKeyCache(String key){
		try (Jedis jedis = jedisPool.getResource()) {
			try {
				boolean value = jedis.exists(key);
				
				if (log) {
					addLog("existKeyCache. Exist:" + key + " = " + value , ParamsApp.LOG_TYPE_INFO);
				}
				return value;
			}
			catch(Exception e) {
				addLog("existKeyCache" + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
				return false;
			}
		}
		
	}
	
	//return if exist the key
		public boolean isEqualValueInCache(String key, String valueToCompare){
			try (Jedis jedis = jedisPool.getResource()) {
				try {
					
					boolean value = jedis.exists(key);
					
					if (value) {
						if (jedis.get(key).toString().equals(valueToCompare)) {
							value = true;
						}
						else {
							value = false;
						}
						
					}
					else {
						if (log) {
							addLog("isEqualValueInCache. No exist Key:" + key , ParamsApp.LOG_TYPE_INFO);
						}	
					}

					addLog("isEqualValueInCache. IsEqual:" + value , ParamsApp.LOG_TYPE_INFO);
					return value;
				}
				catch(Exception e) {
					addLog("isEqualValueInCache" + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
					return false;
				}
			}
			
		}
		
		
		//Number of keys in server
		public long DBSize() {
			try (Jedis jedis = jedisPool.getResource()) {
				try {
					return  jedis.dbSize();
					
				}
				catch(Exception e) {
					return 0;
				}
			}
		}
		
		
		
		// LOG 
		private void addLog(String Message, int severity) {
			 new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_SESSION, Message, severity);
		}
		 
		
	
	
	
}
