package com.jhstudio.projectfeel.repo;

import com.jhstudio.projectfeel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectFeelsRepo extends JpaRepository<User, Long> {


}
