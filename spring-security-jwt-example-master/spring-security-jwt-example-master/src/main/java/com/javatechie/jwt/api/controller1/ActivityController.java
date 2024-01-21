package com.javatechie.jwt.api.controller1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javatechie.jwt.api.model.Activity;
import com.javatechie.jwt.api.repository1.ActivityRepository;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    // API สำหรับการเพิ่ม Activity
    @PostMapping("/add")
    public ResponseEntity<Activity> addActivity(@RequestBody Activity activity) {
        Activity savedActivity = activityRepository.save(activity);
        return new ResponseEntity<>(savedActivity, HttpStatus.CREATED);
    }

    // API สำหรับการดึงข้อมูลทั้งหมด
    @GetMapping("/all")
    public ResponseEntity<List<Activity>> getAllActivities() {
        List<Activity> activities = activityRepository.findAll();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    // API สำหรับการดึงข้อมูลตาม ID
    @GetMapping("/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Long id) {
        return activityRepository.findById(id)
                .map(activity -> new ResponseEntity<>(activity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // API สำหรับการอัปเดต Activity
    @PutMapping("/update/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable Long id, @RequestBody Activity updatedActivity) {
        return activityRepository.findById(id)
                .map(existingActivity -> {
                    updatedActivity.setIdmovie(existingActivity.getIdmovie());
                    Activity savedActivity = activityRepository.save(updatedActivity);
                    return new ResponseEntity<>(savedActivity, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // API สำหรับการลบ Activity
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long id) {
        if (activityRepository.existsById(id)) {
            activityRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
