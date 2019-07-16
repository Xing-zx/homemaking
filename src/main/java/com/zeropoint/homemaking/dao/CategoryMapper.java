package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     *  添加父类
     * @param record 父类
     * @return 状态
     */
    int insert(Category record);

    /**
     *  主键查询
     * @param id  id
     * @return category
     */
    Category selectByPrimaryKey(Integer id);

    /**
     *  全部列表
     * @return 列表
     */

    List<Category> selectAll();

    /**
     *  更新/修改
     * @param record 更新内容
     * @return 状态
     */

    int updateByPrimaryKey(Category record);

    /**
     *
     * 子菜单列表
     * @param parentName  父级名称
     * @return 证书列表
     */
    List<String> getChildListByName(String parentName);


    /** 添加子类
     * @param parent  父类名称
     * @param child 新增子类名称
     * @return 状态
     */
    int insertByParent(String parent, String child);

}

