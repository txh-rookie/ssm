package cn.txh.dao;

import cn.txh.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissions{

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;

}
