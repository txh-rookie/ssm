package cn.txh.dao;

import cn.txh.domain.Orders;
import cn.txh.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao{
    @Select("select * from orders")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",
                    javaType = Product.class,
                    one = @One(select = "cn.txh.dao.IProductDao.findById")),
    })
    List<Orders> findAll() throws Exception;

    /**
     * 订单详情的方法
     * @param ordersId
     * @return
     */
    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",
                    javaType = Product.class,
                    one = @One(select = "cn.txh.dao.IProductDao.findById")),
            @Result(column = "id",property = "travellers",many = @Many(select = "cn.txh.dao.ITravellerDao.findById")),
            @Result(column = "memberId",property = "member",one = @One(select = "cn.txh.dao.IMemberDao.findById")),
    })
     public Orders findById(String ordersId) throws Exception;
}
