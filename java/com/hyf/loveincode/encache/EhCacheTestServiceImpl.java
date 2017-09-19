package com.hyf.loveincode.encache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author loveincode
 * @data Sep 19, 2017 10:06:25 AM
 */
@Service
public class EhCacheTestServiceImpl implements EhCacheTestService {

	@Cacheable(value = "cacheTest", key = "#param")
	public String getTimestamp(String param) {
		Long timestamp = System.currentTimeMillis();
		return timestamp.toString();
	}

}
