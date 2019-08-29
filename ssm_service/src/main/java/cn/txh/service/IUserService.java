package cn.txh.service;

import cn.txh.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService{

    /**
     * 用户管理的方法
     * 查询所有
     * @return
     */
    List<UserInfo> findAll() throws Exception;

    /**
     * 用户保存的方法
     * @param userInfo
     */
    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;
}
