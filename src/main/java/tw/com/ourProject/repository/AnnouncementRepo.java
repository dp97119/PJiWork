package tw.com.ourProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.ourProject.model.Announcement;

public interface AnnouncementRepo extends JpaRepository<Announcement, Integer> {

}
