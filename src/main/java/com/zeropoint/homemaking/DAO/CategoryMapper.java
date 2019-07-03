package com.zeropoint.homemaking.DAO;

import com.zeropoint.homemaking.Entitys.Category;
import java.util.List;

public interface CategoryMapper {
    int insert(Category record);

    List<Category> selectAll();
}