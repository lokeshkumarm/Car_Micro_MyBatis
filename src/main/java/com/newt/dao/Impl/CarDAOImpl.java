package com.newt.dao.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.newt.controller.CarController;
import com.newt.dao.model.Car;
import com.newt.dao.repository.CarMapper;
import com.newt.dao.util.MyBatisSqlSessionFactory;
@Service
public class CarDAOImpl {

	private static Logger log = LoggerFactory.getLogger(CarDAOImpl.class);
	
	public Car findById(String id) {
		log.debug("Find Car by Id: "+ id);
		log.info("hihihih");
		log.error("hellohello");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
			return carMapper.selectByPrimaryKey(id);
		} finally {
			// If sqlSession is not closed
			// then database Connection associated this sqlSession will not be
			// returned to pool
			// and application may run out of connections.
			sqlSession.close();
		}
	}
	
	public void deleteById(String id){
		log.debug("Delete Car by Id: "+ id);
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
			carMapper.deleteCar(id);
			sqlSession.commit(true);
		} finally {
			// If sqlSession is not closed
			// then database Connection associated this sqlSession will not be
			// returned to pool
			// and application may run out of connections.
			sqlSession.close();
		}
	}
}
