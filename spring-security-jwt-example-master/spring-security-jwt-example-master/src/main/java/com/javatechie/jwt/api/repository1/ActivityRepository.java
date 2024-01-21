package com.javatechie.jwt.api.repository1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javatechie.jwt.api.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    // คุณสามารถเพิ่มเมธอดเพิ่มเติมตามต้องการ
}
