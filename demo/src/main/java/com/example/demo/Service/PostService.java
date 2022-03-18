package com.example.demo.Service;

import com.example.demo.Model.Post;
import com.example.demo.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;


    public List<Post> listAll(){
        return repository.findAll();
    }

    public void create(Post post){
        repository.save(post);
    }

    public Post updateById(Long id){
        return repository.findById(id).get();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
