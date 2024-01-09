package com.java.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.entity.Mobile;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Integer> {

}
