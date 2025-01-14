package com.example.Commodity.repository;

import com.example.Commodity.domain.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface CommodityDao extends JpaRepository<Commodity, Long> {

    Commodity findCommodityByName(String name);


}
