package edu.hubu.learn.service;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import edu.hubu.learn.dao.InfoDao;
import edu.hubu.learn.entity.Info;

@Service
public class InfoService {

    @Autowired
    private InfoDao infoDao;

    public Info getUser(Long id) {
        return infoDao.findById(id).get();
    }
    public List<Info> getInfos(){
        return  infoDao.findAll();
}
public Info addInfo(Info info) {



    return infoDao.save(info);



}
}