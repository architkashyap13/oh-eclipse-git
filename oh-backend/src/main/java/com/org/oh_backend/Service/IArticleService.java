package com.org.oh_backend.Service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import com.org.oh_backend.Model.Article;

public interface IArticleService {
	 //@Secured ({"ROLE_ADMIN"}) 
	 @PreAuthorize("hasRole('ADMIN')")
     List<Article> getAllArticles();
	 @Secured ({"ROLE_ADMIN", "ROLE_IRM"})
     Article getArticleById(int articleId);
	 @Secured ({"ROLE_ADMIN"})
     boolean addArticle(Article article);
	 @Secured ({"ROLE_ADMIN"})
     void updateArticle(Article article);
	 @Secured ({"ROLE_ADMIN"})
     void deleteArticle(int articleId);
}
