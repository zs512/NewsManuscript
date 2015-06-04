package com.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.domain.ComWorkType;

/**
 * A data access object (DAO) providing persistence and search support for
 * ComWorkType entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see ComWorkType
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ComWorkTypeDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ComWorkTypeDAO.class);
	// property constants
	public static final String WORK_TYPE_NAME = "workTypeName";
	public static final String STATUS = "status";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(ComWorkType transientInstance) {
		log.debug("saving ComWorkType instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ComWorkType persistentInstance) {
		log.debug("deleting ComWorkType instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ComWorkType findById(String id) {
		log.debug("getting ComWorkType instance with id: " + id);
		try {
			ComWorkType instance = (ComWorkType) getCurrentSession().get(
					"com.domain.ComWorkType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ComWorkType> findByExample(ComWorkType instance) {
		log.debug("finding ComWorkType instance by example");
		try {
			List<ComWorkType> results = (List<ComWorkType>) getCurrentSession()
					.createCriteria("com.domain.ComWorkType")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ComWorkType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ComWorkType as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ComWorkType> findByWorkTypeName(Object workTypeName) {
		return findByProperty(WORK_TYPE_NAME, workTypeName);
	}

	public List<ComWorkType> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all ComWorkType instances");
		try {
			String queryString = "from ComWorkType";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ComWorkType merge(ComWorkType detachedInstance) {
		log.debug("merging ComWorkType instance");
		try {
			ComWorkType result = (ComWorkType) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ComWorkType instance) {
		log.debug("attaching dirty ComWorkType instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ComWorkType instance) {
		log.debug("attaching clean ComWorkType instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ComWorkTypeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ComWorkTypeDAO) ctx.getBean("ComWorkTypeDAO");
	}
}