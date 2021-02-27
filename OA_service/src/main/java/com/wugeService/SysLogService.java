package com.wugeService;

import com.wugeDomain.SysLog;

import java.util.List;

public interface SysLogService {
    void save(SysLog sysLog);
    List<SysLog> findAll();
}
