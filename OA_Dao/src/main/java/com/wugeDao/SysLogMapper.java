package com.wugeDao;

import com.wugeDomain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysLogMapper {
    @Insert("insert into sysLog values (null,#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);
    @Select("select *from syslog")
    List<SysLog> findAll();
}
