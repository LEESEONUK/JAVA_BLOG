package iducs202012068.javaweb.fundmentals.repository;

import iducs202012068.javaweb.fundmentals.model.Blog;

import java.util.List;

public interface BlogDAO {

    int create(Blog b);

    Blog read(Blog b );

    List<Blog> readList();

    int update(Blog b);

    int delete(Blog b);
}
