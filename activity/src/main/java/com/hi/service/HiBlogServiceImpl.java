package com.hi.service;

import com.hi.model.HiBlog;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by a700 on 17/3/3.
 */
@Service("hiBlogService")
public class HiBlogServiceImpl implements HiBlogService{
    @Override
    public boolean addHiBlog(HiBlog hiBlog) {
        return false;
    }

    @Override
    public HiBlog queryHiBlog(Integer id) {
        return null;
    }

    @Override
    public List<HiBlog> queryAllHiBlog() {
        return null;
    }
}
