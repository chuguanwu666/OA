package com.wugeDao;

import com.wugeDomain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {

    @Select("select *from member where id=#{id}")
    Member findById(int id);
}
