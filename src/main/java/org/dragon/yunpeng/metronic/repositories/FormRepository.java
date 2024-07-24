package org.dragon.yunpeng.metronic.repositories;

import java.util.List;

import org.dragon.yunpeng.metronic.entities.Form;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends CrudRepository<Form, Long> {

}
