package ru.otus.hw17.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.hw17.model.Comment;
import ru.otus.hw17.repository.CommentRepository;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = CommentServiceImpl.class)
class CommentServiceImplTest {

  @MockBean
  private CommentRepository commentRepository;

  @Autowired
  private CommentServiceImpl commentService;

  private Comment newComment;
  private Comment oldComment;

  @BeforeEach
  void beforeEach() {
    newComment = new Comment("0", "new comment", "1", new Date());
    oldComment = new Comment("1", "old comment", "2", new Date());
  }

  @Test
  void create() {
    when(commentRepository.save(newComment)).thenReturn(newComment);

    commentService.save(newComment);
    verify(commentRepository, times(1)).save(newComment);
  }

  @Test
  void update() {
    when(commentRepository.save(newComment)).thenReturn(newComment);

    commentService.save(newComment);
    verify(commentRepository, times(1)).save(newComment);
  }

  @Test
  void findAllByBookId() {
    List<Comment> comments = Collections.singletonList(oldComment);
    when(commentRepository.findAllByBookId(oldComment.getBookId())).thenReturn(comments);

    Assertions.assertEquals(comments, commentService.readAllForBook(oldComment.getBookId()));
  }
}
