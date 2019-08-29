package cn.txh.service.Impl;

import cn.txh.dao.IProductDao;
import cn.txh.domain.Product;
import cn.txh.service.IProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service//开启spring框架
@Transactional
public class IProductServiceImpl implements IProductService{
    @Autowired
    private IProductDao productDao;

    public List<Product> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return productDao.findAll();
    }

    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    public void delete(String id) throws Exception {
        productDao.delete(id);
    }

    @Override
    public int update(Product product) throws Exception {
          return productDao.update(product);
    }

    public Product findById(String id) throws Exception {
         return productDao.findById(id);
    }

}
