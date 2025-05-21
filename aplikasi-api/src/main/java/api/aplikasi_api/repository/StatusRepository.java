package api.aplikasi_api.repository;

import api.aplikasi_api.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
