package com.dao;

import java.sql.Timestamp;
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

import com.domain.ComReferee;

/**
 * A data access object (DAO) providing persistence and search support for
 * ComReferee entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see ComReferee
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ComRefereeDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ComRefereeDAO.class);
	// property constants
	public static final String REFEREE_RESULT = "refereeResult";
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

	public void save(ComReferee transientInstance) {
		log.debug("saving ComReferee instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ComReferee persistentInstance) {
		log.debug("deleting ComReferee instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ComReferee findById(String id) {
		log.debug("getting ComReferee instance with id: " + id);
		try {
			ComReferee instance = (ComReferee) getCurrentSession().get(
					"com.domain.ComReferee", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ComReferee> findByExample(ComReferee instance) {
		log.debug("finding ComReferee instance by example");
		try {
			List<ComReferee> results = (List<ComReferee>) getCurrentSession()
					.createCriteria("com.domain.ComReferee")
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
		log.debug("finding ComReferee instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ComReferee as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ComReferee> findByRefereeResult(Object refereeResult) {
		return findByProperty(REFEREE_RESULT, refereeResult);
	}

	public List<ComReferee> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all ComReferee instances");
		try {
			String queryString = "from ComReferee";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ComReferee merge(ComReferee detachedInstance) {
		log.debug("merging ComReferee instance");
		try {
			ComReferee result = (ComReferee) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ComReferee instance) {
		log.debug("attaching dirty ComReferee instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ComReferee instance) {
		log.debug("attaching clean ComReferee instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ComRefereeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ComRefereeDAO) ctx.getBean("ComRefereeDAO");
	}
}