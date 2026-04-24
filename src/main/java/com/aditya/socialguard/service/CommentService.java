package com.aditya.socialguard.service;

import com.aditya.socialguard.entity.Comment;
import com.aditya.socialguard.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final RedisService redisService;

    public Comment addComment(Comment comment) {

    if (comment.getDepthLevel() > 20) {
            throw new RuntimeException("Depth limit exceeded");
        }

        boolean isBot = comment.getAuthorId() > 1000;

        if (isBot) {

            Long count = redisService.incrementBotCount(comment.getPostId());
            if (count > 100) {
                throw new RuntimeException("Too many bot replies");
            }

            redisService.incrementVirality(comment.getPostId(), 1);

        } else {
            redisService.incrementVirality(comment.getPostId(), 50);
        }

        comment.setCreatedAt(LocalDateTime.now());
        return commentRepository.save(comment);
    }
}