package com.baiyangmu.memotask.dao;

import com.baiyangmu.memotask.entity.MemoLink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 备忘录关联表(MemoLink)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-11 15:45:52
 */
@Mapper
public interface MemoLinkDao {

    /**
     * 通过ID查询单条数据
     *
     * @param linkId 主键
     * @return 实例对象
     */
    MemoLink queryById(Integer linkId);

    /**
     * 查询指定行数据
     *
     * @param memoLink 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<MemoLink> queryAllByLimit(MemoLink memoLink, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param memoLink 查询条件
     * @return 总行数
     */
    long count(MemoLink memoLink);

    /**
     * 新增数据
     *
     * @param memoLink 实例对象
     * @return 影响行数
     */
    int insert(MemoLink memoLink);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MemoLink> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MemoLink> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MemoLink> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MemoLink> entities);

    /**
     * 修改数据
     *
     * @param memoLink 实例对象
     * @return 影响行数
     */
    int update(MemoLink memoLink);

    /**
     * 通过主键删除数据
     *
     * @param linkId 主键
     * @return 影响行数
     */
    int deleteById(Integer linkId);

}

