package com.bike.user.service;

import com.bike.user.entity.Student;
import com.bike.user.entity.TAccount;

/**
 * Created by a700 on 16/9/23.
 */
public interface StudentService {
    public Student getStudent();

    public TAccount queryByPhone(String phone);

}
