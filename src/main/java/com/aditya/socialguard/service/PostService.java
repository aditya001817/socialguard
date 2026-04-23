package com.aditya.socialguard.service;

import com.aditya.socialguard.entity.Post;
import com.aditya.socialguard.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post createPost(Post post) {
        post.setCreatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }

    public void likePost(Long postId) {
        System.out.println("Post liked: " + postId);
    }
}