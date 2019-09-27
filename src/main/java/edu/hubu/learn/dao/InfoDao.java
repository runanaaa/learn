package edu.hubu.learn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hubu.learn.entity.Info;

public interface InfoDao extends JpaRepository<Info, Long> {

}