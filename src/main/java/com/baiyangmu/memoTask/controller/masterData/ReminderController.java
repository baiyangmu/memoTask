package com.baiyangmu.memotask.controller.masterData;

import com.baiyangmu.memotask.entity.masterData.Reminder;
import com.baiyangmu.memotask.service.masterData.ReminderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 提醒事项表(Reminder)表控制层
 *
 * @author makejava
 * @since 2023-03-11 15:46:23
 */
@RestController
@RequestMapping("reminder")
public class ReminderController {
    /**
     * 服务对象
     */
    @Resource
    private ReminderService reminderService;

    /**
     * 分页查询
     *
     * @param reminder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Reminder>> queryByPage(Reminder reminder, PageRequest pageRequest) {
        return ResponseEntity.ok(this.reminderService.queryByPage(reminder, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Reminder> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.reminderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param reminder 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Reminder> add(Reminder reminder) {
        return ResponseEntity.ok(this.reminderService.insert(reminder));
    }

    /**
     * 编辑数据
     *
     * @param reminder 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Reminder> edit(Reminder reminder) {
        return ResponseEntity.ok(this.reminderService.update(reminder));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.reminderService.deleteById(id));
    }

}

