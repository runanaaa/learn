package edu.hubu.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.hubu.learn.dao.InfoDao;
import edu.hubu.learn.entity.Info;

@Service
public class InfoService {

    @Autowired
    private InfoDao infoDao;

    public Info getInfo(Long id) {
        return infoDao.findById(id).get();
    }
    public List<Info> getInfos(){
        return infoDao.findAll(new Sort(Direction.DESC, "id"));
}
  public List<Info> searchInfos(String keyword) {
        Info info = new Info();
       
        info.setUSERNAME(keyword);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("USERNAME", match->match.contains());
        Example<Info> example = Example.of(info, matcher);
        Sort sort = new Sort(Direction.DESC, "id");
        return infoDao.findAll(example, sort);
  }

public Info addInfo(Info info) {
    return infoDao.save(info);
}

public void deleteInfo(Long id) {
    infoDao.deleteById(id);
}

public void modifyInfo(Info info) {
    infoDao.save(info);
}
} 
