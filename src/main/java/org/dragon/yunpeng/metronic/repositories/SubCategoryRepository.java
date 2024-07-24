package org.dragon.yunpeng.metronic.repositories;

import org.dragon.yunpeng.metronic.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
	List<SubCategory> findByCategoryId(Long categoryId);
}
