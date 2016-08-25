package com.lip.demo.data.impl;

import com.lip.demo.data.UsersRepository;
import com.lip.demo.model.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author lipeng32768@163.com
 * @version v1.0.0
 * @ClassName: UsersRepositoryImpl
 * @Description: TODO
 * @date 2016/8/25 11:27
 */
@Repository
public class UsersRepositoryImpl extends BaseRespositoryImpl<Users> implements UsersRepository {

    @PersistenceContext
    EntityManager em;

    public Users findUserByPhoneNumber(String phoneNumber) {

        if (phoneNumber == null) {
            return null;
        }
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Users> criteria = cb.createQuery(Users.class);
        Root<Users> root = criteria.from(Users.class);
        criteria.select(root).where(cb.equal(root.get("phoneNumber"),phoneNumber));
        try {
            return em.createQuery(criteria).getSingleResult();
        } catch (Exception e) {
            //log.info("countEntities Exception: " + clazz.getTypeName()+e.getMessage());
            return null;
        }
    }


    public Users findUserByName(String name) {
        if (name == null) {
            return null;
        }
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Users> criteria = cb.createQuery(Users.class);
        Root<Users> root = criteria.from(Users.class);
        criteria.select(root).where(cb.equal(root.get("name"),name));
        try {
            return em.createQuery(criteria).getSingleResult();
        } catch (Exception e) {
            //log.info("countEntities Exception: " + clazz.getTypeName()+e.getMessage());
            return null;
        }
    }
}
