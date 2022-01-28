CREATE TABLE blog_categories (
  blog_category_id INT NOT NULL,
   blog_post_id INT NOT NULL,
   CONSTRAINT pk_blog_categories PRIMARY KEY (blog_category_id, blog_post_id)
);

CREATE TABLE blog_category (
  id INT AUTO_INCREMENT NOT NULL,
   category VARCHAR(255) NOT NULL,
   CONSTRAINT pk_blog_category PRIMARY KEY (id)
);

CREATE TABLE blog_post (
  id INT AUTO_INCREMENT NOT NULL,
   img VARCHAR(90) NOT NULL,
   date date NOT NULL,
   title VARCHAR(30) NOT NULL,
   content VARCHAR(30) NOT NULL,
   CONSTRAINT pk_blog_post PRIMARY KEY (id)
);

ALTER TABLE blog_categories ADD CONSTRAINT fk_blocat_on_blog_category FOREIGN KEY (blog_category_id) REFERENCES blog_category (id);

ALTER TABLE blog_categories ADD CONSTRAINT fk_blocat_on_blog_post FOREIGN KEY (blog_post_id) REFERENCES blog_post (id);