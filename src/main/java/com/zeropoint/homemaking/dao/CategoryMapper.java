package com.zeropoint.homemaking.dao;

import com.zeropoint.homemaking.domain.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    int deleteByPrimaryKey1(Integer id);

    /**
     *  添加父类
     * @param record 父类
     * @return 状态
     */
    int insert1(Category record);

    /**
     *  主键查询
     * @param id  id
     * @return category
     */
    Category selectByPrimaryKey1(Integer id);

    /**
     *  全部列表
     * @return 列表
     */

    List<Category> selectAll1();

    /**
     *  更新/修改
     * @param record 更新内容
     * @return 状态
     */

    int updateByPrimaryKey1(Category record);

    /**
     *
     * 子菜单列表
     * @param parentName  父级名称
     * @return 证书列表
     */
    List<String> getChildListByName1(String parentName);


    /** 添加子类
     * @param parent  父类名称
     * @param child 新增子类名称
     * @return 状态
     */
    int insertByParent1(String parent, String child);

    /**
     *  条件查询
     * @param condition  注册时间,姓名,角色
     * @return the admin list
     */
    List<Category> selectByCondition1();

    int count1();

    List<Category> selectTree1(Integer parent);

    int updateStatus1(Integer id,Integer status);

    int delete1(@Param("ids")Integer[] ids);

}

