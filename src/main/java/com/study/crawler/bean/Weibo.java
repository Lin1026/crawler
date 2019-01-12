package com.study.crawler.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class Weibo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibo.ID
     *
     * @mbg.generated Sat Jan 12 14:24:28 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibo.AUTHOR
     *
     * @mbg.generated Sat Jan 12 14:24:28 CST 2019
     */
    private String author;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibo.CREATE_TIME
     *
     * @mbg.generated Sat Jan 12 14:24:28 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibo.TEXT
     *
     * @mbg.generated Sat Jan 12 14:24:28 CST 2019
     */
    private String text;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibo.IMAGE
     *
     * @mbg.generated Sat Jan 12 14:24:28 CST 2019
     */
    private String image;

}