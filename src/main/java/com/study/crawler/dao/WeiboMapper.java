package com.study.crawler.dao;

import com.study.crawler.bean.Weibo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface WeiboMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibo
     *
     * @mbg.generated Sat Jan 12 14:24:28 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibo
     *
     * @mbg.generated Sat Jan 12 14:24:28 CST 2019
     */
    int insert(Weibo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibo
     *
     * @mbg.generated Sat Jan 12 14:24:28 CST 2019
     */
    List<Weibo> selectAll();

    Weibo selectByPrimaryKey(int id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibo
     *
     * @mbg.generated Sat Jan 12 14:24:28 CST 2019
     */
    int updateByPrimaryKey(Weibo record);

    int count();
}