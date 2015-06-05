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

import com.domain.ComProgramProducer;

/**
 * A data access object (DAO) providing persistence and search support for
 * ComProgramProducer entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see ComProgramProducer
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ComProgramProducerDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ComProgramProducerDAO.class);
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

	public void save(ComProgramProducer transientInstance) {
		log.debug("saving ComProgramProducer instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ComProgramProducer persistentInstance) {
		log.debug("deleting ComProgramProducer instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ComProgramProducer findById(String id) {
		log.debug("getting ComProgramProducer instance with id: " + id);
		try {
			ComProgramProducer instance = (ComProgramProducer) getCurrentSession()
					.get("com.domain.ComProgramProducer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ComProgramProducer> findByExample(ComProgramProducer instance) {
		log.debug("finding ComProgramProducer instance by example");
		try {
			List<ComProgramProducer> results = (List<ComProgramProducer>) getCurrentSession()
					.createCriteria("com.domain.ComProgramProducer")
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
		log.debug("finding ComProgramProducer instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ComProgramProducer as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ComProgramProducer> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all ComProgramProducer instances");
		try {
			String queryString = "from ComProgramProducer";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ComProgramProducer merge(ComProgramProducer detachedInstance) {
		log.debug("merging ComProgramProducer instance");
		try {
			ComProgramProducer result = (ComProgramProducer) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ComProgramProducer instance) {
		log.debug("attaching dirty ComProgramProducer instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ComProgramProducer instance) {
		log.debug("attaching clean ComProgramProducer instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ComProgramProducerDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ComProgramProducerDAO) ctx.getBean("ComProgramProducerDAO");
	}
}