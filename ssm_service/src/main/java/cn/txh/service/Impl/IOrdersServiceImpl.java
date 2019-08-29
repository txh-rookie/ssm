package cn.txh.service.Impl;

import cn.txh.dao.IOrdersDao;
import cn.txh.domain.Orders;
import cn.txh.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IOrdersServiceImpl implements IOrdersService{
    @Autowired
    private IOrdersDao ordersDao;
    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        //配置page的参数 参数pageNum是页码数 参数pagesize是每一页显示的条数
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }
}
