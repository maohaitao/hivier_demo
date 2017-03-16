package com.hi.service;

import com.hi.model.HiProduct;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import com.sf.common.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a700 on 17/3/16.
 */
@Service("hiProductService")
public class HiProductServiceImpl extends BaseService implements HiProductService {
    @Override
    public boolean addHiProduct(HiProduct hiProduct) {
        return false;
    }

    @Override
    public HiProduct queryHiProduct(Integer id) {
        return null;
    }

    @Override
    public List<HiProduct> queryAllHiProduct() {
        String sql = "select * from hi_product where p_status=? order by Id";
//        HiProduct product =new HiProduct();
//        product.setpStatus(1);
        List<Object> parmas = new ArrayList<>();
        parmas.add(1);
        try {
            return queryBySQL(sql,HiProduct.class,parmas);
        } catch (AppException e) {
            LogService.error("查询所有的失败:",e);
        }
        return null;
    }
}
