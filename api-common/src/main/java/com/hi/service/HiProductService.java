package com.hi.service;

import com.hi.model.HiProduct;

import java.util.List;

/**
 * Created by a700 on 17/3/3.
 */
public interface HiProductService {

    public boolean addHiProduct(HiProduct hiProduct);

    public HiProduct queryHiProduct(Integer id);

    public List<HiProduct> queryAllHiProduct();
}
