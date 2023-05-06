package com.example.demo.repository;

import com.example.demo.domain.Commodity;
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface CommodityDao extends JpaRepository<Commodity, Long> {

    Commodity findCommodityByName(String name);


}
