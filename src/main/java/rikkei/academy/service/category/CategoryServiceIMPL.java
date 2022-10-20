package rikkei.academy.service.category;

import rikkei.academy.model.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryServiceIMPL implements ICategoryService {

    private static final Map<Integer, Category> categories = new HashMap<>();
    private static int lastId = 0;

    static {
        categories.put(1, new Category(1, "RED"));
        lastId++;
        categories.put(2, new Category(2, "BLUE"));
        lastId++;
        categories.put(3, new Category(3, "GREEN"));
        lastId++;
        categories.put(4, new Category(4, "YELLOW"));
        lastId++;
    }

    @Override
    public List<Category> findAll() {
        return new ArrayList<>(categories.values());
    }

    @Override
    public void save(Category category) {
        category.setId(++lastId);
        categories.put(category.getId(), category);
    }

    @Override
    public Category findById(int id) {
        return categories.get(id);
    }

    @Override
    public void update(int id, Category category) {
        categories.put(id, category);
    }

    @Override
    public void remove(int id) {
        categories.remove(id);
    }
}