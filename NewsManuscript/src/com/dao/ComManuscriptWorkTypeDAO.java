package com.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.domain.ComManuscriptWorkType;

/**
 * A data access object (DAO) providing persistence and search support for
 * ComManuscriptWorkType entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see ComManuscriptWorkType
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ComManuscriptWorkTypeDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ComManuscriptWorkTypeDAO.class);
	// property constants
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

	public void save(ComManuscriptWorkType transientInstance) {
		log.debug("saving ComManuscriptWorkType instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ComManuscriptWorkType persistentInstance) {
		log.debug("deleting ComManuscriptWorkType instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ComManuscriptWorkType findById(String id) {
		log.debug("getting ComManuscriptWorkType instance with id: " + id);
		try {
			ComManuscriptWorkType instance = (ComManuscriptWorkType) getCurrentSession()
					.get("com.domain.ComManuscriptWorkType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ComManuscriptWorkType> findByExample(
			ComManuscriptWorkType instance) {
		log.debug("finding ComManuscriptWorkType instance by example");
		try {
			List<ComManuscriptWorkType> results = (List<ComManuscriptWorkType>) getCurrentSession()
					.createCriteria("com.domain.ComManuscriptWorkType")
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
		log.debug("finding ComManuscriptWorkType instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ComManuscriptWorkType as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ComManuscriptWorkType> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all ComManuscriptWorkType instances");
		try {
			String queryString = "from ComManuscriptWorkType";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ComManuscriptWorkType merge(ComManuscriptWorkType detachedInstance) {
		log.debug("merging ComManuscriptWorkType instance");
		try {
			ComManuscriptWorkType result = (ComManuscriptWorkType) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ComManuscriptWorkType instance) {
		log.debug("attaching dirty ComManuscriptWorkType instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ComManuscriptWorkType instance) {
		log.debug("attaching clean ComManuscriptWorkType instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ComManuscriptWorkTypeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ComManuscriptWorkTypeDAO) ctx
				.getBean("ComManuscriptWorkTypeDAO");
	}
}