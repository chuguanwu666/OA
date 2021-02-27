package com.wugeService.impl;

import com.wugeDao.SysLogMapper;
import com.wugeDomain.SysLog;
import com.wugeService.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SyslogServiceImpl implements SysLogService {


    @Autowired
    private SysLogMapper sysLogMapper;
    @Override
    public void save(SysLog sysLog) {
        sysLogMapper.save(sysLog);
    }
    @Override
    public List<SysLog> findAll() {
        return sysLogMapper.findAll();
    }
}
