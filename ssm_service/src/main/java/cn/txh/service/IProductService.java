package cn.txh.service;

import cn.txh.domain.Product;

import java.util.List;

public interface IProductService{
    /**
     * 查询所有的方法
     * @return
     * @throws Exception
     */
    public List<Product> findAll(int page ,int size) throws Exception;

    /**
     * 保存方法
     * @throws Exception
     */
    void save(Product product) throws Exception;

    /**
     * 删除方法
     * @param id
     * @throws Exception
     */
    void delete(String id) throws Exception;

    int update(Product product) throws Exception;

    Product findById(String id) throws Exception;

}
