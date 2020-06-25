package ru.otus.hw04.core.domain;

import lombok.*;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Question {

  private final @NonNull String titleQuestion;
  private final @NonNull List<String> answerOptions;

}
