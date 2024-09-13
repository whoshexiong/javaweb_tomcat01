package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DishMapper {

    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    /**
     * 存储菜品和口味信息
     */
    @AutoFill(value = OperationType.INSERT)
    void insert(Dish dish);

    @Delete("delete from dish where id = #{id}")
    void delete(Long id);

    /**
     * 根据id获得dish对象
     * @param id
     * @return
     */
    @Select("select * from dish where id = #{id}")
    Dish getById(Long id);

    /**
     * 进行批量的删除
     * @param ids
     */
    void deleteByIds(List<Long> ids);

    /**
     * 对dish信息进行修改
     * @param dish
     */
    @AutoFill(OperationType.UPDATE)
    void update(Dish dish);

    /**
     *根据dish封装的categoryId和status查找套餐包含的起售菜品
     * @param dish
     * @return
     */
    List<Dish> list(Dish dish);

    /**
     * 对id的菜品进行起售状态的设置
     * @param status
     * @param id
     */
    @Update("update dish set status = #{status} where id = #{id}")
    void updateStatus(Integer status, Long id);
}
