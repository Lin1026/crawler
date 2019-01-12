package com.study.crawler.util;

import com.study.crawler.dao.WeiboMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Future;

/**
 * className: WeiboCrawler
 * description: TODO
 *
 * @author lh
 * @version 1.0
 * @date 19-1-12
 */
@Slf4j
@Data
@Component
public class WeiboCrawler {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("mm分ss秒");
    private final Consts consts;
    private final WeiboMapper weiboMapper;
    private final CrawlerDo crawlerDo;
    @Autowired
    public WeiboCrawler(Consts consts, WeiboMapper weiboMapper, CrawlerDo crawlerDo) {
        this.consts = consts;
        this.weiboMapper = weiboMapper;
        this.crawlerDo = crawlerDo;
    }

    public void start(){
        Set<Document> weiboSet = new HashSet<>(100);
        List<Future> ansList = Collections.synchronizedList(new ArrayList<>());
        long startTime = System.currentTimeMillis();
        long oldNum = weiboMapper.count();
    }
}
