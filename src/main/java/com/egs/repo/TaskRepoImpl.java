package com.egs.repo;

import com.egs.model.Comment;
import com.egs.model.Task;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @author Hayk_Mkhitaryan
 */
public class TaskRepoImpl extends AbstractDao<Long, Task> implements TaskRepo {

    @SuppressWarnings("unchecked")
    public List<Task> findAll() {
        final Criteria criteria = createEntityCriteria();

        return (List<Task>) criteria.list();
    }

    public Task findById(Long id) {
        return getByKey(id);
    }

    @Override
    public void save(Task task) {
        persist(task);
    }

    @SuppressWarnings("unchecked")
    public List<Task> findAllByUserId(Long userId) {
        final Criteria criteria = createEntityCriteria();
        final Criteria userCriteria = criteria.createCriteria("user");
        userCriteria.add(Restrictions.eq("id", userId));

        return (List<Task>) criteria.list();
    }

    @Override
    public void deleteById(Long id) {
        final Task task = getByKey(id);
        delete(task);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Comment> getAllCommentsById(Long id) {
        final Criteria criteria = createEntityCriteria();
        final Criteria commentCriteria = criteria.createCriteria("comment");
        commentCriteria.add(Restrictions.eq("TASK_ID", id));

        return (List<Comment>) criteria.list();
    }
}
