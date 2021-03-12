package com.xebia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xebia.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {

	Page<Article> findAll(Pageable paging);

}
