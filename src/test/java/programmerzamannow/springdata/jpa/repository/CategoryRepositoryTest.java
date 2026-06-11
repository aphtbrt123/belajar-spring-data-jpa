package programmerzamannow.springdata.jpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import programmerzamannow.springdata.jpa.entity.Category;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void testCreate() {
        Category category = new Category();
        category.setName("GADGET");

        categoryRepository.save(category);
        Assertions.assertNotNull(category.getId());
    }

    @Test
    void testUpdate() {
        Category category = categoryRepository.findById(1L).orElse(null);
        Assertions.assertNotNull(category);

        category.setName("GADGET MURAH");
        categoryRepository.save(category);

        category = categoryRepository.findById(1L).orElse(null);
        Assertions.assertNotNull(category);
        Assertions.assertEquals("GADGET MURAH", category.getName());
    }
}