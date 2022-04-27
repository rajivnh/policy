package com.lti.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.NetworkConfig;

@Configuration
@EnableCaching
public class CacheConfig {
    
    @Bean
    public Config hazelCastConfig() {
    	Config config = new Config();
    	
    	config.addMapConfig(new MapConfig().setName("policy"));
    	
    	NetworkConfig network = config.getNetworkConfig();    	
    	network.setPort(5701).setPortCount(20).setPortAutoIncrement(true);
    	
    	JoinConfig join = network.getJoin();    	
    	join.getMulticastConfig().setEnabled(false);
    	join.getTcpIpConfig().addMember("127.0.0.1").setEnabled(true);
    	
        return config;
    }
}
