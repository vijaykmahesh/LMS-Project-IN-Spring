package com.express.selexplms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.express.selexplms.dao.LessonDao;
import com.express.selexplms.entity.Lesson;

@Service
public class LessonServiceImpl implements LessonService {
	
	@Autowired
	LessonDao lessonDao;

	@Transactional
	@Override
	public void saveLesson(Lesson lesson) {
		
		lessonDao.save(lesson);
	}

}
