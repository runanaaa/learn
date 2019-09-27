package edu.hubu.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import edu.hubu.learn.dao.InfoDao;
import edu.hubu.learn.entity.Info;

@Service
public class InfoService {

    @Autowired
    private InfoDao userDao;

    public Info getUser(Long id) {
        return userDao.findById(id).get();
    }
}