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

import com.domain.ComProgramEditorCharge;

/**
 * A data access object (DAO) providing persistence and search support for
 * ComProgramEditorCharge entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see ComProgramEditorCharge
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ComProgramEditorChargeDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ComProgramEditorChargeDAO.class);
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

	public void save(ComProgramEditorCharge transientInstance) {
		log.debug("saving ComProgramEditorCharge instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ComProgramEditorCharge persistentInstance) {
		log.debug("deleting ComProgramEditorCharge instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ComProgramEditorCharge findById(String id) {
		log.debug("getting ComProgramEditorCharge instance with id: " + id);
		try {
			ComProgramEditorCharge instance = (ComProgramEditorCharge) getCurrentSession()
					.get("com.domain.ComProgramEditorCharge", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ComProgramEditorCharge> findByExample(
			ComProgramEditorCharge instance) {
		log.debug("finding ComProgramEditorCharge instance by example");
		try {
			List<ComProgramEditorCharge> results = (List<ComProgramEditorCharge>) getCurrentSession()
					.createCriteria("com.domain.ComProgramEditorCharge")
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
		log.debug("finding ComProgramEditorCharge instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ComProgramEditorCharge as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ComProgramEditorCharge> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all ComProgramEditorCharge instances");
		try {
			String queryString = "from ComProgramEditorCharge";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ComProgramEditorCharge merge(ComProgramEditorCharge detachedInstance) {
		log.debug("merging ComProgramEditorCharge instance");
		try {
			ComProgramEditorCharge result = (ComProgramEditorCharge) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ComProgramEditorCharge instance) {
		log.debug("attaching dirty ComProgramEditorCharge instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ComProgramEditorCharge instance) {
		log.debug("attaching clean ComProgramEditorCharge instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ComProgramEditorChargeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ComProgramEditorChargeDAO) ctx
				.getBean("ComProgramEditorChargeDAO");
	}
}