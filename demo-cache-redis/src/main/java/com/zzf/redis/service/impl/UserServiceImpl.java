package com.zzf.redis.service.impl;

import com.google.common.collect.Maps;
import com.zzf.redis.domain.User;
import com.zzf.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author zzf
 * @date 2021/3/24 11:27 下午
 */
@Slf4j
public class UserServiceImpl implements UserService {
    /**
     * 模拟数据库
     */
    private static final Map<Long, User> DATEBASES = Maps.newConcurrentMap();

    /**
     * 初始化数据
     */
    static {
        DATEBASES.put(1L, new User(1L, "zzf1"));
        DATEBASES.put(2L, new User(2L, "zzf2"));
        DATEBASES.put(3L, new User(3L, "zzf3"));
    }

    @Override
    public User get(Long id) {
        log.info("查询用户id=" + id);
        return DATEBASES.get(id);
    }

    @Override
    public User saveOrUpdate(User user) {
        DATEBASES.put(user.getId(), user);
        log.info("保存用户id=" + user.getId());
        return user;
    }

    @Override
    public void delete(Long id) {
        DATEBASES.remove(id);
        log.info("删除用户id=" + id);
    }
}