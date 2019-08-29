package cn.txh.service.Impl;

import cn.txh.dao.IRoleDao;
import cn.txh.domain.Role;
import cn.txh.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRoleServiceImpl implements IRoleService{
    @Autowired
    private IRoleDao roleDao;
    @Override
    public List<Role> findAll() throws Exception {
         return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
