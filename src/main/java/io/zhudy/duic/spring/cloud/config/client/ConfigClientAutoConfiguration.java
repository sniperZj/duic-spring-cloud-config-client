/*
 * Copyright 2013-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.zhudy.duic.spring.cloud.config.client;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

@Configuration
public class ConfigClientAutoConfiguration {

    @Bean
    @ConditionalOnClass(ContextRefresher.class)
    public ConfigWatchService configClientWatch(ContextRefresher contextRefresher, ConfigurableEnvironment environment,
                                                ConfigurableListableBeanFactory beanFactory, ConfigClientProperties clientProperties) {
        return new ConfigWatchService(contextRefresher, environment, beanFactory, clientProperties);
    }

}
