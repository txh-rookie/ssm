package cn.txh.dao;

import cn.txh.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao{
    /**
     * 根据id查询信息
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from member where id=#{id}")
    public Member findById(String id) throws Exception;
}
