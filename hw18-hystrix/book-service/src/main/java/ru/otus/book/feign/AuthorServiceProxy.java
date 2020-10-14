package ru.otus.book.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.library.model.Author;

@FeignClient(name = "author-service")
@RequestMapping(value = "/api")
public interface AuthorServiceProxy {

	@GetMapping(value = "/author")
  Author getAuthorByLastName(@RequestParam(value = "lastName") String lastName);
}
