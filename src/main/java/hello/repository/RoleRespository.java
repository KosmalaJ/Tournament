package hello.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hello.model.Role;

@Repository("roleRepository")
 public interface RoleRespository extends JpaRepository<Role, Integer> {

    Role findByRole(String role);
}