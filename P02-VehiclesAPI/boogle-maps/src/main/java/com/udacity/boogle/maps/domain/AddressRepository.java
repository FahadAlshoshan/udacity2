package com.udacity.boogle.maps.domain;

import org.hibernate.mapping.PrimaryKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Coordinates> {

}
