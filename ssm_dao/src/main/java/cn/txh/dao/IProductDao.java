package cn.txh.dao;

import cn.txh.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IProductDao{

    /**
     * 查询所有的方法
     *
     * @return
     * @throws Exception
     */
    @Select("select * from product")
    @Transactional
    public List<Product> findAll() throws Exception;

    /**
     * 保存方法
     *
     * @param product
     * @throws Exception
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    @Delete("delete from product where id=#{id}")
    void delete(String id) throws Exception;
    @Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime}," +
            "productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where productNum=#{productNum}")
    int update(Product product) throws Exception;
    @Select("select * from product where id = #{id}")
    Product findById(String id) throws Exception;
}
