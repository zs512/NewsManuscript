package com.dao;

import java.sql.Timestamp;
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

import com.domain.ComManuscript;

/**
 * A data access object (DAO) providing persistence and search support for
 * ComManuscript entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see ComManuscript
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ComManuscriptDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ComManuscriptDAO.class);
	// property constants
	public static final String MANUSCRIPT_TITLE = "manuscriptTitle";
	public static final String MANUSCRIPT_BODY = "manuscriptBody";
	public static final String MANUSCRIPT_STATUS = "manuscriptStatus";
	public static final String MANUSCRIPT_PATH = "manuscriptPath";
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

	public void save(ComManuscript transientInstance) {
		log.debug("saving ComManuscript instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ComManuscript persistentInstance) {
		log.debug("deleting ComManuscript instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ComManuscript findById(String id) {
		log.debug("getting ComManuscript instance with id: " + id);
		try {
			ComManuscript instance = (ComManuscript) getCurrentSession().get(
					"com.domain.ComManuscript", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ComManuscript> findByExample(ComManuscript instance) {
		log.debug("finding ComManuscript instance by example");
		try {
			List<ComManuscript> results = (List<ComManuscript>) getCurrentSession()
					.createCriteria("com.domain.ComManuscript")
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
		log.debug("finding ComManuscript instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ComManuscript as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ComManuscript> findByManuscriptTitle(Object manuscriptTitle) {
		return findByProperty(MANUSCRIPT_TITLE, manuscriptTitle);
	}

	public List<ComManuscript> findByManuscriptBody(Object manuscriptBody) {
		return findByProperty(MANUSCRIPT_BODY, manuscriptBody);
	}

	public List<ComManuscript> findByManuscriptStatus(Object manuscriptStatus) {
		return findByProperty(MANUSCRIPT_STATUS, manuscriptStatus);
	}

	public List<ComManuscript> findByManuscriptPath(Object manuscriptPath) {
		return findByProperty(MANUSCRIPT_PATH, manuscriptPath);
	}

	public List<ComManuscript> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all ComManuscript instances");
		try {
			String queryString = "from ComManuscript";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ComManuscript merge(ComManuscript detachedInstance) {
		log.debug("merging ComManuscript instance");
		try {
			ComManuscript result = (ComManuscript) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ComManuscript instance) {
		log.debug("attaching dirty ComManuscript instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ComManuscript instance) {
		log.debug("attaching clean ComManuscript instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ComManuscriptDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ComManuscriptDAO) ctx.getBean("ComManuscriptDAO");
	}
}