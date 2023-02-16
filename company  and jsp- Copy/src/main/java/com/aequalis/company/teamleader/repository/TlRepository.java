package com.aequalis.company.teamleader.repository;

import com.aequalis.company.teamleader.dao.TlDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TlRepository extends JpaRepository<TlDao,Integer> {
    TlDao findByTeamLeadeId(Integer id);
}
