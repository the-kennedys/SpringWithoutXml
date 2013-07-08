package org.knoxkennedy.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserRepository
{
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    public List<User> getAllUsers()
    {
        return this.hibernateTemplate.loadAll(User.class);
    }
    
    public Integer createUser(User user)
    {
        User mergeUser = this.hibernateTemplate.merge(user);
        return mergeUser.getId();
    }
}