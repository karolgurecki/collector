package org.karolgurecki.collector.domain.dao;

import org.karolgurecki.collector.domain.model.UserRole;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by: Karol Górecki
 * <a href="mailto:kagurecki@gmail.com?Subject=Autotask Question" target="_top">kagurecki (at) gmail.com</a>
 * Version: 0.01
 * Since: 0.01
 */
public interface RolesRepository extends CrudRepository<UserRole, Long> {
}
