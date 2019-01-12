package com.study.crawler;

import com.alibaba.fastjson.JSONObject;
import com.study.crawler.dao.WeiboMapper;
import com.study.crawler.exception.ConnectErrorException;
import com.study.crawler.util.Consts;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CrawlerApplicationTests {
    @Autowired
    WeiboMapper weiboMapper;
    @Autowired
    Consts consts;

    @Test
    public void contextLoads() {
        System.out.println(weiboMapper.selectByPrimaryKey(1).toString());
        log.info(weiboMapper.selectByPrimaryKey(1).toString());
    }

    @Test
    public void connectTest() {
        String url = "https://weibo.com/bilibiliweb?pids=Pl_Official_MyProfileFeed__25&amp;is_search=0&amp;visible=0&amp;is_hot=1&amp;is_tag=0&amp;profile_ftype=1&amp;page=1#feedtop";
        int count = 0;
        while (true) {
            try {
                Connection.Response response = Jsoup.connect(url).timeout(100).ignoreContentType(true).maxBodySize(0).execute();

            } catch (IOException e) {
                log.info(String.format("%s断线重连第%d次", "https://weibo.com/bilibiliweb", (++count)));
                if (count > 3) {
                    log.error("无法连接");
                    break;
                }
            }
        }
    }

    @Test
    public void crawler() {
        String url = "https://m.weibo.cn/api/container/getIndex?type=uid&value=5650807778&containerid=1076031748075785&page=1";
//        String url = consts.baseWebsiteUrl;
        try {
            Document document = connection(url);
            log.info(document.body().toString());
        } catch (ConnectErrorException e) {
            e.printStackTrace();
        }
    }

    Document connection(String url) throws ConnectErrorException {
        Document res;
        String userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36";
        int time = 0;
        Map<String, String> header = new HashMap<>(10);
        header.put("Host", "m.weibo.cn");
        header.put("Referer", "https://m.weibo.cn/u/1748075785");
        header.put("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:60.0) Gecko/20100101 Firefox/60.0");
        header.put("X-Requested-With", "XMLHttpRequest");
        while (true) {
            try {

                res = Jsoup.connect(url).timeout(consts.outOfTime).ignoreContentType(true).get();
//                Connection connection = Jsoup.connect("https://m.weibo.cn/api/container/getIndex?type=uid&value=5650807778&containerid=1076031748075785&page=1");
//                Document document = connection.ignoreContentType(true).get();
                Element body = res.body();
                JSONObject jsonObject = JSONObject.parseObject(body.text());
                System.out.println("jsonObject = " + jsonObject);
//                return res;
            } catch (IOException e) {
                log.info(String.format("%s断线重连第%d次", url, (++time)));
                if (time > consts.retryTimes) {
                    throw new ConnectErrorException(url);
                }
            }
        }
    }


}

