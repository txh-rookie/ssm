package cn.txh.dao;

import cn.txh.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao{
    /**
     * 根据id查询信息
     * @return
     * @throws Exception
     */
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findById(String ordersId) throws Exception;
}
