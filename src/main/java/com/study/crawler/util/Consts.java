package com.study.crawler.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * className: Consts
 * description: TODO
 *
 * @author lh
 * @version 1.0
 * @date 19-1-12
 */
@Component
@PropertySource("classpath:value.properties")
public class Consts {
    @Value("${base.website-url}")
    public String baseWebsiteUrl;
    @Value("${base.url.retry-times}")
    public int retryTimes;
    @Value("${base.connect.out-of-time}")
    public int outOfTime;
    @Value("${final.urlHeader}")
    public String finalUrlHeader;
}
