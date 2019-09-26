package com.diao.home.qiqi;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * QiMapper
 */
@Mapper
public interface QiMapper {

    @Insert("insert into h_qiqi_pic (`categoryId`,`picName`) values (#{categoryId},#{picName})")
    void savePic(QiPicModel qiModel);

    @Select("select * from h_qiqi_category")
    List<QiCategoryModel> queryAllCategory();

    @Select("select * from h_qiqi_pic where `categoryId`=#{categoryId} order by id desc limit #{start},20")
    List<QiPicModel> queryPicInfo(Integer categoryId, int start);
}