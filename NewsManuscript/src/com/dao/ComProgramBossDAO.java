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

import com.domain.ComProgramBoss;

/**
 * A data access object (DAO) providing persistence and search support for
 * ComProgramBoss entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see ComProgramBoss
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ComProgramBossDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ComProgramBossDAO.class);
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

	public void save(ComProgramBoss transientInstance) {
		log.debug("saving ComProgramBoss instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ComProgramBoss persistentInstance) {
		log.debug("deleting ComProgramBoss instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ComProgramBoss findById(String id) {
		log.debug("getting ComProgramBoss instance with id: " + id);
		try {
			ComProgramBoss instance = (ComProgramBoss) getCurrentSession().get(
					"com.domain.ComProgramBoss", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ComProgramBoss> findByExample(ComProgramBoss instance) {
		log.debug("finding ComProgramBoss instance by example");
		try {
			List<ComProgramBoss> results = (List<ComProgramBoss>) getCurrentSession()
					.createCriteria("com.domain.ComProgramBoss")
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
		log.debug("finding ComProgramBoss instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ComProgramBoss as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ComProgramBoss> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all ComProgramBoss instances");
		try {
			String queryString = "from ComProgramBoss";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ComProgramBoss merge(ComProgramBoss detachedInstance) {
		log.debug("merging ComProgramBoss instance");
		try {
			ComProgramBoss result = (ComProgramBoss) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ComProgramBoss instance) {
		log.debug("attaching dirty ComProgramBoss instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ComProgramBoss instance) {
		log.debug("attaching clean ComProgramBoss instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ComProgramBossDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ComProgramBossDAO) ctx.getBean("ComProgramBossDAO");
	}
}