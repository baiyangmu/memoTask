package com.baiyangmu.memotask.service.masterData;

import com.baiyangmu.memotask.entity.masterData.Reminder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 提醒事项表(Reminder)表服务接口
 *
 * @author makejava
 * @since 2023-03-11 15:47:40
 */
public interface ReminderService {

    /**
     * 通过ID查询单条数据
     *
     * @param reminderId 主键
     * @return 实例对象
     */
    Reminder queryById(Integer reminderId);

    /**
     * 分页查询
     *
     * @param reminder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Reminder> queryByPage(Reminder reminder, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param reminder 实例对象
     * @return 实例对象
     */
    Reminder insert(Reminder reminder);

    /**
     * 修改数据
     *
     * @param reminder 实例对象
     * @return 实例对象
     */
    Reminder update(Reminder reminder);

    /**
     * 通过主键删除数据
     *
     * @param reminderId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer reminderId);

}
