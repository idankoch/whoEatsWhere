package com.whoEatsWhere.daos

import java.util
import java.util.UUID

import com.whoEatsWhere.Entities.User
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

/**
 * Created by idank on 31/07/2014.
 */
trait UserDao {
  def getAll: java.util.List[User]
  def save(user: User): Long
  def update(user: User)
  def get(userId: UUID): User
  def delete(userId: UUID)
}
@Repository
class UserDaoImpl  extends UserDao {

  @Autowired
  var sessionFactory: SessionFactory = null

  @Transactional(readOnly = true)
  override def getAll: util.List[User] = getCurrentSession.createCriteria(classOf[User]).list().asInstanceOf[java.util.List[User]]

  @Transactional
  override def update(user: User): UUID = getCurrentSession.saveOrUpdate(user)  //Unit is the mother of all primitives
  @Transactional(readOnly = true)
  override def get(userId: UUID): User = getCurrentSession.get(classOf[User], userId).asInstanceOf[User]

  @Transactional
  override def delete(userId: UUID) = getCurrentSession.delete(get(userId))
  @Transactional
  override def save(user: User): UUID = getCurrentSession.save(user).asInstanceOf[Object]

  def getCurrentSession = sessionFactory.getCurrentSession
}
