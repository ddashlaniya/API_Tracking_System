package com.apicheck.Apicheker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apicheck.Apicheker.bean.ApiBean;
@Repository
public interface RepositoryInter extends JpaRepository<ApiBean, Integer>{

}
