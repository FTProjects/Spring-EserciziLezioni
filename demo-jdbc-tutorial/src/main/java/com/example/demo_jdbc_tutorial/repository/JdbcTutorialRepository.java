package com.example.demo_jdbc_tutorial.repository;

import com.example.demo_jdbc_tutorial.model.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcTutorialRepository implements TutorialRepository {

    private final JdbcTemplate jdbc;

    @Autowired
    public JdbcTutorialRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int save(Tutorial tutorial) {
        String sql = "INSERT INTO tutorials (title, category, description, published) VALUES (?, ?, ?, ?)";
        return jdbc.update(sql,
                tutorial.getTitle(),
                tutorial.getCategory(),
                tutorial.getDescription(),
                tutorial.isPublished()
        );
    }

    @Override
    public int update(Tutorial tutorial) {
        String sql = "UPDATE tutorials SET title = ?, category = ?, description = ?, published = ? WHERE id = ?";
        return jdbc.update(sql,
                tutorial.getTitle(),
                tutorial.getCategory(),
                tutorial.getDescription(),
                tutorial.isPublished(),
                tutorial.getId()
        );
    }

    @Override
    public Tutorial findById(Long id) {
        String sql = "SELECT * FROM tutorials WHERE id = ?";
        return jdbc.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Tutorial.class), // row mapper di default
                id
        );
    }

    @Override
    public List<Tutorial> findAll() {
        String sql = "SELECT * FROM tutorials";
        return jdbc.query(sql, BeanPropertyRowMapper.newInstance(Tutorial.class));
    }

    @Override
    public List<Tutorial> findByPublished(boolean published) {
        String sql = "SELECT * FROM tutorials WHERE published = ?";
        return jdbc.query(sql, BeanPropertyRowMapper.newInstance(Tutorial.class), published);
    }

    @Override
    public List<Tutorial> findByCategory(String category) {
        String sql = "SELECT * FROM tutorials WHERE category = ?";
        return jdbc.query(sql, BeanPropertyRowMapper.newInstance(Tutorial.class), category);
    }

    @Override
    public List<Tutorial> findAllByTitleContaining(String title) {
        String sql = "SELECT * FROM tutorials WHERE title LIKE'%" + title + "%' ";
        return jdbc.query(sql, BeanPropertyRowMapper.newInstance(Tutorial.class));
    }

    @Override
    public int deleteById(Long id) {
        String sql = "DELETE FROM tutorials WHERE id = ?";
        return jdbc.update(sql, id);
    }

    @Override
    public int deleteAll() {
        String sql = "DELETE FROM tutorials";
        return jdbc.update(sql);
    }
}
