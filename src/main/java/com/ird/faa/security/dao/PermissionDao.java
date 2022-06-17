package com.ird.faa.security.dao;

import com.ird.faa.security.bean.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionDao extends JpaRepository<Permission, Long> {
    Permission findByName(String name);
}
