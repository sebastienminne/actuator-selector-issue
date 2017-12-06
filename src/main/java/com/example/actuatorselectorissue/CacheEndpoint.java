package com.example.actuatorselectorissue;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.info.Info;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Configuration
@Component
@Endpoint(id = "mycache")
public class CacheEndpoint {

	@ReadOperation
	public Map<String, Object> cache() {
		Info.Builder builder = new Info.Builder();
		builder.withDetail("blabla", "blabla");

		Info build = builder.build();
		return build.getDetails();
	}

	@ReadOperation
	public Map<String, Object> cache2(@Selector String test) {
		Info.Builder builder = new Info.Builder();
		builder.withDetail("blabla", test);

		Info build = builder.build();
		return build.getDetails();
	}
}
