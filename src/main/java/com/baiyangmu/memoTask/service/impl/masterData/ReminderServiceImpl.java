package com.baiyangmu.memotask.service.impl.masterData;

import com.baiyangmu.memotask.entity.masterData.Reminder;
import com.baiyangmu.memotask.dao.masterData.ReminderDao;
import com.baiyangmu.memotask.service.masterData.ReminderService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 提醒事项表(Reminder)表服务实现类
 *
 * @author makejava
 * @since 2023-03-11 15:46:23
 */
@Service("reminderService")
public class ReminderServiceImpl implements ReminderService {
    @Resource
    private ReminderDao reminderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param reminderId 主键
     * @return 实例对象
     */
    @Override
    public Reminder queryById(Integer reminderId) {
        return this.reminderDao.queryById(reminderId);
    }

    /**
     * 分页查询
     *
     * @param reminder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Reminder> queryByPage(Reminder reminder, PageRequest pageRequest) {
        long total = this.reminderDao.count(reminder);
        return new PageImpl<>(this.reminderDao.queryAllByLimit(reminder, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param reminder 实例对象
     * @return 实例对象
     */
    @Override
    public Reminder insert(Reminder reminder) {
        this.reminderDao.insert(reminder);
        return reminder;
    }

    /**
     * 修改数据
     *
     * @param reminder 实例对象
     * @return 实例对象
     */
    @Override
    public Reminder update(Reminder reminder) {
        this.reminderDao.update(reminder);
        return this.queryById(reminder.getReminderId());
    }

    /**
     * 通过主键删除数据
     *
     * @param reminderId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer reminderId) {
        return this.reminderDao.deleteById(reminderId) > 0;
    }
}
