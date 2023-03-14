package com.baiyangmu.memotask.dao.masterData;

import com.baiyangmu.memotask.entity.masterData.Reminder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 提醒事项表(Reminder)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-11 15:46:23
 */
@Mapper
public interface ReminderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param reminderId 主键
     * @return 实例对象
     */
    Reminder queryById(Integer reminderId);

    /**
     * 查询指定行数据
     *
     * @param reminder 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Reminder> queryAllByLimit(Reminder reminder, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param reminder 查询条件
     * @return 总行数
     */
    long count(Reminder reminder);

    /**
     * 新增数据
     *
     * @param reminder 实例对象
     * @return 影响行数
     */
    int insert(Reminder reminder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Reminder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Reminder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Reminder> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Reminder> entities);

    /**
     * 修改数据
     *
     * @param reminder 实例对象
     * @return 影响行数
     */
    int update(Reminder reminder);

    /**
     * 通过主键删除数据
     *
     * @param reminderId 主键
     * @return 影响行数
     */
    int deleteById(Integer reminderId);

}

