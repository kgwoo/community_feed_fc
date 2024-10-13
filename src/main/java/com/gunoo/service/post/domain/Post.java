package com.gunoo.service.post.domain;

import com.gunoo.service.common.domain.PositiveIntegerCounter;
import com.gunoo.service.post.domain.content.PostContent;
import com.gunoo.service.post.domain.content.PostPublicationState;
import com.gunoo.service.user.domain.User;

public class Post {

    private final Long id;
    private final User author;
    private final PostContent content;
    private final PositiveIntegerCounter likeCount;

    private PostPublicationState state;
 
    public Post(Long id, User author, String content) {
        if (author == null) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.author = author;
        this.content = new PostContent(content);
        this.likeCount = new PositiveIntegerCounter();
        this.state = PostPublicationState.PUBLIC;
    }

    public void like(User user) {
        if (this.author.equals(user)) {
            throw new IllegalArgumentException();
        }
        likeCount.increase();
    }

    public void unlike() {
        this.likeCount.decrease();
    }

    public void updatePost(User user, String updateContent, PostPublicationState state) {
        if (this.author.equals(user)) {
            throw new IllegalArgumentException();
        }
        this.state = state;
        this.content.updateContent(updateContent);
    }
}
